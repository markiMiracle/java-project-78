package hexlet.code;

import hexlet.code.schemas.NumberSchema;
import hexlet.code.schemas.StringSchema;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static hexlet.code.App.hello;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class ValidatorTest {
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
        StringSchema schema = v.string();
        assertTrue(schema.minLength(10).minLength(4).isValid("Hexlet"));
        assertFalse(schema.contains("whatthe").isValid("what does the fox say"));
        assertFalse(schema.isValid("what does the fox say"));
    }

    @Test
    void numberSchemaTest1() {
        NumberSchema schema = v.number();
        assertTrue(schema.isValid(5));
        assertTrue(schema.isValid(null));
        assertTrue(schema.positive().isValid(null));

        schema.required();

        assertFalse(schema.isValid(null));
        assertTrue(schema.isValid(10));
        assertFalse(schema.isValid(-10));
        assertFalse(schema.isValid(0));
    }

    @Test
    void numberSchemaTest2() {
        NumberSchema schema = v.number();
        schema.range(5, 10);
        assertTrue(schema.isValid(5));
        assertTrue(schema.isValid(10));
        assertFalse(schema.isValid(4));
        assertFalse(schema.isValid(11));
    }
}
