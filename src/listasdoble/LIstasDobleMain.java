
package listasdoble;
/*Buscar un nodo por su posición, enumerando el prmero con la posición 0,
el siguiente como el 1, etc. y devolver una referencia a él. 
Insertar un nuevo nodo antes del último.
Intercambiar un nodo por otro buscado.*/

public class LIstasDobleMain {

    public static void main(String[] args) {
        
        
        ListaDoble lista = new ListaDoble();
		lista.insertaPrimerNodo("R");
		lista.imprimir();
		lista.insertaPrimerNodo("F");
		lista.imprimir();
		System.out.println(lista);
		lista.insertaAntesPrimerNodo("H");
		System.out.println(lista);
		lista.insertaAlFinal("Z");
		System.out.println(lista);
		lista.insertaEntreNodos("T", "R");
		System.out.println(lista);
		lista.insertaAntesPrimerNodo("K");
		System.out.println(lista);
		lista.insertaAlFinal("Ñ");
		System.out.println(lista);
		lista.borrarPrimerNodo();
		System.out.println(lista);
		lista.borrarUltimoNodo();
		System.out.println(lista);
		lista.borrarCualquierNodo("R");
		System.out.println(lista);
		
        
       lista.buscarPosicion(0);
        lista.buscarPosicion(1);
         lista.buscarPosicion(2);
          
      //  lista.intercambiarNodos("H", "Z");
        System.out.println(lista);
        
        System.out.println("\n INsertar antes del ultimo");
        lista.insertarAntUlt("A")  ;
        System.out.println(lista);
        
          System.out.println("\n INsertar antes del ultimo");
        lista.insertarAntUlt("B");
        System.out.println(lista);
        
      //  System.out.println(lista);
        
       lista.intercambiarNodos("H", "Z");
        System.out.println(lista);
     
       lista.intercambiarNodos("R", "L");
        System.out.println(lista);
        
        lista.intercambiarNodos("A", "B");
        System.out.println(lista);
        
    }
    
}
