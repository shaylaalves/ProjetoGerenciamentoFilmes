package models;

public class FilmeInternacional extends Filme {
    private String pais;
    private String idioma;

    public FilmeInternacional(String titulo, String diretor, int ano, String pais, String idioma) {
        super(titulo, diretor, ano);
        this.pais = pais;
        this.idioma = idioma;
    }

    public String getPais() { return pais; }
    public void setPais(String pais) { this.pais = pais; }

    public String getIdioma() { return idioma; }
    public void setIdioma(String idioma) { this.idioma = idioma; }

    @Override
    public String getInfo() {
        return super.getInfo() + " - País: " + pais + " - Idioma: " + idioma;
    }
}