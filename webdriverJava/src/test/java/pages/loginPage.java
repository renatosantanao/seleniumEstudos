package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class loginPage extends  basePage{

    public loginPage(WebDriver navegador) {
        super(navegador);
    }

    public loginformpage clicarSignin(){
        /* clicar no link que tem o texto sign in */
        navegador.findElement(By.linkText("Sign in")).click();

        return new loginformpage(navegador);
    }
}
