package yalantis.com.sidemenu.sample.realm;

public class CountryRealm {

    private String idLeague;
    private String idSoccerXML;
    private String strLeague;
    private String strBadge;
    private String strLogo;

    public CountryRealm(String idLeague, String idSoccerXML, String strLeague, String strBadge, String strLogo) {
        this.idLeague = idLeague;
        this.idSoccerXML = idSoccerXML;
        this.strLeague = strLeague;
        this.strBadge = strBadge;
        this.strLogo = strLogo;
    }

    public String getIdLeague() {
        return idLeague;
    }

    public void setIdLeague(String idLeague) {
        this.idLeague = idLeague;
    }

    public String getIdSoccerXML() {
        return idSoccerXML;
    }

    public void setIdSoccerXML(String idSoccerXML) {
        this.idSoccerXML = idSoccerXML;
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

    public String getStrLogo() {
        return strLogo;
    }

    public void setStrLogo(String strLogo) {
        this.strLogo = strLogo;
    }
}
