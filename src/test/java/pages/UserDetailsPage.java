package pages;

import lombok.Data;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.Driver;
@Data
public class UserDetailsPage {

    public UserDetailsPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }



    @FindBy(name =  "email")
    private WebElement emailField;

    @FindBy(xpath = "//button[.='SAVE']")
    private WebElement saveButton;

    @FindBy(xpath = "//span[.='Update successful']")
    private WebElement updateSuccessMessage;


    public void enterNewEmailAndSave(String newEmail){
        emailField.clear();
        emailField.sendKeys(newEmail);
         saveButton.click();
    }


}
