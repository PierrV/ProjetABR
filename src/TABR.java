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

    public void verification(){
        boolean ordre = true;
        ABR abr;
        for (int i = 0; i < tab.length - 1; i++) {
            if(tab[i].getDebut() < tab[i].getFin()){
                if (tab[i].getFin() < tab[i + 1].getFin()){
                    verification_noeud(tab[i].getAbr(), tab[i].getDebut(), tab[i].getFin());
                } else {
                    ordre = false;
                }
            } else {
                ordre = false;
            }
        }
    }

    private boolean verification_noeud(ABR abr, int debut, int fin) {
            boolean b = false;
            if( ( abr.getValeur() > debut ) && ( abr.getValeur() < fin )){
                b = true;
                if (abr.getSag() != null) {
                    verification_noeud(abr.getSag(), debut, fin);
                }
                if (abr.getSad() != null) {
                    verification_noeud(abr.getSad(), debut, fin);
                }
            }
            return b;
    }

    public int intervalle(int x){
        int i = -1;
        while (i < getTab().length - 1){
            i++;
            if ( ( getTab()[i].getDebut() < x ) && ( getTab()[i].getFin() > x) ){
                return i;
            }
        }
        return -1;
    }

    public void affichage(){
        ABR abr;
        for (int i = 0; i < tab.length; i++){
            abr = tab[i].getAbr();
            System.out.print(tab[i].getDebut()+":"+tab[i].getFin()+";");
            tab[i].affiche(abr);
            System.out.println();

        }
    }
}
