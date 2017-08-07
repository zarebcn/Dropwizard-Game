package com.zarebcn.dropwizardgames;

import io.dropwizard.Application;
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
        // nothing to do yet
    }

    @Override
    public void run(GamesConfiguration configuration,
                    Environment environment) {
        // nothing to do yet
    }
}



