
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class LoginForm extends Settings{

    @FindBy(xpath = ".//*[@class='pop-title']")
    private WebElement authorizationTitle;

    @FindBy(xpath = ".//*[@id = 'login_name']")
    private WebElement login;

    @FindBy(xpath = ".//*[@id = 'login_password']")
    private WebElement password;

    @FindBy(xpath = ".//*[@class='pop-list form-login']/li[5]/*")
    private WebElement enterButton;

    @FindBy(xpath = ".//*[@class='siteEnter userEntered']/div[1]/p[contains(text(), 'Привет, ')]")
    private WebElement welcomeMessage;

    @FindBy(xpath = ".//*[@class='alertTitle']")
    private WebElement errorWelcomeMessage;

    @FindBy(xpath = ".//*[@class='enterProfile-list']/li[2]/a")
    private WebElement exitFromAccount;

    public LoginForm(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public String getAuthorizationTitle(){
        return authorizationTitle.getText();
    }

    public String getLoginTitle(){
        String login = driver.findElement(
                By.cssSelector("input[placeholder='Ваш логин']")).getAttribute("placeholder");
        return login;
    }

    public String getPasswordTitle(){
        String password = driver.findElement(
                By.cssSelector("input[placeholder='Ваш пароль']")).getAttribute("placeholder");
        return password;
    }

    public void enterLogin(String login){
        this.login.sendKeys(login);
    }

    public void enterPassword(String password){
        this.password.sendKeys(password);
    }

    public void clickEnter(){
        enterButton.click();
    }

    public void performEnter(String login, String password){
        enterLogin(login);
        enterPassword(password);
        clickEnter();
    }

    public String getWelcomeMessage(){
        return this.welcomeMessage.getText();
    }

    public String expectedWelcomeMessage(String login){
        return welcome = "Привет, "+login+"!";
    }

    public String getErrorWelcomeMessage(){
        return this.errorWelcomeMessage.getText();
    }

    public String expectedErrorWelcomeMessage(){
        return errorWelcome;
    }

    public boolean isEntered(String login){
        if(welcomeMessage.getText().equals(expectedWelcomeMessage(login)));
            return true;
    }

    public boolean notEntered(){
        if(errorWelcomeMessage.getText().equals(expectedErrorWelcomeMessage()));
        return true;
    }

    public void toExitFromAccount(){
        this.exitFromAccount.click();
    }




}
