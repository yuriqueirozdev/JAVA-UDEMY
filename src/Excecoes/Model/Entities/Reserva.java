package Excecoes.Model.Entities;

import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Reserva {
    private Integer numeroDoQuarto;
    private LocalDate checkin;
    private LocalDate checkout;

    private static DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public Reserva() {
    }

    public Reserva(Integer numeroDoQuarto, LocalDate checkin, LocalDate checkout) {
        this.numeroDoQuarto = numeroDoQuarto;
        this.checkin = checkin;
        this.checkout = checkout;
    }

    public Integer getNumeroDoQuarto() {
        return numeroDoQuarto;
    }

    public LocalDate getCheckin() {
        return checkin;
    }

    public LocalDate getCheckout() {
        return checkout;
    }

    public long duracao(){
        return Duration.between(checkin, checkout).toDays();
    }

    public void atualizarDatas(LocalDate checkin, LocalDate checkout){
        this.checkin = checkin;
        this.checkout = checkout;
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();

        sb.append("Room ");
        sb.append(numeroDoQuarto);
        sb.append(", check-in: ");
        sb.append(formato.format(checkin));
        sb.append(", check-out: ");
        sb.append(formato.format(checkout));
        sb.append(", ");
        sb.append(duracao());
        sb.append("nights");

        return sb.toString();
    }
}
