package org.atividadeeng2.imoveisalugel.resoucerTest;

import org.atividadeeng2.imoveisalugel.repositories.LocacaoRepository;
import org.atividadeeng2.imoveisalugel.resources.LocacaoResouce;
import org.junit.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc()
public class LocacaoResoucerTest {

    @Autowired
     MockMvc mockMvc;

    @Autowired
    private LocacaoResouce locacaoResouce;

    @Autowired
    private LocacaoRepository locacaoRepository;


    /*
    @BeforeEach
    void up(){
        Locacao LocacaoTest = new Locacao();
        LocacaoRepository.save(LocacaoTest);
    }
*/

    @AfterEach
    void down(){
        locacaoRepository.deleteAll();
    }


    @BeforeEach
    @Test
    public void insereUmNovoLocacaoNoBancoDeDados() throws Exception {


        mockMvc.perform(MockMvcRequestBuilders.post("http://localhost:8080/locacao")
                .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"valorAluguel\": \"70.00\",\"observacao\":\"nao é calote dessa vez\"}")).andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.header().exists("Location"));
    }




    @Test
   public void retornaTodosOsLocacaoesCadastrados() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("http://localhost:8080/locacao"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print());
    }


    @Test
    public void deletaUmLocacaoeEspecificadoPorIDOuErro() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.delete("http://localhost:8080/locacao/1")
                .contentType(MediaType.APPLICATION_JSON))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isNoContent());
    }

    @Test
    public void fazAltualizacaoDoLocacaoeOuErro() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.put("http://localhost:8080/locacao/1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"id\": \"1\",\"valorPago\": \"46.0\", \"observacao\":\"sofri calote\"}")).andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk());
    }








}
