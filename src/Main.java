import enums.TamanhoAnimal;
import enums.TamanhoPelo;
import model.Banho;
import model.Hotelzinho;
import model.Tosa;
import repository.Inventario;

import java.time.LocalDate;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Inventario inventario = new Inventario();
        int codigo = 1;

        System.out.println("Ola! Bem-vindo ao PetShop no WhatsApp.");

        while (true) {
            System.out.println("\nO que deseja fazer?");
            System.out.println("1 - Registrar um Servico");
            System.out.println("2 - Fechar a Loja (Emitir Relatorio)");
            System.out.print("Sua opcao: ");

            int opcao = sc.nextInt();

            if (opcao == 2) {
                System.out.println("Fechando a loja e gerando relatorio...");
                inventario.emitirRelatorio();
                break;
            }

            if (opcao == 1) {
                System.out.print("Qual o servico? (1-Banho, 2-Tosa, 3-Hotelzinho): ");
                int tipoServico = sc.nextInt();

                System.out.print("Qual o tamanho do pet? (1-PEQUENO, 2-MEDIO, 3-GRANDE): ");
                int opcaoTam = sc.nextInt();


                TamanhoAnimal tamanho = TamanhoAnimal.PEQUENO;
                if (opcaoTam == 2) tamanho = TamanhoAnimal.MEDIO;
                if (opcaoTam == 3) tamanho = TamanhoAnimal.GRANDE;


                if (tipoServico == 1) {
                    System.out.print("Qual o tamanho do pelo? (1-CURTO, 2-MEDIO, 3-LONGO): ");
                    int opcaoPelo = sc.nextInt();

                    TamanhoPelo pelo = TamanhoPelo.CURTO;
                    if (opcaoPelo == 2) pelo = TamanhoPelo.MEDIO;
                    if (opcaoPelo == 3) pelo = TamanhoPelo.LONGO;

                    inventario.adicionarServico(new Banho(codigo++, LocalDate.now(), tamanho, pelo));
                    System.out.println("Servico de Banho registrado com sucesso!");
                }

                else if (tipoServico == 2) {
                    inventario.adicionarServico(new Tosa(codigo++, LocalDate.now(), tamanho));
                    System.out.println("Servico de Tosa registrado com sucesso!");
                }

                else if (tipoServico == 3) {
                    System.out.print("Quantas horas o pet vai ficar? ");
                    int horas = sc.nextInt();

                    inventario.adicionarServico(new Hotelzinho(codigo++, LocalDate.now(), tamanho, horas));
                    System.out.println("Servico de Hotelzinho registrado com sucesso!");
                }
            } else {
                System.out.println("Opcao invalida. Tente novamente.");
            }
        }

        sc.close();
    }
}
