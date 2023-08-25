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

    @Test
    void testEmbeddedCollection() {
        Assertions.assertEquals("default",properties.getDefaultRoles().get(0).getId());
        Assertions.assertEquals("Default Role",properties.getDefaultRoles().get(0).getName());
        Assertions.assertEquals("guest",properties.getDefaultRoles().get(1).getId());
        Assertions.assertEquals("Guest Role",properties.getDefaultRoles().get(1).getName());

        Assertions.assertEquals("admin",properties.getRoles().get("admin").getId());
        Assertions.assertEquals("Admin Role",properties.getRoles().get("admin").getName());
        Assertions.assertEquals("finance",properties.getRoles().get("finance").getId());
        Assertions.assertEquals("Finance Role",properties.getRoles().get("finance").getName());
    }

    @SpringBootApplication
    @EnableConfigurationProperties({
            ApplicationProperties.class
    })
    public static class TestApplication {

    }
}
