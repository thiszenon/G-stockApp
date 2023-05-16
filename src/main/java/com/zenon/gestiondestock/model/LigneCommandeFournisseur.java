package com.zenon.gestiondestock.model;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "LigneCommandeFournisseur")
public class LigneCommandeFournisseur extends AbstractEntity{

    @ManyToOne
    @JoinColumn(name = "idArticle")
    private  Article article;


    @ManyToOne
    @JoinColumn(name = "idCommandeFournisseur")
    private CommandeFournisseur commandeFournisseur;

    @Column(name = "quantity")
    private BigDecimal quantity;

    @Column(name = "prixUnitaire")
    private BigDecimal prixUnitaire;
}
