package com.neurosoft.archivos;

import java.io.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class Archivos {
    public static void main(String[] args) {

        //Busca el path del archivo
        URL url = Archivos.class.getResource("/datos.txt");
        //Crea la variable de tipo archivo
        File file = new File(url.getFile());

        List<Integer> caracteres = new ArrayList<>();

        try{
    //Crea un lector de archivo
    FileReader fileReader = new FileReader(file);
    int c;
    while(( c = fileReader.read()) != -1){
        //Dipuja por consola cada caracter del archivo leido por el lector de archivo. Este lo lee en ANSI, por eso se tiene que parsear a char
        System.out.print((char)c);
        //Agrega a la Lista creada cada caracteres.
        caracteres.add(c);
    }

fileReader.close();
} catch (FileNotFoundException e) {
    e.printStackTrace();
} catch (IOException e) {
    e.printStackTrace();
}
String textoExtra = "ExtrEMADO";
//try-with-resurces. Permite hacer un try con cosas "cerrables-CLOSEABLES"

        try(FileWriter fileWriter = new FileWriter("salida.txt")){
            for (Integer c: caracteres){
                fileWriter.write(c);
            }
            //Agrega una linea
            fileWriter.write("\n");
            //Agrega un array de carateres
            fileWriter.write(textoExtra);
        } catch (IOException e) {
            e.printStackTrace();
        }


//ESTE BLOQUE ES EVITADO POR EL TRY-WITH-RESOURCES
        //Crea un escritor de archivo, Se tiene que tener cuidado porque este metodo pisa el archivo
       /* FileWriter fileWriter = null;
try {
    fileWriter = new FileWriter("salida.txt");

    for (Integer c: caracteres){
        fileWriter.write(c);
    }
    //Agrega una linea
    fileWriter.write("\n");
//Agrega un array de carateres
    fileWriter.write(textoExtra);
    fileWriter.flush();
    fileWriter.close();


} catch (Exception e) {
    e.printStackTrace();
}finally {
    if(fileWriter!=null){
        try {
            fileWriter.flush();
            fileWriter.close();
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }
}*/

try(FileReader fileReader = new FileReader(file);
    BufferedReader bufferedReader = new BufferedReader(fileReader)){

    String linea = null;
    while ((linea=bufferedReader.readLine()) !=null){
        System.out.println(linea);
    }

    } catch (FileNotFoundException e) {
    e.printStackTrace();
} catch (IOException e) {
    e.printStackTrace();
}
    }
}
