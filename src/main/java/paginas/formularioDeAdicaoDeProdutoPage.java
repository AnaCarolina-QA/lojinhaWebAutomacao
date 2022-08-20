package paginas;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class formularioDeAdicaoDeProdutoPage {
    private WebDriver navegador;

    public formularioDeAdicaoDeProdutoPage(WebDriver navegador){
        this.navegador = navegador;

    }
    public formularioDeAdicaoDeProdutoPage informarNomeDoProduto(String ProdutoNome){
        navegador.findElement(By.id("produtonome")).sendKeys(ProdutoNome);

        return this;
    }
    public formularioDeAdicaoDeProdutoPage informarValorDoProduto(String ProdutoValor) {
        navegador.findElement(By.id("produtovalor")).sendKeys(ProdutoValor);

        return this;
    }
    public formularioDeAdicaoDeProdutoPage informarCoresDoProduto(String ProdutoCores){
        navegador.findElement(By.id("produtocores")).sendKeys(ProdutoCores);

        return this;
    }

    public ListaDeProdutosPage submeterFormularioDeAdicaoComErro(){
        navegador.findElement(By.cssSelector("button[type='submit']")).click();

        return new ListaDeProdutosPage(navegador);
    }
}


