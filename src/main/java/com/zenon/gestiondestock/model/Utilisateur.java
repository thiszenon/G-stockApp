package com.zenon.gestiondestock.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.Instant;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "Utilisateur")
public class Utilisateur extends AbstractEntity {

    @Column(name = "nom")
    private String nomUtilisateur;

    @Column(name = "prenomUtilisateur")
    private String prenomUtilisateur;

    @Column(name = "email")
    private String email;

    @Column(name = "dateNaissance")
    private Instant dateNaissance;

    @Column(name = "motDePasse")
    private String motDePasse;

    @Embedded
    private Adresse adresse;

    @Column(name = "photo")
    private  String photo;

    @ManyToOne
    @JoinColumn(name = "idEntreprise")
    private Entreprise entreprise;

    @OneToMany(mappedBy = "utilisateur")
    private List<RoleUtilisateur> roleUtilisateurs;
}
