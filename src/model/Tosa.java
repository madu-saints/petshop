package model;

import enums.TamanhoAnimal;
import java.time.LocalDate;

public class Tosa extends Servico {

    public Tosa(int codigo, LocalDate data, TamanhoAnimal tamanho) {
        super(codigo, data, tamanho);
    }

    @Override
    public double calcularPreco() {
        if (getTamanho() == TamanhoAnimal.PEQUENO) this.preco = 30.0;
        else if (getTamanho() == TamanhoAnimal.MEDIO) this.preco = 40.0;
        else if (getTamanho() == TamanhoAnimal.GRANDE) this.preco = 50.0;

        return this.preco;
    }

    @Override
    public String getDescricao() {
        return "Tosa (" + getTamanho() + ")";
    }
}
