import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class TesteCampoTreinamento {

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
	public void testeTextField(){
		WebDriver driver = new EdgeDriver();
		driver.manage().window().setSize(new Dimension(1200, 765));
		driver.get("file:///" + System.getProperty("user.dir") + "/src/test/resources/componentes.html");
		driver.findElement(By.id("elementosForm:nome")).sendKeys("Teste de escrita");
		Assert.assertEquals("Teste de escrita", driver.findElement(By.id("elementosForm:nome")).getAttribute("value"));
		
		driver.quit();
	}
	
	@Test
	public void deveIntegarirComTextArea(){
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().setSize(new Dimension(1200, 765));
		driver.get("file:///" + System.getProperty("user.dir") + "/src/test/resources/componentes.html");
		driver.findElement(By.id("elementosForm:sugestoes")).sendKeys("teste\n\naasldjdlks\nUltima linha");
		Assert.assertEquals("teste\n\naasldjdlks\nUltima linha", driver.findElement(By.id("elementosForm:sugestoes")).getAttribute("value"));
		
		
		driver.quit();
	}
	
	@Test
	public void deveIntegarirComRadioButton(){
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().setSize(new Dimension(1200, 765));
		driver.get("file:///" + System.getProperty("user.dir") + "/src/test/resources/componentes.html");
		driver.findElement(By.id("elementosForm:sexo:0")).click();
		Assert.assertTrue(driver.findElement(By.id("elementosForm:sexo:0")).isSelected());
		driver.quit();
	}
	
	@Test
	public void deveIntegarirComCheckbox(){
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().setSize(new Dimension(1200, 765));
		driver.get("file:///" + System.getProperty("user.dir") + "/src/test/resources/componentes.html");
		driver.findElement(By.id("elementosForm:comidaFavorita:2")).click();
		Assert.assertTrue(driver.findElement(By.id("elementosForm:comidaFavorita:2")).isSelected());
		driver.quit();
	}
	
	@Test
	public void deveIntegarirComCombo(){

		WebElement element = driver.findElement(By.id("elementosForm:escolaridade"));
		Select combo = new Select(element);
		combo.selectByVisibleText("Corrida");
		
		Assert.assertEquals("2o grau completo", combo.getFirstSelectedOption().getText());
		driver.quit();
	}
	
	@Test
	public void deveVerificarValoresCombo(){
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().setSize(new Dimension(1200, 765));
		driver.get("file:///" + System.getProperty("user.dir") + "/src/test/resources/componentes.html");
		WebElement element = driver.findElement(By.id("elementosForm:escolaridade"));
		Select combo = new Select(element);
		List<WebElement> options = combo.getOptions();
		Assert.assertEquals(8, options.size());
		
		boolean encontrou = false;
		for(WebElement option: options) {
			if(option.getText().equals("Mestrado")){
				encontrou = true;
				break;
			}
		}
		Assert.assertTrue(encontrou);
	}
	
	@Test
	public void deveVerificarValoresComboMultiplo(){
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().setSize(new Dimension(1200, 765));
		driver.get("file:///" + System.getProperty("user.dir") + "/src/test/resources/componentes.html");
		WebElement element = driver.findElement(By.id("elementosForm:esportes"));
		Select combo = new Select(element);
		combo.selectByVisibleText("");
		combo.selectByVisibleText("");
		combo.selectByVisibleText("");
		List<WebElement> allSelectedOptions = combo.getAllSelectedOptions();
		Assert.assertEquals(3, allSelectedOptions.size());
		combo.deselectByVisibleText("Corrida");
		allSelectedOptions = combo.getAllSelectedOptions();
		Assert.assertEquals(2, allSelectedOptions.size());
		driver.quit();
	}
	@Test
	public void deveinteragirComBotoes(){
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().setSize(new Dimension(1200, 765));
		driver.get("file:///" + System.getProperty("user.dir") + "/src/test/resources/componentes.html");
		WebElement botao = driver.findElement(By.id("buttonSimple"));
		botao.click();
		
		Assert.assertEquals("Obrigado!", botao.getAttribute("value"));
		driver.quit();
		
	}
	
	@Test
	public void deveinteragirComLinks(){
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().setSize(new Dimension(1200, 765));
		driver.get("file:///" + System.getProperty("user.dir") + "/src/test/resources/componentes.html");
	
		driver.findElement(By.linkText("Voltar")).click();
		
		Assert.assertEquals("Voltou!", driver.findElement(By.id("resultado")).getText());
		driver.quit();
	}
	
	@Test
	public void deveBuscarTextosNaPagina(){
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().setSize(new Dimension(1200, 765));
		driver.get("file:///" + System.getProperty("user.dir") + "/src/test/resources/componentes.html");
		
//		Assert.assertTrue(driver.findElement(By.tagName("body"))
//				.getText().contains("Campo de Treinamento"));
		Assert.assertEquals("Campo de Treinamento", 
				driver.findElement(By.tagName("h3")).getText());
		
		Assert.assertEquals("Cuidado onde clica, muitas armadilhas...", 
				driver.findElement(By.className("facilAchar")).getText());
		driver.quit();
	}
	
}









