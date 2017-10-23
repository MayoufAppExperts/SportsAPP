package yalantis.com.sidemenu.sample.network.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class FootballModel {

    @SerializedName("countrys")
    @Expose
    private List<Country> countrys = null;

    public List<Country> getCountrys() {
        return countrys;
    }

    public void setCountrys(List<Country> countrys) {
        this.countrys = countrys;
    }

}