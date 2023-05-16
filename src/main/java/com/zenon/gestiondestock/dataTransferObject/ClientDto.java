package com.zenon.gestiondestock.dataTransferObject;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.zenon.gestiondestock.model.Adresse;
import com.zenon.gestiondestock.model.Client;
import com.zenon.gestiondestock.model.CommandeClient;
import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.OneToMany;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class ClientDto {

    private Integer id;


    private  String nomClient;

    private String prenomClient;
    @JsonIgnore
    private Adresse adresse;
    private String photo;

    private String email;
    private String numTel;

    @JsonIgnore
    private List<CommandeClientDto> commandeClients;

//MAPPER Client -->ClientDTO

    public static ClientDto fromEntity(Client client){
        if(client == null){
            return null;
            //exception
        }
        return ClientDto.builder()
                .id(client.getId())
                .nomClient(client.getNomClient())
                .prenomClient(client.getPrenomClient())
                .photo(client.getPhoto())
                .email(client.getEmail())
                .numTel(client.getNumTel())
                .build();
    }

    public static Client toEntity(ClientDto clientDto){
        if(clientDto==null){
            return null;
            //faire une exception
        }

        Client client = new Client();
        client.setId(clientDto.getId());
        client.setNomClient(clientDto.getNomClient());
        client.setPrenomClient(clientDto.getPrenomClient());
        client.setPhoto(clientDto.getPhoto());
        client.setEmail(clientDto.getEmail());
        client.setNumTel(client.getNumTel());
        return client;
    }


}
