package es.salesianos.model;

import java.util.ArrayList;
import java.util.List;

//clase palabra
public class Palabra {
    private List<Letra> lista_letras = new ArrayList<Letra>();

    //getters y setters
    public List<Letra> getLista_letras() {
        return lista_letras;
    }

    public void setLista_letras(List<Letra> lista_letras) {
        this.lista_letras = lista_letras;
    }

    //funciones de la clase
    public void addLetra(Letra letra) {
        lista_letras.add(letra);
    }

    public void removeLetra(Letra letra) {
        lista_letras.remove(letra);
    }

    public void clear(){
        lista_letras.clear();
    }

    public int size(){
        return lista_letras.size();
    }

}
