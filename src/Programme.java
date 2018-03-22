import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

/**
 * Created by valenza-manjaro on 15/03/18.
 */
public class Programme {
    private static Scanner input = new Scanner(System.in);
    int[] tabr;

    public static void main(String [ ] args)
    {
        int choice = 0;
        File file = null;
        do {

            do {
                System.out.println("Instance d'entrée : ");
                System.out.println("1 : ");
                System.out.println("2 : TABR vers fichier");
                System.out.println("3 : ");
                System.out.println("0 : Exit");
                choice = input.nextInt();
            } while (choice < 0 || choice > 3);

            switch (choice) {
                case 1:
                    fichierVersTABR();
                    break;
                case 2:
                    tabABRversFichier();
                    break;
                case 3:
                    break;
                default:
            }
        }while (choice != 0);
        System.out.println("Ciao !");
    }

    private static void fichierVersTABR() {
        BufferedReader br = null;
        String file = "";

        try {
            br = new BufferedReader(new FileReader(file));
            readFile(br);
            br.close();
        } catch(IOException e){
            System.out.println("ERREUR : le fichier n'existe pas.");
            e.printStackTrace();
        }


    }

    private static void readFile(BufferedReader br) throws IOException {
        String line = br.readLine();
        while (line != null){

        }
    }

    private static void tabABRversFichier() {

    }


}
