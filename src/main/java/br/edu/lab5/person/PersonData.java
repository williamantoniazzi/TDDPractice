package br.edu.lab5.person;

import java.util.Arrays;
import java.util.List;

public class PersonData {
    // Mockando dados em arquivo para testes das classes, como se fosse uma ligação com o BD. Garantir valores.
    public static List<Person> getPessoasMockadas() {
        return Arrays.asList(
                new Person(1, "Ana", 25, Arrays.asList(
                        new Email(1, "ana@email.com"),
                        new Email(2, "ana.trabalho@email.com")
                )),
                new Person(2, "Carlos Silva", 17, Arrays.asList(
                        new Email(3, "carlos@email.com")
                )),
                new Person(3, "", 30, Arrays.asList(
                        new Email(4, "semnome@email.com")
                )),
                new Person(4, "João", 40, null),
                new Person(5, "Maria", 29, Arrays.asList())
        );
    }
}

