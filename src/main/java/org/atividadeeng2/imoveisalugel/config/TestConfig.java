package org.atividadeeng2.imoveisalugel.config;


import org.atividadeeng2.imoveisalugel.entities.Aluguel;
import org.atividadeeng2.imoveisalugel.entities.Imoveis;
import org.atividadeeng2.imoveisalugel.entities.User;
import org.atividadeeng2.imoveisalugel.entities.enums.ImoveisTipoStatus;
import org.atividadeeng2.imoveisalugel.repositories.AluguelRepository;
import org.atividadeeng2.imoveisalugel.repositories.ImoveisRepository;
import org.atividadeeng2.imoveisalugel.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.time.LocalDate;
import java.util.Arrays;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AluguelRepository aluguelRepository;

    @Autowired
    private ImoveisRepository imoveisRepository;


    @Override
    public void run(String... args) throws Exception {

        User clientTest1 = new User(1L,"Ytalo",99999,9999,"fulano@hotmail.com", LocalDate.of(2001,02,21));
        User clientTest2 = new User(2L,"Ytalo",99999,9999,"fulano@hotmail.com", LocalDate.of(2001,02,21));

        Aluguel aluguelTest2 = new Aluguel();

        Imoveis imoveltest = new Imoveis();

        aluguelTest2.setObservacao("Sofri calote duas vezes");
        aluguelTest2.setValorPago(45.0);
        aluguelTest2.setDataVencimento(LocalDate.of(2001,02,21));
        aluguelTest2.setDataPagamento(LocalDate.of(2001,02,21));


        imoveltest.setId(1L);
        imoveltest.setMetragem("40");
        imoveltest.setEndereco("RUA CALOTE");
        imoveltest.setValorAluguelSugerido(500.00);
        imoveltest.setTipoImovel(ImoveisTipoStatus.APARTAMENTO);

        imoveisRepository.save(imoveltest);
        userRepository.saveAll(Arrays.asList(clientTest1, clientTest2));
        aluguelRepository.save(aluguelTest2);

    }
}
