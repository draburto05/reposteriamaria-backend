package com.antonieta.MariaSpring.service;


import ch.qos.logback.core.net.server.Client;
import com.antonieta.MariaSpring.dto.ClientOrderRequest;
import com.antonieta.MariaSpring.module.Clients;
import com.antonieta.MariaSpring.module.Order_buy;
import com.antonieta.MariaSpring.repository.ClientsRepository;
import com.antonieta.MariaSpring.repository.OrderBuyRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ClientsServiceImpl implements ClientsService{
 private final ClientsRepository clientsRepository;
 private final PasswordEncoder passwordEncoder;
 private final OrderBuyRepository orderBuyRepository;


    @Override
    public List<Clients> getAllClients() {
        return clientsRepository.findAll();
    }

    @Override
    public Clients getClientById(Long id) {

        return clientsRepository.findById(id).orElseThrow(
                ()->new IllegalArgumentException("El usuario con el id " + id+ " no existe")

        );

    }

    @Override
    public Clients deleteClientById(Long id) {

        Optional<Clients> optionalClient = clientsRepository.findById(id);
        if(optionalClient.isEmpty())throw
                new IllegalArgumentException("El Cliente con el id " + id+ " no existe");
        clientsRepository.deleteById(id);
        return optionalClient.get();


    }

    @Override
    public Clients addClientById(Clients client) {
        String hashedPassword = this.passwordEncoder.encode(client.getPassword());
        client.setPassword(hashedPassword);
        return clientsRepository.save(client);
    }

    @Override
    public Clients UpdateClientById(Long id, Clients clientUpdate) {
        Optional<Clients> optionalClient = clientsRepository.findById(id);
        if(optionalClient.isEmpty())throw
                new IllegalArgumentException("El producto con el id " + id+ " no existe");
        Clients clientOri = optionalClient.get();
        //Evaluar el producto que hara cambio evaluando propiedades y solo donde no esten vacias se aplican cambios
        if(clientUpdate.getName() !=null) clientOri.setName(clientUpdate.getName());
        if(clientUpdate.getLastName() !=null) clientOri.setLastName(clientUpdate.getLastName());
        if(clientUpdate.getLastName2() !=null) clientOri.setLastName2(clientUpdate.getLastName2());
        if(clientUpdate.getEmail() !=null) clientOri.setEmail(clientUpdate.getEmail());
        if(clientUpdate.getTel() !=null) clientOri.setTel(clientUpdate.getTel());
        if(clientUpdate.getAddress() !=null) clientOri.setAddress(clientUpdate.getAddress());
        if(clientUpdate.getPassword() !=null) clientOri.setPassword(passwordEncoder.encode(clientUpdate.getPassword()));
        return clientsRepository.save(clientOri);



    }

    @Override
    public Clients addClientOrder(Long id, ClientOrderRequest clientOrderRequest) {
        Clients client= clientsRepository.findById(id).orElseThrow(
                ()-> new IllegalArgumentException(("El cliente con el id "+id+" no existe")));
       Order_buy order_buy= new Order_buy();
        if(clientOrderRequest.getFecha()!= null) order_buy.setFecha(clientOrderRequest.getFecha());
        if(clientOrderRequest.getPrice()!= null)  order_buy.setPrice(clientOrderRequest.getPrice());
        if(clientOrderRequest.getTipo_entrega()!= null)  order_buy.setTipo_entrega(clientOrderRequest.getTipo_entrega());
        order_buy.setClient(client);
        orderBuyRepository.save(order_buy);
        client.getOrder_buys().add(order_buy);
        return clientsRepository.save(client);
    }

    @Override
    public boolean validateClient(Clients client) {
        return false;
    }
}
