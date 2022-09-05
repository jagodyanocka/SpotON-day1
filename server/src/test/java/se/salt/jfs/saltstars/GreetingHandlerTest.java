package se.salt.jfs.saltstars;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class GreetingHandlerTest {

    private GreetingHandler handler = new GreetingHandler();


    @Test
    void shouldGetQueryParamValue() {
        String johan = handler.getQueryParameter("name", "?name=johan");
        assertEquals("johan", johan);
    }

    @Test
    void shouldHandleLongerQueries() {
        String johan1 = handler.getQueryParameter("name", "?name=johan&age=30&shoesize=47");
        assertEquals("johan", johan1);
    }

    @Test
    void shouldHandleEmptyQuery() {
        String noName = handler.getQueryParameter("name", "name=");
        assertEquals("Unknown Friend", noName);
    }

    @Test
    void shouldHandleMissingQuery() {
        String noName = handler.getQueryParameter("name", "age=");
        assertEquals("Unknown Friend", noName);
    }
}
