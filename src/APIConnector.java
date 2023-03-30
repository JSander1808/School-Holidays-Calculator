import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.time.LocalDate;

public class APIConnector {

    public static String url = "https://ferien-api.de/";
    public static String api = "https://ferien-api.de/api/v1/holidays/";
    public static String getDataStringFromApi(){
        try {
            InputStream input = new URL(api).openStream();
            InputStreamReader inputStreamReader = new InputStreamReader(input);
            BufferedReader reader = new BufferedReader(inputStreamReader);
            StringBuilder json = new StringBuilder();
            int l;
            while((l = reader.read())!=-1){
                json.append((char) l);
            }
            return json.toString();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static String getDataStringFromApi(String stateCode){
        try {
            InputStream input = new URL(api+stateCode).openStream();
            InputStreamReader inputStreamReader = new InputStreamReader(input);
            BufferedReader reader = new BufferedReader(inputStreamReader);
            StringBuilder json = new StringBuilder();
            int l;
            while((l = reader.read())!=-1){
                json.append((char) l);
            }
            return json.toString();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static String getDataStringFromApi(String stateCode, int year){
        try {
            InputStream input = new URL(api+stateCode+"/"+year).openStream();
            InputStreamReader inputStreamReader = new InputStreamReader(input);
            BufferedReader reader = new BufferedReader(inputStreamReader);
            StringBuilder json = new StringBuilder();
            int l;
            while((l = reader.read())!=-1){
                json.append((char) l);
            }
            return json.toString();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static Holiday[] getHolidays(String jsonContent){
        JSONArray response = new JSONArray(jsonContent);
        Holiday[] holidays = new Holiday[response.length()];
        for(int i = 0;i<response.length();i++){
            JSONObject object = response.getJSONObject(i);
            Holiday tempHoliday = new Holiday(
                    LocalDate.parse(object.getString("start")),
                    LocalDate.parse(object.getString("end")),
                    object.getInt("year"),
                    object.getString("stateCode"),
                    object.getString("name").split(" ")[0],
                    object.getString("slug")
            );
            holidays[i]=tempHoliday;
        }
        return holidays;
    }

    public static Holiday getHoliday(Holiday[] holidays, String stateCode, int year, String name){
        for(int i = 0;i< holidays.length;i++){
            if(holidays[i].getName().equals(name)&&holidays[i].getYear()==year&&holidays[i].getStateCode().equals(stateCode)){
                return holidays[i];
            }
        }
        return null;
    }

    public static Holiday getHoliday(String jsonContent, String stateCode, int year, String name){
        Holiday[] holidays = getHolidays(jsonContent);
        for(int i = 0;i< holidays.length;i++){
            if(holidays[i].getName().equals(name)&&holidays[i].getYear()==year&&holidays[i].getStateCode().equals(stateCode)){
                return holidays[i];
            }
        }
        return null;
    }
}
