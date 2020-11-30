package com.gobant.Web.page;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class GoogleDrivePage extends PageObject {

    private String fechaActual;

    @FindBy(xpath = "(//button[@aria-label='Nuevo'])[1]")
    public WebElementFacade btnNuevo;

    @FindBy(xpath = "//div[text()='Documentos de Google']")
    public WebElementFacade btnDocumento;

    @FindBy(className = "docs-title-input")
    public WebElementFacade txtNombreDocumento;

    public void clickNuevo() {
        Serenity.takeScreenshot();
        btnNuevo.waitUntilClickable().click();
    }

    public void clickDocumentoGoogle() {
        btnDocumento.waitUntilClickable().click();
    }

    public void obtenerHoraActual() {
        Date ahora = new Date();
        SimpleDateFormat formateador = new SimpleDateFormat("dd-MM-yyyy" + " hh:mm:ss");
        fechaActual = formateador.format(ahora);
    }

    public void ingresarNombreDocumento() throws InterruptedException {
        ArrayList<String> tabs = new ArrayList<>(getDriver().getWindowHandles());
        getDriver().switchTo().window(tabs.get(2));
        txtNombreDocumento.waitUntilVisible().click();
        Serenity.takeScreenshot();
        txtNombreDocumento.clear();
        txtNombreDocumento.typeAndEnter("E01_" + "York Correa_"+fechaActual);
        Serenity.takeScreenshot();
        Thread.sleep(5000);
    }

    public void verificarCreacionDocumento(){
        ArrayList<String> tabs = new ArrayList<>(getDriver().getWindowHandles());
        getDriver().switchTo().window(tabs.get(1));
        getDriver().navigate().refresh();
        Serenity.takeScreenshot();
    }
}
