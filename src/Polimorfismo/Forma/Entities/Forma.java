package Polimorfismo.Forma.Entities;

import Polimorfismo.Forma.Enums.Color;

public abstract class Forma {
    private Color cor;

    public Forma() {
    }

    public Forma(Color cor) {
        this.cor = cor;
    }

    public Color getCor() {
        return cor;
    }

    public void setCor(Color cor) {
        this.cor = cor;
    }

    public abstract Double area();

    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("%.2f", area()));
        return  sb.toString();
    }
}
