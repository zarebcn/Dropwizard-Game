package com.zarebcn.dropwizardgames.model;

public class Game {

    private String title;
    private String developer;
    private String genre;

    public Game (String title, String developer, String genre) {

        this.title = title;
        this.developer = developer;
        this.genre = genre;
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
}
