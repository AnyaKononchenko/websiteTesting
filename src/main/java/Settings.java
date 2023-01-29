
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.List;


public abstract class Settings {
    static WebDriver driver;
    static final String siteHomePage = "https://english-films.com/";
    protected String password;
    protected String login;
    protected String authorization;
    protected String welcome;
    protected String errorWelcome = "ОШИБКА АВТОРИЗАЦИИ";
    protected String enter = "Вход";
    protected List<String> listSubmenuComponents;
    protected WebElement component;
    static String name;
    static HomePage homePage;
    static LoginForm loginForm;
    static Submenu submenu;
}
