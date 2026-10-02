package Excecoes.Model.Entities;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import Excecoes.Model.Exception.*;

public class Reserva {
    private Integer numeroDoQuarto;
    private LocalDate checkin;
    private LocalDate checkout;

    private static DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public Reserva() {
    }

    public Reserva(Integer numeroDoQuarto, LocalDate checkin, LocalDate checkout) throws DomainException {
        if(!checkout.isAfter(checkin)){
            throw new DomainException("A data do check-out precisa ser maior que a do check-in.");
        }
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
        return ChronoUnit.DAYS.between(checkin, checkout);
    }

    public void atualizarDatas(LocalDate checkin, LocalDate checkout) throws DomainException {
        LocalDate agora = LocalDate.now();
        if(checkin.isBefore(agora) || checkout.isBefore(agora)){
            throw new DomainException("A data de atualização precisa ser um dia maior que o atual.");
        }
        if(!checkout.isAfter(checkin)){
            throw new DomainException("A data do check-out precisa ser maior que a do check-in.");
        }
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
        sb.append(" nights");

        return sb.toString();
    }
}
