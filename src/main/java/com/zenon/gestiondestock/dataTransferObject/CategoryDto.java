package com.zenon.gestiondestock.dataTransferObject;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.zenon.gestiondestock.model.Article;
import com.zenon.gestiondestock.model.Category;
import jakarta.persistence.Column;
import jakarta.persistence.OneToMany;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@Builder
// la class DTO pour le transfert des objects voulu
public class CategoryDto {

    private Integer id;

    private  String code;
    private String designation;

    private List<ArticleDto> articles;

    // Constructeur qui nous renvoi nos objets
    public static CategoryDto fromEntity(Category category){
        if(category == null){// verification de la categorie si elle est nulle
            return null;
        }
// Category ---> CategoryDto Mapper vers l'entité CategoryDto
        return CategoryDto.builder()
                .id(category.getId())
                .code(category.getCode())
                .designation(category.getDesignation())
                .articles(
                        category.getArticles() !=null ?
                        category.getArticles().stream()
                                .map(ArticleDto::fromEntity)
                                .collect(Collectors.toList()): null
                )
                .build();

    }// fromEntity

// CategoryDto ---> Category Mapper vers l'entité Category
    public static Category toEntity(CategoryDto categoryDto){
        if(categoryDto == null){
            return null;
            //RETURN UNE EXECEPTION
        }

        Category category= new Category();
        category.setId(categoryDto.getId());
        category.setCode(categoryDto.getCode());
        category.setDesignation(categoryDto.getDesignation());
        List<Article> articleList= categoryDto.getArticles().stream()
                .map(ArticleDto::toEntity).collect(Collectors.toList());
        category.setArticles(articleList);

        return category;

    }
}
