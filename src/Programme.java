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
    private static TABR t;

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
        String file = "abr.txt";

        try {
            br = new BufferedReader(new FileReader(file));
            definirNbCases(br);
            br.close();

            br = new BufferedReader(new FileReader(file));
            readFile(br);
            br.close();
        } catch(IOException e){
            System.out.println("ERREUR : le fichier n'existe pas.");
            e.printStackTrace();
        }


    }

    private static void readFile(BufferedReader br) throws IOException {
        int nbligne = 0;
        String line = br.readLine();
        String[] tab;
        String[] debutFin;
        String[] valeurs;
        while (line != null){
            System.out.println(line);

            tab = line.split(";");
            debutFin = tab[0].split(":");
            valeurs = tab[1].split(":");

            ABR abr_racine = new ABR(Integer.valueOf(valeurs[0]), null, null);
            ABR abr = abr_racine;

            t.getTab()[nbligne] = new Case(Integer.valueOf(debutFin[0]), Integer.valueOf(debutFin[1]), abr );

            for (int i = 1; i < valeurs.length; i++){

                while ( Integer.valueOf(valeurs[i]) < abr.getValeur() || Integer.valueOf(valeurs[i]) > abr.getValeur()   ) {

                    if (Integer.valueOf(valeurs[i]) < abr.getValeur()) {
                        if(abr.getSag() == null) {
                            abr.setSag(new ABR(Integer.valueOf(valeurs[i]), null, null));
                        } else {
                            abr = abr.getSag();
                        }
                    } else if (Integer.valueOf(valeurs[i]) > abr.getValeur()) {
                        if(abr.getSad() == null) {
                            abr.setSad(new ABR(Integer.valueOf(valeurs[i]), null, null));
                        } else {
                            abr = abr.getSad();
                        }
                    }
                }
                abr = abr_racine;
            }
            nbligne++;
            line = br.readLine();
        }
        t.affiche();
        afficheLesArbres();
    }

    private static void afficheLesArbres() {
        for(int i = 0; i < t.getTab().length; i++) {
            t.getTab()[i].afficheABR(t.getTab()[i].getAbr());
        }
    }

    private static void definirNbCases(BufferedReader br) throws IOException {
        int nb = 0;
        while (br.readLine() != null){
            nb++;
        }
        t = new TABR(nb);
    }

    private static void tabABRversFichier() {

    }


}
