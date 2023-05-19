package com.zenon.gestiondestock.dataTransferObject;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.zenon.gestiondestock.model.Article;
import com.zenon.gestiondestock.model.Category;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Builder
@Data
public class ArticleDto {

    private Integer id;
    private String codeArticle;
    private String designation;
    private BigDecimal prixUnitaire;
    private  BigDecimal tauxTva;
    private BigDecimal prixUnitaireTtc;
    private String photo;

    private CategoryDto categorydto;

//Mapper Article -->ArticleDto
    public static ArticleDto fromEntity(Article article){
        if(article == null){
            return null;
            //une exception serait mieux
        }
        return ArticleDto.builder()
                .id(article.getId())
                .codeArticle(article.getCodeArticle())
                .photo(article.getPhoto())
                .designation(article.getDesignation())
                .prixUnitaire(article.getPrixUnitaire())
                .prixUnitaireTtc(article.getPrixUnitaireTtc())
                .tauxTva(article.getTauxTva())
                .categorydto(CategoryDto.fromEntity(article.getCategory()))
                .build();
    }

//Mapper ArticleDTO --->Article

    public static Article toEntity(ArticleDto articleDto){
        if(articleDto == null){
            return null;
            //exception
        }
        Article article= new Article();
        article.setId(articleDto.getId());
        article.setCodeArticle(articleDto.getCodeArticle());
        article.setPhoto((articleDto.getPhoto()));
        article.setDesignation(articleDto.getDesignation());
        article.setPrixUnitaire(articleDto.getPrixUnitaire());
        article.setPrixUnitaireTtc(articleDto.getPrixUnitaireTtc());
        article.setTauxTva(articleDto.getTauxTva());
        article.setCategory(CategoryDto.toEntity(articleDto.getCategorydto()));// a revoir en cas d'erreur
        return article;
    }

}



























