package com.LucaP111.Lab2;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import com.google.common.base.Joiner;

public class Main {
    public static void main(String[] args) {
        String rezultat = Joiner.on(", ").join("Walk", "to", "store");
        System.out.println(rezultat);
    }
}