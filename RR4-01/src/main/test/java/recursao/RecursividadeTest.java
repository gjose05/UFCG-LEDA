package recursao;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class RecursividadeTest {

    private MetodosRecursivos metodos;

    @Before
    public void criaMetodos(){
        this.metodos = new MetodosRecursivos();
    }

    @Test
    public void calcularSomaArray(){
        int[] i = {2,4,6,8};
        assertEquals(20,metodos.calcularSomaArray(i));
    }

    @Test
    public void calcularFatorial(){
        int i = 3;
        assertEquals(6,metodos.calcularFatorial(i));
    }

    @Test
    public void calcularFibonacci(){
        int i = 5;
        assertEquals(5,metodos.calcularFibonacci(i));
    }

    @Test
    public void contadorNaoNulo(){
        Object[] i = {"oi","ola","buenos dias"};
        assertEquals(3,metodos.countNotNull(i));
    }

    @Test
    public void potencia2(){
        int i = 4;
        assertEquals(16,metodos.potenciaDe2(i));
    }

    @Test
    public void PA(){
        double termoInicial = 1;
        double razao = 2;
        int i = 5;
        assertEquals(9.0, metodos.progressaoAritmetica(termoInicial,razao,i),0);
    }

    @Test
    public void PG(){
        double termoInicial = 1;
        double razao = 2;
        int i = 5;
        assertEquals(16.0, metodos.progressaoGeometrica(termoInicial,razao,i),0);
    }
}
