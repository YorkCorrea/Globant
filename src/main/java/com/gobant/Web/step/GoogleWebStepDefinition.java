package com.gobant.Web.step;

import com.gobant.Web.page.GoogleDrivePage;
import com.gobant.Web.page.LoginGoogleDrivePage;
import com.gobant.Web.page.IndexGooglePage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class GoogleWebStepDefinition {

    IndexGooglePage index;
    LoginGoogleDrivePage loginDrive;
    GoogleDrivePage drivePage;

    @Given("ingresamos a la pagina web de Google")
    public void ingresamosALaPaginaWebDeGoogle() {
        index.open();
    }

    @When("accedemos al menu de Google Apps")
    public void accedemosAlMenuDeGoogleApps() {
        index.clickmenuGoogleApps();
    }

    @And("abrimos Google Drive e ingresamos nuestra cuenta de Google")
    public void abrimosGoogleDriveEIngresamosNuestraCuentaDeGoogle() {
        index.clickGoogleDrive();
    }

    @And("ingreso mi correo electronico")
    public void ingresoMiCorreoElectronico() {
        loginDrive.clickIrADrive();
        loginDrive.ingresarCorreo();
    }

    @And("ingreso mi password")
    public void ingresoMiPassword() {
        loginDrive.ingresarPassword();
    }

    @And("accedemos a Google Drive y creamos un nuevo documento en blanco")
    public void accedemosAGoogleDriveYCreamosUnNuevoDocumentoEnBlanco() {
        drivePage.clickNuevo();
        drivePage.clickDocumentoGoogle();
    }

    @And("ingresamos el nombre del documento y guardamos")
    public void ingresamosElNombreDelDocumentoYGuardamos() throws InterruptedException {
        drivePage.obtenerHoraActual();
        drivePage.ingresarNombreDocumento();
    }

    @Then("regresamos a la pantalla principal para verificar que el archivo haya sido creado correctamente")
    public void regresamosALaPantallaPrincipalParaVerificarQueElArchivoHayaSidoCreadoCorrectamente() {
        drivePage.verificarCreacionDocumento();
    }
}
