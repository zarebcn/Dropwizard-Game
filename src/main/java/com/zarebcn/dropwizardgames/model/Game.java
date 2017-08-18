package com.zarebcn.dropwizardgames.model;

public class Game {

    private String title;
    private String developer;
    private String genre;
    private String portada;
    private int score;
    private int id;

    public Game(int score, String title, String developer, String genre, int id, String portada) {

        this.title = title;
        this.developer = developer;
        this.genre = genre;
        this.portada = portada;
        this.score = score;
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public String getDeveloper() {
        return developer;
    }

    public String getGenre() {
        return genre;
    }

    public int getId() {
        return id;
    }

    public String getPortada() {
        return portada;
    }

    public int getScore() {
        return score;
    }

}
