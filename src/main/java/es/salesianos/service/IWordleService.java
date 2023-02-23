package es.salesianos.service;

import es.salesianos.model.Palabra;
import es.salesianos.model.Wordle;

public interface IWordleService {
    //Funcion principal del juego
    public void wordle(String palabra);
    public Wordle getWordle();
    //Funciones usadas en la principal
    public void check(Palabra palabra, String[] palabras);
    public Palabra getPalabraAAdivinar(String palabra);
}
