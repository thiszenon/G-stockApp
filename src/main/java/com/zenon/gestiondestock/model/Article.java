package com.zenon.gestiondestock.model;


import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.BatchSize;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "Article")
public class Article extends AbstractEntity{
    @Column(name = "codeArticle")
    private String codeArticle;

    @Column(name = "designation")
    private String designation;

    @Column(name = "prixUnitaire")
    private BigDecimal prixUnitaire;

    @Column(name = "tauxTva")
    private  BigDecimal tauxTva;

    @Column(name = "prixUnitaireTtc")
    private BigDecimal prixUnitaireTtc;

    @Column(name = "photo")
    private String photo;

    @ManyToOne
    @JoinColumn(name = "idCategory")
    private Category category;
}
