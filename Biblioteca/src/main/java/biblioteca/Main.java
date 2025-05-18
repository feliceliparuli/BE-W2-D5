package biblioteca;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Archivio archivio = new Archivio();
        Scanner scanner = new Scanner(System.in);

        Libro libro = new Libro("123", "Java Basics", 2020, 300, "Rossi", "Informatica");
        Rivista rivista = new Rivista("456", "Tech Weekly", 2021, 50, Rivista.Periodicita.SETTIMANALE);
        archivio.aggiungiElemento(libro);
        archivio.aggiungiElemento(rivista);

        archivio.stampaTutto();
        archivio.statistiche();
    }
}