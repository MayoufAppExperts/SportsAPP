package yalantis.com.sidemenu.sample.realm;

import java.util.List;

import io.realm.RealmObject;

public class FootballModelRealm extends RealmObject {

    private List<CountryRealm> countrys = null;

    public List<CountryRealm> getCountrys() {
        return countrys;
    }

    public void setCountrys(List<CountryRealm> countrys) {
        this.countrys = countrys;
    }

}
