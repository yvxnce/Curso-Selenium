import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;

public class TesteCompletoRegras {

    @Test
    public void testeNome() {
        System.setProperty("webdriver.edge.driver", "C:\\Users\\jeffe\\IdeaProjects\\CursoSelenium\\drivers\\msedgedriver.exe");
        WebDriver driver = new EdgeDriver();
        driver.get("file:///" + System.getProperty("user.dir") + "/src/test/resources/componentes.html");
        driver.findElement(By.id("elementosForm:nome"));
        driver.findElement(By.id("elementosForm:cadastrar")).click();
        Alert alert = driver.switchTo().alert();
        String msg = alert.getText();
        Assert.assertEquals("Nome eh obrigatorio", msg);
    }

    @Test
    public void testeSobrenome() {
        System.setProperty("webdriver.edge.driver", "C:\\Users\\jeffe\\IdeaProjects\\CursoSelenium\\drivers\\msedgedriver.exe");
        WebDriver driver = new EdgeDriver();
        driver.get("file:///" + System.getProperty("user.dir") + "/src/test/resources/componentes.html");
        driver.findElement(By.id("elementosForm:nome")).sendKeys("Joao");
        driver.findElement(By.id("elementosForm:sobrenome"));
        driver.findElement(By.id("elementosForm:cadastrar")).click();
        Alert alert = driver.switchTo().alert();
        String msg = alert.getText();
        Assert.assertEquals("Sobrenome eh obrigatorio", msg);


    }


    @Test
    public void testeSexo() {
        System.setProperty("webdriver.edge.driver", "C:\\Users\\jeffe\\IdeaProjects\\CursoSelenium\\drivers\\msedgedriver.exe");
        WebDriver driver = new EdgeDriver();
        driver.get("file:///" + System.getProperty("user.dir") + "/src/test/resources/componentes.html");
        driver.findElement(By.id("elementosForm:nome")).sendKeys("Joao");
        driver.findElement(By.id("elementosForm:sobrenome")).sendKeys("Pires");
        driver.findElement(By.id("elementosForm:cadastrar")).click();
        Alert alert = driver.switchTo().alert();
        String msg = alert.getText();
        Assert.assertEquals("Sexo eh obrigatorio", msg);
    }

    @Test
    public void testeComida() {
        System.setProperty("webdriver.edge.driver", "C:\\Users\\jeffe\\IdeaProjects\\CursoSelenium\\drivers\\msedgedriver.exe");
        WebDriver driver = new EdgeDriver();
        driver.get("file:///" + System.getProperty("user.dir") + "/src/test/resources/componentes.html");
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
        System.setProperty("webdriver.edge.driver", "C:\\Users\\jeffe\\IdeaProjects\\CursoSelenium\\drivers\\msedgedriver.exe");
        WebDriver driver = new EdgeDriver();
        driver.get("file:///" + System.getProperty("user.dir") + "/src/test/resources/componentes.html");
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
