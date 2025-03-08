package clubdeportivo;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;


public class ClubDeportivoTest {
    private ClubDeportivo Club1;

    @BeforeEach
    void setUp() throws ClubException {
        Club1 = new ClubDeportivo("Buenash");
    }

    @Test
    void testGetNombre() {
        assertThrows(ClubException.class,()->new ClubDeportivo("Buenash", -1));
    }

}