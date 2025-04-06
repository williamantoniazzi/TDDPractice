package br.edu.lab5.person;

import java.util.ArrayList;
import java.util.List;

public class PersonDAO {

    public void save(Person p) {
        // Simulação de persistência (poderíamos apenas fazer um print se quiser ver o resultado no terminal)
        System.out.println("Salvando pessoa: " + p.getName() + ", Todos os dados estão corretos!");
    }

    public List<String> isValidToInclude(Person p) {
        // Método a ser implementado com TDD
        List<String> erros = new ArrayList<>();

        // Regra 1 - Nome deve ter pelo menos duas partes
        if (p.getName() == null || p.getName().trim().split("\\s+").length < 2) {
            erros.add("Nome deve conter pelo menos duas partes com letras.");
        } else {
            // Verifica se todas as partes são letras
            String[] partes = p.getName().trim().split("\\s+");
            for (String parte : partes) {
                if (!parte.matches("[A-Za-z]+")) {
                    erros.add("Nome deve conter apenas letras.");
                    break;
                }
            }
        }

        // Regra 2 - Idade entre 1 e 200
        if (p.getAge() < 1 || p.getAge() > 200) {
            erros.add("Idade deve estar entre 1 e 200.");
        }

        // Regra 3 - Deve ter pelo menos um email
        if (p.getEmails() == null || p.getEmails().isEmpty()) {
            erros.add("Pessoa deve ter pelo menos um email.");
        } else {
            // Regra 4 - Validação de cada email
            for (Email email : p.getEmails()) {
                if (!email.getName().matches("^.+@.+\\..+$")) {
                    erros.add("Email inválido: " + email.getName());
                }
            }
        }

        return erros;
    }
}