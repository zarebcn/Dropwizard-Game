package com.zarebcn.dropwizardgames.controllers;


import com.zarebcn.dropwizardgames.model.Game;
//import com.zarebcn.webapputils.util.MustacheUtil;
import com.zarebcn.dropwizardgames.MustacheUtil;


import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Path("/games")
@Produces(MediaType.TEXT_HTML)
public class GamesController {

    private List<Game> games;

    public GamesController() {

        games = new ArrayList<>();

        games.add(new Game(96, "Bioshock", "2K Games", "FPS", 1, "https://vignette3.wikia.nocookie.net/bioshock/images/8/8e/BioShock_box.png/revision/latest?cb=20100425082949"));
        games.add(new Game(81, "Alien Isolation", "CA Games", "Survival Horror", 2, "http://www.gamedynamo.com/images/games/boxart/high/4513.jpg"));
        games.add(new Game(85, "PES 2017", "Konami", "Sport", 3, "http://www.mobygames.com/images/covers/l/365348-pes-2017-pro-evolution-soccer-playstation-4-front-cover.jpg"));
        games.add(new Game(94, "TES V Skyrim", "Bethesda", "RPG", 4, "https://i.ytimg.com/vi/AeGpJgt_KiA/maxresdefault.jpg"));
        games.add(new Game(93, "The Witcher 3", "CD Projekt RED", "RPG", 5, "http://i.imgur.com/DVZUGpO.jpg"));
        games.add(new Game(95, "Metal Gear Solid V The Phantom Pain", "Konami", "FPS", 6, "https://static.giantbomb.com/uploads/original/8/86603/2644272-scarf.jpg"));
        games.add(new Game(86, "Resident Evil 7", "Capcom", "Survival Horror", 7, "http://www.heypoorplayer.com/wp-content/uploads/2017/01/Resident-Evil-7-Art.jpg"));
        games.add(new Game(90, "NBA 2K17", "2K Games", "Sport", 8, "http://media.operationsports.com/shots/1470398834-media.jpg"));
        games.add(new Game(85, "Thimbleweed Park", "Terrible Toybox", "Adventure", 9, "http://gamepod.vg/wp-content/uploads/2017/03/ThimbleweedParkCover.jpg"));
        games.add(new Game(88, "Fallout 4", "Bethesda", "RPG", 10, "https://vignette3.wikia.nocookie.net/fallout/images/e/e9/Fallout_4_box_cover.jpg/revision/latest?cb=20170220211249"));
        games.add(new Game(89, "Call of Duty 4 Modern Warfare Remastered", "Raven Software", "FPS", 11, "http://vignette3.wikia.nocookie.net/callofduty/images/e/ec/Cod-mw-remastered-cover_v2.jpeg/revision/latest?cb=20160502190153"));
        games.add(new Game(81, "Wolfenstein The New Order", "MachineGames", "FPS", 12, "https://gamefaqs.akamaized.net/box/2/3/5/396235_front.jpg"));

    }


    @GET
    public String viewGames(@QueryParam("search") String genre) throws IOException {

        List<Game> gamesFiltered = new ArrayList<>();

        if (genre != null) {

            for (int i = 0; i < games.size(); i++) {

                Game game = games.get(i);

                if (genre != null && game.getGenre().toLowerCase().equals(genre.toLowerCase())) {

                    gamesFiltered.add(game);
                }
            }

            if (gamesFiltered.size() > 0) {

                return MustacheUtil.processTemplate("filteredgames.html", gamesFiltered);

            } else {

                return MustacheUtil.processTemplate("games.html", games);
                //return "<h1>No games found by " + "'" + genre + "'" + " filter</h1>";
            }

        } else {

            return MustacheUtil.processTemplate("games.html", games);
        }
    }


    @GET
    @Path("{id}")
    public String viewGame(@PathParam("id") int gameId) throws IOException {



        if (gameId > 0 && gameId <= games.size()) {

            Game game = games.get(gameId - 1);

            Map<String, Object> map = new HashMap<>();
            map.put("title", game.getTitle());
            map.put("developer", game.getDeveloper());
            map.put("cover", game.getPortada());
            map.put("score", game.getScore());

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
    public String filterByGenre(@PathParam("genre") String genre) throws IOException {

       // String html = "<h1>Games found by " + genre + " filter</h1>";
       // html += "<ul>";
        List<Game> gamesFiltered = new ArrayList<>();


        for (int i = 0; i < games.size(); i++) {

            Game game = games.get(i);

            if (genre != null && game.getGenre().toLowerCase().equals(genre.toLowerCase())) {

                gamesFiltered.add(game);
            }
        }

        if (gamesFiltered.size() > 0) {

           /* for (int i = 0; i < gamesFiltered.size(); i++) {

               html += generarHtml(gamesFiltered, i);

                if (i == gamesFiltered.size() - 1) {

                    html += "</ul>";
                }
            }*/

            return MustacheUtil.processTemplate("filteredgames.html", gamesFiltered);

        } else {

            return "<h1>No games found by " + "'" + genre + "'" + " filter</h1>";
        }

        //return html;
    }

    private String generarHtml(List<Game> lista, int indice) {

        Game game = lista.get(indice);
        int id = game.getId();

        return "<li><a href='/games/" + id + "'>" + game.getTitle() + "</a></li>";
    }
}
