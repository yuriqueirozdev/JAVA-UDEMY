package TrabalandoComArquivos.FileManipulandoPastas;

import java.io.File;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Informe o caminho da pasta: ");
        String strPath = sc.nextLine();

        File path = new File(strPath);

        File[] pastas = path.listFiles(File::isDirectory);
        System.out.println("Pastas:");

        if(pastas != null) {
            for (File folder : pastas) {
                System.out.println(folder);
            }
        }

        File[] arquivos = path.listFiles(File::isFile);
        System.out.println("Arquivos:");

        if (arquivos != null) {
            for (File x : arquivos) {
                System.out.println(x);
            }
        }

        boolean sucesso = new File(strPath + "\\subdir").mkdir();
        System.out.println("Diretorio criado com sucesso: " + sucesso);
        sc.close();
    }
}
