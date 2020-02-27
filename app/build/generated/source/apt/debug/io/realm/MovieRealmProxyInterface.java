package io.realm;


public interface MovieRealmProxyInterface {
    public int realmGet$ID();
    public void realmSet$ID(int value);
    public Integer realmGet$page();
    public void realmSet$page(Integer value);
    public Integer realmGet$totalResults();
    public void realmSet$totalResults(Integer value);
    public Integer realmGet$totalPages();
    public void realmSet$totalPages(Integer value);
    public RealmList<org.snowcorp.app.model.MovieResult> realmGet$results();
    public void realmSet$results(RealmList<org.snowcorp.app.model.MovieResult> value);
}
