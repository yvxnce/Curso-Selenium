import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;

public class TestUm {
    private DSL dsl;
    private WebDriver driver;

    @Before
    public void inicializa() {
        System.setProperty("webdriver.edge.driver", "C:\\Users\\joaog\\IdeaProjects\\CursoSelenium\\drivers\\msedgedriver.exe");
        driver = new EdgeDriver();
        driver.get("file:///" + System.getProperty("user.dir") + "/src/test/resources/componentes.html");
        driver.manage().window().maximize();
        dsl = new DSL(driver);
    }

    @Test
    public void TestFull() {
        driver.findElement(By.id("elementosForm:nome")).sendKeys("1");
        Assert.assertEquals("1","1");
        driver.findElement(By.id("elementosForm:sobrenome")).sendKeys("2");
        Assert.assertEquals("2","2");
        driver.findElement(By.id("elementosForm:sexo:0")).click();
        Assert.assertTrue(driver.findElement(By.id("elementosForm:sexo:0")).isSelected());
        driver.findElement(By.id("elementosForm:comidaFavorita:0")).click();
        Assert.assertTrue(driver.findElement(By.id("elementosForm:comidaFavorita:0")).isSelected());
        WebElement element = driver.findElement(By.id("elementosForm:escolaridade"));
        Select combo = new Select(element);
        combo.selectByVisibleText("Superior");
        Assert.assertEquals("Superior", combo.getFirstSelectedOption().getText());
        driver.findElement(By.id("elementosForm:sugestoes")).sendKeys("Oi");
        Assert.assertEquals("Oi","Oi");
        driver.findElement(By.id("elementosForm:cadastrar")).click();
    }

}