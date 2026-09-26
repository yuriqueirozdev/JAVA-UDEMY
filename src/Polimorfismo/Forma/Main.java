package Polimorfismo.Forma;

import Polimorfismo.Forma.Entities.Circulo;
import Polimorfismo.Forma.Entities.Forma;
import Polimorfismo.Forma.Entities.Retangulo;
import Polimorfismo.Forma.Enums.Color;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Locale;

public class Main {
    public static void main(String[] args){
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        List<Forma> formas = new ArrayList<>();

        System.out.print("Informe a quantidade de formas: ");
        int quantidade = sc.nextInt();

        for (int i = 0; i < quantidade; i++) {
            System.out.println("Shape #" + (i + 1) + " data:");
            System.out.print("Retângulo ou círculo (r/c)? ");
            char escolha = sc.next().charAt(0);
            System.out.print("Color (BLACK/BLUE/RED): ");
            sc.nextLine();
            Color cor = Color.valueOf(sc.nextLine().toUpperCase());

            if(escolha == 'r'){
                System.out.print("Largura: ");
                Double largura = sc.nextDouble();
                System.out.print("Altura: ");
                Double altura = sc.nextDouble();
                formas.add(new Retangulo(cor, largura, altura));
            }else{
                System.out.print("Radius: ");
                Double raio = sc.nextDouble();
                formas.add(new Circulo(cor, raio));
            }
        }

        System.out.println("ÁREA DAS FORMAS:");
        for(Forma x : formas){
            System.out.println(x.toString());
        }
        sc.close();
    }
}
