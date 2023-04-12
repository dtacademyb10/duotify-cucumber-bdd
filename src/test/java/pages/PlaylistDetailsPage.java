package pages;

import lombok.Data;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.Driver;
@Data
public class PlaylistDetailsPage {

    @FindBy(xpath = "//button[.='DELETE PLAYLIST']")
    private WebElement deletePlaylistButton;



    public PlaylistDetailsPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

}
