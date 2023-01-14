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
        // Login
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        LoginPage loginPage=new LoginPage(driver);
        loginPage.doLogin("Admin","admin123");

        // Click Admin
        Thread.sleep(2000);
        List<WebElement> sidebarMenu= driver.findElements(By.className("betternet-wrapper"));
        sidebarMenu.get(1).click();
        driver.findElement(By.partialLinkText("Admin")).click();
        Thread.sleep(5000);
    }
    @Test(priority = 2, testName = "TC02")
    public void admin() throws InterruptedException {
        // Read the label
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

        // Add User
        List<WebElement> menus = driver.findElements(By.className("oxd-main-menu-item--name"));
        menus.get(1).click();

        List<WebElement> add_btn = driver.findElements(By.className("oxd-button"));
        add_btn.get(2).click();

        Thread.sleep(2000);

        List<WebElement> input = driver.findElements(By.className("oxd-input"));
        input.get(1).sendKeys("Nazmus");
        input.get(2).sendKeys("Shakib");

        Thread.sleep(2000);

        List<WebElement> radio_btn = driver.findElements(By.className("oxd-switch-wrapper"));
        radio_btn.get(0).click();

        List<WebElement> input_ext = driver.findElements(By.className("oxd-input"));
        input.get(5).sendKeys("shakib");
        input.get(6).sendKeys("12345678");
        input.get(7).sendKeys("12345678");

        List<WebElement> submit = driver.findElements(By.className("oxd-button"));
        submit.get(1).click();

    }
    @Test(priority = 4, testName = "TC04")
    public void pim() throws InterruptedException {
        // Search the user
        Thread.sleep(2000);
        List<WebElement> sidebarMenu= driver.findElements(By.className("oxd-main-menu-search"));
        sidebarMenu.get(1).click();
        driver.findElement(By.partialLinkText("Search")).click();
        Thread.sleep(5000);
        driver.findElement(By.tagName("input")).sendKeys("shakib");
        List<WebElement> Searchbutton = driver.findElements(By.className("type=submit"));
        Searchbutton.get(0).click();

    }
}
