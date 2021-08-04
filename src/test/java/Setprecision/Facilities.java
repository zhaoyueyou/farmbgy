package Setprecision;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebElement;
import pageObjects.BasePage;
import pageObjects.SelLibrary;

public class Facilities {
    private BasePage bp = new BasePage();
    private String inputname = "//input[@placeholder='请输入内容']";
    private String Selectclick = "//div[text()='设施类型：']/../div[2]//span";
    private String btnsee = "(//button/span[text()='查看'])[2]";

    @Given("^: Click the secondary menu \"([^\"]*)\"$")
    public void clickTheSecondaryMenu(String arg0) throws Throwable {
        bp.waitime(2000);
        new BasePage().ClickedElementLikeDiv(arg0);
    }


    @Given("^: Enter the field facilities name \"([^\"]*)\"$")
    public void enterTheFieldFacilitiesName(String name) throws Throwable {
        WebElement ipname = new SelLibrary().findElementByXpath(inputname);
        ipname.clear();
        bp.waitime(2000);
        ipname.sendKeys(name);

    }



    @When("^: Selected field facilitiestype \"([^\"]*)\"$")
    public void selectedFieldFacilitiestype(String type) throws Throwable {

        new SelLibrary().findElementByXpathAndClick(Selectclick);
        String selectType = "//span[text()='"+ type +"']";
        new SelLibrary().findElementByXpathAndClick(selectType);
        bp.waitime(2000);
    }


    @Given("^Check View button(\\d+)$")
    public void checkViewButton(int arg0) {
        new SelLibrary().findElementByXpathAndClick(btnsee);
        bp.waitime(3000);
    }
}
