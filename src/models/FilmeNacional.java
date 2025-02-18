package models;

public class FilmeNacional extends Filme {
    private String estado;

    public FilmeNacional(String titulo, String diretor, int ano, String estado) {
        super(titulo, diretor, ano);
        this.estado = estado;
    }

    public String getEstado() { return estado; }
    public void setEstado(String estado) { this.estado = estado; }

    @Override
    public String getInfo() {
        return super.getInfo() + " - Produzido no estado: " + estado;
    }
}