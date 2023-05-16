package com.zenon.gestiondestock.dataTransferObject;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.zenon.gestiondestock.model.CommandeFournisseur;
import com.zenon.gestiondestock.model.Fournisseur;
import com.zenon.gestiondestock.model.LigneCommandeFournisseur;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Builder;
import lombok.Data;

import java.time.Instant;
import java.util.List;

@Data
@Builder
public class CommandeFournisseurDto {

    private Integer id;


    private String code;

    private Instant dateCommande;


    private FournisseurDto fournisseur;

    @JsonIgnore
    private List<LigneCommandeFournisseurDto> ligneCommandeFournisseurs;

//MAPPER CommandeFournisseur ---> CommandeFournisseurDto
    public static CommandeFournisseurDto fromEntity(CommandeFournisseur commandeFournisseur){
        if(commandeFournisseur == null){
            return null;
            //exception
        }
        return CommandeFournisseurDto.builder()
                .id(commandeFournisseur.getId())
                .code(commandeFournisseur.getCode())
                .dateCommande(commandeFournisseur.getDateCommande())
                .build();
    }
//MAPPER CommandeFournisseurDto -->CommandeFournisseur
    public static CommandeFournisseur toEntity(CommandeFournisseurDto commandeFournisseurDto){
        if(commandeFournisseurDto == null){
            return null;
            //exception
        }
        CommandeFournisseur commandeFournisseur = new CommandeFournisseur();
        commandeFournisseur.setId(commandeFournisseurDto.getId());
        commandeFournisseur.setCode(commandeFournisseurDto.getCode());
        commandeFournisseur.setDateCommande(commandeFournisseurDto.getDateCommande());
        return commandeFournisseur;
    }
}
