package org.acme.config;

import io.quarkus.arc.config.ConfigProperties;

import java.util.List;

@ConfigProperties(prefix = "example")
public class PropertiesExample {
    private String salut;
    private MyTestValues container;

    public String getSalut() {
        return salut;
    }

    public void setSalut(String salut) {
        this.salut = salut;
    }

    public MyTestValues getContainer() {
        return container;
    }

    public void setContainer(MyTestValues container) {
        this.container = container;
    }

    public static class MyTestValues {
        private int id;
        private List<String> roles;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public List<String> getRoles() {
            return roles;
        }

        public void setRoles(List<String> roles) {
            this.roles = roles;
        }
    }
}
