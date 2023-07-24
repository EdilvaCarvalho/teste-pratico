package br.com.projedata.testepratico.modelos;

import br.com.projedata.testepratico.enuns.Funcao;
import br.com.projedata.testepratico.utils.FormataBigDecimal;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.time.LocalDate;
import java.time.Period;
import java.util.*;
import java.util.stream.Collectors;

public class Funcionario extends Pessoa {

    private BigDecimal salario;
    private Funcao funcao;

    public Funcionario(String nome, LocalDate dataNascimento, BigDecimal salario, Funcao funcao) {
        super(nome, dataNascimento);
        this.salario = salario;
        this.funcao = funcao;
    }

    public Funcionario() {
    }

    public BigDecimal getSalario() {
        return salario;
    }

    public void setSalario(BigDecimal salario) {
        this.salario = salario;
    }

    public Funcao getFuncao() {
        return funcao;
    }

    public void setFuncao(Funcao funcao) {
        this.funcao = funcao;
    }

    public void reajustaSalario(double porcentagem) {
        this.setSalario(salario.add(salario.multiply(new BigDecimal(porcentagem/100))));
    }

    public int getIdade() {
        LocalDate dataHoje = LocalDate.now();
        Period period = this.getDataNascimento().until(dataHoje);
        return period.getYears();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Funcionario that)) return false;
        if (!super.equals(o)) return false;
        return Objects.equals(getSalario(), that.getSalario()) && getFuncao() == that.getFuncao();
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getSalario(), getFuncao());
    }

    @Override
    public String toString() {

        FormataBigDecimal formata = new FormataBigDecimal();

        return "Funcionario{" + super.toString() +
                ", salario=" + formata.formata(salario) +
                ", funcao=" + funcao +
                '}';
    }

}
