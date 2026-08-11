package calculadora;


import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Classe para teste da calculadora")
public class CalculadoraTest {
	
	private Calculadora calc;
	
	@BeforeEach
	public void inicializa() {
		calc = new Calculadora();
	}
	
	@DisplayName("Testa a soma de dois números inteiros")
	@Test
	public void testSomaDoisNumeros() {
		int soma = calc.soma(7,7);
		assertEquals(14,soma);
		
	}
	
	@DisplayName("Testa a subtração de dois números inteiros")
	@Test
	public void testSubtraçãoDoisNumeros() {
		int subtrai = calc.subtracao(10, 7);
		assertEquals(3,subtrai);
	}
	
	@DisplayName("Testa a multiplicação de dois números inteiros")
	@Test
	public void testMultiplicacaoDoisNumeros() {
		int multiplica = calc.multiplicacao(400, 3);
		assertEquals(1200,multiplica);
	}
	
	@DisplayName("Testa a divisão de dois números inteiros")
	@Test
	public void testDivisaoDoisNumeros() {
		int divide = calc.divisao(64, 4);
		assertEquals(16,divide);
	}
	
	@DisplayName("Testa a somatória de n números inteiros")
	@Test
	public void testSomatorioNumeros() {
		int somatorio = calc.somatoria(5);
		assertEquals(15,somatorio);
	}
	
	@DisplayName("Testa a funcionalidade para saber se um número é positivo")
	@Test
	public void testPositivo() {
		boolean positivo = calc.ehPositivo(5);
		assertEquals(true,positivo);
	}
	
	@DisplayName("Testa a funcionalidade de comparar qual número é maior")
	@Test
	public void testComparacao() {
		int comparacao = calc.compara(5,6);
		assertEquals(-1,comparacao);
	}
	
}
