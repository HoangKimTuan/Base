package com.tuanhk.data.cache;

public interface UserConfig {

    boolean hasCurrentUser();

    void saveConfigLogin(boolean autoLogin);
}
