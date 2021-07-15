package Utility;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.HashMap;
import java.util.concurrent.TimeUnit;

public class Util {
    public static WebDriver driver;
    public static ChromeOptions options;

    public static void fnLoadBrowser() {
        System.out.println(" ******************");
        System.out.println("启动Chrome浏览器");
        String sOSName = System.getProperty("os.name");
        System.out.println("操作系统是：" + sOSName);
        if(sOSName.contains("Windows")){
            System.out.println("Accessing Windows driver");
            options = new ChromeOptions();
           // System.setProperty("webdriver.chrome.driver", "./chromedriver/chromedriver.exe");
            System.out.println("Windows chromedriver成功启动");
        }
        else if(sOSName.contains("Mac OS X")){
            System.out.println("Accessing Mac driver");
            System.setProperty("webdriver.chrome.driver", "./chromedriver/ chromedriver 3");
            System.out.println("Mac chromedriver成功启动");
        }
        else{
            System.out.println("Accessing Linux driver");
            System.setProperty("webdriver.chrome.driver", "/user/local/bin/chromedriver/");
            System.out.println("Mac chromedriver成功启动");
        }
        //fnSetBrowserOptions();
       driver = new ChromeDriver(options);

        if(sOSName.contains("Windows")){
            driver.manage().window().maximize();
        }
        else{
            System.out.println("Execution Script On non-windwons OS");
        }
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);



    }
    //单独重构成一个方法，然后调用
    public DesiredCapabilities setDownloadsPath() {
        String downloadsPath = "D:\\dataSource\\outputReport\\Downloads";
        HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
        chromePrefs.put("download.default_directory", downloadsPath);
        options = new ChromeOptions();
        options.setExperimentalOption("prefs", chromePrefs);
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability(ChromeOptions.CAPABILITY, options);
        return caps;
    }

    public static void waitForWebElement(By elmEditFAQ) {
        try {
            boolean bFlag = false;
            int iCount = 0;
            WebDriverWait wait = new WebDriverWait(Util.driver, 20);
            wait.until(ExpectedConditions.presenceOfElementLocated(elmEditFAQ));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void fnScrollDownWebPageByVisiblityOfTheElemnt(By eObjectName) throws InterruptedException {
        JavascriptException js = (JavascriptException) driver;
        WebElement Element = driver.findElement(eObjectName);
       /* js.executeScript("",Element);*/
        waitForWebElement(eObjectName);
        Thread.sleep(2000);
    }
}
