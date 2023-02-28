package projeto_automacao_linkedin.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPO extends BasePO {

//#region Região dos WebElements com os quais o driver interage
@FindBy(id = "session_key")
public WebElement inputEmail;

@FindBy(className = "sign-in-form__submit-button")
public WebElement buttonAvancar;

@FindBy(className = "login__form_action_container")
public WebElement buttonEntrar;

@FindBy(id = "session_password")
public WebElement inputSenha;

@FindBy(className = "search-global-typeahead__input")
public WebElement inputPesquisa;

@FindBy(className = "alert-content")
public WebElement inputMensagem;

@FindBy(id = "error-for-username")
public WebElement inputMensagem2;

@FindBy(id = "news-module__title")
public WebElement inputMensagem3;

@FindBy(id = "username")
public WebElement inputEmail2;

@FindBy(id = "password")
public WebElement inputSenha2;
//#endregion dos WebElements

/** Método que obtém a primeira mensagem de erro da página de login */
public String obterMensagem(){
    return this.inputMensagem.getText(); 
}

/** Método que obtém a segunda mensagem de erro da página de login */
public String obterMensagem2(){
    return this.inputMensagem2.getText(); 
}

/** Método que mensagem para validação do teste após inserir e-mail e senha válidos */
public String obterMensagem3(){
    return this.inputMensagem3.getText(); 
}

/** Construtor padrão para criação de uma nova instância da pagina de login */
public LoginPO(WebDriver driver) {
    super(driver);
}

/** Método que faz o input de e-mail e senha na primeira tela de login */
public void fazerLogin(String email, String senha){
    escrever(inputEmail, email);
    escrever(inputSenha, senha);
    buttonAvancar.click();
}

/** Método que faz o input de e-mail e senha na segunda tela de login, que aparece após inserir informações inválidas */
public void fazerLogin2(String email2, String senha2){
    escrever(inputEmail2, email2);
    escrever(inputSenha2, senha2);
    buttonEntrar.click();
}

}
