package EnumAndComposicao.ExercicioPedido;

import EnumAndComposicao.ExercicioPedido.Entities.Client;
import EnumAndComposicao.ExercicioPedido.Entities.Order;
import EnumAndComposicao.ExercicioPedido.Entities.OrderItem;
import EnumAndComposicao.ExercicioPedido.Entities.Product;
import EnumAndComposicao.ExercicioPedido.Enums.OrderStatus;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        DateTimeFormatter formato1 = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        System.out.println("Entre com os dados do cliente:");
        System.out.print("Name: ");
        String nome = sc.nextLine();
        System.out.print("Email: ");
        String email = sc.nextLine();
        System.out.print("Birth date (DD/MM/YYYY): ");
        LocalDate aniversario = LocalDate.parse(sc.nextLine(), formato1);
        Client client = new Client(nome, email, aniversario);

        System.out.println("Enter order data:");
        System.out.print("Status: ");
        OrderStatus status = OrderStatus.valueOf(sc.next());
        LocalDateTime momentoPedido = LocalDateTime.now();

        Order order = new Order(momentoPedido, status, client);

        System.out.print("Quantos itens terá o pedido? ");
        int quantidade = sc.nextInt();

        for (int i = 0; i < quantidade; i++) {
            System.out.println("Enter #" + (i+1) + " order data:");
            System.out.print("Product name: ");
            sc.nextLine();
            String nomeProduto = sc.nextLine();
            System.out.print("Product price: ");
            Double precoProduto = sc.nextDouble();
            System.out.print("quantity: ");
            Integer quantidadeProduto = sc.nextInt();

            Product produto = new Product(nomeProduto, precoProduto);
            OrderItem orderItem = new OrderItem(quantidadeProduto, precoProduto, produto);
            order.addItem(orderItem);
        }

        System.out.println(order);

        sc.close();
    }
}
