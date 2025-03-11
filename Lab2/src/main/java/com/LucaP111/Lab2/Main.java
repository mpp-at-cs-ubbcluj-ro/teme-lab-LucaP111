package com.LucaP111.Lab2;

import com.google.common.base.Splitter;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        String input = "Walk, to, store";

        List<String> splitResult = Splitter.on(", ").splitToList(input);

        System.out.println("Split string: " + splitResult);
    }
}
