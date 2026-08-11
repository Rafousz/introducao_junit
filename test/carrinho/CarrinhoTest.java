package carrinho;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import produto.Produto;
import produto.ProdutoNaoEncontradoException;

class CarrinhoTest {

    private Carrinho carrinho;
    private Produto p1;
    private Produto p2;

    @BeforeEach
    void setUp() {
        carrinho = new Carrinho();
        p1 = new Produto("Livro de Java Teste", 50.0);
        p2 = new Produto("Mouse sem fio Teste", 100.0);
    }
    
    @DisplayName("Teste de carrinho vazio")
    @Test
    void testCarrinhoIniciaVazio() {
        assertEquals(0, carrinho.getQtdeItems());
        assertEquals(0.0, carrinho.getValorTotal(), 0.0001);
    }

    @DisplayName("Teste da funcionalidades de adicionar itens no carrinho")
    @Test
    void testAdicionaItem() {
        carrinho.addItem(p1);
        assertEquals(1, carrinho.getQtdeItems());

        carrinho.addItem(p2);
        assertEquals(2, carrinho.getQtdeItems());
    }

    @DisplayName("Teste da função do valor total do carrinho")
    @Test
    void testValorTotal() {
        carrinho.addItem(p1);
        carrinho.addItem(p2);

        assertEquals(150.0, carrinho.getValorTotal());
    }

    @DisplayName("Teste da funcionalidade de remover item do carrinho")
    @Test
    void testRemoverItem() throws ProdutoNaoEncontradoException {
        carrinho.addItem(p1);
        carrinho.addItem(p2);

        carrinho.removeItem(p1);

        assertEquals(1, carrinho.getQtdeItems());
    }

    @DisplayName("Teste da função de esvaziar o carrinho")
    @Test
    void testEsvazia() {
        carrinho.addItem(p1);
        carrinho.addItem(p2);

        carrinho.esvazia();

        assertEquals(0, carrinho.getQtdeItems());
        assertEquals(0.0, carrinho.getValorTotal(), 0.0001);
    }
}