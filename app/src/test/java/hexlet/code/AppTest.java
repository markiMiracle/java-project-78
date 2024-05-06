package hexlet.code;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static hexlet.code.App.hello;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class AppTest {
    private static Validator v;
    @BeforeAll
    public static void beforeAll() {
        v = new Validator();
    }
    @Test
    void helloTest() {
        var hel = hello();
        assertEquals(hel, hello());
    }

    @Test
    void stringSchemaTest1() {
        v = new Validator();
        StringSchema schema = v.string();
        assertTrue(schema.isValid(""));
        assertTrue(schema.isValid(null));
        schema.required();
        assertFalse(schema.isValid(null));
        assertFalse(schema.isValid(""));
        assertTrue(schema.isValid("what does the fox say"));
        assertTrue(schema.contains("wh").isValid("what does the fox say"));

    }

    @Test
    void stringSchemaTest2() {
        v = new Validator();
        StringSchema schema = v.string();
        assertTrue(schema.minLength(10).minLength(4).isValid("Hexlet"));
        assertFalse(schema.contains("whatthe").isValid("what does the fox say"));
        assertFalse(schema.isValid("what does the fox say"));
    }

}
