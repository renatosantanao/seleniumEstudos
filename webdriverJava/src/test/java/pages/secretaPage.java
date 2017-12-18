package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class secretaPage extends basePage {
    private WebDriver navegador;

    public secretaPage(WebDriver navegador) {
        super(navegador);
    }

    public mePage clicarEmMe(){
        // clicar no link que possui a class "me"
        navegador.findElement(By.className("me")).click();

        return  new mePage(navegador);
    }
}
