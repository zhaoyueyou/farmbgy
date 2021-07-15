package Utility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class Drivers {

    private static volatile WebDriver driver = null;

    /**
     * 单例， 每次getDriver()返回是同一ChromeDriver实例
     * @return
     */
    public static WebDriver getDriver() {
        if(null == driver){
            System.out.println("*********实例化chrome driver");
            //实例化一个ChromeOptions
            ChromeOptions options = new ChromeOptions();
            Map<String, Object> prefs = new HashMap();
            prefs.put("credentials_enable_service", false);
            prefs.put("profile.password_manager_enabled", false);
            options.setExperimentalOption("prefs",prefs); //禁用保存密码提示框
            driver = new ChromeDriver(options);
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            driver.manage().window().maximize();

            //return driver;
        }
        System.out.println("*********无需实例化chrome driver");

        return driver;
    }



}
