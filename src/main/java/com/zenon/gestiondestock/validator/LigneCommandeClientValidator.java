package com.zenon.gestiondestock.validator;

import com.zenon.gestiondestock.dataTransferObject.LigneCommandeClientDto;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class LigneCommandeClientValidator {
    public static List<String> validate(LigneCommandeClientDto ligneCommandeClientDto){
        List<String> errors =  new ArrayList<>();
        if(ligneCommandeClientDto ==  null){
            errors.add("veuillez renseigner le prix de la commande du client");
            errors.add("veuillez renseigner le commande du client");
            errors.add("veuillez renseigner l'article du client");
            errors.add("veuillez renseigner la quantité de la commande du client");
            return errors;
        }
        if(ligneCommandeClientDto.getCommandeClient()== null){
            errors.add("veuillez renseigner le commande du client");
        }
        if(ligneCommandeClientDto.getArticle()== null){
            errors.add("veuillez renseigner l'article du client");
        }
        if(ligneCommandeClientDto.getQuantity()== null){
            errors.add("veuillez renseigner la quantité de la commande du client");
        }
        if(ligneCommandeClientDto.getPrixUnitaire()== null){
            errors.add("veuillez renseigner le prix de la commande du client");
        }


        return errors;
    }
}// ligne Commande Client Vlaidator
