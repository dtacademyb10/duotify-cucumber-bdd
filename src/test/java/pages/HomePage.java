package pages;

import io.cucumber.java.de.Wenn;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.Driver;

public class HomePage {


    public HomePage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }


    @FindBy (id = "hideLogin")
    private WebElement signUpLink;

    public void clickOnSignUpLink(){
        signUpLink.click();
    }

}
