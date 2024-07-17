package recursao;

public class MetodosRecursivos {

	public int calcularSomaArray(int[] array){
		int indice = 0;
		// TODO ESCREVA AQUI O CÓDIGO (USANDO RECURSAO) PARA CALCULAR A SOMA
		// DOS EMENTOS DE UM ARRA

		return somaArray(array,indice);
	}
	private int somaArray(int[] array,int indice){
		int soma = 0;
		if (indice == array.length-1){
			return soma;
		}
		else{
			soma += array[indice];
			soma = soma + somaArray(array,indice+1);
		}
		return soma;
	}


	public long calcularFatorial(int n) {
		// TODO ESCREVA AQUI O CÓDIGO (USANDO RECURSAO) PARA CALCULAR E IMPRIMIR
		// O FATORIAL DO PARAMETRO
		// DE ACORDO COM O QUE FOI MOSTRADO NO EXERCCICIO. OBSERVE QUE SENDO O
		// METODO
		// RECURSIVO, O FATORIAL DOS NUMEROS ANTERIORES TAMBEM VAO SER IMPRESSOS
		if (n == 1){
			return n;
		}
		else{
			return n * calcularFatorial(n-1);
		}	
	}

	public int calcularFibonacci(int n) {
		int result = 1;
		if (n == 1 || n ==2){
			return result;
		}
		else{
			result = calcularFibonacci(n-2) + calcularFibonacci(n-3);
			return result;
		}
	}

	public int countNotNull(Object[] array) {
		// TODO IMPLEMENTE AQUI O CODIGO QUE CONTA (USANDO RECURSAO) A
		// QUANTIDADE DE ELEMENTOS NAO NULOS
		// DE UM ARRAY DE OBJETOS RECEBIDO COMO PARAMETRO
		return contadorNulo(array,0);
	}
	private int contadorNulo(Object[] array, int indice){
		int contador = 0;
		if (indice == array.length - 1){
			if (!array[indice].equals(null)){
				contador++;
			}
		}
		else{
			if(!array[indice].equals(null)){
				contador++;
			}
			contador = contador + contadorNulo(array, indice + 1);
		}
		return contador;
	}

	public long potenciaDe2(int expoente) {
		// TODO IMPLEMENTE (USANDO RECURSAO) O CODIGO PARA PRODUZIR A N-ESIMA
		// POTENCIA
		// DE 2
		return recursividade2(2,expoente,1);
	}
	private int recursividade2(int n, int expoente, int contador){
		int numero = 2;
		if (contador == expoente){
			return n;
		}
		else{
			numero = n * 2;
			numero = recursividade2(numero, expoente,contador+1);
		}
		return numero;
	}

	public double progressaoAritmetica(double termoInicial, double razao, int n) {
		// TODO IMPLEMENTE SEU CODIGO (USANDO RECURSAO) DE ENCONTRAR O n-ESIMO
		// TERMO
		// DA PROGRESSAO ARITMETICA, DADO O TERMO INICIAL E A RAZAO
		// VOCE NAO PODE USAR A FORMULA QUE CALCULA O N-ESIMO TERMO. DEVE USAR RECURSAO
		if (n == 1){
			return termoInicial;
		}
		else{
			return termoInicial + progressaoAritmetica(termoInicial, razao, n-1);
		}
	}

	public double progressaoGeometrica(double termoInicial, double razao, int n) {
		// TODO IMPLEMENTE SEU CODIGO (USANDO RECURSAO) DE ENCONTRAR O n-ESIMO
		// TERMO
		// DA PROGRESSAO GEOMETRICA, DADO O TERMO INICIAL E A RAZAO
		// VOCE NAO PODE USAR A FORMULA QUE CALCULA O N-ESIMO TERMO. DEVE USAR RECURSAO
		if (n == 1){
			return termoInicial;
		}
		else{
			return termoInicial * progressaoGeometrica(termoInicial, razao, n-1);
		}	
	}
	
	
}
