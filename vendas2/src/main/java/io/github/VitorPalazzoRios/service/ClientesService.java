package io.github.VitorPalazzoRios.service;


import io.github.VitorPalazzoRios.model.Cliente;
import io.github.VitorPalazzoRios.repository.ClientesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientesService {

    private ClientesRepository repository;

    @Autowired
    public ClientesService(ClientesRepository repository){
        this.repository = repository;
    }


    public void salvarCliente(Cliente cliente){
        validarCliente(cliente);

        this.repository.persistir(cliente);
    }


    public void validarCliente(Cliente Cliente){

    }


}
