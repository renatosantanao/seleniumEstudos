package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class basePage {
    protected WebDriver navegador;

    public  basePage(WebDriver navegador){
        this.navegador = navegador;
    }

    public String capturarMensagemToast(){
        return navegador.findElement(By.id("toast-container")).getText();
    }
}
