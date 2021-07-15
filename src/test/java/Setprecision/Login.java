package Setprecision;

import Utility.Util;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

public class Login {
    @Given("^Open login page$")
    public void openLoginPage(){
        Util.fnLoadBrowser();
        Util.driver.get("http://sit.farmbgy.com/#/account/login");
        //设置寻找一个元素的时间
        Util.driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        //不验证
        };
    @When("^Enter the account number \"([^\"]*)\"$")
    public void enterTheAccountNumber(String Account) throws Throwable {
        Util.driver.findElement(By.xpath("//input[@placeholder='请输入用户名/手机号码']")).clear();
        Thread.sleep(2000);
        Util.driver.findElement(By.xpath("//input[@placeholder='请输入用户名/手机号码']")).sendKeys(Account);
        Thread.sleep(2000);

    }
    @And("^Enter password \"([^\"]*)\"$")
    public void enterPassword(String Password) throws Throwable {
        Util.driver.findElement(By.xpath("//input[@placeholder='请输入密码']")).clear();
        Thread.sleep(2000);
        Util.driver.findElement(By.xpath("//input[@placeholder='请输入密码']")).sendKeys(Password);
        Thread.sleep(2000);
    }



    @Then("^Account and password prompt \"([^\"]*)\"$")
    public void accountAndPasswordPrompt(String expectedResult) throws Throwable {
        String Account = Util.driver.findElement(By.xpath("//input[@placeholder='请输入用户名/手机号码']")).getText();
        String password = Util.driver.findElement(By.xpath("//input[@placeholder='请输入密码']")).getText();
        System.out.println("login by Account:"+Account + ", password:"+password);
        Thread.sleep(3000);
        Util.driver.findElement(By.xpath("//button[@class='el-button el-button--primary primary-style']")).click();
        Thread.sleep(3000);
        try{
            String text = Util.driver.findElement(By.xpath("//div[@class='user-name']")).getText();
            if("请先进行验证".equals(text)){
                return;
            }
            System.out.println("result:" + text);
            Assert.assertEquals(text, expectedResult);
        }catch (Exception e){
           /*String successText = Util.driver.findElement(By.xpath("//span[@id='spnUid']")).getText();
            System.out.println(successText);
            Assert.assertEquals(successText, expectedResult);*/
            Thread.sleep(2000);
        }
    }


    @Given("^out login$")
    public void outLogin() {
        Util.driver.quit();
    }
}
