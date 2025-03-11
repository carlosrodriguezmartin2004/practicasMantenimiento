package clubdeportivo;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;


public class ClubDeportivoTest {
    private ClubDeportivo ClubD;
    private Grupo g1;
    private Grupo g2;
    private Grupo g3;
    private Grupo g4;
    private Grupo g5;

    @BeforeEach
    void setUp() throws ClubException {
        ClubD = new ClubDeportivo("Club Deportivo 1");
        g1 = new Grupo("1111", "Padel", 7, 5, 20.0);
        g2 = new Grupo("2222", "Tenis", 6, 6, 20.0);
        g3 = new Grupo("3333", "Futbol", 18, 18, 25.0);
        g4 = new Grupo("4444", "Baloncesto", 13, 11, 25.0);
        g5 = new Grupo("5555", "Volleyball", 10, 9, 20.0);
    }

    @Test
    void ClubDeportivoConGruposNegativos() {
        assertThrows(ClubException.class,()->new ClubDeportivo("ClubPrueba", -1));
    }

    @Test
    void AnyadirActividadFormatoDatosErróneos() throws ClubException {
        String[] datosFormatoMalo = {"1", "4", "Club AntiDeportivo", "Ocho", "4.0"};
        assertThrows(ClubException.class, () ->ClubD.anyadirActividad(datosFormatoMalo));
    }

    @Test
    void AnyadirActividadDatosRangoMenor() throws ClubException {
        String[] datosRangoMenor = {"Club AntiDeportivo", "Waterpolo", "10", "8"};
        assertThrows(ClubException.class, () -> ClubD.anyadirActividad(datosRangoMenor));
    }

    @Test
    void AnyadirActividadDatosRangoMayor() throws ClubException {
        String[] datosRangoMayor = {"Club AntiDeportivo", "Waterpolo", "10", "8", "18.0", "RANGO MAYOR"};
       ClubD.anyadirActividad(datosRangoMayor); // No importa que el tamaño del String[] sea mayor al pedido
    }


    @Test
    void AnyadirActividadNULL() throws ClubException {
        Grupo g = null;
        assertThrows(ClubException.class, () -> ClubD.anyadirActividad(g));
    }

    @Test
    void AnyadirActividadQueNoExiste() throws ClubException {
        ClubD.anyadirActividad(g1);
    }


    @Test
    void AnyadirActividadQueYaExiste() throws ClubException {
        ClubD.anyadirActividad(g1); //Anyadimos varias actividades al Club
        ClubD.anyadirActividad(g2);
        ClubD.anyadirActividad(g3);
        ClubD.anyadirActividad(g4);
        ClubD.anyadirActividad(g5);
        ClubD.anyadirActividad(g3); //Volvemos a anyadir la actividad de g3
    }

}