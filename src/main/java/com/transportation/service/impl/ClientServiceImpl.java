package com.transportation.service.impl;

import com.transportation.dto.ClientDTO;
import com.transportation.entity.Client;
import com.transportation.repository.ClientRepository;
import com.transportation.service.ClientService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientServiceImpl implements ClientService {

    private ModelMapper modelMapper = new ModelMapper();

    @Autowired
    private ClientRepository clientRepository;

    @Override
    public Client createClient(ClientDTO client) {
        return clientRepository.save(convertToEntity(client));
    }

    @Override
    public List<Client> getAllClients() {
        return clientRepository.findAll();
    }

    @Override
    public Client getClientById(Long clientId) {
        Optional<Client> optionalClient = clientRepository.findById(clientId);
        return optionalClient.orElse(null);
    }

    @Override
    public Client updateClient(Long clientId, ClientDTO clientDetails) {
        Optional<Client> optionalClient = clientRepository.findById(clientId);
        if (optionalClient.isPresent()) {
            Client existingClient = optionalClient.get();
            existingClient.setFirstName(clientDetails.getFirstName());
            existingClient.setLastName(clientDetails.getLastName());
            existingClient.setEmail(clientDetails.getEmail());
            existingClient.setPassword(clientDetails.getPassword());
            existingClient.setPhoneNumber(clientDetails.getPhoneNumber());
            existingClient.setAddress(clientDetails.getAddress());
            existingClient.setProfileImage(clientDetails.getProfileImage());
            existingClient.setUpdatedBy(clientDetails.getUpdatedBy());
            existingClient.setNotificationToken(clientDetails.getNotificationToken());
            return clientRepository.save(existingClient);
        } else {
            return null;
        }
    }

    @Override
    public void deleteClient(Long clientId) {
        clientRepository.deleteById(clientId);
    }
    public ClientDTO convertToDTO(Client client) {
        return modelMapper.map(client, ClientDTO.class);
    }

    public Client convertToEntity(ClientDTO clientDTO) {
        return modelMapper.map(clientDTO, Client.class);
    }
}
