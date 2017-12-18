package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class mePage extends basePage{

    public mePage(WebDriver navegador) {

        super(navegador);
    }

    public mePage clicarAbaMoreDataAboutYou(){
        // clicar no link que possui "More data about you"
        navegador.findElement(By.linkText("MORE DATA ABOUT YOU")).click();

        return this;
    }

    public addContactPage clicarBotaoAddMoreDataAboutYou(){
        // clicar no botão atráves do seu xpath //[@data-target="addmoredata"]
        navegador.findElement(By.xpath("//button[@data-target=\"addmoredata\"]")).click();

        return new addContactPage(navegador);
    }
}
