/**
 * Created by daniel on 6/9/17.
 */
public class Adlister {

    private String AdlisterUsers;
    private String AdlisterAds;

    public Adlister(String adlisterUser, String adlisterAd) {
        this.AdlisterAds = adlisterAd;
        this.AdlisterUsers = adlisterUser;
    }

    public String getAdlisterUsers() {
        return null;
    }

    public void setAdlisterUsers(String adlisterUsers) {
        AdlisterUsers = adlisterUsers;
    }

    public String getAdlisterAds() {
        return AdlisterAds;
    }

    public void setAdlisterAds(String adlisterAds) {
        AdlisterAds = adlisterAds;
    }

}
