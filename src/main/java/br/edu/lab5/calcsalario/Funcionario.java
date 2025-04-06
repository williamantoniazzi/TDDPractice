package br.edu.lab5.calcsalario;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Funcionario {
    private String nome;
    private String email;
    private Double salarioBase;
    private CargoEnum cargo;
}
