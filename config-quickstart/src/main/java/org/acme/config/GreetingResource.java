package org.acme.config;

import org.eclipse.microprofile.config.ConfigProvider;
import org.eclipse.microprofile.config.inject.ConfigProperty;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.Optional;

@Path("/greeting")
public class GreetingResource {

    @ConfigProperty(name = "greeting.message")
    String message;

    @ConfigProperty(name = "greeting.suffix", defaultValue="!")
    String suffix;

    @ConfigProperty(name = "greeting.name")
    Optional<String> name;

    @Inject
    PropertiesExample propertiesExample;

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        System.out.println(programmaticallyExtract().orElse("Can't find."));
        System.out.println(propertiesExample.getSalut());
        System.out.println(propertiesExample.getContainer().getId());
        propertiesExample.getContainer().getRoles().forEach(System.out::println);
        return message + " " + name.orElse("world") + suffix;
    }

    private Optional<String> programmaticallyExtract() {
        return ConfigProvider.getConfig().getOptionalValue("database.name", String.class);
    }
}