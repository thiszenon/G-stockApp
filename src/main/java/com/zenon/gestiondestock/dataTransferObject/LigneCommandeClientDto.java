package com.zenon.gestiondestock.dataTransferObject;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.zenon.gestiondestock.model.Article;
import com.zenon.gestiondestock.model.CommandeClient;
import com.zenon.gestiondestock.model.LigneCommandeClient;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
public class LigneCommandeClientDto {

    private Integer id;

    @JsonIgnore
    private ArticleDto article;


    @JsonIgnore
    private CommandeClientDto commandeClient;
    private BigDecimal quantity;

    private BigDecimal prixUnitaire;

    public static LigneCommandeClientDto  fromEntity(LigneCommandeClient ligneCommandeClient){
        if(ligneCommandeClient == null){
            return null;
        }
        return LigneCommandeClientDto.builder()
                .id(ligneCommandeClient.getId())
                .prixUnitaire(ligneCommandeClient.getPrixUnitaire())
                .quantity(ligneCommandeClient.getQuantity())
                .build();
    }

    public static LigneCommandeClient toEntity(LigneCommandeClientDto ligneCommandeClientDto){
        if (ligneCommandeClientDto == null){
            return null;
        }

        LigneCommandeClient ligneCommandeClient= new LigneCommandeClient();
        ligneCommandeClient.setId(ligneCommandeClientDto.getId());
        ligneCommandeClient.setPrixUnitaire(ligneCommandeClientDto.getPrixUnitaire());
        ligneCommandeClient.setQuantity(ligneCommandeClientDto.getQuantity());
        return ligneCommandeClient;
    }
}
