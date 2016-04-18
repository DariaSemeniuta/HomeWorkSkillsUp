import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

/**
 * Created by Daria on 18.04.2016.
 */
public class TestSkillsUp extends BaseTest{
    public String startPage = "http://skillsup.ua/";
    private By aboutUs = By.linkText("О нас");
    private By ourTeam = By.linkText("Наша команда");
    private By coachPresent1=By.xpath("//div[@class='team-list clearfix']/div[@class='member']/a/span[contains(text(),'Александр Галковский')]");
    private By coachPresent2=By.xpath("//div[@class='team-list clearfix']/div[@class='member']/a/span[contains(text(),'Михаил Чокан')]");
    private By coachAbsent=By.xpath("//div[@class='team-list clearfix']/div[@class='member']/a/span[contains(text(),'Артем Карпов')]");
    private String nameCoach1="Александр Галковский";
    private String nameCoach2="Михаил Чокан";
    private WebElement element;
    private Actions action;

    @Test
    public void test1() throws Exception{
        setUp(startPage);
        action = new Actions(driver);
        element=driver.findElement(aboutUs);
        action.moveToElement(element);
        element=driver.findElement(ourTeam);
        action.moveToElement(element);
        action.click().build().perform();
        element=driver.findElement(coachPresent1);
        assertEquals(nameCoach1,element.getText());
        element=driver.findElement(coachPresent2);
        assertEquals(nameCoach2,element.getText());
        try{
            element=driver.findElement(coachAbsent);
        }
        catch (NoSuchElementException e){
            System.out.println("Артема нет в списке тренеров");
        }


    }
}
