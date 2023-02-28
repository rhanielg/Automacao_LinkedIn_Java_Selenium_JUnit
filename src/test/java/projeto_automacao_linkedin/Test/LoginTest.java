package projeto_automacao_linkedin.Test;
import static org.junit.Assert.assertEquals;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import projeto_automacao_linkedin.PageObjects.LoginPO;


@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class LoginTest extends BaseTest {

public static LoginPO loginPage;

/** Criação de uma nova instância da página de login */
@BeforeClass
public static void prepararTestes(){
loginPage = new LoginPO(driver);
}

//#region Região dos métodos de testes, com os casos de testes executados
@Test
public void TC001_loginESenhaEmBranco(){
    loginPage.fazerLogin("", "");
    String mensagem = loginPage.obterMensagem();
    assertEquals(mensagem, "Insira seu e-mail ou número de celular.");
}

@Test
public void TC002_loginErradoESenhaEmBranco(){
    loginPage.fazerLogin("testandotestando@teste.com", "");
    String mensagem = loginPage.obterMensagem();
    assertEquals(mensagem, "Insira sua senha.");
}

@Test
public void TC003_loginEmBrancoESenhaErrada(){
    loginPage.fazerLogin("", "senhaInválida");
    String mensagem = loginPage.obterMensagem();
    assertEquals(mensagem, "Insira seu e-mail ou número de celular.");
}

@Test
public void TC004_loginESenhaErrados(){
    loginPage.fazerLogin("testandotestando@teste.com", "senhaInválida");
    String mensagem2 = loginPage.obterMensagem2();
    assertEquals(mensagem2, "Não foi possível encontrar uma conta do LinkedIn associada a este e-mail. Tente novamente ou crie uma conta .");
}
/** Esse método usa a função fazerLogin2 pois, após inserir dados inválidos, 
 o LinkedIn leva para uma nova página de login, onde os novos elementos precisam ser mapeados */
@Test
public void TC005_loginESenhaCorretos(){
    loginPage.fazerLogin2("emailVálido", "senhaVálida");
    String mensagem3 = loginPage.obterMensagem3();
    assertEquals(mensagem3, "LinkedIn Notícias");
}
//#endregion

}
