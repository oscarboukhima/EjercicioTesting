package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertTrue;

import org.junit.Test;


public class AppTest {
    private App app;

    /* FUNCIONES BASICAS
     */
    @BeforeEach
    void setUp(){
        app= new AppTest();
    }
    @Test
    public void Suma(){
        double numero = (double) app.suma( a: 20, b: 20)
        assertEquals(expected: 40, numero);
    }
    @Test
    public void Resta(){
        double numero = (double) app.resta( a: 20, b: 20)
        assertEquals(expected: 0, numero);
    }
    @Test
        public void Multiplicacion(){
        double numero = (double) app.Multiplicacion( a: 20, b: 20)
        assertEquals(expected: 400, numero);
    }
    @Test
    public void Division(){
        double numero = (double) app.Division( a: 20, b: 20)
        assertEquals(expected: 1, numero);
    }
    /* FUNCIONES AVANZADAS
     */
    @Test
    public void esPrimo(){
        boolean esPrimo = (boolean) app.esPrimo( )
        assertEquals(expected: true, );
    }

    @Test
    public void siguientePrimo(){
        boolean siguientePrimo = (boolean) app.siguientePrimo( )
        assertEquals(expected: true, );
    }
    @Test
    public void potencia(){
        double potencia = (boolean) app.potencia()
        assertEquals(expected: true, );
    }
    @Test
    public void esCapicua(){
        boolean potencia = (boolean) app.esCapicua()
        assertEquals(expected: true, );
    }
    @Test
    public void digitos(){
        int digitos = (int) app.digitos()
        assertEquals(expected: 1, );
    }
    @Test
    public void obtenerDigitos(){
        int obtenerDigitos = (int) app.obtenerDigitos()
        assertEquals(expected: 1, );
    }
    @Test
    public void digitoN(){
        int digitoN = (int) app.digitoN(numero:,posicion)
        assertEquals(expected: 1, );
    }
    @Test
    public void digitoN(){
        int digitoN = (int) app.digitoN(numero:,posicion)
        assertEquals(expected: 1, numero,posicion);
    }

    @Test
    public void juntaNumeros(){
        int juntaNumeros = (int) app.juntaNumeros(numero:,numeroAJuntar)
        assertEquals(expected: 1, numero,numeroAJuntar);
    }
    trozoDeNumero(int numero, int posicionInicial, int posicionFinal)

    @Test
    public void trozoDeNumero(){
        int trozoDeNumero = (int) app.trozoDeNumero(numero:,posicionInicial:,posicionFinal:)
        assertEquals(expected: 1, numero,posicionInicial,posicionFinal);
    }





}
