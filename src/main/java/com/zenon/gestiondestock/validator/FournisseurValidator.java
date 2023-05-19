package com.zenon.gestiondestock.validator;

import com.zenon.gestiondestock.dataTransferObject.FournisseurDto;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class FournisseurValidator {

    public static List<String> validate(FournisseurDto fournisseurDto){
        List<String> errors= new ArrayList<>();
        if(fournisseurDto == null){
            errors.add("le nom du fournisseur est obligatoire");
            errors.add("le prénom du fournisseur est obligatoire");
            errors.add("l'adresse email du fournisseur est obligatoire");
            errors.add("le numero de téléphone du fournisseur est obligatoire");

            return errors;


        }// for all obligation
        if( !StringUtils.hasLength(fournisseurDto.getNomFournisseur())){
            errors.add("le nom du fournisseur est obligatoire");
        }
        if( !StringUtils.hasLength(fournisseurDto.getPrenomFournisseur())){
            errors.add("le prénom du fournisseur est obligatoire");
        }
        if( !StringUtils.hasLength(fournisseurDto.getEmail())){
            errors.add("l'adresse email du fournisseur est obligatoire");
        }
        if( !StringUtils.hasLength(fournisseurDto.getNumTel())){
            errors.add("le numero de téléphone du fournisseur est obligatoire");
        }



        return  errors;
    }//validate

}
