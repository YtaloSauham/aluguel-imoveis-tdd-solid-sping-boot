package org.atividadeeng2.imoveisalugel.config;


import org.atividadeeng2.imoveisalugel.entities.Aluguel;
import org.atividadeeng2.imoveisalugel.entities.Imoveis;
import org.atividadeeng2.imoveisalugel.entities.Locacao;
import org.atividadeeng2.imoveisalugel.entities.User;
import org.atividadeeng2.imoveisalugel.entities.enums.ImoveisTipoStatus;
import org.atividadeeng2.imoveisalugel.repositories.AluguelRepository;
import org.atividadeeng2.imoveisalugel.repositories.ImoveisRepository;
import org.atividadeeng2.imoveisalugel.repositories.LocacaoRepository;
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
    @Autowired
    private LocacaoRepository locacaoRepository;


    @Override
    public void run(String... args) throws Exception {

        User clientTest1 = new User(null,"Ytalo",99999,9999,"fulano@hotmail.com", LocalDate.of(2001,02,21));
        User clientTest2 = new User(null,"Ytalo",99999,9999,"fulano@hotmail.com", LocalDate.of(2001,02,21));

        Aluguel aluguelTest2 = new Aluguel();

        Imoveis imoveltest = new Imoveis();

        Locacao locacaoTest =new Locacao();

        aluguelTest2.setObservacao("Sofri calote duas vezes");
        aluguelTest2.setValorPago(45.0);
        aluguelTest2.setDataVencimento(LocalDate.of(2001,02,21));
        aluguelTest2.setDataPagamento(LocalDate.of(2001,02,21));


        imoveltest.setId(null);
        imoveltest.setMetragem("40");
        imoveltest.setEndereco("RUA CALOTE");
        imoveltest.setValorAluguelSugerido(500.00);
        imoveltest.setTipoImovel(ImoveisTipoStatus.APARTAMENTO);



        locacaoTest.setId(1L);
        locacaoTest.setAluguel(aluguelTest2);
        locacaoTest.setAtivo(true);
        locacaoTest.setDataInicio(LocalDate.now());
        locacaoTest.setDiaVencimento(LocalDate.now());
        locacaoTest.setImovel(imoveltest);
        locacaoTest.setInquilino(clientTest1);
        locacaoTest.setDataFim(LocalDate.now());
        locacaoTest.setObservacao("Esse aqui é calote,certeza");
        locacaoTest.setPercentualMulta(2.0);
        locacaoTest.setValorAluguel(400.00);




        imoveisRepository.save(imoveltest);
        userRepository.saveAll(Arrays.asList(clientTest1, clientTest2));
        aluguelRepository.save(aluguelTest2);
        locacaoRepository.save(locacaoTest);

    }
}
