package com.github.zipcodewilmington;

import com.github.zipcodewilmington.casino.Casino;

public class MainApplication {

    public static void main(String[] args) {

        Casino casino = new Casino();
        casino.start();

    }
}
