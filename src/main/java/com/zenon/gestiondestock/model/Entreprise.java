package com.zenon.gestiondestock.model;


import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "Entreprise")
public class Entreprise extends AbstractEntity{

    @Column(name = "nom")
    private String nomEntrepirse;

    @Column(name = "description")
    private String description;

    @Embedded
    private  Adresse adresse;

    @Column(name = "codeFiscal")
    private String codeFiscal;

    @Column(name = "photo")
    private String photo;

    @Column(name = "email")
    private String email;

    @Column(name = "numTel")
    private  String numTel;

    @Column(name = "siteWeb")
    private String siteWeb;

    @OneToMany(mappedBy = "entreprise")
    private List<Utilisateur> utilisateurs;

}
