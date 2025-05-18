package biblioteca;

public class Rivista extends ElementoCatalogo {
    public enum Periodicita { SETTIMANALE, MENSILE, SEMESTRALE }
    private Periodicita periodicita;

    public Rivista(String isbn, String titolo, int anno, int pagine, Periodicita periodicita) {
        super(isbn, titolo, anno, pagine);
        this.periodicita = periodicita;
    }

    public Periodicita getPeriodicita() { return periodicita; }

    @Override
    public String toString() {
        return super.toString() + " - Rivista [" + periodicita + "]";
    }
}