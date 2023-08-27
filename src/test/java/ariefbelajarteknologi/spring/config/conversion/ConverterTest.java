package ariefbelajarteknologi.spring.config.conversion;

import ariefbelajarteknologi.spring.config.properties.ApplicationProperties;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.test.context.SpringBootTest;

import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

@SpringBootTest(classes = ConverterTest.TestApplication.class)
public class ConverterTest {

    @Autowired
    private ApplicationProperties properties;

    @Test
    void testDuration() { // String to Duration converter
        Assertions.assertEquals(Duration.ofSeconds(10), properties.getDefaultTimeout());
    }

    @Test
    void testCustomConverter() {
        Date expireDate = properties.getExpireDate();

        var dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Assertions.assertEquals("2023-08-26", dateFormat.format(expireDate));
    }

    @SpringBootApplication
    @EnableConfigurationProperties({
            ApplicationProperties.class
    })
    public static class TestApplication {

    }
}
