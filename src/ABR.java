/**
 * Created by valenza-manjaro on 22/03/18.
 */
public class ABR {
    private int valeur;
    private ABR sag;
    private ABR sad;

    public ABR(int valeur, ABR sag, ABR sad){
        this.valeur = valeur;
        this.sag = sag;
        this.sad = sad;
    }

    public int getValeur() {
        return valeur;
    }

    public void setValeur(int valeur) {
        this.valeur = valeur;
    }

    public ABR getSag() {
        return sag;
    }

    public void setSag(ABR sag) {
        this.sag = sag;
    }

    public ABR getSad() {
        return sad;
    }

    public void setSad(ABR sad) {
        this.sad = sad;
    }
}
