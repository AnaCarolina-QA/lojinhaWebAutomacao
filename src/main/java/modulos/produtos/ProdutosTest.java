package modulos.produtos;

import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import paginas.LoginPage;

import java.time.Duration;

@DisplayName("Teste Web do Modulo de Produtos")


public class ProdutosTest {

    private WebDriver navegador;

    @BeforeEach
    public void beforeEach() {
        // Abrir o navegador
        System.setProperty("webdriver.chrome.driver", "/home/ana/driver/chromedriver");
       this.navegador =  new ChromeDriver();

        // Vou maximizar a tela
        this.navegador.manage().window().maximize();

        // Vou definir um tempo de espera padrao de 5 segundos
       this.navegador.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        // Navegar para a pagina da lojinha Web
        this.navegador.get("http://165.227.93.41/lojinha-web/v2/");
    }

    @Test
    @DisplayName("Nao e permitido registrar um produto com valor igual a zero")
    public void testTesteNaoEPermitidoRegistrarValorIgualAZero() {

        // Fazer login
        String mensagemApresentada = new LoginPage(navegador)
                .informarOUsuario("admin")
                .informarASenha("admin")
                .submeterFormularioDeLogin()
                .acessarFormularioDeAdicaoDeNovoProduto()
                .informarNomeDoProduto("Macbook Pro")
                .informarValorDoProduto("000")
                .informarCoresDoProduto("preto, branco")
                .submeterFormularioDeAdicaoComErro()
                .capturarMensagemApresentada();

        Assertions.assertEquals("O valor do produto deve estar entre R$ 0,01 e R$ 7.000,00", mensagemApresentada);


    }
    @AfterEach
    public void afterEach() {
        // Vou fechar o navegador
        navegador.quit();
    }
}
