package es.salesianos.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import es.salesianos.model.Palabra;
import es.salesianos.model.Wordle;

@Profile("dificil")
@Repository
public class NivelDificil implements IRepository {
   //el nivel facil tiene 8 letras 
   static String[] palabra = {"E","L","E","F","A","N","T","E"};
   static List<Palabra> lista_palabras = new ArrayList<Palabra>();
   //el nivel facil tiene 6 intentos
   static int intentos = 6;
   
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
