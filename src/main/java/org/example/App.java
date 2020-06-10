package org.example;


public class App {

    public static void main(String[] args) {

        App = new App();

//        int numero = 101;
        int numero = 123450;
//        int numero = 0;

        int exponente = 4;

        final int PRIMER_DIGITO = 0;
        final int SEGUNDO_DIGITO = 1;

        int digitoBuscado = 0;

        int numeroDeDigitosARemover = 1;

        int digitoAPegar = 5;

        int posicionInicial = 1;
        int posicionFinal = 4;

        int numeroAJuntar = 235;

        System.out.println("\n" + numero + ":");
        System.out.println("esCapicua = " + funciones.esCapicua(numero));
        System.out.println("esPrimo = " + funciones.esPrimo(numero));
        System.out.println("siguientePrimo = " + funciones.siguientePrimo(numero));
        System.out.println("elevado a " + exponente + " = " + funciones.potencia(numero, exponente));
        System.out.println("número de digitos = " + funciones.digitos(numero));
        System.out.println("volteado = " + funciones.voltea(numero));
        System.out.println("digito[" + SEGUNDO_DIGITO + "] = " + funciones.digitoN(numero, SEGUNDO_DIGITO));
        System.out.println("posicionDigito_" + digitoBuscado + " = " + funciones.posicionDeDigito(numero, digitoBuscado));
        System.out.println("quitaPorDetras_" + numeroDeDigitosARemover + "_digitos = " + funciones.quitaPorDetras(numero, numeroDeDigitosARemover));
        System.out.println("quitaPorDelante_" + numeroDeDigitosARemover + "_digitos = " + funciones.quitaPorDelante(numero, numeroDeDigitosARemover));
        System.out.println("pegaPorDetras_" + digitoAPegar + " = " + funciones.pegaPorDetras(numero, digitoAPegar));
        System.out.println("pegaPorDelante_" + digitoAPegar + " = " + funciones.pegaPorDelante(numero, digitoAPegar));
        System.out.println("trozoDeNumero_" + posicionInicial + "_" + posicionFinal + " = " + funciones.trozoDeNumero(numero, posicionInicial, posicionFinal));
        System.out.println("juntaNumero_" + numeroAJuntar + " = " + funciones.juntaNumeros(numero, numeroAJuntar));


    }

    // FUNCIONES BÁSICAS

    public double suma(double a, double b) {

        return a + b;
    }

    public double resta(double a, double b) {

        return a - b;
    }

    public double multiplicacion(double a, double b) {

        return a * b;
    }

    public double division(double a, double b) {

        return a / b;
    }


    // FUNCIONES AVANZADAS

    /*
     * Devuelve verdadero si el número que se pasa como parámetro es capicúa y falso en caso contrario
     */
    public boolean esCapicua(int numero) {

        boolean esCapicua = true;

        int longitudNumero = digitos(numero);

        int[] digitos = obtenerDigitos(numero);

        int numeroDeComprobaciones = longitudNumero / 2;
        int indiceSuperior = longitudNumero - 1;
        int indiceInferior = 0;

        for (int i = 0; (i < numeroDeComprobaciones) && esCapicua; i++) {

            if (digitos[indiceInferior] != digitos[indiceSuperior]) {

                esCapicua = false;
            }

            indiceInferior++;
            indiceSuperior--;
        }

        return esCapicua;
    }

    /*
     * Cuenta el número de dígitos de un número entero
     */
    public int digitos(int numero) {

        if (numero != 0) {

            int longitudNumero = 0;

            while (numero > 0) {

                longitudNumero++;

                numero = numero / 10;
            }

            return longitudNumero;

        } else {

            return 1;
        }
    }

    /*
     * Devuelve un array de enteros con cada dígito de un número (recibido como parámetro) en cada posición
     */
    private int[] obtenerDigitos(int numero) {

        int longitudNumero = digitos(numero);

        int[] digitos = new int[longitudNumero];

        for (int i = longitudNumero - 1; i >= 0; i--) {

            digitos[i] = numero % 10;

            numero = numero / 10;
        }

//        for (int i = 0; i < digitos.length; i++) {
//
//            System.out.println("digitos[" + i + "] = " + digitos[i]);
//        }
//
//        System.out.println();

        return digitos;
    }

    /*
     * Devuelve verdadero si el número que se pasa como parámetro es primo y falso en caso contrario
     */
    public boolean esPrimo(int numero) {

        if (numero == 0 || numero == 1) {

            return false;
        }
        else {

            boolean esPrimo = true;

            int ultimoDivisor = numero / 2;

            for (int i = 2; (i <= ultimoDivisor) && esPrimo; i++) {

                if (numero % i == 0) {
                    esPrimo = false;
                }
            }

            return esPrimo;
        }
    }

    /*
     * Devuelve el menor primo que es mayor al número que se pasa como parámetro
     */
    public int siguientePrimo(int numero) {

        int siguientePrimo = numero;

        boolean esPrimo = false;

        while ( !esPrimo ) {

            esPrimo = esPrimo(++siguientePrimo);
        }

        return siguientePrimo;
    }

    /*
     * Dada una base y un exponente devuelve la potencia
     */
    public double potencia(int base, int exponente) {

        double potencia = 1;

        if (exponente > 0) {

            for (int i = 0; i < exponente; i++) {

                potencia = potencia * base;
            }
        }
        // Soporte para exponentes negativos (requiere trabajar con datos float/double)
        else if (exponente < 0) {

            for (int i = 0; i < -exponente; i++) {

                potencia = potencia / base;
            }
        }

        return potencia;
    }

    /*
     * Le da la vuelta a un número
     */
    public int voltea(int numero) {

        int[] digitos = obtenerDigitos(numero);

        int numeroVolteado = 0;

        for (int i = 0; i < digitos.length; i++) {

            numeroVolteado = numeroVolteado + digitos[i] * (int) potencia(10, i);
        }

        return numeroVolteado;
    }

    /*
     * Devuelve el dígito que está en la posición n de un número entero. Se empieza contando por el 0 y de izquierda a derecha
     */
    public int digitoN(int numero, int posicion) {

        int[] digitos = obtenerDigitos(numero);

        if (posicion < digitos.length) {

            return digitos[posicion];

        } else {

            return -1;
        }
    }

    /*
     * Da la posición de la primera ocurrencia de un dígito dentro de un número entero. Si no se encuentra, devuelve -1
     */
    public int posicionDeDigito(int numero, int digitoBuscado) {

        int[] digitos = obtenerDigitos(numero);

        int posicion = -1;

        for (int i = 0; (i < digitos.length) && posicion < 0; i++) {

            if (digitos[i] == digitoBuscado) {

                posicion = i;
            }
        }

        return posicion;
    }

    /*
     * Le quita a un número n dígitos por detrás (por la derecha)
     */
    public int quitaPorDetras(int numero, int numeroDeDigitosARemover) {

        for (int i = 0; i < numeroDeDigitosARemover; i++) {

            numero = numero / 10;
        }

        return numero;
    }

    /*
     * Le quita a un número n dígitos por delante (por la izquierda)
     */
    public int quitaPorDelante(int numero, int numeroDeDigitosARemover) {

        int[] digitos = obtenerDigitos(numero);

        int exponente = digitos.length - 1;

        for (int i = 0; i < numeroDeDigitosARemover; i++) {

            numero = numero - digitos[i] * (int) potencia(10, exponente--);
        }

        return numero;
    }

    /*
     * Añade un dígito a un número por detrás
     */
    public int pegaPorDetras(int numero, int digitoAPegar) {

        if ((digitoAPegar >= 0) && (digitoAPegar < 10)) {

            return numero * 10 + digitoAPegar;

        } else {

            return -1;
        }
    }

    /*
     * Añade un dígito a un número por delante
     */
    public int pegaPorDelante(int numero, int digitoAPegar) {

        if ((digitoAPegar >= 0) && (digitoAPegar < 10)) {

            int exponente = digitos(numero);

            return digitoAPegar * (int) potencia(10, exponente) + numero;

        } else {

            return -1;
        }
    }

    /*
     * Toma como parámetros las posiciones inicial y final dentro de un número y devuelve el trozo correspondiente
     */
    public int trozoDeNumero(int numero, int posicionInicial, int posicionFinal) {

        int longitudNumero = digitos(numero);

        if ( (posicionInicial >= 0) && (posicionFinal < longitudNumero) ) {

            int trozoDeNumero = quitaPorDelante(numero, posicionInicial);

            int digitosARemoverPorDetras = longitudNumero - 1 - posicionFinal;

            return quitaPorDetras(trozoDeNumero, digitosARemoverPorDetras);

        } else {

            return -1;
        }
    }

    /*
     * Pega dos números para formar uno
     */
    public int juntaNumeros(int numero, int numeroAJuntar) {

        int longitudNumeroAJuntar = digitos(numeroAJuntar);

        return numero * (int) potencia(10, longitudNumeroAJuntar) + numeroAJuntar;
    }
}
