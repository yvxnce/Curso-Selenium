import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

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
}
