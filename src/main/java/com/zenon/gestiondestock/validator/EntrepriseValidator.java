package com.zenon.gestiondestock.validator;

import com.zenon.gestiondestock.dataTransferObject.EntrepriseDto;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class EntrepriseValidator {
    public static List<String> validate(EntrepriseDto entrepriseDto){
        List<String> errors = new ArrayList<>();
        if(entrepriseDto == null){
            errors.add("veuillez renseigner le nom de l'entreprise");
            errors.add("veuillez renseigner le code fiscal de l'entreprise");
            errors.add("veuillez renseigner l'adresse email de l'entreprise");
            errors.add("veuillez renseigner le numero de Téléphone de l'entreprise");
            errors.add("veuillez décrire votre entreprise en quelque mot");
            return errors;
        }
        if(!StringUtils.hasLength(entrepriseDto.getNomEntrepirse())){
            errors.add("veuillez renseigner le nom de l'entreprise");
        }
        if(!StringUtils.hasLength(entrepriseDto.getCodeFiscal())){
            errors.add("veuillez renseigner le code fiscal de l'entreprise");
        }
        if(!StringUtils.hasLength(entrepriseDto.getEmail())){
            errors.add("veuillez renseigner l'adresse email de l'entreprise");
        }
        if(!StringUtils.hasLength(entrepriseDto.getNumTel())){
            errors.add("veuillez renseigner le numero de Téléphone de l'entreprise");
        }
        if(!StringUtils.hasLength(entrepriseDto.getDescription())){
            errors.add("veuillez décrire votre entreprise en quelque mot");
        }


        return errors;
    }
}
