package com.zarebcn.dropwizardgames;

import com.zarebcn.dropwizardgames.controllers.GamesController;
import io.dropwizard.Application;
import io.dropwizard.assets.AssetsBundle;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

public class GamesApplication extends Application<GamesConfiguration> {

    public static void main(String[] args) throws Exception {
        new GamesApplication().run(args);
    }

    @Override
    public String getName() {
        return "Games";
    }

    @Override
    public void initialize(Bootstrap<GamesConfiguration> bootstrap) {

        bootstrap.addBundle(new AssetsBundle("/assets/", "/", "index.html"));
    }

    @Override
    public void run(GamesConfiguration configuration, Environment environment) {

        GamesController gamesController = new GamesController();

        //tell dropwizard to setup my resource
        environment.jersey().register(gamesController);
    }
}



