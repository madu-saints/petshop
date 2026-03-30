package repository;

import model.ServicoPet; // Importa a interface
import java.util.ArrayList;
import java.util.List;

public class Inventario {

    private List<ServicoPet> servicos = new ArrayList<>();

    public void adicionarServico(ServicoPet servico) {
        if (servico != null) {
            servicos.add(servico);
        }
    }

    public void emitirRelatorio() {
        System.out.println("\n===== RELATORIO DO DIA =====");
        double totalGeral = 0;

        for (ServicoPet s : servicos) {
            System.out.println(s.toString());
            totalGeral += s.calcularPreco();
        }

        System.out.println("============================");
        System.out.printf("Total Faturado: R$ %.2f\n", totalGeral);
        System.out.println("============================\n");
    }
}
