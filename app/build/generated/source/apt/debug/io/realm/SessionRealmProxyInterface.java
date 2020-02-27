package io.realm;


public interface SessionRealmProxyInterface {
    public Boolean realmGet$success();
    public void realmSet$success(Boolean value);
    public String realmGet$guestSessionId();
    public void realmSet$guestSessionId(String value);
    public String realmGet$expiresAt();
    public void realmSet$expiresAt(String value);
}
