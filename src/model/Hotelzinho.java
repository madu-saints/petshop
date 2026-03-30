package model;

import enums.TamanhoAnimal;
import java.time.LocalDate;

public class Hotelzinho extends Servico {
    private int horas;

    public Hotelzinho(int codigo, LocalDate data, TamanhoAnimal tamanho, int horas) {
        super(codigo, data, tamanho);
        this.horas = horas;
    }

    @Override
    public double calcularPreco() {
        double valorHora = 0;
        if (getTamanho() == TamanhoAnimal.PEQUENO) valorHora = 12.0;
        else if (getTamanho() == TamanhoAnimal.MEDIO) valorHora = 18.0;
        else if (getTamanho() == TamanhoAnimal.GRANDE) valorHora = 25.0;

        this.preco = valorHora * horas;
        return this.preco;
    }

    @Override
    public String getDescricao() {
        return "Hotelzinho (" + getTamanho() + " - " + horas + " horas)";
    }
}
