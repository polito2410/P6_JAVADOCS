package calcualdora;

import java.util.Scanner;

import calcualdora.Operaciones;

public class CalculadoraED {

	/**
	 * 
	 * CLASE CONTROLADORA
	 */
	public static void main(String[] args) {
		
		CerebroCalculadoraED cce = new CerebroCalculadoraED();
		Scanner teclado = new Scanner(System.in);//"teclado" donde se introducira por pantalla las opciones de la calculadora 
		String entrada;
		
		
		/**
		 *  DO-WHILE QUE HARA CUALQUIER OPERACION QUE LE PIDAMOS HASTA QUE INTRODUZCAMOS POR TECLADO UNA "x" (
		 */
		
		do {
			imprimirCabecera();
			imprimirSeleccionOp();
			
			entrada= teclado.next(); // Lo que introduzcamos por teclado se almacenara en "entrada"
			if (validarEntrada(entrada)) {
				cce.procesarOperacion(entrada);
			}else {
				System.out.println("Entrada no reconocida");
			}
		} while (!entrada.toUpperCase().equals("X"));
		imprimirDespedida();
	}
	
	private static void imprimirCabecera() {	// SACARA LA INFORMACION DE ABAJO , CADA VEZ QUE SALGA EL MENU DE OPERACIONES
		System.out.println("*----------------------------------*");
		System.out.println("*----------Calculadora ED----------*");
		System.out.println("*----------------------------------*");
	}
	
	private static void imprimirDespedida() { // SACARA POR PANTALLA LA INFORMACION CUANDO HAYAMOS PUESTO UNA "X"
		System.out.println("*-----------------------------------------*");
		System.out.println("*----¡Gracias por usar Calculadora ED!----*");
		System.out.println("*-----------------------------------------*");
	}
	
	private static void imprimirSeleccionOp() {
		Operaciones[] ops = Operaciones.values();
		for(Operaciones op: ops)
		{
			System.out.println(op.getOpcionMenu());
	    }
		System.out.println("¿Qué operación desea realizar? (x para terminar)");
	}
	
	/**
	 * METODO BOOLEAN PARA VALIDAR QUE LA ENTRADA INTRODUCIDA EN TECLADA SEA VALIDA
	 * 
	 */
	
	private static boolean validarEntrada(String entrada) {
		
		//BUCLE FOR-EACH PARA VALIDAR LA ENTRADA
		
		boolean opValida = false;
		for(Operaciones op: Operaciones.values())
		{
			if(Integer.toString(op.getId()).equals(entrada)| entrada.toUpperCase().equals("x")) {
				opValida=  true;
			}
	    }
	
		return opValida;
	}
	
	

}
