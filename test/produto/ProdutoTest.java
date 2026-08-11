package produto;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotSame;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ProdutoTest {
	
	Produto livro;
	
	@BeforeEach
	public void inicializa() {
		livro = new Produto("Teste", 80.00);
	}
	
	@DisplayName("Teste de criação de produto")
	@Test
	public void testCriaProduto() {
		assertEquals("Teste", livro.getNome());
		assertEquals(80.00, livro.getPreco());
	}
	
	@DisplayName("Teste de dois produtos iguais")
	@Test
	public void testProdutosIguais() {
		Produto livro2 = new Produto("Teste", 90.00);
		
		assertNotSame(livro, livro2);
		
	}

}