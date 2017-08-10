package com.zarebcn.dropwizardgames.util;

import com.github.mustachejava.DefaultMustacheFactory;
import com.github.mustachejava.Mustache;
import com.github.mustachejava.MustacheFactory;

import java.io.IOException;
import java.io.StringWriter;

public class MustacheUtil {

    public static String processTemplate(String filename, Object value) throws IOException {

        MustacheFactory mustache = new DefaultMustacheFactory();
        Mustache template = mustache.compile(filename);
        StringWriter writer = new StringWriter();
        template.execute(writer, value).flush();

        return writer.toString();
    }
}
