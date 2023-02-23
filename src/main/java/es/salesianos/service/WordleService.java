package es.salesianos.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.salesianos.model.*;
import es.salesianos.repository.IRepository;

@Service
public class WordleService implements IWordleService{

    @Autowired
    IRepository repository;

    //Funcion principal
    @Override
    public void wordle(String palabra) {
        Wordle wordle = repository.getWordle();
        String[] checkPalabra = wordle.getPalabras();
        Palabra miPalabra = getPalabraAAdivinar(palabra);
        check(miPalabra, checkPalabra);
        wordle.addPalabra(miPalabra);
    }

    @Override
    public Wordle getWordle() {
        return repository.getWordle();
    }

    //primero necesitamos la funcion de la palabra a adivinar
    @Override
    public Palabra getPalabraAAdivinar(String palabra) {
        Palabra palabra_a_adivinar = new Palabra();
        char[] letras = palabra.toCharArray();
        for (int i = 0; i < letras.length; i++) {
            Letra letra = new Letra();
            letra.setLetra(Character.toUpperCase(letras[i]));
            letra.setPosicion_letra(-1);
            palabra_a_adivinar.getLista_letras().add(letra);
        }
        return palabra_a_adivinar;
    }

    //segundo checkeamos si la palabra es correcta letra a letra
    //si es correcta la letra se pone en verde, si está en la palabra pero no
    //en la posición correcta se pone en amarillo y si no está en la palabra se pone en rojo
    @Override
    public void check(Palabra miPalabra, String[] palabras){
        List<Letra> letras = miPalabra.getLista_letras();
        for (int i = 0; i < letras.size(); i++) {
            if (letras.get(i).getLetra() == palabras[i].charAt(0)) { //pasarlo a char
                letras.get(i).setColor_letra("bg-success"); //verde
                letras.get(i).setPosicion_letra(i);
            }
        }
        for (int i = 0; i < letras.size(); i++) {
            for (int j = 0; j < palabras.length; j++) {
                if (letras.get(i).getLetra() == palabras[j].charAt(0) && letras.get(j).getColor_letra() != "bg-success"
                        && letras.get(i).getColor_letra() != "bg-success") {
                            boolean seRepite = false;
                            for (int k = 0; k < letras.size(); k++) {
                                if (letras.get(k).getPosicion_letra() == j) {
                                    seRepite = true;
                                }
                            }
                            if (!seRepite) {
                                letras.get(i).setColor_letra("bg-warning"); //amarillo
                                letras.get(i).setPosicion_letra(j);
                            }
                }
            }
            if (letras.get(i).getColor_letra() == null) {
                letras.get(i).setColor_letra("bg-danger"); //rojo
            }
        }
    }


}
