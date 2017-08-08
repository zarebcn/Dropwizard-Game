package com.zarebcn.dropwizardgames.resources;


import com.zarebcn.dropwizardgames.model.Game;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.List;

@Path("/games")
@Produces(MediaType.TEXT_HTML)
public class GamesResources {

    private List<Game> games;

    public GamesResources() {

        games = new ArrayList<>();
        games.add(new Game("Bioshock", "2K Games", "FPS", 1));
        games.add(new Game("Alien Isolation", "CA Games", "Survival Horror", 2));
        games.add(new Game("PES 2018", "Konami", "Sport", 3));
        games.add(new Game("Skyrim", "Bethesda", "RPG", 4));
        games.add(new Game("The Witcher 3", "CD Projekt RED", "RPG", 5));
        games.add(new Game("Half Life 2", "Valve", "FPS", 6));
        games.add(new Game("Resident Evil 7", "Capcom", "Survival Horror", 7));
        games.add(new Game("NBA 2K18", "2K Games", "Sport", 8));
        games.add(new Game("Thimbleweed Park", "Terrible Toybox", "Adventure", 9));
        games.add(new Game("Fallout 4", "Bethesda", "RPG", 10));
        games.add(new Game("Call of Duty 4 Modern Warfare Remastered", "Raven Software", "FPS", 11));
        games.add(new Game("Wolfenstein 2 The new Colossus", "MachineGames", "FPS", 12));

    }


    @GET
    public String viewGames() {

        String html = "<h1>Recommended Games</h1>";
        html += "<ul>";

        for (Game game : games) {
            int id = game.getId();
            html += "<li><a href='/games/" + id + "'>" + game.getTitle() + "</a></li>";
        }
        html += "</ul>";

        return html;
    }

    @GET
    @Path("{id}")
    public String viewGame(@PathParam("id") int gameId) {

        Game game = games.get(gameId - 1);

        if (game != null) {
            return "<h1>" + game.getTitle() + "</h1>" + "<h2>" + game.getDeveloper() + "</h2>";
        } else {
            return "Game not found";
        }
    }

    @GET
    @Path("/search")
    public String search() {
        return "<h1>Enter a game genre filter value</h1>";
    }

    @GET
    @Path("/search/{genre}")
    public String filterByGenre(@PathParam("genre") String genre) {

        String html = "<h1>Games found by " + genre + " filter</h1>";
        html += "<ul>";
        List<Game> gamesFiltered = new ArrayList<>();


        for (int i = 0; i < games.size(); i++) {

            Game game = games.get(i);

            if (genre != null && game.getGenre().toLowerCase().equals(genre.toLowerCase())) {

                gamesFiltered.add(game);
            }
        }

        if (gamesFiltered.size() > 0) {

            for (int in = 0; in < gamesFiltered.size(); in++) {

                Game game = gamesFiltered.get(in);
                int id = game.getId();
                html += "<li><a href='/games/" + id + "'>" + game.getTitle() + "</a></li>";

                if (in == gamesFiltered.size() - 1) {

                    html += "</ul>";
                }
            }
        } else {

            html = "<h1>No games found by " + "'" + genre + "'" + " filter</h1>";
        }

        return html;
    }
}
