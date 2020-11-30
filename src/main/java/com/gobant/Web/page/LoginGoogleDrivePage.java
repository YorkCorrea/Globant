package com.gobant.Web.page;

import com.gobant.util.Util;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;

import java.util.ArrayList;

public class LoginGoogleDrivePage extends PageObject {

    Util obtenerConfigProperties = new Util();

    @FindBy(linkText = "Ir a Drive")
    public WebElementFacade btnDrive;

    @FindBy(id = "identifierId")
    public WebElementFacade txtEmail;

    @FindBy(name = "password")
    public WebElementFacade txtPassword;

    @FindBy(xpath = "//span[text()='Siguiente']/following-sibling::div")
    public WebElementFacade btnSiguiente;

    public void clickIrADrive() {
        btnDrive.click();
    }

    public void ingresarCorreo() {
        ArrayList<String> tabs = new ArrayList<>(getDriver().getWindowHandles());
        getDriver().switchTo().window(tabs.get(1));
        txtEmail.waitUntilEnabled().type(obtenerConfigProperties.getVariableSerenity("email"));
        Serenity.takeScreenshot();
        btnSiguiente.click();
    }

    public void ingresarPassword() {
        txtPassword.waitUntilEnabled().type(obtenerConfigProperties.getVariableSerenity("password"));
        Serenity.takeScreenshot();
        btnSiguiente.click();
    }
}
