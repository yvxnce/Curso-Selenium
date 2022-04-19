import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class testePage {

    private WebDriver driver;
    private DSL dsl;
    private PageObjetcs page;


    @Before
    public void inicializa() {
        System.setProperty("webdriver.edge.driver", "C:\\Users\\jeffe\\IdeaProjects\\CursoSelenium\\drivers\\msedgedriver.exe");
        driver = new EdgeDriver();
        driver.get("file:///" + System.getProperty("user.dir") + "/src/test/resources/componentes.html");
        driver.manage().window().maximize();
        dsl = new DSL(driver);
        page = new PageObjetcs(driver);
    }
        @Test
        public void testeCadastroCompleto () {
            page.setNome("joao");
            page.setSobrenome("pires");
            page.setSexoMasculino();
            page.setComidaCarne();
            page.setEscoloridade("Mestrado");
            page.setEsporte("Karate");
            page.setCadastrar();
    }
}
