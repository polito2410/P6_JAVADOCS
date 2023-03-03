package calcualdora;

import java.util.Scanner;
/**
 * ESTA CLASE PERMITE CONTROLAR LAS OPERACIONES DE LA CALCULADORA
 * @author Paul
 * 
 *
 */
public class CerebroCalculadoraED {

	private Operaciones operacion;
	private double resultado, numero1, numero2;
	private String historial[]=  new String[5];
	Scanner tecladoCce = new Scanner(System.in);

	CerebroCalculadoraED() {
		
		resultado = 0;
	}

	/**Metodo el cual que depediendo de la repuesto "op" la cual se introduce en la clase
	* CalculadoraED .Hara la operacion que has elegido
	*/
	public void procesarOperacion(String op) {
		Operaciones operacion;
		System.out.println("proceso " + op);
		switch (op) {
		
		//SUMA
		case "1":
			operacion = Operaciones.SUMAR;
			operarSuma(operacion);
			break;
		//RESTA
		case "2":
			operacion = Operaciones.RESTAR;
			operarResta(operacion);
			break;
		
		//MULTIPLACION
		case "3":
			operacion = Operaciones.MULTIPLICAR;
			operarMultiplica(operacion);
			break;
			
		//DIVISION
		case "4":
			operacion = Operaciones.DIVIDIR;
			operarDivide(operacion);
			break;
			
		//SUMAR AL RESULTADO
		case "5":
			operacion = Operaciones.SUMAR_RES;
			operarSumaRes(operacion);
			break;
			
		//RESTAR AL RESULTADO
		case "6":
			operacion = Operaciones.RESTAR_RES;
			operarRestaRes(operacion);
			break;
		
		//MULTIPLICAR AL RESULTADO
		case "7":
			operacion = Operaciones.MULTIPLICAR_RES;
			operarMultiplicaRes(operacion);
			break;
		
		//DIVIDIR AL RESULTADO
		case "8":
			operacion = Operaciones.DIVIDIR_RES;
			operarDivideRes(operacion);
			break;
		
		//MOSTRAR EL ULTIMO RESULTADO
		case "9":
			operacion = Operaciones.RESULTADO;
			mostrarResultadoActual(operacion);
			break;
		
		//SACA UN NUMERO RAMDON
		case "10":
			operacion = Operaciones.RANDOM;
			numeroAleatorio(operacion);
			break;
			
		//SACA LOS ULTIMOS 5 RESULTADOS	
		case "11":
			operacion = Operaciones.HISTORIAL;
			operarHistorial(operacion);
			break;
		default:
		
		//SI EL NUMERO NO CONCUERDA CON LOS NUMEROS DE LOSO CASOS SACARA EL SIGUIENTE MENSAJE:
			System.out.println("ERROR: La operación " + op + " no es conocida.");
		}
	}

	/**
	 * 
	 * METODOS PARA SUMAR,RESTAR,MULTIPLICAR,DIVIDIR; HACER LO ANTERIOR AL RESULTADO, SACAR NUM ALEATORIO
	 * SACAR POR PANTALLA EL ULTIMO RESULTADO Y EL HISTORIAL DE LOS ULTIMOS 5
	 */
	//METODO QUE HARA LA SUMA
	private void operarSuma(Operaciones op) {
		infoOperacion(op);
		pedirDosNumeros();
		this.resultado = this.numero1 + this.numero2;
		mostrarResultado(op);
		anadirHistorial(op);
	}
	
	//METODO QUE HARA LA RESTA
	
	private void operarResta(Operaciones op) {
		infoOperacion(op);
		pedirDosNumeros();
		this.resultado = this.numero1 - this.numero2;
		mostrarResultado(op);
		anadirHistorial(op);
	}
	
	//METODO QUE HARA LA MULTIPLICACION
	
	private void operarMultiplica(Operaciones op) {
		infoOperacion(op);
		pedirDosNumeros();
		this.resultado = this.numero1 * this.numero2;
		mostrarResultado(op);
		anadirHistorial(op);
	}
	
	//METODO QUE HARA LA DIVISION
	
	private void operarDivide(Operaciones op) {
		infoOperacion(op);
		pedirDosNumeros();
		this.resultado = this.numero1 / this.numero2;
		mostrarResultado(op);
		anadirHistorial(op);
	}
	
	//METODO SUMAR AL RESULTADO
	
	private void operarSumaRes(Operaciones op) {
		infoOperacion(op);
		pedirUnNumero();
		this.resultado = this.resultado + this.numero2;
		mostrarResultado(op);
		anadirHistorial(op);
	}
	
	//METODO RESTAR AL RESULTADO (se cambia el signo ya que de serie hay un "+" en vez de un "-")
	private void operarRestaRes(Operaciones op) {
		infoOperacion(op);
		pedirUnNumero();
		this.resultado = this.resultado - this.numero2;
		mostrarResultado(op);
		anadirHistorial(op);
	}
	
	//METODO MULTIPLICAR AL RESULTADO
	private void operarMultiplicaRes(Operaciones op) {
		infoOperacion(op);
		pedirUnNumero();
		this.resultado = this.resultado * this.numero2;
		mostrarResultado(op);
		anadirHistorial(op);
	}
	
	//METODO DIVIDIR AL RESULTADO
	private void operarDivideRes(Operaciones op) {
		infoOperacion(op);
		pedirUnNumero();
		this.resultado = this.resultado / this.numero2;
		mostrarResultado(op);
		anadirHistorial(op);
	}
	
	//METODO MOSTRAR RESULTADO
	private void mostrarResultadoActual(Operaciones op) {
		infoOperacion(op);
		System.out.println("El valor actual del resultado es: " + this.resultado + "\n");
	}
	
	//METODO NUMERO ALEATORIO
	private void numeroAleatorio(Operaciones op) {
		infoOperacion(op);
		
		this.resultado = Math.random()*100+1;
		System.out.println("El número aleatorio generado es: " + this.resultado + "\n");
		anadirHistorialAleatorio(op);
	}
	
	//METODO HISTORIAL CINCO ULTIMAS OPERACIONES
	private void operarHistorial(Operaciones op) {
		System.out.println("*** Historial de las cinco últimas operaciones ***");
		for (String hist : historial) {
			System.out.println(hist);
		}
		System.out.println("\n");
	}
	
	private void infoOperacion(Operaciones op) {
		System.out.println("//////////////////////////////");
		System.out.println("-> " + op.getNombre() + " - " + op.getInfo());
	}
	
	private void pedirUnNumero() {
		System.out.println("Introduce el número: ");
		this.numero1 = this.resultado;
		this.numero2 = tecladoCce.nextDouble();
	}
	
	private void pedirDosNumeros() {
		System.out.println("Introduce el primer número: ");
		this.numero1 = tecladoCce.nextDouble();
		System.out.println("Introduce el segundo número: ");
		this.numero2 = tecladoCce.nextDouble();
	}
	
	private void mostrarResultado(Operaciones op) {
		System.out.println("El resultado de la operación " + op.getNombre().toLowerCase() + " es:");
		System.out.println(Double.toString(numero1) 
				+ " " + op.getSimbolo() + " " 
				+ numero2 + " = "
				+ resultado + "\n");
	}
	
	/**BUCLE PARA AÑADIR EL RESULTADO AL HISTORIAL EN LA SIGUIENTE POSICION DEL ARRAY 
	*Ejemplo-->Historial[4]=Historial[3]
	*/
	private void anadirHistorial(Operaciones op) {
		
		for(int i=4;0<i;i--){
		historial[i]=historial[i-1];	
		}
		
		historial[0]=op.getNombre() + " -> " + numero1 + " " + op.getSimbolo() + " " +numero2 + " = "
		+ resultado;
	}
	public void anadirHistorialAleatorio(Operaciones op) {
		
		for(int i=4;0<i;i--) {
			historial[i]=historial[i-1];
		}
	historial[0]=op.getNombre() + " -> "+resultado;

		}

	}



