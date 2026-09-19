package Polimorfismo.Produto.Entities;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class ProdutoUsado extends Produto {
    private LocalDate dataManufatura;
    DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public ProdutoUsado() {
        super();
    }

    public ProdutoUsado(String nome, Double preco, LocalDate dataManufatura) {
        super(nome, preco);
        this.dataManufatura = dataManufatura;
    }

    public LocalDate getDataManufatura() {
        return dataManufatura;
    }

    public void setDataManufatura(LocalDate dataManufatura) {
        this.dataManufatura = dataManufatura;
    }

    public String priceTag(){
        return getNome() + " (used) $ " + String.format("%.2f", getPreco()) + " (Manufacte date: " + dataManufatura.format(formato) + ")";
    }
}
