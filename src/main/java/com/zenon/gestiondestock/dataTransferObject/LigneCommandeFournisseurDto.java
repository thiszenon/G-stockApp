package com.zenon.gestiondestock.dataTransferObject;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.zenon.gestiondestock.model.Article;
import com.zenon.gestiondestock.model.CommandeFournisseur;
import com.zenon.gestiondestock.model.LigneCommandeFournisseur;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
public class LigneCommandeFournisseurDto {

    private Integer id;


    @JsonIgnore
    private ArticleDto article;

    @JsonIgnore
    private CommandeFournisseurDto commandeFournisseur;

    private BigDecimal quantity;

    private BigDecimal prixUnitaire;

    public static LigneCommandeFournisseurDto fromEntity(LigneCommandeFournisseur ligneCommandeFournisseur){
        if(ligneCommandeFournisseur == null) {
            return null;
        }
        return LigneCommandeFournisseurDto.builder()
                .id(ligneCommandeFournisseur.getId())
                .quantity(ligneCommandeFournisseur.getQuantity())
                .prixUnitaire(ligneCommandeFournisseur.getPrixUnitaire())
                .build();
    }//fromEntity

    public static LigneCommandeFournisseur toEntity(LigneCommandeFournisseurDto ligneCommandeFournisseurDto){
        if(ligneCommandeFournisseurDto == null){
            return null;
        }
        LigneCommandeFournisseur ligneCommandeFournisseur = new LigneCommandeFournisseur();
        ligneCommandeFournisseur.setId(ligneCommandeFournisseurDto.getId());
        ligneCommandeFournisseur.setQuantity(ligneCommandeFournisseurDto.getQuantity());
        ligneCommandeFournisseur.setPrixUnitaire(ligneCommandeFournisseurDto.getPrixUnitaire());
        return ligneCommandeFournisseur;
    }
}
