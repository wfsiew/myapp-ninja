package controllers;

import conf.AuthFilter;
import ninja.*;
import ninja.params.Param;
import ninja.session.Session;

import com.google.inject.Singleton;

import java.util.HashMap;

@FilterWith(AuthFilter.class)
@Singleton
public class ContactController {

    public Result data(@Param("id") String id) {
        HashMap<String, Object> m = new HashMap<>();
        m.put("id", id);

        return Results.json().render(m);
    }
}
