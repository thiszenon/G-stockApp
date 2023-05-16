package com.zenon.gestiondestock.model;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "LigneCommandeClient")
public class LigneCommandeClient extends  AbstractEntity{

    @ManyToOne
    @JoinColumn(name = "idArticle")
    private  Article article;

    @ManyToOne
    @JoinColumn(name = "idCommandeClient")
    private CommandeClient commandeClient;

    @Column(name = "quantity")
    private BigDecimal quantity;

    @Column(name = "prixUnitaire")
    private BigDecimal prixUnitaire;
}
