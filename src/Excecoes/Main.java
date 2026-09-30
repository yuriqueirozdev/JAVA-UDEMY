package Excecoes;

import Excecoes.Model.Entities.Reserva;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import java.util.Locale;

public class Main {
    public static void main(String[] args){
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        System.out.print("Número do quarto: ");
        int numeroDoQuarto = sc.nextInt();
        System.out.print("Data de check-in: ");
        sc.nextLine();
        LocalDate checkin = LocalDate.parse(sc.nextLine(), formato);
        System.out.print("Data de check-out: ");
        LocalDate checkout = LocalDate.parse(sc.nextLine(), formato);
        Reserva reserva = new Reserva(numeroDoQuarto, checkin, checkout);

        System.out.print(reserva);

        System.out.println("Informe os dados para atualizar a reserva: ");
        System.out.print("Data de check-in: ");
        sc.nextLine();
        checkin = LocalDate.parse(sc.nextLine(), formato);
        System.out.print("Data de check-out: ");
        checkout = LocalDate.parse(sc.nextLine(), formato);
        reserva.atualizarDatas(checkin, checkout);

        System.out.print(reserva);

        sc.close();
    }
}
