package br.edu.lab5.calcsalario;

import java.util.Arrays;
import java.util.List;

public class FuncionarioData {

    public static List<Funcionario> getFuncionarios() {
        return Arrays.asList(
                new Funcionario("João", "joao@email.com", 3500.0, CargoEnum.DESENVOLVEDOR),
                new Funcionario("Maria", "maria@email.com", 2500.0, CargoEnum.DBA),
                new Funcionario("Carlos", "carlos@email.com", 5500.0, CargoEnum.GERENTE),
                new Funcionario("Ana", "ana@email.com", 1900.0, CargoEnum.TESTADOR),
                new Funcionario("Bruno", "bruno@email.com", 2800.0, CargoEnum.DESENVOLVEDOR),
                new Funcionario("Lúcia", "lucia@email.com", 1500.0, CargoEnum.DBA)
        );
    }
}

