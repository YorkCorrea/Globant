package com.gobant.Servicios.fact;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.facts.Fact;

public class Access implements Fact {
    public static Access toOctoperf() {
        return new Access();
    }

    public String toString() {
        return "Access{ API OCTOPERF }";
    }

    @Override
    public void setup(Actor actor) {
    }
}
