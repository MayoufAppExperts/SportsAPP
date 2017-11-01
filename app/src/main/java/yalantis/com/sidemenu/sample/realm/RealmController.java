package yalantis.com.sidemenu.sample.realm;//package yalantis.com.sidemenu.sample.realm;
//
//import java.util.ArrayList;
//
//import io.realm.Realm;
//import io.realm.RealmResults;
//
///**
// * Created by TheAppExperts on 31/10/2017.
// */
//
//public class RealmController {
//
//    Realm realm;
//
//    public RealmController(Realm realm) {
//        this.realm = realm;
//    }
//
//    public void saveLeagues (final FootballModelRealm footballModelRealm){
//        realm.executeTransaction(new Realm.Transaction() {
//            @Override
//            public void execute(Realm realm) {
//                realm.copyToRealm(footballModelRealm);
//            }
//        });
//    }
//
//    public ArrayList<FootballModelRealm> getLeaguesList(){
//        ArrayList<FootballModelRealm> footballModelRealmArrayList = new ArrayList<>();
//        RealmResults <FootballModelRealm> realmResults = realm.where(FootballModelRealm.class).findAll();
//
//        for (FootballModelRealm footballModelRealm:realmResults){
//            footballModelRealmArrayList.add(footballModelRealm);
//        }
//
//        return footballModelRealmArrayList;
//    }
//
//
//}
