package br.edu.lab5.calcsalario;

public class MainCalcSalario {
    public static void main(String[] args) {
        CalculadoraSalario calc = new CalculadoraSalario();

        for (Funcionario f : FuncionarioData.getFuncionarios()) {
            Double salarioLiquido = calc.calcular(f);
            System.out.printf("Funcionário: %-10s | Cargo: %-13s | Salário Líquido: R$ %.2f\n",
                    f.getNome(), f.getCargo(), salarioLiquido);
        }
    }
}
