
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends Settings{

    @FindBy(xpath = ".//*[@class='openPop'][contains(text(), 'Вход')]")
    private WebElement enterToAccount;

    @FindBy(xpath = ".//*[@id='mainNav']/li[2]/a")
    private  WebElement genreButton;

    public HomePage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public LoginForm clickAuthorization() {
        this.enterToAccount.click();
        return new LoginForm(this.driver);
    }

    public String getEnterButton(){
        return this.enterToAccount.getText();
    }

    public Submenu clickGenreButton(){
        this.genreButton.click();
        return new Submenu(this.driver);
    }

}
