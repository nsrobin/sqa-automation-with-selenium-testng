import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class AdminPage {
    @FindBy(className = "oxd-text oxd-text--h5 oxd-table-filter-title")

    public AdminPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }
    public void admin(){
        btnSubmit.click();
    }

}
