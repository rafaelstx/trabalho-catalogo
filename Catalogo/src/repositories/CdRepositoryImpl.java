package repositories;

import models.Cd;

public class CdRepositoryImpl implements CdRepository {

    Cd cd = new Cd();

    @Override
    public void createCd(Cd cd) {
       this.cd = cd;
    }

    @Override
    public void showCd() {
        System.out.println(cd.toString());
    }
    
}
