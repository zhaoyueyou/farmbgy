package pageObjects;

import Utility.Util;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class BasePage {
    private static Object GetLoctions;
   // private static volatile WebDriver driver = null;
   SelLibrary SL = new SelLibrary();

    /**
     * 单击事件
     */
    public void Click(WebElement element) {
        try {
            element.click();
        } catch (ElementNotVisibleException e) {
            System.out.println("传入的元素" + element + "有误！请检查元素是否正确！");
        }
    }



    /**
     * 输入文本框
     */
    public void Sendkeys(WebElement element, String key) {
        try {
            element.sendKeys(key);
        } catch (Exception e) {
            System.out.println("传入的元素:" + element + ",传入的Key值：" + key + "有错误！请检查");
        }
    }

//    // 处理提示框输入字符
//    public void AlterSendCase(String text, boolean iscancel) {
//        driver.DelAlterSendcase(text, iscancel);
//
//    }
    /**
     * 获取子元素的所有信息
     */
    public WebElement getSonElement(List elements, int index) {
        return (WebElement) elements.get(index);
    }
    /**
     * 时间等待
     */
    public void waitime(long time) {
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    /**
     * 滚动到最下方
     */
    public void OperitionScrollDown() {
        ((JavascriptExecutor) Util.driver).executeScript("window.scrollTo(0,document.body.scrollHeight)");
        this.waitime(3000);
    }

    /**
     * 元素等待
     */
    public void WaitForWebElement(By btn){
        try {
            boolean bFlag =false;
            int iCount = 0;
            WebDriverWait wait = new WebDriverWait(Util.driver,20);
            wait.until(ExpectedConditions.presenceOfElementLocated(btn));
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }
    /**
     * 滚动到指定元素位置
     */
    public void OperitionScrollToElement(WebElement element) {
        ((JavascriptExecutor) Util.driver).executeScript("arguments[0].scrollIntoView();", element);
        this.waitime(3000);
    }

    /**
     * 向下滑动800像素
     */
    public void OperitionScrollTo() {
        ((JavascriptExecutor) Util.driver).executeScript("window…scrollBy(0,800);");
        waitime(3000);
    }
    /**
     * 页面滚动直到元素出现
     */
    public void OperitionScrollToWebPage(String btn) {
        try {
            JavascriptExecutor js = (JavascriptExecutor) Util.driver;
            WebElement Element = SL.findElementByXpath(btn);
            js.executeScript("arguments[0].scrollIntoView():",Element);
            waitime(3000);
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }
    /**
     * 处理Alert提示框
     */
    public void DelAlete(boolean iscancel) {
        Alert alt = Util.driver.switchTo().alert();
        if (iscancel != false) {
            waitime(2000);
            alt.accept();
        } else {
            alt.dismiss();
        }
    }

    /**
     * 处理提示框里的输入框
     */
    public void DelAlterSendcase(String text, boolean iscancel) {
        Alert prompt = Util.driver.switchTo().alert();
        prompt.sendKeys(text);
        if (iscancel != false) {
            prompt.accept();
        } else {
            prompt.dismiss();
        }
    }

    /**
     * 处理ifream
     */
    public void swichTo(WebElement element) {
        Util.driver.switchTo().frame(element);
    }

    // 清除之前输入框的内容
    public void ClearTest(WebElement element) {
        if (element != null) {
            this.waitime(2000);
            element.clear();
        } else {
            System.out.println(element + "有错误！请检查");
        }
    }


    /**
     * 刷新页面
     */
    public void ReflshPage() {
        Util.driver.navigate().refresh();
        this.waitime(1000);
    }
    // 多个窗口切换
    public void getWindows() {
        Set winHandels = Util.driver.getWindowHandles();
        List it = new ArrayList(winHandels);
        Util.driver.switchTo().window((String) it.get(1));
        this.waitime(2500);
       // Util.driver.close();
        Util.driver.switchTo().window((String) it.get(0));
        this.waitime(1500);
        Util.driver.switchTo().window((String) it.get(2));
        this.waitime(1000);
    }

    // 多窗口切换
    public void ChangeWindows() {
       // Util.driver.getWindows();
        this.getWindows();
    }

    /*
     * 处理多窗口之间切换
     */
    public void switchWindow(){

        String currentWindow = Util.driver.getWindowHandle();// 获取当前窗口句柄
        Set<String> handles = Util.driver.getWindowHandles();// 获取所有窗口句柄
        System.out.println( "当前窗口数量： "+ handles.size());
        Iterator<String> it = handles.iterator();
        while (it.hasNext()) {
            if (currentWindow == it.next()) {
                continue;
            }
            try {
                //Util.driver.close();// 关闭旧窗口
                this.waitime(2000);
                WebDriver window = Util.driver.switchTo().window(it.next());// 切换到新窗口
                System.out.println("new page title is "+ window.getTitle());
                //Util.driver.close();
            } catch (Exception e) {
                System.out.println("无法切换到新打开窗口"+ e.getMessage());

            }
            this.waitime(2000);
           // Util.driver.close();//关闭当前焦点所在的窗口
        }
        Util.driver.close();
        Util.driver.switchTo().window(currentWindow);//回到原来页面
    }



   // 处理时间输入框–时间输入框的元素
//    public WebElement SendTime(String key) {
//        return Util.driver.findElement(GetLoctions.Loction(key));
//    }

    // 处理模态框
    public void Del_MoTai_Alter() {
        Util.driver.switchTo().activeElement();
    }
    // 处理模态框
    public void MoTaiBox() {
       // Util.driver.Del_MoTai_Alter();
        this.Del_MoTai_Alter();
    }
    //验证这个元素是否存在
    public void fnVerityWebElementExistance(String elmTicketTypeDropDown){
        boolean bFlag = false;
        String sExpectedResult = "Element:-"+elmTicketTypeDropDown+ "exost";
        String sActualResult = "Element:-"+elmTicketTypeDropDown+ "exost";
        try {
            this.OperitionScrollToWebPage(elmTicketTypeDropDown);
            this.waitime(2000);
            bFlag = SL.findElementByXpath(elmTicketTypeDropDown).isDisplayed();
        }catch (Exception ex){
            sActualResult = "Element:-"+elmTicketTypeDropDown+ "exost";
            ex.printStackTrace();
        }
        Assert.assertEquals(sExpectedResult,sActualResult);
    }

    //检查菜单元素
    public void theClickedElementLike(String arg0){
        String sExpectedValues = arg0;
        String[] arryElements = sExpectedValues.split("#");
        for(int iStart = 0; iStart<arryElements.length; iStart++){
            try{
                String myObject = "//a[contains(text(),'"+arryElements[iStart]+"')]";
                this.waitime(2000);
                this.fnVerityWebElementExistance(myObject);
            } catch (Exception e){
                e.printStackTrace();
            }
        }
    }
    //单击的记录将展开，以显示进一步的信息
    public void ClickedElementLike(String arg0){
        String sExpectedValues = arg0;
        String[] arryElements = sExpectedValues.split("#");
        for(int iStart = 0; iStart<arryElements.length; iStart++){
            try{
                String myObject = "//a[contains(text(),'"+arryElements[iStart]+"')]";
                this.waitime(2000);
                SL.findElementByXpathAndClick(myObject);
            } catch (Exception e){
                e.printStackTrace();
            }
        }
    }

    //单击的记录将展开，以显示进一步的信息
    public void ClickedElementLikespan(String arg0){
        String sExpectedValues = arg0;
        String[] arryElements = sExpectedValues.split("#");
        for(int iStart = 0; iStart<arryElements.length; iStart++){
            try{
                String myObject = "//span[contains(text(),'"+arryElements[iStart]+"')]";
                this.waitime(2000);
                SL.findElementByXpathAndClick(myObject);
            } catch (Exception e){
                e.printStackTrace();
            }
        }
    }

    //单击的记录将展开，以显示进一步的信息
    public void ClickedElementLikeLI(String arg0){
        String sExpectedValues = arg0;
        String[] arryElements = sExpectedValues.split("#");
        for(int iStart = 0; iStart<arryElements.length; iStart++){
            try{
                String myObject = "//li[text()='"+arryElements[iStart]+"']";
                this.waitime(2000);
                SL.findElementByXpathAndClick(myObject);
            } catch (Exception e){
                e.printStackTrace();
            }
        }
    }

}
