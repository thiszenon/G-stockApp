package com.zenon.gestiondestock.validator;

import com.zenon.gestiondestock.dataTransferObject.CategoryDto;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class CategoryValidator {// class validateur qui valide si les dataTransfer Object son validé
    // dans le cas que nous voulons bien avoir certaines données obligatoire
    public static List<String> validate(CategoryDto categoryDto){
        List<String> errors= new ArrayList<>();
        if(categoryDto==null || !StringUtils.hasLength(categoryDto.getCode())){// si le code de la category est vide ou est null
            errors.add("Veuillez renseigner le code de la categorie");// renvoie le message d'erreur
        }

        return errors;
    }
}
