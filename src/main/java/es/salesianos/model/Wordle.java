package es.salesianos.model;

import java.util.List;

//dividir clase Wordle del examen en letra , palabra y wordle
public class Wordle {
    private int intentos; 
    private String[] palabras;
    private List<Palabra> lista_palabras;
    private static int longitudPalabra;

    //generar getters y setters
    public int getIntentos() {
        return intentos;
    }
    public void setIntentos(int intentos) {
        this.intentos = intentos;
    }
    public String[] getPalabras() {
        return palabras;
    }
    public void setPalabras(String[] palabras) {
        this.palabras = palabras;
    }
    public List<Palabra> getLista_palabras() {
        return lista_palabras;
    }
    public void setLista_palabras(List<Palabra> lista_palabras) {
        this.lista_palabras = lista_palabras;
    }
    public int getLongitudPalabra() {
        return longitudPalabra;
    }

    //constructor
    public Wordle(int intentos, String[] palabras, List<Palabra> lista_palabras) {
        this.intentos = intentos;
        this.palabras = palabras;
        this.lista_palabras = lista_palabras;
        longitudPalabra = palabras.length;
    }

    //funciones de la clase
    public void addPalabra(Palabra palabra) {
        lista_palabras.add(palabra);
    }

    public void removePalabra(Palabra palabra) {
        lista_palabras.remove(palabra);
    }

    public void clear(){
        lista_palabras.clear();
    }
    public Palabra getPalabra_a_adivinar() {
        return null;
    }

}
