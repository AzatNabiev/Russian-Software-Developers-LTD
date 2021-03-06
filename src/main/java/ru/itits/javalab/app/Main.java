package ru.itits.javalab.app;

import org.json.JSONObject;
import ru.itits.javalab.util.CsvWriterImpl;
import ru.itits.javalab.util.JsonReturner;
import ru.itits.javalab.util.JsonReturnerImpl;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        String firstPart="https://gpsfront.aliexpress.com/getRecommendingResults.do?widget_id=5547572&limit=10&callback=jQuery18307747424644988596_1614942071082&offset=";
        String secondPart="&postback=f6949074-c4eb-4c66-a6ba-ab8ea83d89b1";
        String csvFilePath="src\\main\\resources\\data.csv";
        StringBuilder stringBuilder;
        JsonReturner jsonReturner = new JsonReturnerImpl();
        int offset=0;
        for (int i=0;i<10;i++){
            stringBuilder = new StringBuilder();
            stringBuilder.append(firstPart).append(offset).append(secondPart);
            JSONObject json = jsonReturner.readJsonFromUrl(stringBuilder.toString());
            CsvWriterImpl csvWriter = new CsvWriterImpl(json.toString());
            csvWriter.writeToCsv(csvFilePath);
            offset+=10;
        }
    }
}
