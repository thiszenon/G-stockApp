package com.zenon.gestiondestock.validator;

import com.zenon.gestiondestock.dataTransferObject.LigneCommandeFournisseurDto;

import java.util.ArrayList;
import java.util.List;

public class LigneCommandeFournisseurValidator {
    public static List<String> validate(LigneCommandeFournisseurDto ligneCommandeFournisseurDto){
        List<String> errors = new ArrayList<>();
        if(ligneCommandeFournisseurDto ==  null){
            errors.add("veuillez renseigner le prix de la commande du fournisseur");
            errors.add("veuillez renseigner le commande du fournisseur");
            errors.add("veuillez renseigner l'article du fournisseur");
            errors.add("veuillez renseigner la quantité de la commande du fournisseur");
            return errors;
        }
        if(ligneCommandeFournisseurDto.getCommandeFournisseur()== null){
            errors.add("veuillez renseigner le commande du fournisseur");
        }
        if(ligneCommandeFournisseurDto.getArticle()== null){
            errors.add("veuillez renseigner l'article du fournisseur");
        }
        if(ligneCommandeFournisseurDto.getQuantity()== null){
            errors.add("veuillez renseigner la quantité de la commande du fournisseur");
        }
        if(ligneCommandeFournisseurDto.getPrixUnitaire()== null){
            errors.add("veuillez renseigner le prix de la commande du fournisseur");
        }


        return errors;
    }
}
