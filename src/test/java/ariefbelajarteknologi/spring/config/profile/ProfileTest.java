package ariefbelajarteknologi.spring.config.profile;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest
@ActiveProfiles({"production"})
public class ProfileTest {

    @Autowired
    private TestApplication.Sayhello sayhello;

    @Test
    @Disabled
    void testProfileLocal() {
        Assertions.assertEquals("Hello Arief From Local", sayhello.say("Arief"));
    }

    @Test
    void testProfileProduction() {
        Assertions.assertEquals("Hello Arief From Production", sayhello.say("Arief"));
    }

    @SpringBootApplication
    public static class TestApplication {

        public interface Sayhello {
            String say(String name);
        }

        @Component
        @Profile({"local"})
        public static class SayHelloLocal implements Sayhello {

            @Override
            public String say(String name) {
                return "Hello " + name + " From Local";
            }
        }

        @Component
        @Profile({"production"})
        public static class SayHelloProduction implements Sayhello {

            @Override
            public String say(String name) {
                return "Hello " + name + " From Production";
            }
        }

    }
}
