package com.zenon.gestiondestock.dataTransferObject;

import com.zenon.gestiondestock.model.Adresse;
import jakarta.persistence.Column;
import lombok.Builder;
import lombok.Data;

@Data
@Builder

public class AdresseDto {

    private Integer id;
    private String adresse1;
    private String adresse2;
    private String ville;
    private String codePostal;
    private String pays;

// Mapper Adresse -->AdresseDto
    public static AdresseDto fromEntity(Adresse adresse){
        if(adresse == null){
            return null;
            // faire une exception
        }
        return AdresseDto.builder()
                .adresse1(adresse.getAdresse1())
                .adresse2(adresse.getAdresse2())
                .codePostal(adresse.getCodePostal())
                .ville(adresse.getVille())
                .pays(adresse.getPays())
                .build();
    }

//Mapper AdresseDTO ----> Adresse
    public static Adresse toEntity(AdresseDto adresseDto){
        if(adresseDto == null){
            return null;
            //faire une exception
        }
        Adresse adresse= new Adresse();
        adresse.setAdresse1(adresseDto.getAdresse1());
        adresse.setAdresse2(adresseDto.getAdresse2());
        adresse.setCodePostal(adresseDto.getCodePostal());
        adresse.setVille(adresseDto.getVille());
        adresse.setPays(adresseDto.getPays());

        return adresse;
    }
}























