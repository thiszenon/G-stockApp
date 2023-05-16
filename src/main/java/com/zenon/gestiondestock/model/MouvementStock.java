package com.zenon.gestiondestock.model;


import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.Instant;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "MouvementStock")
public class MouvementStock extends  AbstractEntity{

    @Column(name = "dateMvt")
    private Instant dateMvt;

    @Column(name = "quantity")
    private BigDecimal quantity;
    @ManyToOne
    @JoinColumn(name = "idArticle")
    private  Article article;


    @Column(name = "typeMouvementStock")
    private  TypeMouvementStock typeMouvementStock;

}
