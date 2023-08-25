package ariefbelajarteknologi.spring.config.complexconfigurationproperties;

import ariefbelajarteknologi.spring.config.properties.ApplicationProperties;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = ComplexConfigurationPropertiesTest.TestApplication.class)
public class ComplexConfigurationPropertiesTest {

    @Autowired
    private ApplicationProperties properties;

    @Test
    void testDatabaseProperties() {
        Assertions.assertEquals("arief",properties.getDatabase().getUsername());
        Assertions.assertEquals("rahasia",properties.getDatabase().getPassword());
        Assertions.assertEquals("belajar",properties.getDatabase().getDatabase());
        Assertions.assertEquals("jdbc:contoh",properties.getDatabase().getUrl());
    }

    @SpringBootApplication
    @EnableConfigurationProperties({
            ApplicationProperties.class
    })
    public static class TestApplication {

    }
}
