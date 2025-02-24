package pres;

import dao.DaoImpl;
import metier.MetierImpl;

public class PresentationV1 {
    public static void main(String[] args) {
        /*
        * Injection des dependances par instanciation statique
         */
        DaoImpl d = new DaoImpl();

        //l'autre solution est de faire l'injection en utilisant constructeur
        MetierImpl metier = new MetierImpl(d);
        //metier.setDao(d); // on utilise setter
        System.out.println("Res : " +metier.calcul());
    }
}
