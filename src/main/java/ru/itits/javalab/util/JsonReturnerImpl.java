package ru.itits.javalab.util;

import org.json.JSONObject;

import java.io.*;
import java.net.URL;
import java.nio.charset.Charset;

public class JsonReturnerImpl implements JsonReturner {
    @Override
    public JSONObject readJsonFromUrl(String url) {
        InputStream is = null;
        try {
            is = new URL(url).openStream();
            BufferedReader rd = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
            String jsonText = readAll(rd);
            JSONObject json = new JSONObject(jsonText);
            is.close();
            return json;
        } catch (IOException e){
            throw  new IllegalArgumentException(e);
        }
    }

    @Override
    public String readAll(Reader rd) {
        StringBuilder sb = new StringBuilder();
        int cp;
        int i = 0;
        try {
            while ((cp = rd.read()) != -1) {
                if ((char) cp != '{' && i == 0) {
                    continue;
                } else {
                    i = 1;
                    sb.append((char) cp);
                }
            }
        }catch (IOException e){
            throw new IllegalArgumentException(e);
        }
        return sb.toString();
    }
}
