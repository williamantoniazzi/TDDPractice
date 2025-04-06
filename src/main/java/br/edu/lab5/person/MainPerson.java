package br.edu.lab5.person;

import java.util.List;

public class MainPerson {

    public static void main(String[] args) {
        List<Person> pessoas = PersonData.getPessoasMockadas();
        PersonDAO dao = new PersonDAO();

        for (Person pessoa : pessoas) {
            List<String> erros = dao.isValidToInclude(pessoa);
            System.out.println("Validando pessoa: " + pessoa.getName());
            if (erros.isEmpty()) {
                dao.save(pessoa);
            } else {
                System.out.println("❌ Erros encontrados:");
                erros.forEach(erro -> System.out.println("  - " + erro));
            }
            System.out.println("--------------------------------------------------");
        }
    }
}

