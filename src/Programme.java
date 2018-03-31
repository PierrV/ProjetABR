import java.io.*;
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
            System.out.println("");
            do {
                System.out.println("Instance d'entrée : ");
                System.out.println("1 : Fichier vers TABR");
                System.out.println("2 : TABR vers fichier");
                System.out.println("3 : Affichage sur écran");
                System.out.println("4 : Verification");
                System.out.println("5 : Insertion d'un entier");
                System.out.println("6 : Suppression d'un entier");
                System.out.println("7 : Fusion de 2 cases !");
                System.out.println("8 : Fusion de TABR !");
                System.out.println("0 : Exit");
                choice = input.nextInt();
            } while (choice < 0 || choice > 8);

            switch (choice) {
                case 1:
                    fichierVersTABR();
                    break;
                case 2:
                    tabABRversFichier();
                    break;
                case 3:
                    t.affichage();
                   break;
                case 4:
                    if( t != null) {
                        if(t.verification())
                            System.out.println("Le TABR est correcte.");
                    } else {
                        System.out.println("Le TABR n'est pas instancier");
                    }
                    break;
                case 5:
                    if( t != null){
                        System.out.println("Entrez un nombre ! ");
                        int entree = input.nextInt();
                        int intervalle = t.intervalle(entree);
                        if(intervalle >= 0) {
                            t.getTab()[intervalle].getAbr().insertion(entree);
                        } else {
                            System.out.println("Aucun intervalle ne contient : " + entree );
                        }
                    } else {
                        System.out.println("Attention aucun TABR n'est instancier");
                    }
                    break;
                case 6:
                    if( t != null){
                        System.out.println("Entrez un nombre ! ");
                        int entree = input.nextInt();
                        int intervalle = t.intervalle(entree);
                        if ( intervalle >= 0) {
                            t.getTab()[intervalle].getAbr().supprimer(entree, t.getTab()[intervalle].getAbr());
                        } else {
                            System.out.println("Aucun intervalle ne contient : " + entree );
                        }
                    } else {
                        System.out.println("Attention aucun TABR n'est instancier");
                    }
                    break;
                case 7:
                    System.out.println("Quel case doit fusionner avec la suivante ?");
                    t.fusion2cases(input.nextInt());
                    break;
                case 8:
                    System.out.println("Fusion de TABR !");
                    ABR abr = t.fusionTABR();
                    break;
                default:
            }
        }while (choice != 0);
        System.out.println("Ciao !");
    }

    /*
     * Génère un TABR a partir d'un fichier donner en entrée (situer dans le meme répertoire que le programme)
     */
    private static void fichierVersTABR() {
        BufferedReader br = null;
        System.out.print("Entrez le nom du fichier : ");
        String file = input.next();
        System.out.println();

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
    /*
     * Lit le fichier en créant une nouvelle case pour chaque ligne
     * La ligne est séparer par des ; et :
     * Pour chaque valeur de noeud on va l'insérer dans l'abr de la case
     */
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
                abr.insertion(Integer.valueOf(valeurs[i]));
                abr = abr_racine;
            }
            nbligne++;
            line = br.readLine();
        }
        t.affiche();
    }

    private static void afficheLesArbres() {
        for(int i = 0; i < t.getTab().length; i++) {
            t.getTab()[i].afficheABR(t.getTab()[i].getAbr());
        }
    }

    /*
     * Definit la longueur du TABR
     */
    private static void definirNbCases(BufferedReader br) throws IOException {
        int nb = 0;
        while (br.readLine() != null){
            nb++;
        }
        t = new TABR(nb);
    }

    /*
     * Écrit un TABR dans un fichier
     */
    private static void tabABRversFichier() {
        BufferedWriter bw = null;
        System.out.println("Comment appeler le fichier ?");
        String file = input.next();

        try {
            bw = new BufferedWriter(new FileWriter(file));
            writeFile(bw);
            bw.close();
        } catch(IOException e){
            System.out.println("ERREUR : "+file+" existe déjà.");
            e.printStackTrace();
        }

    }

    /*
     * Pour chaque case du tableau écrit une ligne dans le fichier sous la forme debut:fin;noeud1:noeud2
     */
    private static void writeFile(BufferedWriter bw) throws IOException {
        if(t != null){
            ABR abr;
            Case[] tab = t.getTab();
            for (int i = 0; i < tab.length; i++){
                if(tab[i] != null) {
                    System.out.println("Écriture en cours ...");
                    abr = tab[i].getAbr();
                    bw.write(tab[i].getDebut() + ":" + tab[i].getFin() + ";");
                    tab[i].write(abr, bw);
                    bw.newLine();
                }
            }
        } else {
            System.out.println("Aucun TABR n'existe");
        }
    }
}
