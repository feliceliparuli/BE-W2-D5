package biblioteca;

public abstract class ElementoCatalogo {
    private String isbn;
    private String titolo;
    private int annoPubblicazione;
    private int numeroPagine;

    public ElementoCatalogo(String isbn, String titolo, int annoPubblicazione, int numeroPagine) {
        this.isbn = isbn;
        this.titolo = titolo;
        this.annoPubblicazione = annoPubblicazione;
        this.numeroPagine = numeroPagine;
    }

    public String getIsbn() { return isbn; }
    public String getTitolo() { return titolo; }
    public int getAnnoPubblicazione() { return annoPubblicazione; }
    public int getNumeroPagine() { return numeroPagine; }

    public void setTitolo(String titolo) { this.titolo = titolo; }
    public void setAnnoPubblicazione(int anno) { this.annoPubblicazione = anno; }
    public void setNumeroPagine(int pagine) { this.numeroPagine = pagine; }

    @Override
    public String toString() {
        return isbn + " - " + titolo + " (" + annoPubblicazione + ", " + numeroPagine + " pagine)";
    }
}