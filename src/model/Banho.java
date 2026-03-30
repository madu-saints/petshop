package model;

import enums.TamanhoAnimal;
import enums.TamanhoPelo;
import java.time.LocalDate;

public class Banho extends Servico {
    private TamanhoPelo pelo;

    public Banho(int codigo, LocalDate data, TamanhoAnimal tamanho, TamanhoPelo pelo) {
        super(codigo, data, tamanho);
        this.pelo = pelo;
    }

    @Override
    public double calcularPreco() {
        double valorBase = 0;
        if (getTamanho() == TamanhoAnimal.PEQUENO) valorBase = 50.0;
        else if (getTamanho() == TamanhoAnimal.MEDIO) valorBase = 60.0;
        else if (getTamanho() == TamanhoAnimal.GRANDE) valorBase = 70.0;

        double acrescimo = 0;
        if (this.pelo == TamanhoPelo.MEDIO) acrescimo = 15.0;
        else if (this.pelo == TamanhoPelo.LONGO) acrescimo = 25.0;

        this.preco = valorBase + acrescimo;
        return this.preco;
    }

    @Override
    public String getDescricao() {
        return "Banho (" + getTamanho() + ", Pelo " + pelo + ")";
    }
}
