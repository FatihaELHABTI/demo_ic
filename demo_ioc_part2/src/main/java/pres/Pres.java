package pres;

import dao.DaoImpl;
import metier.MetierImpl;

import java.lang.reflect.Method;

public class Pres {
    public static void main(String[] args) {
        DaoImpl dao = new DaoImpl();
        //MetierImpl metier = new MetierImpl();
        //metier.setDao(dao);
        //System.out.println(metier.calcul());
    }
}
