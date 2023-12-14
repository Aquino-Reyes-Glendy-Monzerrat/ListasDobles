
package listasdoble;


public class ListaDoble {
    
    Node topForward;
	Node topBackward;

        //d¿saber si la lista esta vacia
          public boolean estaVacia() {
        return topForward == null;
    }
        
        
        
        
	//Métodos para los casos de inserción de nodos
	public boolean insertaPrimerNodo(String dato){
		if (topForward == null) { //La lista está vacía
			topForward = new Node();
			topForward.name = dato;
			topForward.previous = null;
			topForward.next = null;
			
			topBackward = topForward;

			return true;
		}
		else {
			return false;
		}
	}
	
	public void imprimir(){
		System.out.print("[X]"); 

		for (Node temp = this.topForward; temp != null; temp = temp.next){
			System.out.print(" <- [ " + temp.name + " ] -> ");
		}

		System.out.print("[X]\n"); 
	}
	
	public String toString(){
		String cadAux = "[X]";
		for (Node temp = this.topForward; temp != null; temp = temp.next){
			cadAux += " <- [ " + temp.name + " ] -> ";
		}

		cadAux += "[X]\n"; 

		return cadAux;
	}

	public void insertaAntesPrimerNodo(String nombre){
		Node temp; 
		temp = new Node ();
		temp.name = nombre;
		temp.next = this.topForward;
		this.topForward.previous = temp;
		this.topForward = temp;
		temp = null;
	}

	public void insertaAlFinal(String nombre){
		Node temp = new Node ();
		temp.name = nombre;
		temp.next = null;
		
		temp.previous = this.topBackward;
		this.topBackward.next = temp;
		this.topBackward = temp;
		temp = null;
	}

	public boolean insertaEntreNodos(String nombre, String buscado){
		Node temp = new Node();
		temp.name = nombre;
		Node temp2 = this.topForward;

		//boolean NodoNoEncontrado = true;

		while ( (temp2 != null) 
				&& temp2.name.equals(buscado) == false ) {	
		         temp2 = temp2.next;
		}

		if (temp2 != null){  //Nodo buscado se encontró
			temp.next = temp2.next;
			temp2.next = temp;

			temp.previous = temp2;
			temp.next.previous = temp;

			temp = null;
			temp2 = null;
			
			return true;
		}
		else return false;
	} 
	
	//Métodos de borrado
	public void borrarPrimerNodo(){
		this.topForward = this.topForward.next;
		this.topForward.previous.next = null;
		this.topForward.previous = null;
	}

	public void borrarUltimoNodo(){
		this.topBackward = this.topBackward.previous;
		this.topBackward.next.previous = null;
		this.topBackward.next = null;
	}

	
	//Borrar cualquier nodo que no sea el primero
	public boolean borrarCualquierNodo(String buscado){
		Node temp = this.topForward;

		while ( (temp != null) 
				&& temp.name.equals(buscado) == false ) {	
		         temp = temp.next;
		}

		if (temp != null){  //Nodo buscado se encontró
			temp.next = temp.next.next;
			temp.next.previous.previous = null;
			temp.next.previous.next = null;
			temp.next.previous = temp;
			temp = null;
			
			return true;
		}
		else return false;
	}

/////////////////////////////////////////////////////////////////////////////////
         //buscr un nodo por su posicin   
        
     public void buscarPosicion(int posicion) {
   

     Node temp=topForward;
     int count =0;
     while (temp!=null)
     {
     if(count ==posicion){
         System.out.println("La posicion es " + count + " su datos es " + temp.name);
     break;
     }
     count++;
     temp=temp.next;
         }
        if(count !=posicion){
System.out.println("La posicion  " + posicion + " no se encuentra en la lista" );        
        
        }
     }
 ///////////////////////////////////////////////////////////////////////////////////////////   
   


   
     
 ///////////////////////////////////////////////////////////////////////////////////////
         //insrtar un nuevo nodo antes del ultiimo
    public void insertarAntUlt(String nombre) {
  Node temp = new Node();
    temp.name = nombre;
    Node temp2 = topForward;
    Node temp3 = null;

    if(!estaVacia()){
    // temp apunta al ultimo y emp3 al penultimo
    while (temp2.next != null) {
        temp3 = temp2;
        temp2 = temp2.next;
    } 
       
        temp.previous = temp3;
        temp.next = temp2;
        temp3.next = temp;
        temp2.previous = temp;
        
        System.out.println("El nodo: " + nombre + " Se ha insertado antes de : " + temp2.name);
   
    } else if(temp3==null && temp2==topForward){  //si solo hay un nodo
     
		temp = new Node ();
		temp.name = nombre;
		temp.next = this.topForward;
		this.topForward.previous = temp;
		this.topForward = temp;
		temp = null;
    
    
    }
    
    
    
    
      if(estaVacia()){
      
        topBackward=topForward=temp;  
          
      
      }              
}
 
 ///////////////////////////////////////////////////////////////// ////////////////////////////////////  
 //Intercambiar un nodo por otro buscado.  
   public void intercambiarNodos(String val1, String val2) {
    
        
        if (topForward == null || topForward.next == null || val1.equals(val2)) {
            System.out.println("La lista no tiene suficientes nodos para intercambiar o los valores son iguales.");
            return;
        }

        Node Node1 = null;
        Node Node2 = null;
        Node temp = topForward;

        
        while (temp != null) {
            if (temp.name.equals(val1)) {
                Node1 = temp;
            } else if (temp.name.equals(val2)) {
                Node2 = temp;
            }

            temp = temp.next;
        }

        
        if (Node1 == null || Node2 == null) {
            System.out.println("Uno o ambos nodos no existen en la lista.");
            return;
        }

        
        if (Node1 == topForward) {
            topForward = Node2;
        } else if (Node2 == topForward) {
            topForward = Node1;
        }

        if (Node1 == topBackward) {
            topBackward = Node2;
        } else if (Node2 == topBackward) {
            topBackward = Node1;
        }

        Node tempNext1 = Node1.next;
        Node1.next = Node2.next;
        Node2.next = tempNext1;

        if (Node1.next != null) {
            Node1.next.previous = Node1;
        }
        if (Node2.next != null) {
            Node2.next.previous = Node2;
        }

        Node tempPrev1 = Node1.previous;
        Node1.previous = Node2.previous;
        Node2.previous = tempPrev1;

        if (Node1.previous != null) {
            Node1.previous.next = Node1;
        }
        if (Node2.previous != null) {
            Node2.previous.next = Node2;
        }

        System.out.println("Los nodos se cambiaron con éxito.");
    }


    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
 /* public void intercambiarNodos(String valor1, String valor2) {
        if (topForward == null || topForward.next == null || valor1.equals(valor2))
            return;

        Node Node1 = null, Node2 = null;
        Node temp = topForward;

        while (temp != null) {
            if (temp.name.equals(valor1))
                Node1 = temp;
            else if (temp.name.equals(valor2))
                Node2 = temp;

            temp = temp.next;
        }

        if (Node1 == null || Node2 == null) {
            System.out.println("Uno o ambos nodos no existen en la lista.");
            return;
        }

        if (Node1 == topForward)
            topForward = Node2;
        else if (Node2 == topForward)
            topForward = Node1;

        if (Node1 == topBackward)
            topBackward = Node2;
        else if (Node2 == topBackward)
            topBackward = Node1;

        Node tempNext1 = Node1.next;
        Node1.next = Node2.next;
        Node2.next = tempNext1;

        if (Node1.next != null)
            Node1.next.previous = Node1;
        if (Node2.next != null)
            Node2.next.previous = Node2;

        Node tempPrev1 = Node1.previous;
        Node1.previous = Node2.previous;
        Node2.previous = tempPrev1;

        if (Node1.previous != null)
            Node1.previous.next = Node1;
        if (Node2.previous != null)
            Node2.previous.next = Node2;
    }*/
     
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
     
}//fin
