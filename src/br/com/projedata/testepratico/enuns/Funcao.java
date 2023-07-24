package br.com.projedata.testepratico.enuns;

public enum Funcao {

    CONTADOR("Contador"),
    COORDENADOR("Coordenador"),
    DIRETOR("Diretor"),
    ELETRICISTA("Eletricista"),
    GERENTE("Gerente"),
    OPERADOR("Operador"),
    RECEPCIONISTA("Recepcionista");

    private final String descricao;

    Funcao(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}
