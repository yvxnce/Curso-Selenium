import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class DSL {
    private final WebDriver driver;

    public DSL(WebDriver driver) {
        this.driver = driver;
    }

    public void escrever(String id_campo, String texto){
        driver.findElement(By.id(id_campo)).sendKeys(texto);

    }

    public void cadastrar(){
        driver.findElement(By.id("elementosForm:cadastrar")).click();

    }


    public void verificar(String texto){
        Alert alert = driver.switchTo().alert();
        String msg = alert.getText();
        Assert.assertEquals(texto, msg);

    }

    public void marcarHomem(){
        driver.findElement(By.id("elementosForm:sexo:0")).click();


    }


    public void marcarcarnevegan(){
        driver.findElement(By.id("elementosForm:comidaFavorita:0")).click();
        driver.findElement(By.id("elementosForm:comidaFavorita:3")).click();


    }

    public void marcarcarne() {
        driver.findElement(By.id("elementosForm:comidaFavorita:0")).click();

    }

    public void marcarvegan() {
        driver.findElement(By.id("elementosForm:comidaFavorita:3")).click();

    }

    public void marcaresporte(String esporte){
        WebElement element = driver.findElement(By.id("elementosForm:esportes"));
        Select combo = new Select(element );
        combo.selectByVisibleText(esporte);



    }
    public void escolaridade(String form){
        WebElement element = driver.findElement(By.id("elementosForm:escolaridade"));
        Select combo = new Select(element);
        combo.selectByVisibleText(form);

    }


}
