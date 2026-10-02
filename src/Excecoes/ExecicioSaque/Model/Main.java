package Excecoes.ExecicioSaque.Model;

import Excecoes.ExecicioSaque.Model.Entities.Conta;
import Excecoes.Reserva.Model.Exception.DomainException;

import java.util.Scanner;
import java.util.Locale;

public class Main {
    public static void main(String[] args){
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        try {
            System.out.println("Informe os dados da sua conta");
            System.out.print("Número: ");
            int numeroConta = sc.nextInt();
            System.out.print("Titular: ");
            sc.nextLine();
            String titular = sc.nextLine();
            System.out.print("Saldo inicial: ");
            Double saldo = sc.nextDouble();
            System.out.print("Limite de saque: ");
            Double limiteSaque = sc.nextDouble();
            Conta conta = new Conta(numeroConta, titular, saldo, limiteSaque);

            System.out.println();
            System.out.print("Informe o valor do saque: ");
            Double saque = sc.nextDouble();
            conta.saque(saque);

            System.out.println(conta);
        }catch (DomainException e){
            System.out.println("Erro: " + e.getMessage());
        } catch (RuntimeException e) {
            System.out.println("Ocorreu um erro inesperado.");
        }
        sc.close();
    }
}
