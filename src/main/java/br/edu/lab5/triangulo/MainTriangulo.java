package br.edu.lab5.triangulo;

import java.util.Scanner;

public class MainTriangulo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite o primeiro lado do triângulo:");
        int ladoA = scanner.nextInt();

        System.out.println("Digite o segundo lado do triângulo:");
        int ladoB = scanner.nextInt();

        System.out.println("Digite o terceiro lado do triângulo:");
        int ladoC = scanner.nextInt();

        Triangulo triangulo = new Triangulo(ladoA, ladoB, ladoC);

        System.out.println("Resultado:");
        System.out.println(triangulo.tipoTriangulo());

        scanner.close();
    }
}

