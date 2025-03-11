package com.LucaP111.ProiectJava;

import java.io.IOException;
import java.util.Properties;

public class MainBD {
    public static void main(String[] args) {

        Properties props = new Properties();
        try {
            props.load(MainBD.class.getClassLoader().getResourceAsStream("bd.config"));
        } catch (IOException | NullPointerException e) {
            System.out.println("Cannot find bd.config: " + e);
        }

        CarteRepository carteRepo=new CartiDBRepository(props);
        carteRepo.add(new Carte("Nameless",100, 2020));
        System.out.println("Toate cartile din db");
        for(Carte carte :carteRepo.findAll())
            System.out.println(carte);
       String manufacturer="Nameless";
        System.out.println("Carti produse de "+manufacturer);
        for(Carte carte :carteRepo.findByManufacturer(manufacturer))
            System.out.println(carte);

    }
}
