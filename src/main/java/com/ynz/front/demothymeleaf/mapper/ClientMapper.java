package com.ynz.front.demothymeleaf.mapper;

import com.ynz.front.demothymeleaf.Entities.Client;
import com.ynz.front.demothymeleaf.dto.ClientDto;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor(staticName = "instance")
public class ClientMapper implements Mapper<Client, ClientDto> {

    @Override
    public ClientDto map(Client client) {
        return ClientDto.builder()
                .firstName(client.getFirstName())
                .lastName(client.getLastName())
                .email(client.getEmail())
                .phone(client.getPhone())
                .build();
    }

    @Override
    public Client invert(ClientDto clientDto) {
        Client client = new Client();
        client.setEmail(clientDto.getEmail());
        client.setFirstName(clientDto.getFirstName());
        client.setLastName(clientDto.getLastName());
        client.setPhone(clientDto.getPhone());
        return client;
    }
}
