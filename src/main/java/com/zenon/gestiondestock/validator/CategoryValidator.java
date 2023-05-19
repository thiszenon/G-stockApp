package com.zenon.gestiondestock.validator;

import com.zenon.gestiondestock.dataTransferObject.CategoryDto;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class CategoryValidator {
    // on creer une methode "validete" qui valide les entity de la class avant le save in BDD
    public static List<String> validate(CategoryDto categoryDto){
        List<String> errors= new ArrayList<>();
        // verifier si le code de la categorie est null ou vide
        if(categoryDto== null || !StringUtils.hasLength(categoryDto.getCode())){
            //ajout d'un message d'erreur dans la liste "errors"
            errors.add("Veuillez renseigner le code de la Categorie");
        }

        return errors;
    }
}
