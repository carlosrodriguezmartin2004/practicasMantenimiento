package org.mps.ronqi2;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.mps.dispositivo.Dispositivo;
import org.mps.dispositivo.DispositivoSilver;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class ronQI2Silvertest {

    private RonQI2Silver rqs;

    @BeforeEach
    void setUp() {
        rqs = new RonQI2Silver();
    }

    /*
     * Analiza con los caminos base qué pruebas se han de realizar para comprobar que al inicializar funciona como debe ser.
     * El funcionamiento correcto es que si es posible conectar ambos sensores y configurarlos,
     * el método inicializar de ronQI2 o sus subclases,
     * debería devolver true. En cualquier otro caso false. Se deja programado un ejemplo.
     */
    @Test
    @DisplayName("Se conectan ambos sensores y se configuran")
    public void inicializarTestTodoTrue() {
        DispositivoSilver dispositivoMock = mock(DispositivoSilver.class);
        when(dispositivoMock.conectarSensorPresion()).thenReturn(true);
        when(dispositivoMock.conectarSensorSonido()).thenReturn(true);
        when(dispositivoMock.configurarSensorPresion()).thenReturn(true);
        when(dispositivoMock.configurarSensorSonido()).thenReturn(true);

        rqs.anyadirDispositivo(dispositivoMock);

        boolean actual = rqs.inicializar();

        assertTrue(actual);

    }

    @Test
    @DisplayName("Se conectan ambos sensores pero solo se configura SensorPresion")
    public void inicializarSeConectanAmbosNoConfigPresion() {
        DispositivoSilver dispositivoMock = mock(DispositivoSilver.class);
        when(dispositivoMock.conectarSensorPresion()).thenReturn(true);
        when(dispositivoMock.conectarSensorSonido()).thenReturn(true);
        when(dispositivoMock.configurarSensorPresion()).thenReturn(true);
        when(dispositivoMock.configurarSensorSonido()).thenReturn(false);

        rqs.anyadirDispositivo(dispositivoMock);

        boolean actual = rqs.inicializar();

        assertFalse(actual);
    }

    @Test
    @DisplayName("Solo se conecta sensorPresion y se configura bien")
    public void inicializarSoloSeConectaSensorPresionYSeConfiguraBien() {
        DispositivoSilver dispositivoMock = mock(DispositivoSilver.class);
        when(dispositivoMock.conectarSensorPresion()).thenReturn(true);
        when(dispositivoMock.conectarSensorSonido()).thenReturn(false);
        when(dispositivoMock.configurarSensorPresion()).thenReturn(true);

        rqs.anyadirDispositivo(dispositivoMock);

        boolean actual = rqs.inicializar();

        assertFalse(actual);
    }

    @Test
    @DisplayName("Solo se conecta sensorPresion y no se configura bien")
    public void inicializarSoloSeConectaSensorPresionYSeConfiguraMal() {
        DispositivoSilver dispositivoMock = mock(DispositivoSilver.class);
        when(dispositivoMock.conectarSensorPresion()).thenReturn(true);
        when(dispositivoMock.conectarSensorSonido()).thenReturn(false);
        when(dispositivoMock.configurarSensorPresion()).thenReturn(false);

        rqs.anyadirDispositivo(dispositivoMock);

        boolean actual = rqs.inicializar();

        assertFalse(actual);
    }

    @Test
    @DisplayName("No se conecta sensorPresion")
    public void inicializarNoSeConectaSensorPresion() {
        DispositivoSilver dispositivoMock = mock(DispositivoSilver.class);
        when(dispositivoMock.conectarSensorPresion()).thenReturn(false);

        rqs.anyadirDispositivo(dispositivoMock);

        boolean actual = rqs.inicializar();

        assertFalse(actual);
    }


    /*
     * Un inicializar debe configurar ambos sensores, comprueba que cuando se inicializa de forma correcta (el conectar es true),
     * se llama una sola vez al configurar de cada sensor.
     */

    @Test
    @DisplayName("Se conectan ambos sensores y comprobamos que solo se llama una vez al configurar de cada sensor")
    public void inicializarVerificarSoloSeLlama1VezConfigurar() {
        DispositivoSilver dispositivoMock = mock(DispositivoSilver.class);
        when(dispositivoMock.conectarSensorPresion()).thenReturn(true);
        when(dispositivoMock.conectarSensorSonido()).thenReturn(true);
        when(dispositivoMock.configurarSensorPresion()).thenReturn(true);
        when(dispositivoMock.configurarSensorSonido()).thenReturn(true);

        rqs.anyadirDispositivo(dispositivoMock);

        boolean actual = rqs.inicializar();

        assertTrue(actual);
        verify(dispositivoMock, times(1)).configurarSensorPresion();
        verify(dispositivoMock, times(1)).configurarSensorSonido();
    }

    @Test
    @DisplayName("Inicializar sin ningun dispositivo añadido")
    void inicializarSistemaSinDispositivoAñadido() {
        String actual = "No hay dispositivo añadido";
        NullPointerException e = assertThrows(NullPointerException.class, () -> rqs.inicializar());
        String expected = e.getMessage();

        assertEquals(expected, actual);
    }


    /*
     * Un reconectar, comprueba si el dispositivo desconectado, en ese caso, conecta ambos y devuelve true si ambos han sido conectados.
     * Genera las pruebas que estimes oportunas para comprobar su correcto funcionamiento.
     * Centrate en probar si todo va bien, o si no, y si se llama a los métodos que deben ser llamados.
     */

    @Test
    @DisplayName("El dispositivo no esta conectado y conecta bien ambos sensores")
    void reconectarDispositivoNoEstaConectadoYConectanSensores() {
        DispositivoSilver dispositivoMock = mock(DispositivoSilver.class);
        when(dispositivoMock.estaConectado()).thenReturn(false);
        when(dispositivoMock.conectarSensorPresion()).thenReturn(true);
        when(dispositivoMock.conectarSensorSonido()).thenReturn(true);
        rqs.anyadirDispositivo(dispositivoMock);

        boolean actual = rqs.reconectar();

        assertTrue(actual);
        verify(dispositivoMock, times(1)).estaConectado();
        verify(dispositivoMock, times(1)).conectarSensorPresion();
        verify(dispositivoMock, times(1)).conectarSensorSonido();
    }

    @Test
    @DisplayName("El dispositivo no esta conectado y solo conecta bien SensorPresion")
    void reconectarDispositivoNoEstaConectadoYSoloConectaSensonPresion() {
        DispositivoSilver dispositivoMock = mock(DispositivoSilver.class);
        when(dispositivoMock.estaConectado()).thenReturn(false);
        when(dispositivoMock.conectarSensorPresion()).thenReturn(true);
        when(dispositivoMock.conectarSensorSonido()).thenReturn(false);
        rqs.anyadirDispositivo(dispositivoMock);

        boolean actual = rqs.reconectar();

        assertFalse(actual);
        verify(dispositivoMock, times(1)).estaConectado();
        verify(dispositivoMock, times(1)).conectarSensorPresion();
        verify(dispositivoMock, times(1)).conectarSensorSonido();
    }

    @Test
    @DisplayName("El dispositivo no esta conectado y solo conecta bien SensorSonido")
    void reconectarDispositivoNoEstaConectadoYSoloConectaSenorSonido() {
        DispositivoSilver dispositivoMock = mock(DispositivoSilver.class);
        when(dispositivoMock.estaConectado()).thenReturn(false);
        when(dispositivoMock.conectarSensorPresion()).thenReturn(false);
        when(dispositivoMock.conectarSensorSonido()).thenReturn(true);
        rqs.anyadirDispositivo(dispositivoMock);

        boolean actual = rqs.reconectar();

        assertFalse(actual);
        verify(dispositivoMock, times(1)).estaConectado();
        verify(dispositivoMock, times(1)).conectarSensorPresion();
    }

    @Test
    @DisplayName("El dispositivo no esta conectado y no conecta bien ningun sensor")
    void reconectarDispositivoNoEstaConectadoYNoConectaNingunSensor() {
        DispositivoSilver dispositivoMock = mock(DispositivoSilver.class);
        when(dispositivoMock.estaConectado()).thenReturn(false);
        when(dispositivoMock.conectarSensorPresion()).thenReturn(false);
        when(dispositivoMock.conectarSensorSonido()).thenReturn(false);
        rqs.anyadirDispositivo(dispositivoMock);

        boolean actual = rqs.reconectar();

        assertFalse(actual);
        verify(dispositivoMock, times(1)).estaConectado();
        verify(dispositivoMock, times(1)).conectarSensorPresion();
    }

    @Test
    @DisplayName("El dispositivo ya esta conectado, devuelve false")
    void reconectarDispositivoYaConectado() {
        DispositivoSilver dispositivoMock = mock(DispositivoSilver.class);
        when(dispositivoMock.estaConectado()).thenReturn(true);
        rqs.anyadirDispositivo(dispositivoMock);

        boolean actual = rqs.reconectar();

        assertFalse(actual);
        verify(dispositivoMock, times(1)).estaConectado();
    }

    @Test
    @DisplayName("Reconectar sin ningun dispositivo añadido")
    void reconectarSistemaSinDispositivoAñadido() {
        String actual = "No hay dispositivo añadido";
        NullPointerException e = assertThrows(NullPointerException.class, () -> rqs.reconectar());
        String expected = e.getMessage();

        assertEquals(expected, actual);

    }

    @Test
    @DisplayName("El dispositivo no esta conectado")
    void estaConectadoNO() {
        DispositivoSilver dispositivoMock = mock(DispositivoSilver.class);
        when(dispositivoMock.estaConectado()).thenReturn(false);
        rqs.anyadirDispositivo(dispositivoMock);


        boolean actual = rqs.estaConectado();

        assertFalse(actual);
    }

    @Test
    @DisplayName("El dispositivo sí esta conectado")
    void estaConectadoSI() {
        DispositivoSilver dispositivoMock = mock(DispositivoSilver.class);
        when(dispositivoMock.estaConectado()).thenReturn(true);
        rqs.anyadirDispositivo(dispositivoMock);

        boolean actual = rqs.estaConectado();

        assertTrue(actual);
    }

    @Test
    @DisplayName("El sistema no tiene el dispositivo añadido")
    void estaConectadoSinDispositivo() {
        String actual = "No hay dispositivo añadido";
        NullPointerException e = assertThrows(NullPointerException.class, () -> rqs.estaConectado());
        String expected = e.getMessage();

        assertEquals(expected, actual);
    }


    /*
     * El método evaluarApneaSuenyo, evalua las últimas 5 lecturas realizadas con obtenerNuevaLectura(),
     * y si ambos sensores superan o son iguales a sus umbrales, que son thresholdP = 20.0f y thresholdS = 30.0f;,
     * se considera que hay una apnea en proceso. Si hay menos de 5 lecturas también debería realizar la media.
     */






    /* Realiza un primer test para ver que funciona bien independientemente del número de lecturas.
     * Usa el ParameterizedTest para realizar un número de lecturas previas a calcular si hay apnea o no (por ejemplo 4, 5 y 10 lecturas).
     * https://junit.org/junit5/docs/current/user-guide/index.html#writing-tests-parameterized-tests
     */

    @Test
    void obtenerNuevaLectura() {
        DispositivoSilver dispositivoMock = mock(DispositivoSilver.class);
        rqs.anyadirDispositivo(dispositivoMock);

        for (int i = 1; i <= 5; i++) {
            when(dispositivoMock.leerSensorPresion()).thenReturn((float) i);
            when(dispositivoMock.leerSensorSonido()).thenReturn((float) i);
            rqs.obtenerNuevaLectura();
        }
    }


    ////////////////////////////////////////////////////////////////////////////////

    @ParameterizedTest
    @ValueSource(ints = {4, 5, 10})
    @DisplayName("Evaluar apnea: valores por debajo de umbral, independientemente del número de lecturas")
    void evaluarApnea_NoApneaDistintasLecturas(int numLecturas) {
        Dispositivo dispositivoMock = mock(DispositivoSilver.class);
        when(dispositivoMock.leerSensorPresion()).thenReturn(10.0f);
        when(dispositivoMock.leerSensorSonido()).thenReturn(10.0f);
        rqs.anyadirDispositivo(dispositivoMock);

        for (int i = 0; i < numLecturas; i++) {
            rqs.obtenerNuevaLectura();
        }

        boolean resultado = rqs.evaluarApneaSuenyo();
        assertFalse(resultado);
    }

    @ParameterizedTest
    @ValueSource(ints = {4, 5, 10})
    @DisplayName("Evaluar apnea: valores por encima del umbral, distintas lecturas")
    void evaluarApnea_ConApneaDistintasLecturas(int numLecturas) {
        Dispositivo dispositivoMock = mock(DispositivoSilver.class);
        when(dispositivoMock.leerSensorPresion()).thenReturn(25.0f);
        when(dispositivoMock.leerSensorSonido()).thenReturn(35.0f);
        rqs.anyadirDispositivo(dispositivoMock);

        for (int i = 0; i < numLecturas; i++) {
            rqs.obtenerNuevaLectura();
        }

        boolean resultado = rqs.evaluarApneaSuenyo();
        assertTrue(resultado);
    }



    @Test
    @DisplayName("Evaluar apnea: presión en umbral, sonido justo por debajo")
    void evaluarApnea_JustoBajoSonido() {
        Dispositivo dispositivoMock = mock(DispositivoSilver.class);
        rqs.anyadirDispositivo(dispositivoMock);
        when(dispositivoMock.leerSensorPresion()).thenReturn(20.0f);
        when(dispositivoMock.leerSensorSonido()).thenReturn(29.9f);

        for (int i = 0; i < 5; i++) {
            rqs.obtenerNuevaLectura();
        }

        assertFalse(rqs.evaluarApneaSuenyo());
    }

    @Test
    @DisplayName("Evaluar apnea: sonido en umbral, presión justo por debajo")
    void evaluarApnea_JustoBajoPresion() {
        Dispositivo dispositivoMock = mock(DispositivoSilver.class);
        rqs.anyadirDispositivo(dispositivoMock);
        when(dispositivoMock.leerSensorPresion()).thenReturn(19.9f);
        when(dispositivoMock.leerSensorSonido()).thenReturn(30.0f);

        for (int i = 0; i < 5; i++) {
            rqs.obtenerNuevaLectura();
        }

        assertFalse(rqs.evaluarApneaSuenyo());
    }

    @Test
    @DisplayName("Evaluar apnea: ambos justo en el umbral (20.0 / 30.1) → debe detectar apnea")
    void evaluarApnea_ExactamenteEnElUmbral() {
        Dispositivo dispositivoMock = mock(DispositivoSilver.class);
        rqs.anyadirDispositivo(dispositivoMock);
        when(dispositivoMock.leerSensorPresion()).thenReturn(20.0f);
        when(dispositivoMock.leerSensorSonido()).thenReturn(30.1f);

        for (int i = 0; i < 5; i++) {
            rqs.obtenerNuevaLectura();
        }

        assertTrue(rqs.evaluarApneaSuenyo());
    }



    @Test
    @DisplayName("Evaluar apnea: lectura  vacia → return false")
    void evaluarApnea_LecturaVacia() {
        DispositivoSilver dispositivoMock = mock(DispositivoSilver.class);
        when(dispositivoMock.estaConectado()).thenReturn(true);

        rqs.anyadirDispositivo(dispositivoMock);


        boolean apnea = rqs.evaluarApneaSuenyo();

        assertFalse(apnea);
    }

}
