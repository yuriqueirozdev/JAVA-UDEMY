package Polimorfismo.Contribuinte;

import Polimorfismo.Contribuinte.Entities.Contribuinte;
import Polimorfismo.Contribuinte.Entities.Fisica;
import Polimorfismo.Contribuinte.Entities.Juridica;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Locale;

public class Main {
    public static void main(String[] args){
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        List<Contribuinte> contribuintes = new ArrayList<>();
        Double total = 0.0;

        System.out.print("Informe a quantidade de contribuintes: ");
        int quantidadeContribuintes = sc.nextInt();

        for (int i = 0; i < quantidadeContribuintes; i++) {
            System.out.println("Dados do contribuinte #" + (i + 1) + ":");
            System.out.print("Pessoa física ou jurídica (f/j)? ");
            char tipo = Character.toLowerCase(sc.next().charAt(0));
            System.out.print("Nome: ");
            sc.nextLine();
            String nome = sc.nextLine();
            System.out.print("Arrecadação anual: ");
            Double arrecadacao = sc.nextDouble();

            if (tipo == 'f'){
                System.out.print("Gastos com saúde: ");
                Double gastosSaude = sc.nextDouble();
                contribuintes.add(new Fisica(nome, arrecadacao, gastosSaude));
            }else{
                System.out.print("Quantidade de funcionários: ");
                int quantidadeFuncionarios = sc.nextInt();
                contribuintes.add(new Juridica(nome, arrecadacao, quantidadeFuncionarios));
            }
        }

        System.out.println("IMPOSTOS PAGOS:");

        for (Contribuinte x : contribuintes){
            System.out.println(x.toString());
            total += x.imposto();
        }

        System.out.printf("IMPOSTOS TOTAIS: $ %.2f%n", total);

        sc.close();
    }
}
