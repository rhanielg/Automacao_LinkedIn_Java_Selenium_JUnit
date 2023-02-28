package projeto_automacao_linkedin.PageObjects;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;


/**
 * Classe base para a criação de novas PageObjects. Todas as classes de PageObjects herdam dessa classe.
 */
public class BasePO {

/** Driver que será usado pelas pages */
public WebDriver driver;

/** Construtor base para o uso do PageFactory */
public BasePO(WebDriver driver){
    this.driver = driver;
    PageFactory.initElements(driver, this);
}

/** Método que sabe escrever em qualquer WebElement do tipo input */
public void escrever(WebElement input, String texto){
    input.clear();
    input.sendKeys(texto + Keys.TAB);
}
    
}
