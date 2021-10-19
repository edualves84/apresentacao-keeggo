package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Home {
    WebDriver driver;

    @FindBy (name = "as_word")
    WebElement caixaDePesquisa;

    @FindBy (className = "nav-icon-search")
    WebElement botaoLupa;

    public Home(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements( driver, this);
    }
    public void pesquisarNotebook (String arg0){
        caixaDePesquisa.sendKeys(arg0);

    }
    public void clicarNaLupa(){
        botaoLupa.click();

    }
}
