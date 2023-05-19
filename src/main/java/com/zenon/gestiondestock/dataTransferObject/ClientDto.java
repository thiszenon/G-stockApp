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
import java.util.stream.Collectors;

@Data
@Builder
public class ClientDto {

    private Integer id;


    private  String nomClient;

    private String prenomClient;

    private AdresseDto adresseDto;
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
                .adresseDto(AdresseDto.fromEntity(client.getAdresse()))
                .commandeClients(
                        client.getCommandeClients() != null?
                                client.getCommandeClients().stream()
                                        .map(CommandeClientDto::fromEntity)
                                        .collect(Collectors.toList()) : null
                )
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
        client.setAdresse(AdresseDto.toEntity(clientDto.getAdresseDto()));
        //client.setCommandeClients(CommandeClientDto.toEntity(clientDto.getCommandeClients()));

        return client;
    }


}
