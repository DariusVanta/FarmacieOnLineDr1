package Tests;

import Domain.Client;

import static org.junit.jupiter.api.Assertions.*;

class ClientTest {

    @org.junit.jupiter.api.Test
    void constructorShouldSetEverythingCorrectly() {
        Client c = new Client("1","ionescu","ion","1234", "14.11.1982", "12.03.2019");
        assertEquals("1", c.getId());
        assertEquals("ionescu",c.getLastName());
        assertEquals("ion",c.getFirstName());
        assertEquals("1234",c.getCNP());
        assertEquals("14.11.1982",c.getDateOfBirth());
        assertEquals("12.03.2019",c.getDateOfRegistration());

    }
}