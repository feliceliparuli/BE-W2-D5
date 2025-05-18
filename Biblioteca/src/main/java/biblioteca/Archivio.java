package biblioteca;

import java.util.*;
import java.util.stream.Collectors;

public class Archivio {
    private Map<String, ElementoCatalogo> elementi = new HashMap<>();

    public void aggiungiElemento(ElementoCatalogo e) {
        if (elementi.containsKey(e.getIsbn())) {
            System.out.println("Elemento con ISBN già esistente.");
        } else {
            elementi.put(e.getIsbn(), e);
        }
    }

    public ElementoCatalogo cercaPerIsbn(String isbn) throws ElementoNonTrovatoException {
        if (!elementi.containsKey(isbn)) throw new ElementoNonTrovatoException("Elemento non trovato.");
        return elementi.get(isbn);
    }

    public void rimuoviPerIsbn(String isbn) {
        elementi.remove(isbn);
    }

    public List<ElementoCatalogo> cercaPerAnno(int anno) {
        return elementi.values().stream().filter(e -> e.getAnnoPubblicazione() == anno).toList();
    }

    public List<Libro> cercaPerAutore(String autore) {
        return elementi.values().stream()
                .filter(e -> e instanceof Libro)
                .map(e -> (Libro) e)
                .filter(l -> l.getAutore().equalsIgnoreCase(autore))
                .toList();
    }

    public void aggiornaElemento(String isbn, ElementoCatalogo nuovo) {
        elementi.put(isbn, nuovo);
    }

    public void statistiche() {
        long nLibri = elementi.values().stream().filter(e -> e instanceof Libro).count();
        long nRiviste = elementi.values().stream().filter(e -> e instanceof Rivista).count();
        Optional<ElementoCatalogo> maxPagine = elementi.values().stream()
                .max(Comparator.comparing(ElementoCatalogo::getNumeroPagine));
        double mediaPagine = elementi.values().stream()
                .mapToInt(ElementoCatalogo::getNumeroPagine).average().orElse(0);

        System.out.println("Libri: " + nLibri);
        System.out.println("Riviste: " + nRiviste);
        System.out.println("Max pagine: " + maxPagine.orElse(null));
        System.out.println("Media pagine: " + mediaPagine);
    }

    public void stampaTutto() {
        elementi.values().forEach(System.out::println);
    }
}