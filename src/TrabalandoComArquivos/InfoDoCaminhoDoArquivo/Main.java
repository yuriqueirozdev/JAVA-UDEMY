package TrabalandoComArquivos.InfoDoCaminhoDoArquivo;

import java.io.File;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Informe o caminho do arquivo:");
        String stringPath = sc.nextLine();

        File path = new File(stringPath);

        System.out.println(path.getName());
        System.out.println(path.getPath());
        System.out.println(path.getParent());

        sc.close();
    }
}
