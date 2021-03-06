package ru.itits.javalab.util;

import com.github.opendevl.JFlat;

import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;

public class CsvWriterImpl implements CsvWriter {
    private JFlat jFlat;
    public CsvWriterImpl(String json){
        jFlat = new JFlat(json);
        try {
            jFlat.json2Sheet().headerSeparator("_").getJsonAsSheet();
        } catch (Exception e) {
            throw new IllegalArgumentException(e);
        }
    }
    public void writeToCsv(String path){
        try {
            jFlat.write2csv(path);
        } catch (FileNotFoundException | UnsupportedEncodingException e) {
            throw new IllegalArgumentException(e);
        }
    }
}
