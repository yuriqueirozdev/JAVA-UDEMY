package EnumAndComposicao.ExercicioPedido.Entities;

import EnumAndComposicao.ExercicioPedido.Enums.OrderStatus;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Order {
    private LocalDateTime moment;
    private OrderStatus status;
    private final DateTimeFormatter formato1 = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    private final DateTimeFormatter formato2 = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");

    private final List<OrderItem> orderItems = new ArrayList<>();
    private Client client;

    public Order() {
    }

    public Order(LocalDateTime moment, OrderStatus status, Client client) {
        this.moment = moment;
        this.status = status;
        this.client = client;
    }

    public LocalDateTime getMoment() {
        return moment;
    }

    public void setMoment(LocalDateTime moment) {
        this.moment = moment;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    public List<OrderItem> getOrderItems() {
        return orderItems;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public void addItem(OrderItem item){
        orderItems.add(item);
    }

    public void removeItem(OrderItem item){
        orderItems.remove(item);
    }

    public Double total(){
        Double total = 0.0;

        for(OrderItem c : orderItems){
            total += c.subTotal();
        }

        return total;
    }

    public String toString(){
        StringBuilder sb = new StringBuilder();

        sb.append("ORDER SUMMARY:").append("\n");
        sb.append("Order moment: ");
        sb.append(moment.format(formato2)).append("\n");
        sb.append("Order status: ");
        sb.append(status).append("\n");
        sb.append("Client: ");
        sb.append(client.getName());
        sb.append(" (");
        sb.append(client.getBirthDate().format(formato1));
        sb.append(") - ");
        sb.append(client.getEmail()).append("\n");

        sb.append("Order items:").append("\n");
        for (OrderItem c : orderItems){
            sb.append(c.getProduct().getName());
            sb.append(", $");
            sb.append(String.format("%.2f", c.subTotal()));
            sb.append(", Quantity: ");
            sb.append(c.getQuantity());
            sb.append(", Subtotal: $");
            sb.append(String.format("%.2f", c.subTotal())).append("\n");
        }

        sb.append("Total price: $");
        sb.append(String.format("%.2f", total()));

        return sb.toString();
    }
}
