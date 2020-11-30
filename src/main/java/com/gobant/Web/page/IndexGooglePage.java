package com.gobant.Web.page;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.By;

@DefaultUrl("https://www.google.com/")
public class IndexGooglePage extends PageObject {

    @FindBy(xpath = "//a[@title='Aplicaciones de Google']")
    public WebElementFacade btnGoogleApps;

    @FindBy(xpath = "//a[@data-pid='49']//div[1]")
    public WebElementFacade btnGoogleDrive;

    public void clickmenuGoogleApps() {
        btnGoogleApps.waitUntilClickable();
        btnGoogleApps.click();
        Serenity.takeScreenshot();
    }

    public void clickGoogleDrive() {
        getDriver().switchTo().frame(getDriver().findElement(By.xpath("//iframe[@role='presentation'][@scrolling='no']")));
        btnGoogleDrive.click();
        Serenity.takeScreenshot();
    }
}
