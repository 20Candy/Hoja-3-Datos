/******************************************************************
@author Carol Arevalo
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
            if (arr[j].compareTo(pivot) <=0){  //si el numero en la posicion j es mas pequeño que el pivote
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
    public Comparable[] MergeSort(Comparable [] datos){

        return datos; 
    }

    public Comparable[] RadixSort(Comparable [] datos){

        return datos; 
    }

    



    
}
