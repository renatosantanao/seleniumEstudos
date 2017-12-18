package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class loginformpage extends basePage {

    public loginformpage(WebDriver navegador) {

        super(navegador);
    }

    public loginformpage typeLogin(String login){
        navegador.findElement(By.id("signinbox")).findElement(By.name("login")).sendKeys(login);

        return this;
    }

    public loginformpage typePassword(String password){
        navegador.findElement(By.id("signinbox")).findElement(By.name("password")).sendKeys(password);

        return  this;
    }

    public secretaPage clicarSignIn(){
        navegador.findElement(By.linkText("SIGN IN")).click();

        return new secretaPage(navegador);
    }

    public secretaPage fazerLogin(String login, String senha){
        typeLogin(login);
        typePassword(senha);
        clicarSignIn();

        return new secretaPage(navegador);
    }
}
