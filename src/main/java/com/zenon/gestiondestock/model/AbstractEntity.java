package com.zenon.gestiondestock.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.io.Serializable;
import java.time.Instant;
import java.util.Date;


@Data
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)//pour signifier qu'elle fait la gobalité de class
public class AbstractEntity implements Serializable {
    @Id
    @GeneratedValue
    private Integer id;
    @CreatedDate
    @Column(name="creationDate", nullable=false)
    @JsonIgnore
    private Instant creationDate;
    @LastModifiedDate
    @Column(name="lastModifiedDate")
    @JsonIgnore
    private  Instant lastModifiedDate;
}
