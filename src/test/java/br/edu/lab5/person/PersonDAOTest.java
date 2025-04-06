package br.edu.lab5.person;

import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class PersonDAOTest {

    private final PersonDAO dao = new PersonDAO(); // Instância da classe que contém o método de validação

    // Teste 1: Verifica se o nome tem pelo menos duas partes (ex: "João Silva")
    @Test
    public void deveRetornarErro_QuandoNomeNaoTemDuasPartes() {
        Person pessoa = new Person(1, "João", 30,
                Arrays.asList(new Email(1, "joao@email.com")));
        List<String> erros = dao.isValidToInclude(pessoa);
        assertTrue(erros.contains("Nome deve conter pelo menos duas partes com letras."));
    }

    // Teste 2: Verifica se o nome contém apenas letras (sem números ou símbolos)
    @Test
    public void deveRetornarErro_QuandoNomeTemNumeros() {
        Person pessoa = new Person(1, "João123 Silva", 30,
                Arrays.asList(new Email(1, "joao@email.com")));
        List<String> erros = dao.isValidToInclude(pessoa);
        assertTrue(erros.contains("Nome deve conter apenas letras."));
    }

    // Teste 3: Verifica se a idade está dentro do intervalo permitido [1, 200]
    @Test
    public void deveRetornarErro_QuandoIdadeForaDoIntervalo() {
        Person pessoa = new Person(2, "Maria Silva", 201, // idade inválida
                Arrays.asList(new Email(2, "maria@email.com")));
        List<String> erros = dao.isValidToInclude(pessoa);
        assertTrue(erros.contains("Idade deve estar entre 1 e 200."));
    }

    // Teste 4: Verifica se existe pelo menos um e-mail associado
    @Test
    public void deveRetornarErro_QuandoNaoTemEmails() {
        Person pessoa = new Person(3, "Carlos Silva", 25, Collections.emptyList());
        List<String> erros = dao.isValidToInclude(pessoa);
        assertTrue(erros.contains("Pessoa deve ter pelo menos um email."));
    }

    // Teste 5: Verifica se o e-mail está no formato correto "____@____.___"
    @Test
    public void deveRetornarErro_QuandoEmailInvalido() {
        Person pessoa = new Person(4, "Julia Santos", 28,
                Arrays.asList(new Email(1, "email_invalido"))); // formato incorreto
        List<String> erros = dao.isValidToInclude(pessoa);
        assertTrue(erros.contains("Email inválido: email_invalido"));
    }

    // Teste 6: Verifica se todos os dados estão válidos (nenhum erro deve ser retornado)
    @Test
    public void devePassar_QuandoDadosValidos() {
        Person pessoa = new Person(5, "Lucas Oliveira", 32,
                Arrays.asList(new Email(1, "lucas@email.com")));
        List<String> erros = dao.isValidToInclude(pessoa);
        assertTrue(erros.isEmpty()); // Nenhum erro, teste deve passar
    }
}


