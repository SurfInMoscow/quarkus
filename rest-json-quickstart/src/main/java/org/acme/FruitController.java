package org.acme;

import io.vertx.core.impl.ConcurrentHashSet;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.io.FileNotFoundException;
import java.util.Set;

@Path("/fruits")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class FruitController {

    private static Set<Fruit> fruits = new ConcurrentHashSet<>();

    static {
        fruits.add(new Fruit("Apple", "Antonovka"));
        fruits.add(new Fruit("Plum", "Ripe plums"));
    }

    @GET
    public Set<Fruit> list() throws FileNotFoundException {
        return fruits;
    }

    @POST
    public Set<Fruit> add(Fruit fruit) {
        fruits.add(fruit);
        return fruits;
    }

    @DELETE
    public Set<Fruit> delete(Fruit fruit) {
        fruits.removeIf(exfr -> exfr.getName().contentEquals(fruit.getName()));

        return fruits;
    }
}
