package oop2.tp3.ejercicio4;

import org.jdbi.v3.core.Jdbi;


public class Main {

    public static void main(String[] args) {

        Jdbi jdbi = Jdbi.create("jdbc:hsqldb:mem;create=true");

        new SetUpDatabase(jdbi).setUp();

        var repo = new PersonaRepository(jdbi);
        try {
            var personas = repo.buscarPorNombre("Vla");
            for (Persona persona : personas) {
                System.out.println(persona.nombre() + " " + persona.apellido());
            }

            var persona = repo.buscarId(40L);
            System.out.println(persona.nombre() + " " + persona.apellido());
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }

    }
}
