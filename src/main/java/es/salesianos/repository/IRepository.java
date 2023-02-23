package es.salesianos.repository;

import es.salesianos.model.Wordle;

public interface IRepository {
    Wordle getWordle();
    void reset();
}
