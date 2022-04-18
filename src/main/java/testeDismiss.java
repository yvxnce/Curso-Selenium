import org.junit.Test;
import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class testeDismiss {


    @Test
    public void testeDiss() {
        System.setProperty("webdriver.edge.driver", "C:\\Users\\jeffe\\IdeaProjects\\CursoSelenium\\drivers\\msedgedriver.exe");
        WebDriver driver = new EdgeDriver();
        driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
        driver.findElement(By.id("confirm")).click();
        Alert alerta = driver.switchTo().alert();
        alerta.dismiss();
        String texto = alerta.getText();
        System.out.println(texto);
        Assert.assertEquals("Negado", alerta.getText());

    }



    @Test
        public void testPrompt (){
        System.setProperty("webdriver.edge.driver", "C:\\Users\\jeffe\\IdeaProjects\\CursoSelenium\\drivers\\msedgedriver.exe");
        WebDriver driver = new EdgeDriver();
        driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
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



