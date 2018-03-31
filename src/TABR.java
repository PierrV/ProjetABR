/**
 * Created by valenza-manjaro on 22/03/18.
 */
public class TABR {
    private Case[] tab;

    public TABR(int n){
        tab = new Case[n];
    }


    public Case[] getTab() {
        return tab;
    }

    public void setTab(Case[] tab) {
        this.tab = tab;
    }

    public void affiche() {
        for (int i = 0 ; i < tab.length; i++) {
            System.out.println("Case : " + i);
            System.out.println("Debut : " + tab[i].getDebut());
            System.out.println("Fin : " + tab[i].getFin());
            tab[i].afficheABR(tab[i].getAbr());
        }

    }

    public boolean verification(){
        boolean ordre = true;
        ABR abr;
        for (int i = 0; i < tab.length - 1; i++) {
            if(tab[i].getDebut() < tab[i].getFin()){
                if (tab[i].getFin() < tab[i + 1].getFin()){
                    if(!verification_noeud(tab[i].getAbr(), tab[i].getDebut(), tab[i].getFin())){
                        return false;
                    }
                } else {
                    ordre = false;
                }
            } else {
                ordre = false;
            }
        }
        return ordre;
    }

    private boolean verification_noeud(ABR abr, int debut, int fin) {
            boolean b = false;
            if( ( abr.getValeur() < debut ) || ( abr.getValeur() > fin )) {
                System.out.println("Le noeud : " + abr.getValeur() + " sort de l'intervalle ["+debut+";"+fin+"]");
                return false;
            } else
                if (abr.getSag() != null) {
                   return verification_noeud(abr.getSag(), debut, fin);
                }
                if (abr.getSad() != null) {
                   return verification_noeud(abr.getSad(), debut, fin);
                }

            return true;
    }

    public int intervalle(int x){
        int i = -1;
        while (i < getTab().length - 1){
            i++;
            if ( ( getTab()[i].getDebut() <= x ) && ( getTab()[i].getFin() >= x) ){
                return i;
            }
        }
        return -1;
    }

    public void affichage(){
        ABR abr;
        for (int i = 0; i < tab.length; i++){
            if(tab[i] != null) {
                abr = tab[i].getAbr();
                System.out.print(tab[i].getDebut() + ":" + tab[i].getFin() + ";");
                tab[i].affiche(abr);
                System.out.println();
            }
        }
    }

    public void fusion2cases(int i) {
        if( ( i < tab.length - 1 ) && (tab[i+1] != null)){
            tab[i].setFin(tab[i+1].getFin());
            ABR abr = tab[i].getAbr();
            while (abr.getSad() != null){
                abr = abr.getSad();
            }
            abr.setSad(tab[i+1].getAbr());
            for (int j = i + 1; j < tab.length - 1; j++){
                tab[j] = tab[j+1];
            }
            tab[tab.length - 1] = null;
        }
    }

    public ABR fusionTABR(){
        int i = 0;
        ABR abr = tab[i].getAbr();
        ABR racine = abr;
        while (i < tab.length-1 && tab[i] != null){
            while (abr.getSad() != null){
                abr = abr.getSad();
            }
            abr.setSad(tab[i+1].getAbr());
            i++;
            System.out.println(abr.getSad().getValeur() + " attacher a " + abr.getValeur());
        }
        return racine;
    }
}
