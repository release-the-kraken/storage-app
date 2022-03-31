import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class JSONReadWrite {
Gson gson = new GsonBuilder().setPrettyPrinting().create();
//writing an array of objects to json file
    public void writeToJSON(Object[] array, String fileName){
        try {
            Writer writer = Files.newBufferedWriter(Paths.get(fileName));
            gson.toJson(array, writer);
            writer.close();
        }catch(Exception ex){
            ex.printStackTrace();
        }

    }
    //reading from json file
    public void readFromJSON(Object[] array, String fileName){
        try {
            Reader reader = Files.newBufferedReader(Paths.get(fileName));
            Product[] list = gson.fromJson(reader, Product[].class);
            //assigning items from json response object to listOfProducts array that hold our products
            for(int i = 0; i < array.length; i++){
                array[i] = list[i];
            }
            reader.close();
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }

}
