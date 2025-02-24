package metier;

import dao.IDao;

public class MetierImpl implements IMetier {
    //Couplage faible
    private IDao dao;

    @Override
    public double calcul() {
        double t = dao.getData();
        double res = t * 23;
        return res;
    }
}
