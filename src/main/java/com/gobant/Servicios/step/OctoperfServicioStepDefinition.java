package com.gobant.Servicios.step;

import com.gobant.Servicios.fact.Access;
import com.gobant.Servicios.task.Octoperf;
import com.gobant.util.Util;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.actors.Cast;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;
import org.apache.http.HttpStatus;
import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static net.serenitybdd.screenplay.rest.questions.ResponseConsequence.seeThatResponse;
import static org.hamcrest.Matchers.*;

public class OctoperfServicioStepDefinition {

    private String Token;
    private String Message;
    private String Type;

    @Given("York hace la consulta al servicio de Octoperf")
    public void yorkHaceLaConsultaAlServicioDeOctoperf() {
        RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();
        Cast cast = OnlineCast.whereEveryoneCan(CallAnApi.at("https://api.octoperf.com"));
        OnStage.setTheStage(cast);
        theActorCalled("York").has(Access.toOctoperf());
    }

    @And("York accede con su password correcta {string} y username {string}")
    public void yorkAccedeConSuPasswordCorrectaYUsername(String password, String username) {
        theActorInTheSpotlight().attemptsTo(Octoperf.withLogin(password, username));
        Token = SerenityRest.lastResponse().path("token");
        System.out.println("Este es el Token generado: " + Token);
    }

    @Then("verificaremos que sea un login correcto obteniendo un token")
    public void verificaremosQueSeaUnLoginCorrectoObteniendoUnToken() {
        theActorCalled("Test").should(seeThatResponse(response ->
                response.statusCode(HttpStatus.SC_OK).contentType(ContentType.JSON)
                        .body("token", not(isEmptyString())).log().all()));
    }

    @And("York accede con una password incorrecta {string} y username {string}")
    public void yorkAccedeConUnaPasswordIncorrectaYUsername(String password, String username) {
        theActorInTheSpotlight().attemptsTo(Octoperf.withLogin(password, username));
        Message = SerenityRest.lastResponse().path("message");
        Type = SerenityRest.lastResponse().path("type");
        System.out.println(Message + Type);
    }

    @Then("verificaremos que sea un login incorrecto")
    public void verificaremosQueSeaUnLoginIncorrecto() {
        theActorCalled("Test").should(seeThatResponse(response ->
                        response.statusCode(HttpStatus.SC_NOT_FOUND).contentType(ContentType.JSON)
                                .body("message", equalTo(Message))
                                .body("type", equalTo(Type)).log().all()
                )
        );
    }
}
