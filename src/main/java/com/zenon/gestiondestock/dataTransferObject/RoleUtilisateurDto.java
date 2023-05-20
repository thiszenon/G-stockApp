package com.zenon.gestiondestock.dataTransferObject;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.zenon.gestiondestock.model.RoleUtilisateur;
import com.zenon.gestiondestock.model.Utilisateur;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class RoleUtilisateurDto {

    private Integer id;

    private String roleName;

    private UtilisateurDto utilisateur;

    public static RoleUtilisateurDto fromEntity(RoleUtilisateur roleUtilisateur){
        if(roleUtilisateur == null){
            return null;
        }
        return RoleUtilisateurDto.builder()
                .id(roleUtilisateur.getId())
                .roleName(roleUtilisateur.getRoleName())
                .utilisateur(UtilisateurDto.fromEntity(roleUtilisateur.getUtilisateur()))
                .build();

    }//fromEntity

    public static RoleUtilisateur toEntity(RoleUtilisateurDto roleUtilisateurDto){
        if(roleUtilisateurDto == null){
            return null;
        }
        RoleUtilisateur roleUtilisateur = new RoleUtilisateur();
        roleUtilisateur.setId(roleUtilisateurDto.getId());
        roleUtilisateur.setRoleName((roleUtilisateurDto.getRoleName()));
        roleUtilisateur.setUtilisateur(UtilisateurDto.toEntity(roleUtilisateurDto.getUtilisateur()));
        return roleUtilisateur;
    }//toEntity
}
