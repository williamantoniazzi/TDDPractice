package br.edu.lab5.triangulo;

public class Triangulo {
    private int ladoA;
    private int ladoB;
    private int ladoC;

    public Triangulo(int ladoA, int ladoB, int ladoC) {
        this.ladoA = ladoA;
        this.ladoB = ladoB;
        this.ladoC = ladoC;
    }

    public boolean isTrianguloValido() {
        return (ladoA + ladoB > ladoC) &&
                (ladoA + ladoC > ladoB) &&
                (ladoB + ladoC > ladoA);
    }

    public String tipoTriangulo() {
        if (!isTrianguloValido()) {
            return "Não é um triângulo";
        }

        if (ladoA == ladoB && ladoB == ladoC) {
            return "Equilátero";
        } else if (ladoA == ladoB || ladoA == ladoC || ladoB == ladoC) {
            return "Isósceles";
        } else {
            return "Escaleno";
        }
    }
}