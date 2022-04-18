import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class TesteIframeEJanelas {


    @Test
    public void testeClickFrame() {
        System.setProperty("webdriver.edge.driver", "C:\\Users\\jeffe\\IdeaProjects\\CursoSelenium\\drivers\\msedgedriver.exe");
        WebDriver driver = new EdgeDriver();
        driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");

        driver.switchTo().frame("frame1");
        driver.findElement(By.id("frameButton")).click();
        Alert alert = driver.switchTo().alert();
        String msg = alert.getText();
        Assert.assertEquals("Frame OK!", msg);
        alert.accept();
        driver.switchTo().defaultContent();
        driver.findElement(By.id("elementosForm:nome")).sendKeys(msg);

    }
        @Test
        public void DeveInteragirJanelas(){
            System.setProperty("webdriver.edge.driver", "C:\\Users\\jeffe\\IdeaProjects\\CursoSelenium\\drivers\\msedgedriver.exe");
            WebDriver driver = new EdgeDriver();
            driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");

            driver.findElement(By.id("buttonPopUpEasy")).click();
            driver.switchTo().window("Popup");
            driver.findElement(By.tagName("textarea")).sendKeys("Deu certo?");
            driver.close();
            driver.switchTo().window("");
            driver.findElement(By.tagName("textarea")).sendKeys("Deu certo?");
        }

    @Test
    public void DeveInteragirJanelasSemTitulo() {
        System.setProperty("webdriver.edge.driver", "C:\\Users\\jeffe\\IdeaProjects\\CursoSelenium\\drivers\\msedgedriver.exe");
        WebDriver driver = new EdgeDriver();
        driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");


    }
    }




