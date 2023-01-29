
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import java.util.concurrent.TimeUnit;

public class Behavior extends Settings{

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver",
                "C:\\Users\\Anna\\Desktop\\chromedriver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        try {
            driver.get(siteHomePage);
            homePage = (HomePage) PageFactory.initElements(driver, HomePage.class);
            //driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
            System.out.println("WORK WITH LOGIN FORM");
            System.out.println("We have enter button on the home page: "+homePage.getEnterButton()+
                    "\nSo click on it...");
            loginForm = homePage.clickAuthorization();
            System.out.println("Now we have login form: \nAuthorization title: "+loginForm.getAuthorizationTitle()
                    +"\nLogin field: "+loginForm.getLoginTitle()+"\nPassword field: "+loginForm.getPasswordTitle());
            System.out.println("Entering data...");
            loginForm.enterLogin("shesstaya");
            loginForm.enterPassword("shesstaya.21");
            loginForm.clickEnter();
            System.out.println("If we have logged in there should be message: "+
                    loginForm.expectedWelcomeMessage("shesstaya")+
                    "\nThe actual result: "+loginForm.getWelcomeMessage());
            System.out.println("Quitting from the account...");
            loginForm.toExitFromAccount();
            System.out.println("After quitting there should be enter button again." +
                    "\nEnter button: "+homePage.getEnterButton());
            System.out.println("Try to input invalid login and password..");
            loginForm = homePage.clickAuthorization();
            loginForm.performEnter("VasyaPupkin", "ladyLover12345");
            System.out.println("Expected message: "+loginForm.getErrorWelcomeMessage()+
                    "\nThe actual message: "+loginForm.getErrorWelcomeMessage());
            System.out.println("WORK WITH SUBCOMPONENTS");
            System.out.println("Choosing element with dropdown menu...");
            submenu = homePage.clickGenreButton();
            System.out.println("Get list of subcomponents..");
            System.out.println(submenu.getGenresList());
            System.out.println("Choose one of the subcomponents..");
            System.out.println("This component is '"+submenu.goToSubcomponent()+"'");
            System.out.println("Get list of elements of chosen subcomponent..");
            System.out.println(submenu.getSubcomponentGenresList());
            driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
            driver.quit();
        }catch (Throwable cause) {
            cause.printStackTrace();
            driver.quit();
        }
    }
}
