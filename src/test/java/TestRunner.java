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
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        LoginPage loginPage=new LoginPage(driver);
        loginPage.doLogin("Admin","admin123");

        Thread.sleep(2000);
        List<WebElement> sidebarMenu= driver.findElements(By.className("betternet-wrapper"));
        sidebarMenu.get(1).click();
        driver.findElement(By.partialLinkText("Admin")).click();
        Thread.sleep(5000);
    }
    @Test(priority = 2, testName = "TC02")
    public void admin() throws InterruptedException {
        Thread.sleep(2000);
        List<WebElement> txtLabel= driver.findElements(By.className("oxd-text oxd-text--h5 oxd-table-filter-title"));
        String userName_Actual= txtLabel.get(0).getText();
        String userName_Expected="System Users";
        Assert.assertEquals(userName_Actual,userName_Expected);

    }
    @Test(priority = 3, testName = "TC03")
    public void pim() throws InterruptedException {
        Thread.sleep(2000);
        List<WebElement> sidebarMenu= driver.findElements(By.className("oxd-main-menu-item"));
        sidebarMenu.get(1).click();
        driver.findElement(By.partialLinkText("PIM")).click();
        Thread.sleep(5000);

    }
    @Test(priority = 4, testName = "TC04")
    public void pim() throws InterruptedException {
        Thread.sleep(2000);
        List<WebElement> sidebarMenu= driver.findElements(By.className("oxd-main-menu-search"));
        sidebarMenu.get(1).click();
        driver.findElement(By.partialLinkText("Search")).click();
        Thread.sleep(5000);

    }
}
