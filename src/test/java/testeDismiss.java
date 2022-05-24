import org.junit.Before;
import org.junit.Test;
import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class testeDismiss {
public WebDriver driver;

    @Before
    public void Iniciliza(){
        System.setProperty("webdriver.edge.driver", "C:\\Users\\joaog\\IdeaProjects\\CursoSelenium\\drivers\\msedgedriver.exe");
        driver = new EdgeDriver();
        driver.get("file:///" + System.getProperty("user.dir") + "/src/test/resources/componentes.html");
        driver.manage().window().maximize();

    }

    @Test
    public void testeDiss() {

        driver.findElement(By.id("confirm")).click();
        Alert alerta = driver.switchTo().alert();
        alerta.dismiss();
        String texto = alerta.getText();
        Assert.assertEquals("Negado", texto);

    }

    @Test
    public void testeAcc() {

        driver.findElement(By.id("confirm")).click();
        Alert alerta = driver.switchTo().alert();
        alerta.accept();
        String texto = alerta.getText();
        Assert.assertEquals("Confirmado", texto);


    }


    @Test
        public void testPrompt (){

        driver.findElement(By.id("prompt")).click();
        Alert alerta = driver.switchTo().alert();
        Assert.assertEquals("Digite um numero", alerta.getText());
        alerta.sendKeys("3");
        alerta.accept();
        Assert.assertEquals("Era 3?", alerta.getText());
        alerta.accept();
        Assert.assertEquals(":D", alerta.getText());
        alerta.accept();







        }







    }



