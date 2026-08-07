package com.github.zipcodewilmington.casino;

import java.util.HashMap;
import java.util.Map;

/**
 * Creates and looks up human CasinoAccounts across the app's lifetime.
 */
public class CasinoAccountManager {
    private Map<String, CasinoAccount> accounts = new HashMap<>();

    public CasinoAccount createAccount(String name) {
       CasinoAccount account = new CasinoAccount(name, 0.0);
       accounts.put(name, account);
        return account;
    }

    public CasinoAccount getAccount(String name) {
        return  accounts.get(name);
    }
}
