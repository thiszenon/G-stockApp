package com.zenon.gestiondestock.dataTransferObject;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.zenon.gestiondestock.model.Adresse;
import com.zenon.gestiondestock.model.Entreprise;
import com.zenon.gestiondestock.model.RoleUtilisateur;
import com.zenon.gestiondestock.model.Utilisateur;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;

import java.time.Instant;
import java.util.List;
import java.util.stream.Collectors;

@Data
@Builder
public class UtilisateurDto {

    private Integer id;



    private String nomUtilisateur;

    private String prenomUtilisateur;

    private String email;

    private Instant dateNaissance;

    private String motDePasse;
    private  String photo;


    private AdresseDto adresse;


    private EntrepriseDto entreprise;


    private List<RoleUtilisateurDto> roleUtilisateurs;

    public static UtilisateurDto fromEntity(Utilisateur utilisateur){
        if(utilisateur == null){
            return null;
        }
        return UtilisateurDto.builder()
                .id(utilisateur.getId())
                .nomUtilisateur(utilisateur.getNomUtilisateur())
                .prenomUtilisateur(utilisateur.getPrenomUtilisateur())
                .dateNaissance(utilisateur.getDateNaissance())
                .email(utilisateur.getEmail())
                .motDePasse(utilisateur.getMotDePasse())
                .photo(utilisateur.getPhoto())
                .adresse(AdresseDto.fromEntity(utilisateur.getAdresse()))
                .entreprise(EntrepriseDto.fromEntity(utilisateur.getEntreprise()))
                .roleUtilisateurs(
                        utilisateur.getRoleUtilisateurs() != null ?
                                utilisateur.getRoleUtilisateurs().stream()
                                        .map(RoleUtilisateurDto::fromEntity)
                                        .collect(Collectors.toList()) : null
                )
                .build();
    }//fromEntity

    public static Utilisateur toEntity(UtilisateurDto utilisateurDto){
        if(utilisateurDto == null){
            return null;
        }
        Utilisateur utilisateur = new Utilisateur();
        utilisateur.setId(utilisateurDto.getId());
        utilisateur.setNomUtilisateur(utilisateurDto.getNomUtilisateur());
        utilisateur.setPrenomUtilisateur(utilisateurDto.getPrenomUtilisateur());
        utilisateur.setDateNaissance(utilisateurDto.getDateNaissance());
        utilisateur.setEmail(utilisateurDto.getEmail());
        utilisateur.setMotDePasse(utilisateurDto.getMotDePasse());
        utilisateur.setPhoto(utilisateurDto.getPhoto());
        utilisateur.setAdresse(AdresseDto.toEntity(utilisateurDto.getAdresse()));
        utilisateur.setEntreprise(EntrepriseDto.toEntity(utilisateurDto.getEntreprise()));
        List<RoleUtilisateur> roleUtilisateurList= utilisateurDto.getRoleUtilisateurs().stream()
                .map(RoleUtilisateurDto::toEntity)
                .collect(Collectors.toList());
        utilisateur.setRoleUtilisateurs(roleUtilisateurList);

        return utilisateur;
    }//toEntity

}
