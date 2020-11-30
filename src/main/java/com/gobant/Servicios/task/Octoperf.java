package com.gobant.Servicios.task;

import io.restassured.http.ContentType;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.rest.interactions.Post;

public class Octoperf implements Task {

    private static final String URL_LOGIN = "/public/users/login";

    private final String password;
    private final String username;

    public Octoperf(String password, String username) {
        this.password = password;
        this.username = username;
    }

    public static Performable withLogin(String password, String username) {
        return Tasks.instrumented(Octoperf.class, password, username);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Post.to(URL_LOGIN).
                with(request -> request
                        .contentType(ContentType.JSON)
                        .queryParam("password", password)
                        .queryParam("username", username)
                ));
    }
}
