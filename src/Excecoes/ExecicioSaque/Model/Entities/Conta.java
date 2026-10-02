package Excecoes.ExecicioSaque.Model.Entities;

import Excecoes.Reserva.Model.Exception.DomainException;

public class Conta {
    private Integer numero;
    private String titular;
    private Double saldo;
    private Double limiteSaque;

    public Conta() {
    }

    public Conta(Integer numero, String titular, Double saldo, Double limiteSaque) {
        this.numero = numero;
        this.titular = titular;
        this.saldo = saldo;
        this.limiteSaque = limiteSaque;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public String getTitular() {
        return titular;
    }

    public void setTitular(String titular) {
        this.titular = titular;
    }

    public Double getSaldo() {
        return saldo;
    }

    public Double getLimiteSaque() {
        return limiteSaque;
    }

    public void deposito(Double valor){
        this.saldo += valor;
    }

    public void saque(Double valor) throws DomainException {
        if (saldo < valor){
            throw new DomainException("Saldo insuficiente");
        }
        if (valor > limiteSaque){
            throw new DomainException("Valor maior que o limite de saque");
        }
        this.saldo -= valor;
    }

    public String toString(){
        StringBuilder sb = new StringBuilder();

        sb.append("Novo saldo: ");
        sb.append(String.format("%.2f", saldo));

        return sb.toString();
    }
}
