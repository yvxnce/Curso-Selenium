import org.openqa.selenium.WebDriver;

public class PageObjetcs {
    private DSL dsl;
    private WebDriver driver;

    public PageObjetcs(WebDriver driver) {
        dsl = new DSL(driver);
    }


    public void setNome(String nome) {
        dsl.escrever("elementosForm:nome", nome);


    }

    public void setSobrenome(String sobrenome) {
    dsl.escrever("elementosForm:sobrenome", sobrenome);


    }

    public void setSexoMasculino(){
        dsl.marcarHomem();

    }

    public void setComidaCarne(){
        dsl.marcarcarne();


    }

    public void setComidaVegetariano(){
        dsl.marcarvegan();


    }

    public void setEscoloridade(String form){

        dsl.escolaridade(form);

    }

    public void setEsporte(String esporte){
        dsl.marcaresporte(esporte);


    }

    public void setCadastrar(){
        dsl.cadastrar();


    }

}