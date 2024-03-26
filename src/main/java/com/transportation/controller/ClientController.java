package com.transportation.controller;


import com.transportation.dto.ClientDTO;
import com.transportation.entity.Client;
import com.transportation.security.service.UserInfoDetails;
import com.transportation.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/client")
public class ClientController {

    @Autowired
    private ClientService clientService;

    // Create a new client
    @PostMapping
    public ResponseEntity<Client> createClient(@RequestBody ClientDTO client) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UserInfoDetails userDetailsDTO = (UserInfoDetails) authentication.getPrincipal();
        client.setCreatedBy(userDetailsDTO.getId());
        client.setUpdatedBy(userDetailsDTO.getId());
        Client createdClient = clientService.createClient(client);
        return new ResponseEntity<>(createdClient, HttpStatus.CREATED);
    }

    // Get all clients
    @GetMapping
    public ResponseEntity<List<Client>> getAllClients() {
        List<Client> clients = clientService.getAllClients();
        return new ResponseEntity<>(clients, HttpStatus.OK);
    }

    // Get client by ID
    @GetMapping("/{id}")
    public ResponseEntity<Client> getClientById(@PathVariable("id") Long clientId) {
        Client client = clientService.getClientById(clientId);
        if (client != null) {
            return new ResponseEntity<>(client, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Update client
    @PutMapping("/{id}")
    public ResponseEntity<Client> updateClient(@PathVariable("id") Long clientId, @RequestBody ClientDTO clientDetails) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UserInfoDetails userDetailsDTO = (UserInfoDetails) authentication.getPrincipal();
        clientDetails.setUpdatedBy(userDetailsDTO.getId());
        Client updatedClient = clientService.updateClient(clientId, clientDetails);
        if (updatedClient != null) {
            return new ResponseEntity<>(updatedClient, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Delete client
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteClient(@PathVariable("id") Long clientId) {
        clientService.deleteClient(clientId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
