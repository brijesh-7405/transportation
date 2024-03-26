package com.transportation.service;

import com.transportation.dto.ClientDTO;
import com.transportation.entity.Client;

import java.util.List;

public interface ClientService {
    Client createClient(ClientDTO client);
    List<Client> getAllClients();
    Client getClientById(Long clientId);
    Client updateClient(Long clientId, ClientDTO clientDetails);
    void deleteClient(Long clientId);
}
