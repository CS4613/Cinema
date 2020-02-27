package io.realm;


public interface ReviewRealmProxyInterface {
    public Integer realmGet$id();
    public void realmSet$id(Integer value);
    public Integer realmGet$page();
    public void realmSet$page(Integer value);
    public RealmList<org.snowcorp.app.model.ReviewResult> realmGet$ReviewResults();
    public void realmSet$ReviewResults(RealmList<org.snowcorp.app.model.ReviewResult> value);
    public Integer realmGet$totalPages();
    public void realmSet$totalPages(Integer value);
    public Integer realmGet$totalResults();
    public void realmSet$totalResults(Integer value);
    public int realmGet$movieID();
    public void realmSet$movieID(int value);
}
