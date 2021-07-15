package pageObjects;

import Utility.Util;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class SelLibrary {
    public final String sad = "*o*";
    //通过id获取元素并点击
    public void findElementByIdAndClick(String id) {
        Util.driver.findElement(By.id(id)).click();
    }

    public void findElementByNameAndClick(String name) {
        findElementByName(name).click();
    }

    //根据文本获取元素并点击
    public void findElementByTextAndClick(String text) {
        Util.driver.findElement(By.linkText(text)).click();
    }

    //根据文本模糊查找
    public void findElementByPartiaTextAndClick(String text) {
        Util.driver.findElement(By.partialLinkText(text)).click();
    }

    //根据xpath获取元素
    public WebElement findElementByXpath(String xpath) {
        return Util.driver.findElement(By.xpath(xpath));
    }

    public WebElement findElementByTag(String tag) {
        return Util.driver.findElement(By.tagName(tag));
    }

    //根据id获取元素
    public WebElement findElementById(String id) {
        return Util.driver.findElement(By.id(id));
    }

    //通过xpath获取元素点击
    public void findElementByXpathAndClick(String xpath) {
        Util.driver.findElement(By.xpath(xpath)).click();
    }

    //通过class获取元素并点击
    public void findElementByClassNameAndClick(String name) {
        Util.driver.findElement(By.className(name)).click();
    }

    public WebElement findElementByClassName(String name) {
        return Util.driver.findElement(By.className(name));
    }

    //获取一组元素
    public List<WebElement> findElementsByClassName(String className) {
        return Util.driver.findElements(By.className(className));
    }

    //根据text获取一组页面元素
    public List<WebElement> findElementsByText(String text) {
        return Util.driver.findElements(By.linkText(text));
    }

    public List<WebElement> findElementsByPartialText(String text) {
        return Util.driver.findElements(By.partialLinkText(text));
    }

    //根据id获取一组页面元素
    public List<WebElement> findElementsById(String id) {
        return Util.driver.findElements(By.id(id));
    }

    //根据tagName获取一组页面元素
    public List<WebElement> findElementsByTag(String tag) {
        return Util.driver.findElements(By.tagName(tag));
    }

    public WebElement findElementByText(String text) {
        return Util.driver.findElement(By.linkText(text));
    }

    public WebElement findElementByPartialText(String text) {
        return Util.driver.findElement(By.partialLinkText(text));
    }

    public WebElement findElementByName(String name) {
        return Util.driver.findElement(By.name(name));
    }

    //输出cookies信息
    public void outputCookie() {
        Set<Cookie> cookie = Util.driver.manage().getCookies();
        System.out.println(cookie);
//        Cookie abc = new Cookie("", "");
//        driver.manage().addCookie(abc);
    }

    public void addCookie(Map<String, String> args) {
        Set<String> keys = args.keySet();
        for (String key : keys) {
            Util.driver.manage().addCookie(new Cookie(key, args.get(key)));
        }
    }

    //判断元素是否存在
    public boolean exists(By selector) {
        Util.driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);//设置查询组件等待时间
        try {
            Util.driver.findElement(selector);
            Util.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);//设置查询组件等待时间
            return true;
        } catch (Exception e) {
            Util.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);//设置查询组件等待时间
            return false;
        }
    }

    //获取文本
    public String getTextByXpath(String xpath) {
        return findElementByXpath(xpath).getText();
    }

    public String getTextByClassName(String name) {
        return findElementByClassName(name).getText();
    }

    public String getTextById(String id) {
        return findElementById(id).getText();
    }

    public String getTextByName(String name) {
        return findElementByName(name).getText();
    }

  /*  //获取数量
    public int getNumByXpath(String xpath) {
        String num = getTextByXpath(xpath);
        return changeStringToInt(num);
    }

    public int getNumByClassName(String name) {
        String num = getTextByClassName(name);
        return changeStringToInt(num);
    }*/

    //通过xpath获取classname
    public String getClassNameByXpath(String xpath) {
        return findElementByXpath(xpath).getAttribute("class");
    }

    //通过id获取classname
    public String getClassNameById(String id) {
        return findElementById(id).getAttribute("class");
    }

    //按物理按键
    public void pressKeyEvent(int keycode) throws AWTException {
        Robot robot = new Robot();
//        robot.keyPress(KeyEvent.VK_ENTER);//按下enter键
        robot.keyPress(keycode);
    }
//    //强制刷新
//    public void refresh() {
//        Actions ctrl = new Actions(Util.driver);
//        ctrl.keyDown(Keys.CONTROL).perform();
//        try {
//            pressKeyEvent(KeyEvent.VK_F5);
//        } catch (AWTException e) {
//            output(sad + getNow());
//            e.printStackTrace();
//        }
//        ctrl.keyUp(Keys.CONTROL).perform();
//
//    }



    //右键点击
    public void RightClickWebElement(String id) {
        Actions actions = new Actions(Util.driver);
        actions.contextClick(findElementById(id)).perform();;
    }
    //根据classname获取元素清除并输入内容
    public void findElementByClassnameAndClearSendkeys(String classname, String text) {
        Util.driver.findElement(By.className(classname)).clear();
        Util.driver.findElement(By.className(classname)).sendKeys(text);
    }
    public void findElementByClassnameAndClearSendkeys(String classname, int num) {
        Util.driver.findElement(By.className(classname)).clear();
        Util.driver.findElement(By.className(classname)).sendKeys(num+"");
    }
    //根据id获取下拉框，根据index选择选项
    public void findSelectByIdAndSelectByIndex(String id, int index) {
        Select select = new Select(findElementById(id));
        select.selectByIndex(index);
    }
    //根据id获取下拉框，根据value选择选项
    public void findSelectByIdAndSelectByValue(String id, String value) {
        Select select = new Select(findElementById(id));
        select.selectByValue(value);
    }
    //根据id获取下拉框，根据text选择选项
    public void findSelectByIdAndSelectByText(String id, String text) {
        Select select = new Select(findElementById(id));
        select.selectByVisibleText(text);;
    }
    //根据name获取下拉框，根据Value选择选项
    public void findSelectByNameAndSelectByValue(String name, String value) {
        Select select = new Select(findElementByName(name));
        select.selectByValue(value);
    }
    //根据name获取下拉框，根据index选择选项
    public void findSelectByNameAndSelectByIndex(String name, int index) {
        Select select = new Select(findElementByName(name));
        select.selectByIndex(index);
    }
    //鼠标悬停
    public void moveToElementById(String id) {
        Actions actions = new Actions(Util.driver);
        actions.moveToElement(findElementById(id));
    }
    public void moveToElementByClassName(String name) {
        Actions actions = new Actions(Util.driver);
        actions.moveToElement(findElementByClassName(name));
    }

    //下拉选项方法
    public static void fnSelectValueFromDropDown(By elmDropDown, String svalueToBeSelected) throws IOException{
        String sActualValue = "The vale :-" + svalueToBeSelected + " is selected from dropdown:-" + elmDropDown + "";
        String sExpctedValue = "The vale :-" + svalueToBeSelected + " is selected from dropdown:-" + elmDropDown + "";
        try {
            Util.waitForWebElement(elmDropDown);
            Select select = new Select(Util.driver.findElement(elmDropDown));
            select.selectByVisibleText(svalueToBeSelected.trim());
        }catch (Exception e){
            sActualValue = "The vale :-" + svalueToBeSelected + " is selected from dropdown:-" + elmDropDown + "";

            e.printStackTrace();
        }
        Assert.assertEquals(sExpctedValue, sActualValue);
    }





}