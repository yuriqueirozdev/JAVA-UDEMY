package TrabalandoComArquivos.Desafio;

import TrabalandoComArquivos.Desafio.Entities.Produto;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class Main {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        List<Produto> produtos = new ArrayList<>();

        String strPath = "/home/yuri/Área de Trabalho/ORIGINAL/original.csv";

        try(BufferedReader br = new BufferedReader(new FileReader(strPath))){
            String linha = br.readLine();
            while (linha != null){
                String[] itensLinha = linha.split(",");
                produtos.add(new Produto(itensLinha[0], Double.parseDouble(itensLinha[1]), Integer.parseInt(itensLinha[2])));
                linha = br.readLine();
            }

            try(BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("/home/yuri/Área de Trabalho/ORIGINAL/out/summary.csv"))){
                for(Produto x : produtos){
                    bufferedWriter.write(x.getNome() + ", " + String.format("%.2f%n", x.precoTotal()));
                }
            }catch(IOException e) {
                System.out.println("Erro: " + e);
            }

        } catch(IOException e) {
            System.out.println("Erro: " + e);
        }
    }
}
