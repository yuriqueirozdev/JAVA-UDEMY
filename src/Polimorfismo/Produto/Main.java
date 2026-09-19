package Polimorfismo.Produto;

import Polimorfismo.Produto.Entities.Produto;
import Polimorfismo.Produto.Entities.ProdutoImportado;
import Polimorfismo.Produto.Entities.ProdutoUsado;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Locale;

public class Main {
    public static void main(String[] args){
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        List<Produto> produtos = new ArrayList<>();
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");


        System.out.print("Entre com o número de produtos: ");
        int quantidadeProdutos = sc.nextInt();

        for (int i = 0; i < quantidadeProdutos; i++) {
            System.out.println("Product #" + (i + 1) + " data:");
            System.out.print("Common, used or imported (c/u/i)? ");
            char tipo = sc.next().charAt(0);
            System.out.print("Nome: ");
            sc.nextLine();
            String nome = sc.nextLine();
            System.out.print("Preço: ");
            Double preco = sc.nextDouble();

            if (tipo == 'i'){
                System.out.print("Customs fee: ");
                Double taxaAlfandega = sc.nextDouble();
                produtos.add(new ProdutoImportado(nome, preco, taxaAlfandega));
            }else if(tipo == 'u'){
                System.out.print("Data da manufatura (DD/MM/YYYY): ");
                sc.nextLine();
                LocalDate data = LocalDate.parse(sc.nextLine(), formato);
                produtos.add(new ProdutoUsado(nome, preco, data));
            }else{
                produtos.add(new Produto(nome, preco));
            }

        }

        System.out.println("PRICE TAGS:");
        for(Produto x : produtos){
            System.out.println(x.priceTag());
        }
        sc.close();
    }
}
