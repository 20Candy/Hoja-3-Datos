/******************************************************************
@author Carol Arevalo y Priscilla
@since 12/02/21

class sort
******************************************************************/

public class sorts {

     /** 
    * constructor
    * 
    */
    sorts(){ 
    }

    /** 
    * metodos BubbleSort
    * @return Comparable[]
    * @param Comparable[] 
    */
    public Comparable[] BubbleSort(Comparable [] datos){
        for(int i = 0; i < datos.length; i++) { 
            for (int j = 0; j < datos.length; j++) { 
                if (datos[j].compareTo(datos[i]) == 1) { 
                    Comparable temp = datos[i]; 
                    datos[i] = datos[j]; 
                    datos[j] = temp;
                }
            }
        }
        return datos; 
    }

    /** 
    * metodos GnomeSort
    * @return Comparable[]
    * @param Comparable[] 
    */
    public Comparable[] GnomeSort(Comparable [] datos){
       
        int index = 0; 
  
        while (index < datos.length) { 
            if (index == 0) {
                index++; 
            }if (datos[index].compareTo(datos[index - 1]) >= 0) { 
                index++; 
            } else { 
                Comparable temp;  
                temp = datos[index]; 
                datos[index] = datos[index - 1]; 
                datos[index - 1] = temp;
                index--; 
            } 
        }

        return datos; 
    }

    //..............................................................................................................
    /** 
    * metodos Quicksort
    * @return Comparable[]
    * @param Comparable[] 
    */
    public Comparable[] QuickSort(Comparable [] datos){

        sort(datos, 0, datos.length-1);

        return datos; 
    }

    /** 
    * metodo particion parte de funcionamiento de Quicksort
    * @return Comparable[]
    * @param Comparable[] 
    */
    
    //recibe una lista, la posicion mas baja, y la posicion mas alta
    int particion(Comparable arr[], int low, int high) 
    { 
        Comparable pivot = arr[high];   //se coloca como pivote el valor del ultimo espacio del array
        int i = (low-1); // se coloca como i el valor del primer espacio del array -1
        for (int j=low; j<high; j++){ 
            if (arr[j].compareTo(pivot) <=0){  //si el numero en la posicion j es mas peque�o que el pivote
                i++; 

                //se intrecambian los valores
                Comparable temp = arr[i]; 
                arr[i] = arr[j]; 
                arr[j] = temp; 
            } 
        } 
  
        //se intercambian los valores
        Comparable temp = arr[i+1]; 
        arr[i+1] = arr[high]; 
        arr[high] = temp; 
  
        return i+1; 
    } 
  
      /** 
    * metodo sort parte de funcionamiento de Quicksort
    * @return Comparable[]
    * @param Comparable[] 
    */

    Comparable[] sort(Comparable arr[], int low, int high) 
    { 
        //recorre lista
        if (low < high){   
            int pi = particion(arr, low, high);  //llama al metodo de particion que divide la lista en dos partes
  
            //utiliza recursividad para ordenamineto de listas
            sort(arr, low, pi-1); 
            sort(arr, pi+1, high); 
        } 

        return arr;
    } 
   
    //........................................................................................................
    /** 
     * metodos MergeSort
     * @return Comparable[]
     * @param Comparable[] 
     */
    public Comparable[] MergeSort(Comparable[] datos) {
		onlySort(datos, 0, datos.length-1); //funcionamiento del ordenamiento
		return datos;
	}
    
    /** 
     * metodo sortMerge el cual ir� mezclando o comparando los n�meros para el MergeSort
     * @return Comparable[]
     * @param Comparable[] 
     */
    Comparable[] sortMerge(Comparable[] datos, int left, int middle, int right) {
		Comparable[] t = new Comparable[datos.length]; //contiene todos los valores que se ir�n cambiando
		int i = left, j = middle + 1, leftT = left;

		while (!(i > middle && j > right)) { //valores son mayores a pivote y derechos
			if ((i > middle) || (j <= right) && (datos[j].compareTo(datos[i]) < 0)) { //compara si el n�mero en posici�n j es menor al pivote 
				t[leftT] = datos[j]; //se guardar� en el Comparable[] t
				j += 1; //incrementa en 1
			} else {
				t[leftT] = datos[i]; 
				i += 1;
			}
			leftT += 1;
		}
		for (int iS = left; iS <= right; iS++) {
			datos[iS] = t[iS]; // regresa los datos almacenados en t a los datos originales
		}
		return datos;
	}

    /** 
     * metodo onlySort el cual dividir� en dos los datos obtendiso
     * @return Comparable[]
     * @param Comparable[] 
     */
	Comparable[] onlySort(Comparable datos[], int small, int big) {
		int center = 0; //n�mero pivote de la partici�n
		if (small < big) { 
			center = (small + big) / 2; //dividir� a la mitad la cantidad de n�meros que se tenga
			onlySort(datos, small, center); //m�todo recursivo que devolver� n�meros menores al pivote
			onlySort(datos, center + 1, big); //m�todo recursivo que devolver� n�meros mayores al pivote
			sortMerge(datos, small, center, big); //m�todo recursivo para unir y realizar la ordenaci�n de los n�meros
		}
		return datos;
	}
	//Referencia de Platzi
	//........................................................................................................
	 /** 
     * metodos RadixSort
     * @return Comparable[]
     * @param Comparable[] 
     */
	public Comparable[] RadixSort(Comparable[] datos) {
		onlyRadix(datos, datos.length);
        return datos;
    }

	/** 
     * metodos onlyRadix determinar� los valores m�ximos y m�nimos
     * @return Comparable[]
     * @param Comparable[] 
     */
    Comparable[] onlyRadix(Comparable[] datos, int size) {
        Comparable[] t = new Comparable[datos.length];

        // Determine minimum and maximum values
        int min = 0;
        int max = 0;
        for (int i = 1; i < datos.length; i++) {
            if (datos[i].compareTo(min) < 0) {
                t[min] = datos[i];
                //i++;
            } else if (datos[i].compareTo(max) > 0) {
                t[max] = datos[i];
                i++;
            }
        }

        // Perform counting sort on each exponent/digit, starting at the least
        // significant digit
        int exponent = 1;
        while ((max - min) / exponent >= 1) {
        	digitByDigit(datos, size, exponent, min);
            exponent *= size;
        }
        return datos;
    }

    /** 
     * metodos digitByDigit servir� para ir comparando d�gito por d�gito
     * @return Comparable[]
     * @param Comparable[] 
     */
    Comparable[] digitByDigit(Comparable[] datos, int radix, int exp, int min) {
        int pivot;
        int[] buckets = new int[radix];
        Comparable[] t = new Comparable[datos.length]; //contiene todos los valores que ir�n cambiando

        // Initialize bucket
        for (int i = 0; i < radix; i++) {
            buckets[i] = 0;
        }

        // Count frequencies
        for (int i = 0; i < datos.length; i++) {
        	pivot = (((datos[i].compareTo(min)-min) / exp) % radix);
            buckets[pivot]++;
        }

        // Compute cumulates
        for (int i = 1; i < radix; i++) {
            buckets[i] += buckets[i - 1];
        }

        // Move records
        for (int i = datos.length - 1; i >= 0; i--) {
        	pivot = (((datos[i].compareTo(min)-min) / exp) % radix);
            t[--buckets[pivot]] = datos[i];
        }

        // Copy back
        for (int i = 0; i < datos.length; i++) {
        	datos[i] = t[i];
        }
        return datos;
    }
	//Java Sorting Algorithms Radix
	
}