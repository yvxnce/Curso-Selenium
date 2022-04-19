import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class testeDSL {
    private WebDriver driver;
    private DSL dsl;

    @Before
    public void inicializa() {
        System.setProperty("webdriver.edge.driver", "C:\\Users\\jeffe\\IdeaProjects\\CursoSelenium\\drivers\\msedgedriver.exe");
        driver = new EdgeDriver();
        driver.get("file:///" + System.getProperty("user.dir") + "/src/test/resources/componentes.html");
        driver.manage().window().maximize();
        dsl = new DSL(driver);
    }


    @Test
    public void testesobrenome() {

        dsl.escrever("elementosForm:nome", "Joao");
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
}



