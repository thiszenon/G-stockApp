package com.zenon.gestiondestock.validator;

import com.zenon.gestiondestock.dataTransferObject.CommandeFournisseurDto;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class CommandeFournisseurValidator {
    public static List<String> validate(CommandeFournisseurDto commandeFournisseurDto){
        List<String> errors =  new ArrayList<>();
        if(commandeFournisseurDto== null){
            errors.add("le code de la commande Fournisseur est obligatoire");
            errors.add("la date de la commande Fournisseur est obligatoire");
            return errors;
        }
        if(!StringUtils.hasLength(commandeFournisseurDto.getCode())){
            errors.add("le code de la commande Fournisseur est obligatoire");
        }
        if(commandeFournisseurDto.getDateCommande()== null){

            errors.add("la date de la commande Fournisseur est obligatoire");
        }


        return errors;
    }
}
