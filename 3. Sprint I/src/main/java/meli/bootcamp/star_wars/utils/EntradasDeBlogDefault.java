package meli.bootcamp.star_wars.utils;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import meli.bootcamp.star_wars.domain.EntradaBlog;
import org.springframework.stereotype.Component;

@Component
public class EntradasDeBlogDefault {
  public List<EntradaBlog> entradas = new ArrayList<>();

  public EntradasDeBlogDefault() {
    EntradaBlog entrada1 = new EntradaBlog(
        1L,
        "A long time ago in a galaxy far, far away...",
        "George Lucas",
        LocalDateTime.now()
    );

    EntradaBlog entrada2 = new EntradaBlog(
        2L,
        "The Empire Strikes Back",
        "George Lucas",
        LocalDateTime.now()
    );

    EntradaBlog entrada3 = new EntradaBlog(
        3L,
        "Return of the Jedi",
        "George Lucas",
        LocalDateTime.now()
    );

    EntradaBlog entrada4 = new EntradaBlog(
        4L,
        "The Phantom Menace",
        "George Lucas",
        LocalDateTime.now()
    );

    EntradaBlog entrada5 = new EntradaBlog(
        5L,
        "Attack of the Clones",
        "George Lucas",
        LocalDateTime.now()
    );

    EntradaBlog entrada6 = new EntradaBlog(
        6L,
        "Revenge of the Sith",
        "George Lucas",
        LocalDateTime.now()
    );

    EntradaBlog entrada7 = new EntradaBlog(
        7L,
        "The Force Awakens",
        "J.J. Abrams",
        LocalDateTime.now()
    );

    EntradaBlog entrada8 = new EntradaBlog(
        8L,
        "The Last Jedi",
        "Rian Johnson",
        LocalDateTime.now()
    );

    EntradaBlog entrada9 = new EntradaBlog(
        9L,
        "The Rise of Skywalker",
        "J.J. Abrams",
        LocalDateTime.now()
    );

    entradas.add(entrada1);
    entradas.add(entrada2);
    entradas.add(entrada3);
    entradas.add(entrada4);
    entradas.add(entrada5);
    entradas.add(entrada6);
    entradas.add(entrada7);
    entradas.add(entrada8);
    entradas.add(entrada9);
  }


}
