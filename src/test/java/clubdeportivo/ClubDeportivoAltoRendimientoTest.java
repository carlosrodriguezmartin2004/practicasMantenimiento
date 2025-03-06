package clubdeportivo;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ClubDeportivoAltoRendimientoTest {
        private ClubDeportivoAltoRendimiento club;

         
        @Test
    void testConstructorValoresNegativos() {
        assertThrows(ClubException.class, () -> new ClubDeportivoAltoRendimiento("Club Invalido", -5, -10.0));
    }
    
    @Test
    void testConstructorConTamValoresNegativos() {
        assertThrows(ClubException.class, () -> new ClubDeportivoAltoRendimiento("Club Invalido", 5, -5, -10.0));
    }
    
    @Test
    void testAnyadirActividadFaltanDatos() {
        String[] datosIncompletos = {"Futbol", "Lunes"};
        assertThrows(ClubException.class, () -> club.anyadirActividad(datosIncompletos));
    }
    
    @Test
    void testAnyadirActividadFormatoIncorrecto() {
        String[] datosIncorrectos = {"Futbol", "Lunes", "diez", "cinco", "cien"};
        assertThrows(ClubException.class, () -> club.anyadirActividad(datosIncorrectos));
    }
    
    @Test
    void testAnyadirActividadMaximoPlazas() throws ClubException {
        String[] datos = {"Natación", "Martes", "15", "5", "50.0"};
        club.anyadirActividad(datos);
        // Verificar si se ha añadido correctamente (dependerá de la implementación de Grupo y ClubDeportivo)
        assertEquals(1, club.plazasLibres("Natación"));
    }
    
    @Test
    void testIngresos() throws ClubException {
        String[] datos = {"Yoga", "Jueves", "10", "5", "100.0"};
        club.anyadirActividad(datos);
        double ingresosBase = 5 * 100.0; // 5 matriculados * tarifa 100
        double ingresosEsperados = ingresosBase + ingresosBase * 0.2; // Incremento del 20%
        assertEquals(ingresosEsperados, club.ingresos(), 0.01);
    }



}
