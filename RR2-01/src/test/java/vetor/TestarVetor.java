package vetor;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;


public class TestarVetor {

	private Vetor vetor;

	@Before 
	public void criaVetor(){
		this.vetor = new Vetor<String>(3);
		vetor.inserir("ola");
		vetor.inserir("oi");
		vetor.inserir("opa");
	}

	@Test
	public void testInserir(){
		assertTrue(vetor.existe("ola"));
	}

	@Test
	public void testRemover(){
		vetor.remover("ola");
		assertFalse(vetor.existe("ola"));
		assertTrue(vetor.existe("oi"));
	}

	@Test
	public void testProcurar(){
		assertEquals("ola",vetor.procurar("ola"));
	}

	@Test
	public void testIsVazio(){
		assertFalse(vetor.isVazio());
	}

	@Test 
	public void testIsCheio(){
		assertTrue(vetor.isCheio());
	}

}
