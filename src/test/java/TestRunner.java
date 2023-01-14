import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class TestRunner extends Setup {
    @Test(priority = 1,description = "User can login successfully",testName = "TC01")
    public void doLogin(){
        driver.get("https://erp.madina.co/");
        LoginPage loginPage=new LoginPage(driver);
        loginPage.doLogin("parvej@madina.co","madina@123");

        List<WebElement> txtLabel= driver.findElements(By.tagName("b"));
        String welcomeMessage_Actual= txtLabel.get(0).getText();
        String welcomeMessage_Expected="Welcome to Madina ERP";
        Assert.assertEquals(welcomeMessage_Actual,welcomeMessage_Expected);
    }
    @Test(priority = 2)
    public void clickOnProcurementMenu() throws InterruptedException {
        Thread.sleep(2000);
        driver.findElement(By.xpath("//span[contains(text(),'PROCUREMENT MANAGEMENT')]")).click();
        List<WebElement> sidebarMenu= driver.findElements(By.className("sidebar-dropdown"));
        sidebarMenu.get(1).click();
        driver.findElement(By.partialLinkText("Standard PR")).click();
        Thread.sleep(5000);
        Assert.assertEquals(driver.findElement(By.xpath("//h6[contains(text(),'Standard Purchase Request')]")).getText(),"Standard Purchase Request");

    }
    @Test(priority = 3)
    public void selectWareHouse() throws InterruptedException {
        List <WebElement> dropdowns= driver.findElements(By.className("ant-select-selection-item"));
        dropdowns.get(2).click();
        Actions actions=new Actions(driver);
        actions.sendKeys(Keys.ARROW_DOWN).perform();
        Thread.sleep(500);
        actions.sendKeys(Keys.ARROW_DOWN).perform();
        Thread.sleep(500);
        actions.sendKeys(Keys.ENTER).perform();


    }
    @Test(priority = 4)
    public void createProcurement() throws InterruptedException {
        List<WebElement> buttons= driver.findElements(By.cssSelector("[type=button]"));
        buttons.get(0).click();
        driver.findElement(By.cssSelector("[placeholder='Required Date']")).click();
        driver.findElement(By.cssSelector("[placeholder='Required Date']")).sendKeys(Keys.CONTROL+"a");
        driver.findElement(By.cssSelector("[placeholder='Required Date']")).sendKeys(Keys.BACK_SPACE);
        driver.findElement(By.cssSelector("[placeholder='Required Date']")).sendKeys("2022-12-30");
        driver.findElement(By.cssSelector("[placeholder='Required Date']")).sendKeys(Keys.ENTER);
        driver.findElement(By.cssSelector("[placeholder=Remarks]")).sendKeys("Test");
        Thread.sleep(2000);
        driver.findElements(By.cssSelector("[type=search]")).get(1).sendKeys("Madina Super",Keys.ENTER);
        driver.findElement(By.cssSelector("[placeholder=Quantity]")).sendKeys("5");
        driver.findElement(By.cssSelector("[placeholder='Use For']")).sendKeys("Test");
        driver.findElements(By.cssSelector("[type=search]")).get(2).sendKeys("Audit", Keys.ENTER);
        Thread.sleep(2000);
        driver.findElements(By.tagName("button")).get(3).click();
    }
}
