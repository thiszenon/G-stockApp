package com.zenon.gestiondestock.validator;

import com.zenon.gestiondestock.dataTransferObject.ArticleDto;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class ArticleValidator {
    public static List<String> validate(ArticleDto articleDto){
        List<String> errors = new ArrayList<>();
        //si l'articl est null
        if(articleDto == null){
            errors.add("veuillez renseigner le code de l'article");
            errors.add("veuillez renseigner la designation de l'article");
            errors.add("veuillez renseigner le prix unitaire de l'article");
            errors.add("veuillez renseigner le taux tva de l'article");
            errors.add("veuillez renseigner le prix unitaire TTC de l'article");
            errors.add("veuillez selectionner une categorie");
            return errors;

        }
        if(!StringUtils.hasLength(articleDto.getCodeArticle())){
            errors.add("veuillez renseigner le code de l'article");
        }//getCode
        if(!StringUtils.hasLength(articleDto.getDesignation())){
            errors.add("veuillez renseigner la designation de l'article");
        }//designation
        if(articleDto.getPrixUnitaire()== null){
            errors.add("veuillez renseigner le prix unitaire de l'article");
        }//prix unitaire
        if(articleDto.getTauxTva() == null){
            errors.add("veuillez renseigner le taux tva de l'article");
        }//tauxTva
        if(articleDto.getPrixUnitaireTtc()==null){
            errors.add("veuillez renseigner le prix unitaire TTC de l'article");
        }//prix TTC
        if(articleDto.getCategorydto()== null){
            errors.add("veuillez selectionner une categorie");
        }


        return  errors;
    }
}
