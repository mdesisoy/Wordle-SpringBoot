package es.salesianos.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import es.salesianos.model.Palabra;
import es.salesianos.model.Wordle;

@Profile("medio")
@Repository
public class NivelMedio implements IRepository{
    //el nivel medio tiene 5 letras 
    static String[] palabra = {"R","A","T","O","N"};
    static List<Palabra> lista_palabras = new ArrayList<Palabra>();
    //el nivel facil tiene 10 intentos
    static int intentos = 10;
    
    //creamos el objeto wordle
    private static Wordle wordle = new Wordle(intentos, palabra, lista_palabras);

    @Override
    public Wordle getWordle() {
        return wordle;
    }

    @Override
    public void reset(){
        wordle = new Wordle(0, null, null);
    }
}