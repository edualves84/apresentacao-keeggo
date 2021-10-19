package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Resultado {
    WebDriver driver;
    @FindBy (className =  "ui-search-breadcrumb__title")
    WebElement resultadoNotebook;

    public Resultado(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    public String  confirmaResultadoNotebook(){
        return resultadoNotebook.getText();

    }

}
