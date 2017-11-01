package yalantis.com.sidemenu.sample.realm;

import io.realm.RealmList;
import io.realm.RealmObject;

public class FootballModelRealm extends RealmObject {

    private RealmList<CountryRealm> countrys = null;

    public RealmList<CountryRealm> getCountrys() {
        return countrys;
    }

    public void setCountrys(RealmList<CountryRealm> countrys) {
        this.countrys = countrys;
    }

}
