package clubdeportivo;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.*;

public class ClubDeportivoAltoRendimientoTest {
        
    @Test
    public void ClubDeportivoAltoRendimiento_valoresnegativos_returnClubException() throws ClubException {
        String nombre= "ClubErroneo";
        int maximo=-1;
        double incremento=-1;
        assertThrows(ClubException.class,()-> new ClubDeportivoAltoRendimiento(nombre, maximo, incremento));
    }

    @Test
    public void ClubDeportivoAltoRendimiento_maximonegativos_returnClubException() throws ClubException {
        String nombre= "ClubErroneo";
        int maximo=-1;
        double incremento=1;
        assertThrows(ClubException.class,()-> new ClubDeportivoAltoRendimiento(nombre, maximo, incremento));
    }
    @Test
    public void ClubDeportivoAltoRendimiento_incrementonegativos_returnClubException() throws ClubException {
        String nombre= "ClubErroneo";
        int maximo=1;
        double incremento=-1;
        assertThrows(ClubException.class,()-> new ClubDeportivoAltoRendimiento(nombre, maximo, incremento));
    }

    @Test
    public void ClubDeportivoAltoRendimiento_maximocero_returnClubException() throws ClubException {
        String nombre= "ClubErroneo";
        int maximo=0;
        double incremento=1;
        assertThrows(ClubException.class,()-> new ClubDeportivoAltoRendimiento(nombre, maximo, incremento));
    }
    @Test
    public void ClubDeportivoAltoRendimiento_incrementocero_returnClubException() throws ClubException {
        String nombre= "ClubErroneo";
        int maximo=1;
        double incremento=0;
        assertThrows(ClubException.class,()-> new ClubDeportivoAltoRendimiento(nombre, maximo, incremento));
    }

    @Test
    public void ClubDeportivoAltoRendimiento_valoresAceptados_NoReturnException() throws ClubException {
        String nombre= "ClubDeportivoAltoRendimiento";
        int maximo=20;
        double incremento=2;
        assertDoesNotThrow(() -> new ClubDeportivoAltoRendimiento(nombre, maximo, incremento));
    }

    //

    @Test
    public void ClubDeportivoAltoRendimientoConTam_valoresnegativos_returnClubException() throws ClubException {
        String nombre= "ClubErroneo";
        int maximo=-1;
        double incremento=-1;
        int tam = -1;
        assertThrows(ClubException.class,()-> new ClubDeportivoAltoRendimiento(nombre,tam, maximo, incremento));
    }

    @Test
    public void ClubDeportivoAltoRendimientoConTam_maximonegativos_returnClubException() throws ClubException {
        String nombre= "ClubErroneo";
        int maximo=-1;
        double incremento=1;
        int tam = 1;
        assertThrows(ClubException.class,()-> new ClubDeportivoAltoRendimiento(nombre,tam, maximo, incremento));
    }
    @Test
    public void ClubDeportivoAltoRendimientoConTam_incrementonegativos_returnClubException() throws ClubException {
        String nombre= "ClubErroneo";
        int maximo=1;
        double incremento=-1;
        int tam = 1;
        assertThrows(ClubException.class,()-> new ClubDeportivoAltoRendimiento(nombre,tam, maximo, incremento));
    }
    @Test
    public void ClubDeportivoAltoRendimientoConTam_tamnegativos_returnClubException() throws ClubException {
        String nombre= "ClubErroneo";
        int maximo=1;
        double incremento=1;
        int tam = -1;
        assertThrows(ClubException.class,()-> new ClubDeportivoAltoRendimiento(nombre,tam, maximo, incremento));
    }

    @Test
    public void ClubDeportivoAltoRendimientoConTam_maximocero_returnClubException() throws ClubException {
        String nombre= "ClubErroneo";
        int maximo=0;
        double incremento=1;
        int tam = 1;
        assertThrows(ClubException.class,()-> new ClubDeportivoAltoRendimiento(nombre,tam, maximo, incremento));
    }
    @Test
    public void ClubDeportivoAltoRendimientoConTam_incrementocero_returnClubException() throws ClubException {
        String nombre= "ClubErroneo";
        int maximo=1;
        double incremento=0;
        int tam = 1;
        assertThrows(ClubException.class,()-> new ClubDeportivoAltoRendimiento(nombre,tam, maximo, incremento));
    }
    @Test
    public void ClubDeportivoAltoRendimientoConTam_tamcero_returnClubException() throws ClubException {
        String nombre= "ClubErroneo";
        int maximo=1;
        double incremento=1;
        int tam = 0;
        assertThrows(ClubException.class,()-> new ClubDeportivoAltoRendimiento(nombre,tam, maximo, incremento));
    }

    @Test
    public void ClubDeportivoAltoRendimientoConTam_valoresAceptados_NoReturnException() throws ClubException {
        String nombre= "ClubDeportivoAltoRendimiento";
        int maximo=20;
        double incremento=2;
        int tam = 1;
        assertDoesNotThrow(() -> new ClubDeportivoAltoRendimiento(nombre,tam, maximo, incremento));
    }

    //anyadirActividad

}
