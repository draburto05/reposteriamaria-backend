package com.antonieta.MariaSpring.service;

import com.antonieta.MariaSpring.dto.ClientOrderRequest;
import com.antonieta.MariaSpring.module.Clients;

import java.util.List;

public interface ClientsService  {

    List<Clients> getAllClients();

    Clients getClientById(Long id);
    Clients deleteClientById(Long id);
    Clients addClientById(Clients client);
    Clients UpdateClientById(Long id,Clients clientUpdate);

    Clients addClientOrder(Long id, ClientOrderRequest clientOrderRequest);

    boolean validateClient(Clients client);
}

