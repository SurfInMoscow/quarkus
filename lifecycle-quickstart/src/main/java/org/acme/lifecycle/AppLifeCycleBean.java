package org.acme.lifecycle;

import io.quarkus.runtime.ShutdownEvent;
import io.quarkus.runtime.StartupEvent;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Observes;

//When startup or shutting down events are fired up some logic can be handled
@ApplicationScoped
public class AppLifeCycleBean {
    public void onStart(@Observes StartupEvent startupEvent) {
        System.out.println("I'm started!");
    }

    public void onStop(@Observes ShutdownEvent shutdownEvent) {
        System.out.println("I'm shutting down!");
    }
}
