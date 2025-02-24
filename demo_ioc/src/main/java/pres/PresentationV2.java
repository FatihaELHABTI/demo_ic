package pres;

import dao.IDao;
import metier.IMetier;

import javax.imageio.metadata.IIOMetadata;
import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.Method;
import java.util.Scanner;

public class PresentationV2 {
    public static void main(String[] args)  {
        // Instantiation dynamique en utilisant config.txt
        try {
            Scanner sc = new Scanner(new File("config.txt"));


            String daoClassname = sc.nextLine();
            Class cDao = Class.forName(daoClassname);
            //cDao.newInstance();
            IDao dao = (IDao) cDao.getConstructor().newInstance();


            String metierClassname = sc.nextLine();
            Class cMetier = Class.forName(metierClassname);
            //constructeur avec parametres
            //IMetier metier = (IMetier) cMetier.getConstructor(IDao.class).newInstance(dao);

            //en utilisant setter
            //constructeur sans parametres
            IMetier metier = (IMetier) cMetier.getConstructor().newInstance();
            Method setDao = cMetier.getDeclaredMethod("setDao", IDao.class);
            setDao.invoke(metier, dao);

            System.out.println(metier.calcul());
        }catch (Exception e) {
            System.out.println(e.getMessage());
        }


    }
}
