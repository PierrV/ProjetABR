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
        for (int i = 0; i < tab.length; i++) {
            System.out.println("Case " + i);
            System.out.println("Debut " + tab[i].getDebut());
            System.out.println("Fin " + tab[i].getFin());
            afficheABR(tab[i].getAbr());
        }
    }

    private void afficheABR(ABR abr) {
        System.out.println("Noeud courant : "+abr.getValeur());
        System.out.println("Fils gauche : " + abr.getSag() );
        if(abr.getSag() != null){
            afficheABR(abr.getSag());
        }
        System.out.println("Fils droit : " +abr.getSad());
        if(abr.getSad() != null){
            afficheABR(abr.getSad());
        }

    }
}
