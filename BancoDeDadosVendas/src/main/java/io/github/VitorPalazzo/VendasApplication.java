package io.github.VitorPalazzo;

import io.github.VitorPalazzo.domain.entity.Cliente;
import io.github.VitorPalazzo.domain.repositorio.Clientes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;


@SpringBootApplication
public class VendasApplication {

    @Bean
    public CommandLineRunner init(@Autowired Clientes clientes){
        return args -> {

            clientes.salvar(new Cliente("Vitor"));
            clientes.salvar(new Cliente("Outro Cliente"));

            List<Cliente> todosClientes = clientes.obterTodos();
            todosClientes.forEach(System.out :: println);

           todosClientes.forEach(c -> {
               c.setNome(c.getNome() + " Atualizado");
               clientes.atualizar(c);
           });

           clientes.buscarPorNome("Cli").forEach(System.out :: println);

            System.out.println("deletando os clintes");
            clientes.obterTodos().forEach(c -> {
                clientes.deletar(c);
            });


            todosClientes = clientes.obterTodos();
            if(todosClientes.isEmpty()){
                System.out.println("nenhum cliente encontrado");
            }else{
                todosClientes.forEach(System.out :: println);
            }

        };

    }

    public static void main(String[] args) {
        SpringApplication.run(VendasApplication.class, args);
    }
}
