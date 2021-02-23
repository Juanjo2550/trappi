/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epn.trappi.db.proveedores;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Peterca
 */
public class Archivo {

    public static final String SEPARATOR = ";";
    public static final String QUOTE = "\"";

    public List<String[]> leerArchivoCSV(String name) throws IOException {
        List<String[]> contenido = new ArrayList<String[]>();
        BufferedReader br = null;

        try {

            br = new BufferedReader(new FileReader(name,StandardCharsets.UTF_8));
            String line = br.readLine();
            while (null != line) {
                String[] fields = line.split(SEPARATOR);
                fields = removeTrailingQuotes(fields);
                contenido.add(fields);
                line = br.readLine();
            }

            /*for(String[] c : contenido){
                System.out.println(Arrays.toString(c));
            }*/
            return contenido;

        } catch (Exception e) {
            System.out.println(e);
        } finally {
            if (null != br) {
                br.close();
            }
        }

        return null;
    }

    public void writeArchivoCSV(String path, String content) throws IOException {
        BufferedWriter bw = null;
        try {
            FileWriter fw = new FileWriter(path, true);
            bw = new BufferedWriter(fw);
            PrintWriter pw = new PrintWriter(bw);
            pw.println(content);
            pw.flush();
            pw.close();
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            if (null != bw) {
                bw.close();
            }
        }
    }

    private String[] removeTrailingQuotes(String[] fields) {
        String result[] = new String[fields.length];
        for (int i = 0; i < result.length; i++) {
            result[i] = fields[i].replaceAll("^" + QUOTE, "").replaceAll(QUOTE + "$", "");
        }
        return result;
    }
}
