package pages;

import lombok.Data;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.Driver;

@Data
public class PlaylistPage {


    @FindBy(xpath = "//button[.='NEW PLAYLIST']")
    private WebElement newPlaylistButton;



    public PlaylistPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }


    public void clickOnPlaylistByName(String name){
        Driver.getDriver().findElement(By.xpath("//div[@class='gridViewInfo'][.='"+name+"']")).click();
    }
}
