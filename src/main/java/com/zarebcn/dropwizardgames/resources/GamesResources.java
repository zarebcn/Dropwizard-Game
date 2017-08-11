package com.zarebcn.dropwizardgames.resources;


import com.zarebcn.dropwizardgames.model.Game;
import com.zarebcn.webapputils.util.MustacheUtil;
//import com.zarebcn.dropwizardgames.util.MustacheUtil;


import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
        games.add(new Game("Wolfenstein 2 The New Colossus", "MachineGames", "FPS", 12));

    }


    @GET
    public String viewGames() throws IOException {

       /* String html = "<h1>Recommended Games</h1>";
        html += "<ul>";

        for (int i = 0; i < games.size(); i++) {

           html += generarHtml(games, i);
        }
        html += "</ul>";

        return html;*/

       return MustacheUtil.processTemplate("games.html", games);

    }

    @GET
    @Path("{id}")
    public String viewGame(@PathParam("id") int gameId) throws IOException {

        Game game = games.get(gameId - 1);

        if (game != null) {

            Map<String, Object> map = new HashMap<>();
            map.put("title", game.getTitle());
            map.put("developer", game.getDeveloper());
            map.put("genre", game.getGenre());

            return MustacheUtil.processTemplate("game.html", map);

            //return "<h1>" + game.getTitle() + "</h1>" + "<h2>" + game.getDeveloper() + "</h2>";

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

            for (int i = 0; i < gamesFiltered.size(); i++) {

               html += generarHtml(gamesFiltered, i);

                if (i == gamesFiltered.size() - 1) {

                    html += "</ul>";
                }
            }
        } else {

            html = "<h1>No games found by " + "'" + genre + "'" + " filter</h1>";
        }

        return html;
    }

    private String generarHtml(List<Game> lista, int indice) {

        Game game = lista.get(indice);
        int id = game.getId();

        return "<li><a href='/games/" + id + "'>" + game.getTitle() + "</a></li>";
    }
}
