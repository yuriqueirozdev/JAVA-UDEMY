package EnumAndComposicao.ExercicioDepartment;
import EnumAndComposicao.ExercicioDepartment.Entities.Department;
import EnumAndComposicao.ExercicioDepartment.Entities.HourContract;
import EnumAndComposicao.ExercicioDepartment.Entities.Trabalhador;
import EnumAndComposicao.ExercicioDepartment.Enums.WorkerLevel;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        System.out.print("Informe o nome do departamento: ");
        String departamento = sc.nextLine();

        System.out.println("Enter worker data:");
        System.out.print("Name: ");
        String name = sc.nextLine();
        System.out.print("Level: ");
        WorkerLevel workerLevel = WorkerLevel.valueOf(sc.next());
        System.out.print("Base salary: ");
        Double salary = sc.nextDouble();
        Trabalhador trabalhador = new Trabalhador(name, salary, workerLevel, new Department(departamento));

        System.out.print("How many contracts to this worker? ");
        int quantidadeContratos = sc.nextInt();

        for (int i = 0; i < quantidadeContratos; i++) {
            System.out.println("Enter contract #" + (i + 1) + " data:");
            System.out.print("Data (DD/MM/YYYY): ");
            LocalDate data = LocalDate.parse(sc.next(), formato);
            System.out.print("Value per hour: ");
            Double valorPorHora = sc.nextDouble();
            System.out.print("Duration (hours): ");
            int duracao = sc.nextInt();
            HourContract contract = new HourContract(data, valorPorHora, duracao);
            trabalhador.addContract(contract);
        }

        System.out.print("Enter month and year to calculate income (MM/YYYY): ");
        String mesEAno = sc.next();
        Integer mes = Integer.valueOf(mesEAno.substring(0,2));
        Integer ano = Integer.valueOf(mesEAno.substring(3));
        Double valorTotal = trabalhador.income(ano, mes);

        System.out.println("Name: " + trabalhador.getName());
        System.out.println("Department: " + trabalhador.getDepartment().getName());
        System.out.printf("Income for %s/%s: %.2f%n", mes, ano, valorTotal);

        sc.close();
    }
}
