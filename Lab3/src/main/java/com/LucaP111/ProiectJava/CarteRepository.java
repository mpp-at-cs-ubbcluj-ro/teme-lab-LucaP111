package com.LucaP111.ProiectJava;

import java.util.List;

public interface CarteRepository extends Repository<Integer,Carte> {
    List<Carte> findByManufacturer(String manufacturer);
    List<Carte> findBetweenYears(int min, int max);
}
