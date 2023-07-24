package br.com.projedata.testepratico.utils;

import br.com.projedata.testepratico.modelos.Funcionario;

import java.util.Comparator;

public class DataNascimentoComparator implements Comparator<Funcionario> {

    @Override
    public int compare(Funcionario o1, Funcionario o2) {
        return o1.getDataNascimento().compareTo(o2.getDataNascimento());
    }
}
