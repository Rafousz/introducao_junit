package calculadora;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CalculadoraTest {

    private Calculadora calculadora;

    @BeforeEach
    void setUp() {
        calculadora = new Calculadora();
    }

    @Test
    void deveSomarDoisNumerosPositivos() {
        assertEquals(8, calculadora.soma(5, 3));
    }

    @Test
    void deveSomarNumerosNegativos() {
        assertEquals(-8, calculadora.soma(-5, -3));
    }

    @Test
    void deveSubtrairDoisNumeros() {
        assertEquals(2, calculadora.subtracao(5, 3));
    }

    @Test
    void deveSubtrairNumerosNegativos() {
        assertEquals(-2, calculadora.subtracao(-5, -3));
    }

    @Test
    void deveMultiplicarDoisNumeros() {
        assertEquals(15, calculadora.multiplicacao(5, 3));
    }

    @Test
    void deveMultiplicarPorZero() {
        assertEquals(0, calculadora.multiplicacao(5, 0));
    }

    @Test
    void deveDividirDoisNumeros() {
        assertEquals(5, calculadora.divisao(10, 2));
    }

    @Test
    void deveRealizarDivisaoInteira() {
        assertEquals(3, calculadora.divisao(10, 3));
    }

    @Test
    void deveLancarExcecaoAoDividirPorZero() {
        assertThrows(
            ArithmeticException.class,
            () -> calculadora.divisao(10, 0)
        );
    }

    @Test
    void deveCalcularSomatoria() {
        assertEquals(15, calculadora.somatoria(5));
    }

    @Test
    void somatoriaDeZeroDeveSerZero() {
        assertEquals(0, calculadora.somatoria(0));
    }

    @Test
    void somatoriaDeNumeroNegativoDeveSerZero() {
        assertEquals(0, calculadora.somatoria(-5));
    }

    @Test
    void zeroDeveSerConsideradoPositivo() {
        assertTrue(calculadora.ehPositivo(0));
    }

    @Test
    void numeroPositivoDeveRetornarTrue() {
        assertTrue(calculadora.ehPositivo(10));
    }

    @Test
    void numeroNegativoDeveRetornarFalse() {
        assertFalse(calculadora.ehPositivo(-10));
    }

    @Test
    void deveRetornarZeroQuandoNumerosForemIguais() {
        assertEquals(0, calculadora.compara(5, 5));
    }

    @Test
    void deveRetornarUmQuandoPrimeiroNumeroForMaior() {
        assertEquals(1, calculadora.compara(10, 5));
    }

    @Test
    void deveRetornarMenosUmQuandoPrimeiroNumeroForMenor() {
        assertEquals(-1, calculadora.compara(5, 10));
    }
}
