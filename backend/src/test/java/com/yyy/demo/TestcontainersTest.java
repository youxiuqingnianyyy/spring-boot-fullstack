package com.yyy.demo;
import org.junit.jupiter.api.Test;
import org.testcontainers.junit.jupiter.Testcontainers;
import static org.junit.jupiter.api.Assertions.assertTrue;

@Testcontainers
public class TestcontainersTest extends AbstractTestcontainers {

    // @Autowired
    // private ApplicationContext applicationContext;
    @Test
    void canStartPostgresDB() {
        assertTrue(postgreSQLContainer.isRunning());
        assertTrue(postgreSQLContainer.isCreated());
    }
    //System.out.println(applicationContext.getBeanDefinitionCount());
    //for (int name = 0; name < applicationContext.getBeanDefinitionNames().length; name++) {
    //    System.out.println(name);
    //}
}

