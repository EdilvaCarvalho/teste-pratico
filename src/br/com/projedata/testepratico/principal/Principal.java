package br.com.projedata.testepratico.principal;

import br.com.projedata.testepratico.enuns.Funcao;
import br.com.projedata.testepratico.modelos.Funcionario;
import br.com.projedata.testepratico.utils.DataNascimentoComparator;
import br.com.projedata.testepratico.utils.FormataBigDecimal;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

public class Principal {
    public static void main(String[] args) {

        // Criando todos os funcionários
        Funcionario maria = new Funcionario("Maria", LocalDate.of(2000, 10, 18), new BigDecimal(2009.44), Funcao.OPERADOR);
        Funcionario joao = new Funcionario("João", LocalDate.of(1990, 5, 12), new BigDecimal(2284.38), Funcao.OPERADOR);
        Funcionario caio = new Funcionario("Caio", LocalDate.of(1961, 5, 2), new BigDecimal(9836.14), Funcao.COORDENADOR);
        Funcionario miguel = new Funcionario("Miguel", LocalDate.of(1988, 10, 14), new BigDecimal(19119.88), Funcao.DIRETOR);
        Funcionario alice = new Funcionario("Alice", LocalDate.of(1995, 1, 5), new BigDecimal(2234.68), Funcao.RECEPCIONISTA);
        Funcionario heitor = new Funcionario("Heitor", LocalDate.of(1999, 11, 19), new BigDecimal(1582.72), Funcao.OPERADOR);
        Funcionario arthur = new Funcionario("Arthur", LocalDate.of(1993, 3, 31), new BigDecimal(4071.84), Funcao.CONTADOR);
        Funcionario laura = new Funcionario("Laura", LocalDate.of(1994, 7, 8), new BigDecimal(3017.45), Funcao.GERENTE);
        Funcionario heloisa = new Funcionario("Heloísa", LocalDate.of(2003, 5, 24), new BigDecimal(1606.85), Funcao.ELETRICISTA);
        Funcionario helena = new Funcionario("Helena", LocalDate.of(1996, 9, 2), new BigDecimal(2799.93), Funcao.GERENTE);

        // Criando uma lista e inserindo todos os funcionários nela
        List <Funcionario> funcionarios = new ArrayList<>();
        funcionarios.add(maria);
        funcionarios.add(joao);
        funcionarios.add(caio);
        funcionarios.add(miguel);
        funcionarios.add(alice);
        funcionarios.add(heitor);
        funcionarios.add(arthur);
        funcionarios.add(laura);
        funcionarios.add(heloisa);
        funcionarios.add(helena);

        // Imprimindo a lista com todos os funcionários
        // Com a data de nascimento exibida no formato dd/mm/aaaa
        // Com o salário exibido no formatado com separador de milhar como ponto e decimal como vírgula
        funcionarios.forEach(System.out::println);
        System.out.println("***************************************************************************************");

        System.out.println("Lista com o funcionário João removido.");
        funcionarios.removeIf(funcionario -> funcionario.getNome().equals("João"));
        funcionarios.forEach(System.out::println);
        System.out.println("***************************************************************************************");

        System.out.println("Lista de funcionários com o salário com reajuste de 10%.");
        for (Funcionario funcionario: funcionarios) {
            funcionario.reajustaSalario(10);
            System.out.println(funcionario);
        }
        System.out.println("***************************************************************************************");

        System.out.println("Agrupamento dos funcionários por função em um MAP, sendo a chave a “função” e o valor a “lista de funcionários\"");
        Map<Funcao, List<Funcionario>> funcionariosPorFuncao
                = funcionarios.stream().collect(Collectors.groupingBy(Funcionario::getFuncao));
        for (Funcao key: funcionariosPorFuncao.keySet()){
            System.out.println(key+ " = " + funcionariosPorFuncao.get(key));
        }
        System.out.println("***************************************************************************************");

        System.out.println("Funcionários que fazem aniversário no mês 10 e 12");
        List<Funcionario> funcionariosAniversario = funcionarios.stream().
                filter(funcionario -> funcionario.getDataNascimento().getMonthValue() == 10 || funcionario.getDataNascimento().getMonthValue() == 12).toList();
        funcionariosAniversario.forEach(System.out::println);
        System.out.println("***************************************************************************************");

        funcionarios = funcionarios.stream().sorted(Comparator.comparing(Funcionario::getDataNascimento)).collect(Collectors.toList());
        Funcionario funcionarioComMaiorIdade = funcionarios.get(0);
        System.out.println("Funcionário(a) com a maior idade é " + funcionarioComMaiorIdade.getNome() + ", " + funcionarioComMaiorIdade.getIdade() + " anos.");
        System.out.println("***************************************************************************************");

        funcionarios = funcionarios.stream().sorted(Comparator.comparing(Funcionario::getNome)).collect(Collectors.toList());
        System.out.println("Funcionários por ordem alfabética:");
        funcionarios.forEach(System.out::println);
        System.out.println("***************************************************************************************");

        BigDecimal soma = new BigDecimal(0);
        for (Funcionario funcionario: funcionarios) {
            soma = soma.add(funcionario.getSalario());
        }

        FormataBigDecimal formata = new FormataBigDecimal();
        System.out.println("O total dos salários dos funcionários é " + formata.formata(soma));
        System.out.println("***************************************************************************************");

        System.out.println("Quantidade de salários mínimos que cada funcionário ganha:");
        for (Funcionario funcionario: funcionarios) {
            BigDecimal quantSalarios = funcionario.getSalario().divide(new BigDecimal(1212.00), 1, RoundingMode.HALF_UP);
            System.out.println(funcionario.getNome() + ": " + formata.formata(quantSalarios) + " salários.");
        }

    }

}
