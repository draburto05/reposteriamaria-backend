package com.antonieta.MariaSpring.controller;


import ch.qos.logback.core.net.server.Client;
import com.antonieta.MariaSpring.dto.ClientOrderRequest;
import com.antonieta.MariaSpring.module.Clients;
import com.antonieta.MariaSpring.module.Products;
import com.antonieta.MariaSpring.service.ClientsService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController//vamos a usar este controlador para llamar a la API
@RequestMapping(path="/api/clients")

@AllArgsConstructor
public class ClientsController {


    private ClientsService clientsService;

    @GetMapping //http://localhost:8080/api/users
    public List<Clients> getAllClients(){
        return this.clientsService.getAllClients();
    }

    @GetMapping(path="{clientId}")
    public Clients getUserById(@PathVariable("userId")Long id){
        return this.clientsService.getClientById(id);

    }

    @PostMapping
    public Clients addClient(@RequestBody Clients clients){
        return this.clientsService.addClientById(clients);
    }


    @PutMapping(path="{clientId}")
    public Clients updateClientId(@PathVariable("clientId") Long id,@RequestBody Clients clientUpdated){
        return this.clientsService.UpdateClientById(id,clientUpdated);
    }

    @DeleteMapping(path = "{clientId}")// http://localhost:8080/api/products/id  http://localhost:8080/api/products/2 pero con peticion tipo delete
    public Clients deleteClientById(@PathVariable("clientId")Long id) {
        return this.clientsService.deleteClientById(id);
    }

    //PETICION PARA AGREGAR PEDIDO
    @PostMapping(path="{clientId}/add-order")//http://localhost:8081/api/users/userId/add-direction
    public Clients addClientOrder(@PathVariable("clientId")Long id, @RequestBody ClientOrderRequest clientOrderRequest){
        return clientsService.addClientOrder(id,clientOrderRequest);

    }


}
