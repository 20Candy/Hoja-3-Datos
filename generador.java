/******************************************************************
@author Carol Arevalo 
@since 12/02/21

class generador
******************************************************************/


import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

/**
*Escritura y lectura de archivos
*manejo de datos tipo Comparable
*/ 

public class generador {

    /** 
    * constructor
    *
    */
    generador() {
    }

    /** 
    * metodos datos
    * @return void
    * @param int 
    */
    public void datos(int cantidad_numeros){

        try{
            //crea el archivo
            String archivo = "datos.txt";
            File f = new File(archivo);
            f.delete();
            f.createNewFile();

            //escribir 
            PrintWriter writer = new PrintWriter(archivo, "UTF-8");
           
            //genera numeros
            Random r = new Random();
            for (int i = 0; i < cantidad_numeros; i++) {
                int numero = r.nextInt(1000) + 1;
                writer.println(numero); 
            }
            writer.close();
           
        }catch (IOException ioe){
            ioe.printStackTrace();
        }
        
    }

    /** 
    * metodo de lectura
    * @return Comparable[]
    * @param int
    */
    public Comparable[] Read(int cantidad_numeros){
        //crear un array con los datos del archivo
        Comparable<Integer>[] datos = new Comparable [cantidad_numeros];
        String nombreFichero = "datos.txt";
        BufferedReader br = null;

        try {
           //se instancua Buffer para lectura de archivo
           br = new BufferedReader(new FileReader(nombreFichero));
           
           //minentras la lista sea menor a la cantidad de numero va a leer linea por liena
           for(int i=0; i<cantidad_numeros; i++){
                int texto = Integer.valueOf(br.readLine());
                Comparable<Integer> dato= (Comparable)texto;
                datos[i]= texto;
                
           }
           
        }
        catch (FileNotFoundException e) {
            System.out.println("Error: Fichero no encontrado");
            System.out.println(e.getMessage());
            
        } catch (IOException e) {

            e.printStackTrace();
        }
            
        return datos;
    }
       
     
}