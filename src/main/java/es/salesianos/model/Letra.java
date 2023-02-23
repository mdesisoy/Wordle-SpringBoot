package es.salesianos.model;

//clase letra
public class Letra {
    private char letra;
    private int posicion_letra;
    private String color_letra;

    //generar getters y setters
    public char getLetra() {
        return letra;
    }

    public void setLetra(char letra) {
        this.letra = letra;
    }

    public int getPosicion_letra() {
        return posicion_letra;
    }

    public void setPosicion_letra(int posicion_letra) {
        this.posicion_letra = posicion_letra;
    }

    public String getColor_letra() {
        return color_letra;
    }

    public void setColor_letra(String color_letra) {
        this.color_letra = color_letra;
    }

    //constructor
    public Letra(char letra, int posicion_letra, String color_letra) {
        this.letra = letra;
        this.posicion_letra = posicion_letra;
        this.color_letra = color_letra;
    }

    public Letra() {
    }

}
