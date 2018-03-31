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

    public void insertion(int x ){
        ABR noeud = this;
        boolean trouver = false;
        while ( ( x < noeud.getValeur() || x > noeud.getValeur()  ) && !trouver ) {
            System.out.println("Noeud : " + noeud.getValeur());
            if (x < noeud.getValeur()) {
                if(noeud.getSag() == null) {
                    noeud.setSag(new ABR(x, null, null));
                    trouver = true;
                } else {
                    noeud = noeud.getSag();
                }
            } else if (x > noeud.getValeur()) {
                System.out.println("A droite ? : " + noeud.getValeur());

                if(noeud.getSad() == null) {
                    System.out.println("Oui : " + noeud.getValeur());
                    noeud.setSad(new ABR(x, null, null));
                    trouver = true;
                } else {
                    noeud = noeud.getSad();
                }
            }
        }
    }

    public void supprimer(int x, ABR noeud){
        if (x < noeud.getValeur()) {
            if(noeud.getSag() != null) {
                supprimer(x, noeud.getSag());
            }
        } else if (x > noeud.getValeur()) {
            if(noeud.getSad() != null) {
                supprimer(x, noeud.getSad());
            }
        } else if (x == noeud.getValeur()) {
            System.out.println("on a trouver ");
            remonter(noeud);
        } else {
            System.out.println("Le noeud " + x + " n'a pas était trouver dans l'arbre correspondant à l'intervalle");
        }
    }

    private void remonter(ABR noeud) {
            if (noeud.getSad() == null) {
                if(noeud.getSag() != null) {
                    noeud.setValeur(noeud.getSag().getValeur());
              //      noeud.setSag(noeud.getSag().getSag());
              //      noeud.setSad(noeud.getSag().getSad());
                    if(noeud.getSag().getSag() != null) {
                        noeud.setSag(noeud.getSag().getSag());
                    } else {
                        noeud.setSag(null);
                    }
                    if(noeud.getSag().getSad() != null) {
                        noeud.setSad(noeud.getSag().getSad());
                    }
                    System.out.println("on remonte gauche " + noeud.getValeur());
                } else {
                    noeud = null;
                }
            } else {
                System.out.println("on remonte droite");
                noeud = noeud.getSad();
            }
    }

    public void affiche(){
        System.out.print(this.getValeur());
        if(this.getSag() != null){
            System.out.print(":");
            this.getSag().affiche();
        }
        if(this.getSad() != null){
            System.out.print(":");
            this.getSad().affiche();
        }
    }
}
