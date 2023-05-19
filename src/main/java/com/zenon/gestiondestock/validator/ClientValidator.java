package com.zenon.gestiondestock.validator;

import com.zenon.gestiondestock.dataTransferObject.ClientDto;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class ClientValidator {
    public static List<String> validate(ClientDto clientDto){
        List<String> errors= new ArrayList<>();

        if(clientDto == null){
            errors.add("le nom du client est obligatoire");
            errors.add("le prénom du client est obligatoire");
            errors.add("l'adresse email du client est obligatoire");
            errors.add("le numero de téléphone du client est obligatoire");

            return errors;


        }// for all obligation
        if( !StringUtils.hasLength(clientDto.getNomClient())){
            errors.add("le nom du client est obligatoire");
        }
        if( !StringUtils.hasLength(clientDto.getPrenomClient())){
            errors.add("le prénom du client est obligatoire");
        }
        if( !StringUtils.hasLength(clientDto.getEmail())){
            errors.add("l'adresse email du client est obligatoire");
        }
        if( !StringUtils.hasLength(clientDto.getNumTel())){
            errors.add("le numero de téléphone du client est obligatoire");
        }



        return  errors;
    }//validate
}
