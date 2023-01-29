import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

public class Testing extends Settings {

    private HomePage homePage;
    private LoginForm loginForm;
    private  Submenu submenu;

    public Testing(){}

    @Before
    public void testBeforeClass() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Anna\\Desktop\\it\\chromedriver_win32\\chromedriver.exe");
        this.driver = new ChromeDriver();
        this.driver.get(this.siteHomePage);
    }

    @Test
        public void checkLoginFormPresence(){
        System.out.println("TEST 'IF LOGIN FORM IS PRESENT'");
        homePage = PageFactory.initElements(this.driver, HomePage.class);
        loginForm = homePage.clickAuthorization();
        System.out.println("Checking if there is login form..");
        System.out.println(authorization = loginForm.getAuthorizationTitle());
        System.out.println(login = loginForm.getLoginTitle());
        System.out.println(password = loginForm.getPasswordTitle());
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        Assert.assertEquals("Авторизация", authorization);
        Assert.assertEquals("Ваш логин", login);
        Assert.assertEquals("Ваш пароль", password);
    }

    @Test
    public void testWelcomeMessage(){
        System.out.println("TEST 'IF WE GET WELCOME MESSAGE'");
        login = "shesstaya";
        password = "shesstaya.21";
        homePage = PageFactory.initElements(this.driver, HomePage.class);
        System.out.println("Performing authorization...");
        loginForm = homePage.clickAuthorization();
        System.out.println("Inputting login and password..");
        loginForm.performEnter(login,password);
        System.out.println("Expected Welcome Message: "+loginForm.expectedWelcomeMessage(login));
        System.out.println("Our Welcome Message: "+loginForm.getWelcomeMessage());
        Assert.assertTrue(loginForm.isEntered(login));
    }

    @Test
    public void testErrorWelcomeMessage(){
        System.out.println("TEST 'IF WE GET ERROR MESSAGE'");
        login = "whatshappening";
        password = "nothinggood";
        homePage = PageFactory.initElements(this.driver, HomePage.class);
        System.out.println("Performing authorization...");
        loginForm = homePage.clickAuthorization();
        System.out.println("Inputting invalid login and password..");
        loginForm.performEnter(login,password);
        System.out.println("Expected Welcome Message: "+ loginForm.expectedErrorWelcomeMessage());
        System.out.println("Our Welcome Message: "+loginForm.getErrorWelcomeMessage());
        Assert.assertTrue(loginForm.notEntered());
    }

    @Test
    public void testSuccessfulExit(){
        System.out.println("TEST 'IF WE CAN QUIT FROM THE ACCOUNT'");
        login = "shesstaya";
        password = "shesstaya.21";
        homePage = PageFactory.initElements(this.driver, HomePage.class);
        System.out.println("Performing authorization...");
        loginForm = homePage.clickAuthorization();
        System.out.println("Inputting login and password..");
        loginForm.performEnter(login,password);
        System.out.println("User entered account, welcome message: "+loginForm.getWelcomeMessage());
        System.out.println("Performing quitting from the account..");
        loginForm.toExitFromAccount();
        System.out.println("User have quited, because we have button "+homePage.getEnterButton());
        Assert.assertEquals(enter,homePage.getEnterButton());
    }

    @Test
    public void testSubmenuIsPresent(){
        System.out.println("TEST 'IF CATEGORY HAS ITS DROPDOWN MENU'");
        homePage = PageFactory.initElements(this.driver, HomePage.class);
        System.out.println("Choosing element with dropdown menu...");
        submenu = homePage.clickGenreButton();
        System.out.println("Dropdown menu has the following list: "+submenu.getGenresList());
        System.out.println("It has "+submenu.getListSize()+" elements.");
        Assert.assertFalse(submenu.isEmpty());
    }

    @Test
    public void testSubmenuComponentsIsFunctional(){
        System.out.println("TEST 'IF ELEMENT FORM DROPDOWN MENU IS FUNCTIONAL'");
        homePage = PageFactory.initElements(this.driver, HomePage.class);
        System.out.println("Choosing element with dropdown menu...");
        submenu = homePage.clickGenreButton();
        System.out.println("Get list of subcomponents..");
        submenu.getGenresList();
        Assert.assertFalse(submenu.sequence());
    }

    @After
    public void testAfterClass() {
        this.driver.close();
    }
}
