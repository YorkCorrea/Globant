package com.gobant.util;

import net.serenitybdd.core.environment.EnvironmentSpecificConfiguration;
import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.util.EnvironmentVariables;
import net.thucydides.core.util.SystemEnvironmentVariables;

public class Util extends PageObject {

    EnvironmentVariables variables = SystemEnvironmentVariables.createEnvironmentVariables();

    public String getVariableSerenity(String tipoVariable) {
        return EnvironmentSpecificConfiguration.from(variables).getProperty(tipoVariable);
    }
}
