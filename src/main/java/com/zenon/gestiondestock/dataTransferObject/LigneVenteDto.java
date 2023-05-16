package com.zenon.gestiondestock.dataTransferObject;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.zenon.gestiondestock.model.LigneVente;
import com.zenon.gestiondestock.model.Vente;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
public class LigneVenteDto {

    private Integer id;


    @JsonIgnore
    private VenteDto vente;

    private BigDecimal quantity;


    private BigDecimal prixUnitaire;

    public static LigneVenteDto fromEntity(LigneVente ligneVente){
        if(ligneVente == null){
            return null;
        }
        return    LigneVenteDto.builder()
                .id(ligneVente.getId())
                .prixUnitaire(ligneVente.getPrixUnitaire())
                .quantity(ligneVente.getQuantity())
                .build();
    }//fromEntity

    public static LigneVente toEntity(LigneVenteDto ligneVenteDto){
        if(ligneVenteDto == null){
            return null;
        }
        LigneVente ligneVente = new LigneVente();
        ligneVente.setId(ligneVenteDto.getId());
        ligneVente.setPrixUnitaire(ligneVenteDto.getPrixUnitaire());
        ligneVente.setQuantity(ligneVenteDto.getQuantity());
        return  ligneVente;
    }//toEntity
}
