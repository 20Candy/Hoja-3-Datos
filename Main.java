/******************************************************************
@author Carol Arevalo 
@since 12/02/21

class main - controlador
******************************************************************/

import java.util.Scanner;
import java.util.Random;
import java.io.File;
import java.io.FileNotFoundException;

class Main{

	public static void main(String[] args){

    //instancias
    generador g= new generador();
    Scanner scan = new Scanner(System.in);
    sorts s= new sorts();
    Random r = new Random();
   
    //generar canditada de datos datos y guarador en txt
    int cantidad_numeros = r.nextInt(3000) + 10;
    g.datos(cantidad_numeros);
   

    //lee txt y lo guarda en un array
    Comparable<Integer>[] datos = new Comparable [cantidad_numeros];
    datos= g.Read(cantidad_numeros);

    //Menu**************************************************************************************************************************
    int opcion = -1;
    while (opcion != 6){

        //-----------------------------------------------------------------------------------------------------------------------
        System.out.println("\n\nBienvenido al programa de sorts");
        System.out.println("1. BubbleSort");
        System.out.println("2. GnomeSort");
        System.out.println("3. QuickSort");
        System.out.println("4. MergeSort");
        System.out.println("5. RadixSort");
        System.out.println("6. Salir\n\n");
        
        opcion = scan.nextInt();
        
        if (opcion == 1){

            Comparable<Integer>[] datosG= s.BubbleSort(datos);

            for(int i=0; i< cantidad_numeros; i++){
                System.out.println(datosG[i]);
            }
            

        } else if (opcion == 2){
            
            Comparable<Integer>[] datosGn= s.GnomeSort(datos);

           for(int i=0; i< cantidad_numeros; i++)1{
            System.out.println(datosGn[i]);
        }

        } else if (opcion == 3){
            Comparable<Integer>[] datosQ= s.QuickSort(datos);

           for(int i=0; i< cantidad_numeros; i++){
            System.out.println(datosQ[i]);
        }

        } else if (opcion == 4){
            
        } else if (opcion == 5){
           

        } else if (opcion == 6){
            scan.close(); //cierra ciclo
            System.out.println("Ha cerrado el programa :)");

        }else{
            System.out.println("La opción es incorrecta");
        }

    }
}
}