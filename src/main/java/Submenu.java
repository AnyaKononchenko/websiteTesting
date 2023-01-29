import org.junit.jupiter.api.MethodOrderer;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class Submenu extends Settings{

    @FindBy(xpath = ".//*[@id='mainNav']/li[2]/ul/li")
    private List<WebElement> genresList;

    @FindBy(xpath = ".//*[@id='dle-content']/*/div/div[2]/div[2]/dl[6]")
    private List<WebElement> subcomponentGenres;



    public Submenu(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public int chooseRandomly(){
        int index = 1 + (int) (Math.random() * 20);
        return index;
    }

    public WebElement chooseSubcomponent(int i){
        WebElement subcomponent = driver.
                findElement(By.xpath(".//*[@id='mainNav']/li[2]/ul/li["+i+"]/*"));
        return subcomponent;
    }

    public String goToSubcomponent(){
        int index = chooseRandomly();
        component = chooseSubcomponent(index);
        return name = clickOnName(component);
    }

    public String clickOnName(WebElement component){
        name = component.getText();
        System.out.println("Name of chosen subcomponent: "+ name);
        component.click();
        return name;
    }

    public boolean lookForGenres(String name){
        getSubcomponentGenresList();
        boolean flag = true;
        for (int i=0; i<listSubmenuComponents.size(); i++)
            if(listSubmenuComponents.get(i).contains(name))
                flag = true;
            else
                flag = false;
        return flag;
    }

    public boolean sequence(){
        return lookForGenres(goToSubcomponent());
    }



    public void setGenresList(){
        listSubmenuComponents = new ArrayList<String>();
        for(int i=0; i<genresList.size(); i++){
            genresList.get(i).getText();
            listSubmenuComponents.add("\n"+genresList.get(i).getText());
        }
    }

    public List<String> getGenresList(){
        setGenresList();
        return listSubmenuComponents;
    }

    public List<String> getSubcomponentGenresList(){
        listSubmenuComponents = new ArrayList<String>();
        for(int i=0; i<15; i++){
            System.out.println(subcomponentGenres.get(i).getText());
            listSubmenuComponents.add("\n"+subcomponentGenres.get(i).getText());
        }
        return listSubmenuComponents;
    }

    public int getListSize(){
        return listSubmenuComponents.size();
    }


    public boolean isEmpty() {
        if (listSubmenuComponents.size() == 0)
            return true;
        else
            return false;
    }

}
