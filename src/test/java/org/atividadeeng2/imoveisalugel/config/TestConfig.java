package org.atividadeeng2.imoveisalugel.config;


import org.atividadeeng2.imoveisalugel.entities.User;
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




    @Override
    public void run(String... args) throws Exception {
        User clientTest1 = new User(1L,"Ytalo",99999,9999,"fulano@hotmail.com", LocalDate.of(2001,02,21));
        User clientTest2 = new User(2L,"Ytalo",99999,9999,"fulano@hotmail.com", LocalDate.of(2001,02,21));


        userRepository.saveAll(Arrays.asList(clientTest1, clientTest2));

    }
}
