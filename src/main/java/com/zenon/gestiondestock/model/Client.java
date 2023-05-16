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
@Table(name = "Client")
public class Client extends AbstractEntity{

    @Column(name = "nomClient")
    private  String nomClient;

    @Column(name = "prenomClient")
    private String prenomClient;

    @Embedded
    private  Adresse adresse;
    @Column(name = "photo")
    private String photo;

    @Column(name = "email")
    private String email;
    @Column(name = "phoneNumber")
    private String numTel;

    @OneToMany(mappedBy = "client")
    private List<CommandeClient> commandeClients;

}
