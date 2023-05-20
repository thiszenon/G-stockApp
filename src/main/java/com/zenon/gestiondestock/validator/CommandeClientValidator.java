package com.zenon.gestiondestock.validator;

import com.zenon.gestiondestock.dataTransferObject.CommandeClientDto;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class CommandeClientValidator {

    public static List<String> validate(CommandeClientDto commandeClientDto){
        List<String> errors = new ArrayList<>();
        if(commandeClientDto== null){
            errors.add("la date de la commande est obligatoire");
            errors.add("le code de la commande est obligatoire");
            return errors;
        }
        if(!StringUtils.hasLength(commandeClientDto.getCode())){
            errors.add("le code de la commande est obligatoire");
        }
        if(commandeClientDto.getDateCommande()== null){

            errors.add("la date de la commande est obligatoire");
        }




        return errors;
    }
}
