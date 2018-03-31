/**
 * Created by valenza-manjaro on 15/03/18.
 */
public class Case {
    private int debut;
    private int fin;
    private ABR abr;

    public Case(int debut, int fin, ABR abr){
        this.debut = debut;
        this.fin = fin;
        this.abr = abr;
    }

    public int getDebut() {
        return debut;
    }

    public void setDebut(int debut) {
        this.debut = debut;
    }

    public int getFin() {
        return fin;
    }

    public void setFin(int fin) {
        this.fin = fin;
    }

    public ABR getAbr() {
        return abr;
    }

    public void setAbr(ABR abr) {
        this.abr = abr;
    }

    public void afficheABR(ABR abr){
        System.out.print(" Le noeud " + abr.getValeur());
        if (abr.getSag() != null) {
            System.out.print(" a pour fils gauche : " + abr.getSag().getValeur());
        }
        if (abr.getSad() != null) {
            System.out.print(" a pour fils droit : " + abr.getSad().getValeur());
        }
        System.out.println();
        int noeud = abr.getValeur();
        if(abr.getSag() != null){
            afficheABR(abr.getSag());
        }
        if(abr.getSad() != null){
            afficheABR(abr.getSad());
        }
    }

    public void affiche(ABR abr){
        System.out.print(abr.getValeur());
        if(abr.getSag() != null){
            System.out.print(":");
            affiche(abr.getSag());
        }
        if(abr.getSad() != null){
            System.out.print(":");
            affiche(abr.getSad());
        }
    }

}
