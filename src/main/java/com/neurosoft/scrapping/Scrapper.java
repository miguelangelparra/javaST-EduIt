package com.neurosoft.scrapping;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;


public class Scrapper {
    public static void main(String[] args) throws IOException {
        //Crea url
        URL url = new URL("https://www.dolarhoy.com/cotizacion-dolar-blue");
        //Establece conexion con Url y deposita la respuesta en un reader
        Reader reader = new InputStreamReader(url.openConnection().getInputStream());

        /*
        //Lee por caracter
        System.out.println("POr caracter");
        int c = -1;
        while((c=reader.read())!=-1){
            System.out.print((char)c);
        }
*/

        //Lee por linea
        System.out.println("POr Linea");
        BufferedReader bufferedReader = new BufferedReader(reader);
String linea = null;
while((linea=bufferedReader.readLine()) != null){
    System.out.println(linea);
}

bufferedReader.close();
//Libreria JSOUP
        System.out.println("Esto es hecho con JSOUP");
        Document doc = Jsoup.connect("https://en.wikipedia.org/").get();
System.out.println(doc.title());
        Elements newsHeadlines = doc.select("#mp-itn b a");
        for (Element headline : newsHeadlines) {
            System.out.printf("%s\n\t%s",
                    headline.attr("title"), headline.absUrl("href"));
        }
    }
}
