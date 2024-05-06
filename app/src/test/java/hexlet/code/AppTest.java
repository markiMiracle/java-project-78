package hexlet.code;

import org.junit.jupiter.api.Test;

import static hexlet.code.App.hello;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class AppTest {
    @Test
    void helloTest() {
        var hel = hello();
        assertEquals(hel, hello());
    }

}
