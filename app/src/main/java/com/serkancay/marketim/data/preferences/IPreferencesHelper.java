package com.serkancay.marketim.data.preferences;

/**
 * Created by S.Serkan Cay on 21.09.2019
 */

public interface IPreferencesHelper {

    void setUsername(String username);

    String getUsername();

    void setPassword(String password);

    String getPassword();

    void setRememberMe(boolean isRememberMeOn);

    boolean isRememberMeOn();

}
