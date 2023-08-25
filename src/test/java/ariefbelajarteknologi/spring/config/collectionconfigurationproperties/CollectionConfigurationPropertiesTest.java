package ariefbelajarteknologi.spring.config.collectionconfigurationproperties;

import ariefbelajarteknologi.spring.config.properties.ApplicationProperties;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;

@SpringBootTest(classes = CollectionConfigurationPropertiesTest.TestApplication.class)
public class CollectionConfigurationPropertiesTest {

    @Autowired
    private ApplicationProperties properties;

    @Test
    void testCollection() {
        Assertions.assertEquals(Arrays.asList("products","customers","categories"),properties.getDatabase().getWhitelistTables());
        Assertions.assertEquals(100,properties.getDatabase().getMaxTablesSize().get("products"));
        Assertions.assertEquals(100,properties.getDatabase().getMaxTablesSize().get("customers"));
        Assertions.assertEquals(100,properties.getDatabase().getMaxTablesSize().get("categories"));
    }

    @SpringBootApplication
    @EnableConfigurationProperties({
            ApplicationProperties.class
    })
    public static class TestApplication {

    }
}
