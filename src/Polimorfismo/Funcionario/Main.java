package Polimorfismo.Funcionario;

import Polimorfismo.Funcionario.Entities.Funcionario;
import Polimorfismo.Funcionario.Entities.FuncionarioTerceiro;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Locale;

public class Main {
    public static void main(String[] args){
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        System.out.print("Quantos funcionários? ");
        int quantidade = sc.nextInt();
        List<Funcionario> funcionarios = new ArrayList<>();

        for (int i = 0; i < quantidade; i++) {
            System.out.println("Funcionário #" + (i + 1) + " data:");
            System.out.print("Terceiro (y/n)? ");
            char terceiro = sc.next().charAt(0);

            System.out.print("Nome: ");
            sc.nextLine();
            String nome = sc.nextLine();
            System.out.print("Horas: ");
            Integer horas = sc.nextInt();
            System.out.print("Valor por hora: ");
            Double valorPorHora = sc.nextDouble();
            if (terceiro == 'y') {
                System.out.print("Despesa adicional: ");
                Double valorAdicional = sc.nextDouble();
                funcionarios.add(new FuncionarioTerceiro(nome, horas, valorPorHora, valorAdicional));
            }else {
                funcionarios.add(new Funcionario(nome, horas, valorPorHora));
            }
        }

        System.out.println("PAGAMENTOS:");
        for(Funcionario x : funcionarios){
            System.out.println(x);
        }

        sc.close();
    }
}
