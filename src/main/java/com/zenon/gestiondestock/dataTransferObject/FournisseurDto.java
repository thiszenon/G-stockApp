package com.zenon.gestiondestock.dataTransferObject;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.zenon.gestiondestock.model.Adresse;
import com.zenon.gestiondestock.model.CommandeFournisseur;
import com.zenon.gestiondestock.model.Fournisseur;
import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.OneToMany;
import lombok.Builder;
import lombok.Data;

import java.util.List;
import java.util.stream.Collectors;

@Data
@Builder
public class FournisseurDto {

    private Integer id;


    private  String nomFournisseur;

    private String prenomFournisseur;


    private AdresseDto adresse;
    private String photo;

    private String email;
    private String numTel;



    private List<CommandeFournisseurDto> commandeFournisseurs;

//Mapped Fournisseur --->FournisseurDto
    public static FournisseurDto fromEntity(Fournisseur fournisseur){
        if(fournisseur == null){
            return null;
            //exception
        }
        return FournisseurDto.builder()
                .id(fournisseur.getId())
                .nomFournisseur(fournisseur.getNomFournisseur())
                .prenomFournisseur(fournisseur.getPrenomFournisseur())
                .email(fournisseur.getEmail())
                .numTel(fournisseur.getNumTel())
                .photo(fournisseur.getPhoto())
                .adresse(AdresseDto.fromEntity(fournisseur.getAdresse()))
                .commandeFournisseurs(fournisseur.getCommandeFournisseurs() != null?
                        fournisseur.getCommandeFournisseurs().stream()
                                .map(CommandeFournisseurDto::fromEntity)
                                .collect(Collectors.toList()): null
                )
                .build();
    }

//Mapped FournisseurDto ---> Fournisseur
    public static Fournisseur toEntity(FournisseurDto fournisseurDto){
        if(fournisseurDto == null){
            return null;
        }
        Fournisseur fournisseur= new Fournisseur();
        fournisseur.setId(fournisseurDto.getId());
        fournisseur.setNomFournisseur(fournisseurDto.getNomFournisseur());
        fournisseur.setPrenomFournisseur(fournisseurDto.getPrenomFournisseur());
        fournisseur.setEmail(fournisseurDto.getEmail());
        fournisseur.setNumTel(fournisseurDto.getNumTel());
        fournisseur.setPhoto(fournisseurDto.getPhoto());
        fournisseur.setAdresse(AdresseDto.toEntity(fournisseurDto.getAdresse()));
        List<CommandeFournisseur> commandeFournisseurList= fournisseurDto.getCommandeFournisseurs().stream()
                .map(CommandeFournisseurDto::toEntity)
                .collect(Collectors.toList());
        fournisseur.setCommandeFournisseurs(commandeFournisseurList);
        return fournisseur;
    }
}
