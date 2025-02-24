package metier;

import dao.DaoImpl;
import dao.IDao;

public class MetierImpl implements IMetier {
    //Couplage faible
    private IDao dao;

    public MetierImpl() {
    }

    public MetierImpl(IDao dao) {
        this.dao = dao;
    }

    @Override
    public double calcul() {
        double t = dao.getData();
        double res = t * 23;
        return res;
    }

    /**
     *Pour injecter dans la variable dao un objet d'une classe qui
     * implemente IDao
     * un setter qui permet l'injection des dependances
     */
    public void setDao(IDao dao) {
        this.dao = dao;
    }
}
