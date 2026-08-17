package carrinho;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import produto.Produto;
import produto.ProdutoNaoEncontradoException;

class CarrinhoTest {

    private Carrinho carrinho;

    @BeforeEach
    void setUp() {
        carrinho = new Carrinho();
    }

    @Test
    void carrinhoDeveIniciarVazio() {
        assertEquals(0, carrinho.getQtdeItems());
    }

    @Test
    void deveAdicionarProdutoAoCarrinho() {
        Produto produto = new Produto("Notebook", 2500.00);

        carrinho.addItem(produto);

        assertEquals(1, carrinho.getQtdeItems());
    }

    @Test
    void deveAdicionarDoisProdutosAoCarrinho() {
        Produto produto1 = new Produto("Notebook", 2500.00);
        Produto produto2 = new Produto("Mouse", 100.00);

        carrinho.addItem(produto1);
        carrinho.addItem(produto2);

        assertEquals(2, carrinho.getQtdeItems());
    }

    @Test
    void deveCalcularValorTotalDeUmProduto() {
        Produto produto = new Produto("Notebook", 2500.00);

        carrinho.addItem(produto);

        assertEquals(2500.00, carrinho.getValorTotal());
    }

    @Test
    void deveCalcularValorTotalDeDoisProdutos() {
        Produto produto1 = new Produto("Notebook", 2500.00);
        Produto produto2 = new Produto("Mouse", 100.00);

        carrinho.addItem(produto1);
        carrinho.addItem(produto2);

        assertEquals(2600.00, carrinho.getValorTotal());
    }

    @Test
    void valorTotalDeCarrinhoVazioDeveSerZero() {
        assertEquals(0.0, carrinho.getValorTotal());
    }

    @Test
    void deveRemoverProdutoDoCarrinho() throws ProdutoNaoEncontradoException {
        Produto produto = new Produto("Notebook", 2500.00);

        carrinho.addItem(produto);
        carrinho.removeItem(produto);

        assertEquals(0, carrinho.getQtdeItems());
    }

    @Test
    void deveAtualizarValorTotalDepoisDeRemoverProduto()
            throws ProdutoNaoEncontradoException {

        Produto produto1 = new Produto("Notebook", 2500.00);
        Produto produto2 = new Produto("Mouse", 100.00);

        carrinho.addItem(produto1);
        carrinho.addItem(produto2);

        carrinho.removeItem(produto1);

        assertEquals(100.00, carrinho.getValorTotal());
    }

    @Test
    void deveLancarExcecaoAoRemoverProdutoInexistente() {
        Produto produto = new Produto("Notebook", 2500.00);

        assertThrows(
            ProdutoNaoEncontradoException.class,
            () -> carrinho.removeItem(produto)
        );
    }

    @Test
    void deveEsvaziarOCarrinho() {
        Produto produto1 = new Produto("Notebook", 2500.00);
        Produto produto2 = new Produto("Mouse", 100.00);

        carrinho.addItem(produto1);
        carrinho.addItem(produto2);

        carrinho.esvazia();

        assertEquals(0, carrinho.getQtdeItems());
    }

    @Test
    void valorTotalDeveSerZeroDepoisDeEsvaziarCarrinho() {
        Produto produto1 = new Produto("Notebook", 2500.00);
        Produto produto2 = new Produto("Mouse", 100.00);

        carrinho.addItem(produto1);
        carrinho.addItem(produto2);

        carrinho.esvazia();

        assertEquals(0.0, carrinho.getValorTotal());
    }

    @Test
    void devePermitirAdicionarProdutosComMesmoNome() {
        Produto produto1 = new Produto("Notebook", 2500.00);
        Produto produto2 = new Produto("Notebook", 3000.00);

        carrinho.addItem(produto1);
        carrinho.addItem(produto2);

        assertEquals(2, carrinho.getQtdeItems());
        assertEquals(5500.00, carrinho.getValorTotal());
    }
}
