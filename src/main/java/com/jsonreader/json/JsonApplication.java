package com.jsonreader.json;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.io.FileReader;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

@SpringBootApplication
public class JsonApplication {
    
	public static void main( String[] args ) {

        JSONParser jsonParser = new JSONParser();

        try (FileReader reader = new FileReader("parking.json")) {

            Object object = jsonParser.parse(reader);
            JSONArray listParking = (JSONArray) object;

            listParking.forEach(parking -> parseParkingData((JSONObject)parking));

        } catch (Exception e) {
            // TODO: handle exception
        }

    }

    private static void parseParkingData(JSONObject parkingData) {
        System.out.println(parkingData.get("nome"));
        System.out.println(Integer.parseInt(parkingData.get("idade").toString()));
        System.out.println(parkingData.get("CPF"));


        System.out.println(parkingData.get("Automoveis: "));
        JSONArray arrayAutomoveis = (JSONArray) parkingData.get("automoveis");
        for(Object automovel: arrayAutomoveis) {
            System.out.println(automovel + " ");
        }
        System.out.println("\n ---------");

    }

}
