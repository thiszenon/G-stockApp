package com.zenon.gestiondestock.dataTransferObject;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.zenon.gestiondestock.model.Client;
import com.zenon.gestiondestock.model.CommandeClient;
import com.zenon.gestiondestock.model.LigneCommandeClient;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Builder;
import lombok.Data;

import java.time.Instant;
import java.util.List;

@Data
@Builder
public class CommandeClientDto {
    private Integer id;


    private String code;

    private Instant dateCommande;


    @JsonIgnore
    private ClientDto client;

    @JsonIgnore
    private List<LigneCommandeClientDto> ligneCommandeClient;

//MAPPER CommandeClient --->CommandeClientDto
    public static CommandeClientDto fromEntity(CommandeClient commandeClient){
        if(commandeClient==null){
            return null;
            //exception
        }
        return CommandeClientDto.builder()
                .id(commandeClient.getId())
                .code(commandeClient.getCode())
                .dateCommande(commandeClient.getDateCommande())
                .build();
    }
//MAPPER CommandeClientDto -->CommandeClient
    public static CommandeClient toEntity(CommandeClientDto commandeClientDto){
        if(commandeClientDto==null){
            return null;
            //exception
        }
        CommandeClient client=new CommandeClient();
        client.setId(commandeClientDto.getId());
        client.setCode(commandeClientDto.getCode());
        client.setDateCommande(commandeClientDto.getDateCommande());
        return client;
    }
}
