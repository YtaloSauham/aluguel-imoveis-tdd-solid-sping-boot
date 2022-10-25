package org.atividadeeng2.imoveisalugel.resoucerTest;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.atividadeeng2.imoveisalugel.AluguelImoveisSpringBootApplicationTests;
import org.atividadeeng2.imoveisalugel.entities.User;
import org.atividadeeng2.imoveisalugel.repositories.UserRepository;
import org.atividadeeng2.imoveisalugel.resources.UserResouce;
import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.time.LocalDate;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc()
public class UserResoucerTest{

    @Autowired
     MockMvc mockMvc;

    @Autowired
    private UserResouce userResouce;

    @Autowired
    private UserRepository userRepository;


    @BeforeEach
    void up(){
        User clientTest = new User(1L,"Ytalo",99999,9999,"fulano@hotmail.com", LocalDate.of(2001,02,21));
        userRepository.save(clientTest);
    }

    /*
    @AfterEach
    void down(){
        userRepository.deleteAll();
    }
*/

    @Test
    public void insereUmNovoUsuarioNoBancoDeDados() throws Exception {
        User clientTest = new User();
        clientTest.setName("Ytalo");
        clientTest.setEmail("fulano@hotmail.com");
        ObjectMapper mapper = new ObjectMapper();

        String json = mapper.writeValueAsString(clientTest);

        mockMvc.perform(MockMvcRequestBuilders.post("http://localhost:8080/users")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"name\": \"Ytalo\", \"email\":\"fulano@hotmail.com\"}")).andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.header().exists("Location"));
    }




    @Test
   public void retornaTodosOsClientesCadastrados() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("http://localhost:8080/users"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print());
    }







}
