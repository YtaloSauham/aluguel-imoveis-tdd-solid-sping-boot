package org.atividadeeng2.imoveisalugel.resoucerTest;

import org.atividadeeng2.imoveisalugel.repositories.AluguelRepository;
import org.atividadeeng2.imoveisalugel.resources.AluguelResouce;
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
    private AluguelResouce AluguelResouce;

    @Autowired
    private AluguelRepository AluguelRepository;


    /*
    @BeforeEach
    void up(){
        Aluguel aluguelTest = new Aluguel();
        AluguelRepository.save(aluguelTest);
    }
*/

    @AfterEach
    void down(){
        AluguelRepository.deleteAll();
    }


    @BeforeEach
    @Test
    public void insereUmNovoAluguelNoBancoDeDados() throws Exception {


        mockMvc.perform(MockMvcRequestBuilders.post("http://localhost:8080/aluguel")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"valorPago\": \"45.0\", \"observacao\":\"sofri calote\"}")).andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.header().exists("Location"));
    }




    @Test
   public void retornaTodosOsaluguelesCadastrados() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("http://localhost:8080/aluguel"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print());
    }


    @Test
    public void deletaUmalugueleEspecificadoPorIDOuErro() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.delete("http://localhost:8080/aluguel/1")
                .contentType(MediaType.APPLICATION_JSON))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isNoContent());
    }

    @Test
    public void fazAltualizacaoDoalugueleOuErro() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.put("http://localhost:8080/aluguel/1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"id\": \"1\",\"valorPago\": \"46.0\", \"observacao\":\"sofri calote\"}")).andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk());
    }








}
