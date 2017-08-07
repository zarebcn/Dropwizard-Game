package com.zarebcn.dropwizardgames.resources;


import com.zarebcn.dropwizardgames.model.Game;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
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
        games.add(new Game("Bioshock", "2K Games", "FPS"));
        games.add(new Game("Alien Isolation", "CA Games", "Survival Horror"));
        games.add(new Game("PES 2018", "Konami", "Sport"));

    }


    @GET
    public String viewGames() {

        String html = "<h1>Recommended Games</h1>";
        html += "<ul>";

        for (Game game : games) {
            html += "<li>" + game.getTitle() + "</li>";
        }
        html += "</ul>";

        return html;
    }
}
