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
@Table(name = "CommandeFournisseur")
public class CommandeFournisseur extends AbstractEntity{

    @Column(name = "code")
    private String code;

    @Column(name = "dateCommande")
    private Instant dateCommande;

    @ManyToOne
    @JoinColumn(name = "idFournisseur")
    private  Fournisseur fournisseur;

    @OneToMany(mappedBy = "commandeFournisseur")
    private List<LigneCommandeFournisseur> ligneCommandeFournisseurs;


}
