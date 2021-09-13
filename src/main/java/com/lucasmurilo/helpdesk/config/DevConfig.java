package com.lucasmurilo.helpdesk.config;

import com.lucasmurilo.helpdesk.entities.Cliente;
import com.lucasmurilo.helpdesk.entities.OrdemServico;
import com.lucasmurilo.helpdesk.entities.Tecnico;
import com.lucasmurilo.helpdesk.entities.enums.Prioridade;
import com.lucasmurilo.helpdesk.entities.enums.Status;
import com.lucasmurilo.helpdesk.repositories.ClienteRepository;
import com.lucasmurilo.helpdesk.repositories.OrdemServicoRepository;
import com.lucasmurilo.helpdesk.repositories.TecnicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("dev")
public class DevConfig implements CommandLineRunner {

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private TecnicoRepository tecnicoRepository;

    @Autowired
    private OrdemServicoRepository ordemServicoRepository;
    @Override
    public void run(String... args) throws Exception {
        Tecnico tec1 = new Tecnico(null, "Bod Marley", "284.757.570-73", "(65) 98150-5851");
        Cliente c1 = new Cliente(null, "Paula Fernandez", "816.326.090-45", "(65) 98113-3307");
    OrdemServico os1 = new OrdemServico(null, Prioridade.ALTA, "Teste create OS", Status.ANDAMENTO, tec1, c1);

    tec1.getList().add(os1);
    c1.getList().add(os1);

    tecnicoRepository.save(tec1);
    clienteRepository.save(c1);
    ordemServicoRepository.save(os1);

    }
}
