package com.zenon.gestiondestock.validator;

import com.zenon.gestiondestock.dataTransferObject.LigneVenteDto;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class LigneVenteValidator {
    public static List<String> validate(LigneVenteDto ligneVenteDto){
        List<String> errors =  new ArrayList<>();
        if(ligneVenteDto == null){
            errors.add("Au moins une vente est obligatoire");
            return errors;
        }
        if(ligneVenteDto.getVente()==null){
            errors.add("veuillez renseigner les details de la vente");
        }
        if(ligneVenteDto.getQuantity()==null){
            errors.add("entrez la quantité de la vente");
        }
        if(ligneVenteDto.getPrixUnitaire()== null){
            errors.add("entrez le prix unitaire de la vente");
        }

        return errors;
    }
}
