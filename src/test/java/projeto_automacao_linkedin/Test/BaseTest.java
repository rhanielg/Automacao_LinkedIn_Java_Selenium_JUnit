package projeto_automacao_linkedin.Test;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/*
 * Classe base que serve de herança para todas as classes de testes.
 */
public class BaseTest {

/*Driver do navegador da página atual.*/
public static WebDriver driver;
/*URL do sistema a ser testado */
private static final String URL_BASE = "https://www.linkedin.com/home";
/**Caminho do driver do projeto referente ao path */
private static final String CAMINHO_DRIVER = "src/test/java/projeto_automacao_linkedin/Resources/chromedriver.exe";


/**
 * Método para iniciar o driver do navegador antes de qualquer classe de teste
 */
@BeforeClass
public static void iniciar(){
    System.setProperty("webdriver.chrome.driver", CAMINHO_DRIVER);
    driver = new ChromeDriver();
    driver.manage().window().maximize();
    driver.get(URL_BASE);
    }

/**
 * Método para finaliza o driver do navegador depois de qualquer classe de teste
 */
@AfterClass
public static void finalizar(){
    driver.quit();
    } 
    
}
