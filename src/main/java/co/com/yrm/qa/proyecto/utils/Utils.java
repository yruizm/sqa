package co.com.yrm.qa.proyecto.utils;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;

public class Utils {

    private static final String AVISO = "\n----------------------------------------------------------------\n%s\n----------------------------------------------------------------";
    private static final Logger LOGGER = LoggerFactory.getLogger(Utils.class);
    
    private Utils() {
    }

    public static void esperaExplicita(long duracion) {
        try {
            String s = formatiarAviso("se pausa el programa por " + (duracion / 1000L) + "s");
            LOGGER.info(s);
            Thread.sleep(duracion);
        } catch (InterruptedException e) {
            LOGGER.info(e.getMessage());
            Thread.currentThread().interrupt();
        }
    }

    public static String formatiarAviso(String texto) {
        return String.format(AVISO, texto);
    }

    public static ArrayList<String> lsListaTraza= new ArrayList<String>();

    public static void crearArchivoTraza(String NombreArchivo) {
        try {
            FileWriter fichero = null;
            PrintWriter pw = null;
            fichero = new FileWriter("src/test/resources/InformaciónReserva/"+NombreArchivo+".txt");
            pw = new PrintWriter(fichero);

            String ruta = "src/test/resources/InformaciónReserva/"+NombreArchivo+".txt";
            File archivo = new File(ruta);
            BufferedWriter bw;
            if(archivo.exists()) {
                bw = new BufferedWriter(new FileWriter(archivo));
                //lsListaTraza.add("El fichero de texto ya estaba creado.");
            } else {
                bw = new BufferedWriter(new FileWriter(archivo));
                //lsListaTraza.add("Acabo de crear el fichero de texto.");
            }


            try
            {
                Iterator<String> nombreIterator = lsListaTraza.iterator();
                while(nombreIterator.hasNext()){
                    pw.println(nombreIterator.next());
                }

            } catch (Exception e) {
                LOGGER.info(e.toString());
            } finally {
                try {
                    // Nuevamente aprovechamos el finally para
                    // asegurarnos que se cierra el fichero.
                    if (null != fichero)
                        fichero.close();
                } catch (Exception e2) {
                    LOGGER.info(e2.toString());
                }

            }

        } catch (Exception e) {
            LOGGER.info(e.toString());
        }

    }




}
