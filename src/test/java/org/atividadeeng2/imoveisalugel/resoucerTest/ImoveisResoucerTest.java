package org.atividadeeng2.imoveisalugel.resoucerTest;

import org.atividadeeng2.imoveisalugel.entities.Imoveis;
import org.atividadeeng2.imoveisalugel.repositories.ImoveisRepository;
import org.atividadeeng2.imoveisalugel.resources.ImoveisResouce;
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
public class ImoveisResoucerTest {

    @Autowired
     MockMvc mockMvc;

    @Autowired
    private ImoveisResouce imoveisResouce;

    @Autowired
    private ImoveisRepository imoveisRepository;



    @BeforeEach
    void up(){
        Imoveis imoveisTest = new Imoveis();
        imoveisRepository.save(imoveisTest);
    }


    @AfterEach
    void down(){
        imoveisRepository.deleteAll();
    }


    @Test
    public void insereUmNovoImoveisNoBancoDeDados() throws Exception {


        mockMvc.perform(MockMvcRequestBuilders.post("http://localhost:8080/imovel")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"endereco\": \"Rua 90 Quadra 70\", \"cep\":\"65000-000\"," +
                        "\"metragem\":\"40m\",\"dormitorios\":\"4\"," +
                        "\"suites\":\"2\"," +
                        "\"vagasGaragen\":\"1\"," +
                        "\"valorAluguelSugerido\":\"50\"" +
                        ",\"observacao\":\"nao é calote dessa vez\"}")).andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.header().exists("Location"));
    }




    @Test
   public void retornaTodosOsImoveisesCadastrados() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("http://localhost:8080/imovel"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print());
    }


    @Test
    public void deletaUmImoveiseEspecificadoPorIDOuErro() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.delete("http://localhost:8080/imovel/1")
                .contentType(MediaType.APPLICATION_JSON))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isNoContent());
    }

    @Test
    public void fazAltualizacaoDoImoveiseOuErro() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.put("http://localhost:8080/imovel/1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"id\": \"1\",\"bairro\": \"Cohama\", \"observacao\":\"nada de calote\"}")).andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk());
    }
    @Test
    public void deveTrazerOsImoveisPorBairro() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("http://localhost:8080/imovel/Cohatrac"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print());
    }


}
