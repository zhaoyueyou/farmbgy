package Utility;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pageObjects.SelLibrary;

import java.util.concurrent.TimeUnit;

public class TestLogin {
    //登陆操作
    public static void login(WebDriver driver, String Account, String password) throws InterruptedException {
        driver.get("http://69.231.162.38/#/account/login");
        //设置寻找一个元素的时间
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        //通过name定位账号输入框
        WebElement Accountname = new SelLibrary().findElementByXpath(Logback.properties.getProperty("输入账号"));
       // WebElement Accountname = driver.findElement(By.xpath("//input[@placeholder='请输入用户名/手机号码']"));
        // 调用WebElement的clear()方法，清空用户名输入框的数据
        Accountname.clear();
        // 调用WebElement的sendKeys()方法，输入用户名
        Accountname.sendKeys(Account);
        Thread.sleep(2000);
        // 通过name定位密码输入框
     //   driver.findElement(By.xpath("//input[@placeholder='请输入密码']")).sendKeys(password);
        new SelLibrary().findElementByXpath(Logback.properties.getProperty("输入密码")).sendKeys(password);
        Thread.sleep(2000);
       // driver.findElement(By.xpath("//button[@class='el-button el-button--primary primary-style']")).click();
        new SelLibrary().findElementByXpathAndClick(Logback.properties.getProperty("登录"));
    }
}
