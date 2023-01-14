import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DashboardPage {
    @FindBy(xpath = "//span[contains(text(),'PROCUREMENT MANAGEMENT')]")
    WebElement menuProc;

}
