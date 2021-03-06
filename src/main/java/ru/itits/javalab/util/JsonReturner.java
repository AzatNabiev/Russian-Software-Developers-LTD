package ru.itits.javalab.util;

import org.json.JSONObject;

import java.io.Reader;

public interface JsonReturner {
    JSONObject readJsonFromUrl(String url);
    String readAll(Reader rd);
}
