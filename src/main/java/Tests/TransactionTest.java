package Tests;

        import Domain.Transaction;

        import static org.junit.jupiter.api.Assertions.assertEquals;
        import static org.junit.jupiter.api.Assertions.*;

class TransactionTest {

    @org.junit.jupiter.api.Test
    void constructorShouldSetEverythingCorrectly() {
        Transaction t = new Transaction("1","002","009",3,"12.03.2019","10:00",32,4);
        assertEquals("1", t.getId());
        assertEquals("002",t.getIdMedicament());
        assertEquals("009",t.getIdClientCard());
        assertEquals(3,t.getNumberOfItems());
        assertEquals("12.03.2019",t.getDate());
        assertEquals("10:00",t.getTime());
        assertEquals(32,t.getBasePrice());
        assertEquals(4,t.getDiscount());

    }
}