import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class testeDSL {
    public WebDriver driver;
    private DSL dsl;

    @Before
    public void inicializa() {
        System.setProperty("webdriver.edge.driver", "C:\\Users\\joaog\\IdeaProjects\\CursoSelenium\\drivers\\msedgedriver.exe");
        driver = new EdgeDriver();
        driver.get("file:///" + System.getProperty("user.dir") + "/src/test/resources/componentes.html");
        driver.manage().window().maximize();
        dsl = new DSL(driver);
    }


    @Test
    public void testesobrenome() {

        dsl.escrever("elementosForm:nome", "Joao");
        dsl.checarNome("Joao");
        dsl.cadastrar();
        dsl.verificar("Sobrenome eh obrigatorio");

    }
    @Test
    public void testesexo() {


        dsl.escrever("elementosForm:nome", "Joao");
        dsl.escrever("elementosForm:sobrenome", "Pires");
        dsl.cadastrar();
        dsl.verificar("Sexo eh obrigatorio");


    }

    @Test
    public void testevegan(){
        dsl.escrever("elementosForm:nome","joao");
        dsl.escrever("elementosForm:sobrenome","pires");
        dsl.marcarHomem();
        dsl.marcarcarnevegan();
        dsl.cadastrar();
        dsl.verificar("Tem certeza que voce eh vegetariano?");
    }


    @Test
    public void testeesporte(){
        dsl.escrever("elementosForm:nome","joao");
        dsl.escrever("elementosForm:sobrenome","pires");
        dsl.marcarHomem();
        dsl.marcaresporte("Corrida");
        dsl.marcaresporte("O que eh esporte?");
        dsl.cadastrar();
        dsl.verificar("Voce faz esporte ou nao?");
    }

    @Test
    public void testJavaSc() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("alert('Testando js via selenium')");
    }

}



