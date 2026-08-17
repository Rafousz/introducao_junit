package produto;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ProdutoTest {

    private Produto produto;

    @BeforeEach
    void setUp() {
        produto = new Produto("Notebook", 2500.00);
    }

    @Test
    void deveCriarProdutoComNomeEPreco() {
        assertEquals("Notebook", produto.getNome());
        assertEquals(2500.00, produto.getPreco());
    }

    @Test
    void deveRetornarNomeDoProduto() {
        assertEquals("Notebook", produto.getNome());
    }

    @Test
    void deveAlterarNomeDoProduto() {
        produto.setNome("Celular");

        assertEquals("Celular", produto.getNome());
    }

    @Test
    void deveRetornarPrecoDoProduto() {
        assertEquals(2500.00, produto.getPreco());
    }

    @Test
    void deveAlterarPrecoDoProduto() {
        produto.setPreco(3000.00);

        assertEquals(3000.00, produto.getPreco());
    }

    @Test
    void produtosComMesmoNomeDevemSerIguais() {
        Produto outroProduto = new Produto("Notebook", 3500.00);

        assertEquals(produto, outroProduto);
    }

    @Test
    void produtosComNomesDiferentesNaoDevemSerIguais() {
        Produto outroProduto = new Produto("Celular", 2500.00);

        assertNotEquals(produto, outroProduto);
    }

    @Test
    void produtosComMesmoNomeEMesmoPrecoDevemSerIguais() {
        Produto outroProduto = new Produto("Notebook", 2500.00);

        assertEquals(produto, outroProduto);
    }

    @Test
    void produtosComMesmoNomeEPrecosDiferentesDevemSerIguais() {
        Produto outroProduto = new Produto("Notebook", 5000.00);

        assertEquals(produto, outroProduto);
    }
}
