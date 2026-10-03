package TrabalandoComArquivos.FileWriteAndBufferedWrite;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Main {
    public static void main(String[] args){
        String[] linhas = new String[]{"Eu", "te", "amo"};
        String path = "C:\\Users\\beatr\\OneDrive\\Desktop\\bea.txt";

        try(BufferedWriter bw = new BufferedWriter(new FileWriter(path, true))){
            for(String x : linhas){
                bw.write(x);
                bw.newLine();
            }
        } catch (IOException e) {
            System.out.println("Erro: " + e);
        }
    }
}
