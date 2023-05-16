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
@Table(name = "LigneVente")
public class LigneVente extends AbstractEntity{

    @ManyToOne
    @JoinColumn(name = "idVente")
    private  Vente vente;

    @Column(name = "quantity")
    private BigDecimal quantity;


    @Column(name = "prixUnitaire")
    private BigDecimal prixUnitaire;
}
