package com.zenon.gestiondestock.model;


import jakarta.persistence.*;
import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "RoleUtilisateur")
public class RoleUtilisateur extends AbstractEntity{
    @Column(name = "roleName")
    private String roleName;

    @ManyToOne
    @JoinColumn(name = "idUtilisateur")
    private  Utilisateur utilisateur;
}
