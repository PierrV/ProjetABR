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

    /*
     * Parcours les noeuds de l'ABR pour inséré la valeur.
     *
     */
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

    /*
     * Permet de supprimer un noeud x
     */
    public void supprimer(int x, ABR noeud){
       if (noeud == null){
            System.out.println("Le noeud " + x + " n'a pas était trouver dans l'arbre correspondant à l'intervalle");
        } else {
           System.out.println(noeud.getValeur());
            if(noeud.getValeur() == x) {
                if (noeud.getSad() == null) {
                    if (noeud.getSag() != null) {
                        ABR fils = noeud.getSag();
                        noeud.setValeur(fils.getValeur());
                        noeud.setSad(fils.getSad());
                        noeud.setSag(fils.getSag());
                    } else {
                        if (noeud.getSag() == null) {
                            System.out.println("nulllll");
                        }
                        noeud = null;
                    }
                } else {
                    ABR fils = noeud.getSad();
                    noeud.setValeur(fils.getValeur());
                    noeud.setSad(fils.getSad());
                    while (fils.getSag() != null) {
                        fils = fils.getSag();
                    }
                    noeud.setSag(fils);
                }
            }
            else if (noeud.getValeur() > x){
                supprimer(x, noeud.getSag());
            }
            else if (noeud.getValeur() < x){
                supprimer(x, noeud.getSad());
            }
        }
    }
}
