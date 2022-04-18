import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;

public class TesteCompletoRegras {

    public WebDriver driver;


    @Before
    public void inicializa(){
        System.setProperty("webdriver.edge.driver", "C:\\Users\\jeffe\\IdeaProjects\\CursoSelenium\\drivers\\msedgedriver.exe");
        driver = new EdgeDriver();
        driver.get("file:///" + System.getProperty("user.dir") + "/src/test/resources/componentes.html");
    }

    @Test
    public void testeNome() {
        driver.findElement(By.id("elementosForm:nome"));
        driver.findElement(By.id("elementosForm:cadastrar")).click();
        Alert alert = driver.switchTo().alert();
        String msg = alert.getText();
        Assert.assertEquals("Nome eh obrigatorio", msg);
    }

    @Test
    public void testeSobrenome() {
        driver.findElement(By.id("elementosForm:nome")).sendKeys("Joao");
        driver.findElement(By.id("elementosForm:cadastrar")).click();
        Alert alert = driver.switchTo().alert();
        String msg = alert.getText();
        Assert.assertEquals("Sobrenome eh obrigatorio", msg);


    }


    @Test
    public void testeSexo() {
        driver.findElement(By.id("elementosForm:nome")).sendKeys("Joao");
        driver.findElement(By.id("elementosForm:sobrenome")).sendKeys("Pires");
        driver.findElement(By.id("elementosForm:cadastrar")).click();
        Alert alert = driver.switchTo().alert();
        String msg = alert.getText();
        Assert.assertEquals("Sexo eh obrigatorio", msg);
    }

    @Test
    public void testeComida() {
        driver.findElement(By.id("elementosForm:nome")).sendKeys("Joao");
        driver.findElement(By.id("elementosForm:sobrenome")).sendKeys("Pires");
        driver.findElement(By.id("elementosForm:sexo:0")).click();
        driver.findElement(By.id("elementosForm:comidaFavorita:0")).click();
        driver.findElement(By.id("elementosForm:comidaFavorita:3")).click();
        driver.findElement(By.id("elementosForm:cadastrar")).click();
        Alert alert = driver.switchTo().alert();
        String msg = alert.getText();
        Assert.assertEquals("Tem certeza que voce eh vegetariano?", msg);


    }
    @Test
    public void testeEsporte() {
        driver.findElement(By.id("elementosForm:nome")).sendKeys("Joao");
        driver.findElement(By.id("elementosForm:sobrenome")).sendKeys("Pires");
        driver.findElement(By.id("elementosForm:sexo:0")).click();
        driver.findElement(By.id("elementosForm:comidaFavorita:0")).click();
        WebElement element = driver.findElement(By.id("elementosForm:esportes"));
        Select combo = new Select(element );
        combo.selectByVisibleText("Natacao");
        combo.selectByVisibleText("Corrida");
        combo.selectByVisibleText("O que eh esporte?");
        driver.findElement(By.id("elementosForm:cadastrar")).click();
        Alert alert = driver.switchTo().alert();
        String msg = alert.getText();
        Assert.assertEquals("Voce faz esporte ou nao?", msg);

}

}
