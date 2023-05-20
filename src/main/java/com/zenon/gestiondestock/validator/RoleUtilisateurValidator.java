package com.zenon.gestiondestock.validator;

import com.zenon.gestiondestock.dataTransferObject.RoleUtilisateurDto;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class RoleUtilisateurValidator {
    public static List<String> validate(RoleUtilisateurDto roleUtilisateurDto){
        List<String> errors = new ArrayList<>();
        if(roleUtilisateurDto == null){
            errors.add("il faut au moins un rôle de l'utilisateur");
            return errors;
        }
        if(!StringUtils.hasLength(roleUtilisateurDto.getRoleName())){
            errors.add("veuillez saisir le rôle de l'utilisateur ");
        }
        if(roleUtilisateurDto.getUtilisateur() ==  null){
            errors.add("veuillez renseigner l'utilisateur");
        }

        return errors;
    }
}
