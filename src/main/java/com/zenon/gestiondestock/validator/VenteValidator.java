package com.zenon.gestiondestock.validator;

import com.zenon.gestiondestock.dataTransferObject.VenteDto;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class VenteValidator {
    public static List<String> validate(VenteDto venteDto){
        List<String> errors= new ArrayList<>();
        if(venteDto== null){
            errors.add("Au moins une vente est obligatoire");
            return errors;
        }
        if(!StringUtils.hasLength(venteDto.getCode())){
            errors.add("veuillez entrer le code de la vente");
        }
        if(venteDto.getDateVente()==null){
            errors.add("une date est obligatoire pour une vente");
        }
       return errors;


    }
}
