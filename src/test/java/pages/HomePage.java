package pages;

import com.github.javafaker.Faker;
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

    public void clickOnRegisterButton(){
        registerButton.click();
    }


    @FindBy (id = "username")
    private WebElement username;
    @FindBy (id = "firstName")
    private WebElement firstName;
    @FindBy (id = "lastName")
    private WebElement lastName;

    @FindBy (id = "email")
    private WebElement email;

    @FindBy (id = "email2")
    private WebElement email2;

    @FindBy (id = "password")
    private WebElement password;


    @FindBy (id = "password2")
    private WebElement password2;

    @FindBy (name = "registerButton")
    private WebElement registerButton;

    public WebElement getEmailErrorMessage() {
        return emailErrorMessage;
    }

    @FindBy (xpath = "//span[.='This email is already in use']")
    private WebElement emailErrorMessage;




    public void fillTheFormWithRandomData(){
        Faker faker = new Faker();
        username.sendKeys(faker.name().username());
        firstName.sendKeys(faker.name().firstName());
        lastName.sendKeys(faker.name().lastName());
        String email = faker.internet().emailAddress();
        this.email.sendKeys(email);
        this.email2.sendKeys(email);
        String pass = faker.internet().password();
        this.password.sendKeys(pass);
        this.password2.sendKeys(pass);

    }

    public void enterInvalidEmailAddress() {

        Faker faker = new Faker();
        username.sendKeys(faker.name().username());
        firstName.sendKeys(faker.name().firstName());
        lastName.sendKeys(faker.name().lastName());
        String email = faker.internet().emailAddress();
        this.email.sendKeys("duotech2023@gmail.com");
        email2.sendKeys("duotech2023@gmail.com");
        String pass = faker.internet().password();
        this.password.sendKeys(pass);
        this.password2.sendKeys(pass);


    }
}
