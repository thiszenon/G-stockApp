package com.zenon.gestiondestock.dataTransferObject;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.zenon.gestiondestock.model.Article;
import com.zenon.gestiondestock.model.MouvementStock;
import com.zenon.gestiondestock.model.TypeMouvementStock;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.time.Instant;

@Data
@Builder
public class MouvementStockDto {
    private Integer id;



    private Instant dateMvt;

    private BigDecimal quantity;

    @JsonIgnore
    private ArticleDto article;

    @JsonIgnore
    private TypeMouvementStock typeMouvementStock;

    public  static MouvementStockDto fromEntity(MouvementStock mouvementStock){
        if(mouvementStock == null){
            return null;
        }
        return MouvementStockDto.builder()
                .id(mouvementStock.getId())
                .dateMvt(mouvementStock.getDateMvt())
                .quantity(mouvementStock.getQuantity())
                .build();
    }//fromEntity

    public static MouvementStock toEntity(MouvementStockDto mouvementStockDto){
        if(mouvementStockDto == null){
            return null;
        }
        MouvementStock mouvementStock= new MouvementStock();
        mouvementStock.setId(mouvementStockDto.getId());
        mouvementStock.setDateMvt(mouvementStockDto.getDateMvt());
        mouvementStock.setQuantity(mouvementStockDto.getQuantity());

        return mouvementStock;
    }//toEntity
}
