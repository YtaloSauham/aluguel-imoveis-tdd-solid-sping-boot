package org.atividadeeng2.imoveisalugel;



import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = AluguelImoveisSpringBootApplication.class)
@TestPropertySource(locations = "application-test.properties")

public class AluguelImoveisSpringBootApplicationTests {

    @Test
    void contextLoads() {
    }

}
