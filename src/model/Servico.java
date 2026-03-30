package model;

import enums.TamanhoAnimal;
import java.time.LocalDate;

public abstract class Servico implements ServicoPet {
    private int codigo;
    private LocalDate data;
    private TamanhoAnimal tamanho;
    protected double preco;

    public Servico(int codigo, LocalDate data, TamanhoAnimal tamanho) {
        this.codigo = codigo;
        this.data = data;
        this.tamanho = tamanho;
    }

    public int getCodigo() { return codigo; }
    public LocalDate getData() { return data; }
    public TamanhoAnimal getTamanho() { return tamanho; }
    public double getPreco() { return preco; }

    @Override
    public String toString() {
        return String.format("Cod: %d | Data: %s | %s | Valor: R$ %.2f",
                codigo, data, getDescricao(), calcularPreco());
    }
}
