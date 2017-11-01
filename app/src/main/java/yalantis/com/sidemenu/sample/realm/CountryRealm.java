package yalantis.com.sidemenu.sample.realm;

import io.realm.RealmObject;

public class CountryRealm extends RealmObject{

    private String idLeague;
    private String strLeague;
    private String strBadge;

    public CountryRealm() {
    }

    public CountryRealm(String idLeague, String strLeague, String strBadge) {
        this.idLeague = idLeague;
        this.strLeague = strLeague;
        this.strBadge = strBadge;
    }

    public String getIdLeague() {
        return idLeague;
    }

    public void setIdLeague(String idLeague) {
        this.idLeague = idLeague;
    }


    public String getStrLeague() {
        return strLeague;
    }

    public void setStrLeague(String strLeague) {
        this.strLeague = strLeague;
    }

    public String getStrBadge() {
        return strBadge;
    }

    public void setStrBadge(String strBadge) {
        this.strBadge = strBadge;
    }

}
