package ariefbelajarteknologi.spring.config.environtment;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.env.Environment;

@SpringBootTest
public class EnvirontmentTest {

    @Autowired
    private Environment environment;

    @Test
    void testEnvirontment() {
        String javaHome = environment.getProperty("JAVA_HOME");
        System.out.println(javaHome);
        // Assertions.assertEquals("D:\jdk-19.0.2", javaHome);
        // ERROR gegara path wondows lol
    }

    @SpringBootApplication
    public static class TestApplication {

    }
}
