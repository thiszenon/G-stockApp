package com.zenon.gestiondestock.dataTransferObject;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.zenon.gestiondestock.model.Adresse;
import com.zenon.gestiondestock.model.Entreprise;
import com.zenon.gestiondestock.model.Utilisateur;
import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.OneToMany;
import lombok.Builder;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Data
@Builder
public class EntrepriseDto {

    private Integer id;


    private String nomEntrepirse;

    private String description;


    private AdresseDto adresse;

    private String codeFiscal;

    private String photo;

    private String email;

    private  String numTel;

    private String siteWeb;


    private List<UtilisateurDto> utilisateurs;

//MAPPER Entreprise --> EntrepriseDto
    public static EntrepriseDto fromEntity(Entreprise entreprise){
        if(entreprise == null){
            return null;
            //exception
        }
        return EntrepriseDto.builder()
                .id(entreprise.getId())
                .codeFiscal(entreprise.getCodeFiscal())
                .nomEntrepirse(entreprise.getNomEntrepirse())
                .email(entreprise.getEmail())
                .numTel(entreprise.getNumTel())
                .description(entreprise.getDescription())
                .photo(entreprise.getPhoto())
                .siteWeb(entreprise.getSiteWeb())
                .adresse(AdresseDto.fromEntity(entreprise.getAdresse()))
                .utilisateurs(entreprise.getUtilisateurs()!=null ?
                        entreprise.getUtilisateurs().stream()
                                .map(UtilisateurDto::fromEntity)
                                .collect(Collectors.toList()) : null
                )
                .build();
    }
//MAPPEED EntrepriseDto ---> Entreprise

    public static Entreprise toEntity(EntrepriseDto entrepriseDto){
        if(entrepriseDto == null){
            return null;
            //exception
        }
        Entreprise entreprise=new Entreprise();
        entreprise.setId(entrepriseDto.getId());
        entreprise.setCodeFiscal(entreprise.getCodeFiscal());
        entreprise.setNomEntrepirse(entrepriseDto.getNomEntrepirse());
        entreprise.setEmail((entrepriseDto.getEmail()));
        entreprise.setNumTel(entreprise.getNumTel());
        entreprise.setDescription(entrepriseDto.getDescription());
        entreprise.setPhoto(entrepriseDto.getPhoto());
        entreprise.setSiteWeb(entrepriseDto.getSiteWeb());
        entreprise.setAdresse(AdresseDto.toEntity(entrepriseDto.getAdresse()));
        List<Utilisateur> utilisateurList= entrepriseDto.getUtilisateurs().stream()
                .map(UtilisateurDto::toEntity).collect(Collectors.toList());
        entreprise.setUtilisateurs(utilisateurList);
        return entreprise;
    }
}
