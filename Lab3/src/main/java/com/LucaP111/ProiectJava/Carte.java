package com.LucaP111.ProiectJava;

public class Carte implements Identifiable<Integer> {
    private String author;
    private int publication;
    private int id;
    private int nr_pages;

    public Carte(String author, int nr_pages, int publication) {
        this.author = author;
        this.nr_pages = nr_pages;
        this.publication = publication;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getNrPages() {
        return nr_pages;
    }

    public void setNrPages(int nr_pages) {
        this.nr_pages = nr_pages;
    }

    public int getPublication() {
        return publication;
    }

    public void setpublication(int publication) {
        this.publication = publication;
    }

    @Override
    public void setId(Integer id) {
        this.id=id;
    }

    @Override
    public Integer getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Id=" + id + " " + author + ' ' + nr_pages + ' ' + publication ;
    }
}
