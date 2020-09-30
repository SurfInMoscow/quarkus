package org.acme.lifecycle;

import io.quarkus.runtime.Quarkus;
import io.quarkus.runtime.QuarkusApplication;
import io.quarkus.runtime.annotations.QuarkusMain;

//На версии 1.8.1.Final не работает, есть открытый issue
// https://github.com/quarkusio/quarkus/issues/10147
@QuarkusMain
public class Main {
    public static void main(String[] args) {
        System.out.println("Running Main method.");
        Quarkus.run(args);
        //Quarkus.run(MyApp.class, args);
    }

    /*public static class MyApp implements QuarkusApplication {

        @Override
        public int run(String... args) {
            System.out.println("I'm doing logic here on startup.");
            Quarkus.waitForExit();

            return 0;
        }

    }*/
}
