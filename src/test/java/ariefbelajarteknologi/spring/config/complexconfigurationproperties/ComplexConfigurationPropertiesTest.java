package ariefbelajarteknologi.spring.config.complexconfigurationproperties;

import ariefbelajarteknologi.spring.config.converter.StringToDateConverter;
import ariefbelajarteknologi.spring.config.properties.ApplicationProperties;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.convert.ApplicationConversionService;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.springframework.core.convert.ConversionService;

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
    @Import(StringToDateConverter.class)
    public static class TestApplication {

        @Bean
        public ConversionService conversionService(StringToDateConverter stringToDateConverter) {
            ApplicationConversionService conversionService = new ApplicationConversionService();
            conversionService.addConverter(stringToDateConverter);
            return conversionService;
        }

    }

}
