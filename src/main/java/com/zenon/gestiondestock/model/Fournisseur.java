package com.zenon.gestiondestock.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Entity
@Table(name = "Fournisseur")
public class Fournisseur extends AbstractEntity{

    @Column(name = "nomFournisseur")
    private  String nomFournisseur;

    @Column(name = "prenomFournisseur")
    private String prenomFournisseur;

    @Embedded
    private  Adresse adresse;
    @Column(name = "photo")
    private String photo;

    @Column(name = "email")
    private String email;
    @Column(name = "phoneNumber")
    private String numTel;


    @OneToMany(mappedBy = "fournisseur")
    private List<CommandeFournisseur> commandeFournisseurs;
}
