package br.edu.lab5.triangulo;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TrianguloTest {

    //Os três lados devem ser diferentes entre si e satisfazer a regra da soma (a soma de dois lados sempre maior que o terceiro).
    @Test
    public void testTrianguloEscalenoValido() {
        Triangulo triangulo = new Triangulo(4, 5, 6);
        assertTrue(triangulo.isTrianguloValido(), "Deveria ser um triângulo válido");
        assertEquals("Escaleno", triangulo.tipoTriangulo(), "Deveria ser escaleno");
    }

    //tem dois lados iguais e um diferente, e tem que ser um triângulo válido.
    @Test
    public void testTrianguloIsoscelesValido() {
        Triangulo triangulo = new Triangulo(5, 5, 3);
        assertTrue(triangulo.isTrianguloValido(), "Deveria ser um triângulo válido");
        assertEquals("Isósceles", triangulo.tipoTriangulo(), "Deveria ser isósceles");
    }

    // Os três lados iguais e, obviamente, sempre será um triângulo válido
    @Test
    public void testTrianguloEquilateroValido() {
        Triangulo triangulo = new Triangulo(7, 7, 7);
        assertTrue(triangulo.isTrianguloValido(), "Deveria ser um triângulo válido");
        assertEquals("Equilátero", triangulo.tipoTriangulo(), "Deveria ser equilátero");
    }

    //validar se o programa está funcionando independente da ordem dos lados, a lógica não pode depender da posição dos valores
    @Test
    public void testIsoscelesPermutacao1() {
        Triangulo triangulo = new Triangulo(5, 5, 3);
        assertTrue(triangulo.isTrianguloValido());
        assertEquals("Isósceles", triangulo.tipoTriangulo());
    }

    @Test
    public void testIsoscelesPermutacao2() {
        Triangulo triangulo = new Triangulo(5, 3, 5);
        assertTrue(triangulo.isTrianguloValido());
        assertEquals("Isósceles", triangulo.tipoTriangulo());
    }

    @Test
    public void testIsoscelesPermutacao3() {
        Triangulo triangulo = new Triangulo(3, 5, 5);
        assertTrue(triangulo.isTrianguloValido());
        assertEquals("Isósceles", triangulo.tipoTriangulo());
    }

    //Um valor zero o que não formam um triângulo válido
    @Test
    public void testLadoZero() {
        Triangulo triangulo = new Triangulo(0, 5, 5);
        assertFalse(triangulo.isTrianguloValido(), "Não deveria ser um triângulo válido");
        assertEquals("Não é um triângulo", triangulo.tipoTriangulo());
    }

    //Um valor negativo o que não é um triângulo válido
    @Test
    public void testLadoNegativo() {
        Triangulo triangulo = new Triangulo(-3, 4, 5);
        assertFalse(triangulo.isTrianguloValido(), "Não deveria ser um triângulo válido com lado negativo");
        assertEquals("Não é um triângulo", triangulo.tipoTriangulo());
    }

    //A soma de dois lados deve ser maior que o terceiro lado. Se for igual, não forma triângulo — é apenas uma linha reta
    //Se quiser, podemos também testar permutações como (5, 2, 3) ou (3, 5, 2), que devem dar o mesmo resultado.
    @Test
    public void testSomaDeDoisLadosIgualAoTerceiro() {
        Triangulo triangulo = new Triangulo(2, 3, 5);
        assertFalse(triangulo.isTrianguloValido(), "Soma de dois lados igual ao terceiro não forma triângulo");
        assertEquals("Não é um triângulo", triangulo.tipoTriangulo());
    }

    // Todas as permutações dos valores do caso acima (A soma de 2 lados é igual ao teceiro lado: 2, 3, 5).
    // Cada permutação deve continuar sendo um triângulo inválido, já que a soma de dois lados será sempre igual ao terceiro.
    // Opções: (2, 3, 5), (3, 2, 5), (5, 2, 3)
    @Test
    public void testPermutacao1_SomaIgual() {
        Triangulo triangulo = new Triangulo(2, 3, 5);
        assertFalse(triangulo.isTrianguloValido());
        assertEquals("Não é um triângulo", triangulo.tipoTriangulo());
    }

    @Test
    public void testPermutacao2_SomaIgual() {
        Triangulo triangulo = new Triangulo(3, 2, 5);
        assertFalse(triangulo.isTrianguloValido());
        assertEquals("Não é um triângulo", triangulo.tipoTriangulo());
    }

    @Test
    public void testPermutacao3_SomaIgual() {
        Triangulo triangulo = new Triangulo(5, 2, 3);
        assertFalse(triangulo.isTrianguloValido());
        assertEquals("Não é um triângulo", triangulo.tipoTriangulo());
    }

    // Se a + b < c, não forma triângulo, O mesmo vale para qualquer permutação.
    // (2,2,5) Aqui: 2 + 2 = 4 < 5 → inválido
    @Test
    public void testSomaDeDoisLadosMenorQueOTerceiro() {
        Triangulo triangulo = new Triangulo(2, 2, 5);
        assertFalse(triangulo.isTrianguloValido(), "Soma de dois lados menor que o terceiro não forma triângulo");
        assertEquals("Não é um triângulo", triangulo.tipoTriangulo());
    }

    // CT onde a soma de dois lados é menor que o terceiro. Permutações de (2, 2, 5): (2, 2, 5), (2, 5, 2), (5, 2, 2)
    @Test
    public void testPermutacao1_SomaMenor() {
        Triangulo triangulo = new Triangulo(2, 2, 5);
        assertFalse(triangulo.isTrianguloValido());
        assertEquals("Não é um triângulo", triangulo.tipoTriangulo());
    }

    @Test
    public void testPermutacao2_SomaMenor() {
        Triangulo triangulo = new Triangulo(2, 5, 2);
        assertFalse(triangulo.isTrianguloValido());
        assertEquals("Não é um triângulo", triangulo.tipoTriangulo());
    }

    @Test
    public void testPermutacao3_SomaMenor() {
        Triangulo triangulo = new Triangulo(5, 2, 2);
        assertFalse(triangulo.isTrianguloValido());
        assertEquals("Não é um triângulo", triangulo.tipoTriangulo());
    }

    //CT para quando os 3 lados são iguais a zero, não formando um triângulo.
    @Test
    public void testTodosOsLadosZero() {
        Triangulo triangulo = new Triangulo(0, 0, 0);
        assertFalse(triangulo.isTrianguloValido(), "Triângulo com todos os lados zero deve ser inválido");
        assertEquals("Não é um triângulo", triangulo.tipoTriangulo());
    }

}

