package metier;

import dao.IDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("metier")
public class MetierImpl implements IMetier{

    //@Autowired  --> not recommended
    /*
    ** Avec la programmation dynamique, spring peut acceder au variable qui est normalement private et le modifier
    * alors c'est comme une vilation du principe d'encapsulation.
     */
    private IDao dao;

    //injection avec consructeur
    //neccessite avoir un seul constructeur
    public MetierImpl(@Qualifier("dao") IDao dao) {
        this.dao = dao;
    }
// il ne faut pas avoir un constructeur sans parametres avec injection par constructeur
//    public MetierImpl() {
//    }

    @Override
    public double calcul() {
        double t = dao.getData();
        double res = t * 23;
        return res;
    }

    public void setDao(IDao dao) {
        this.dao = dao;
    }
}
