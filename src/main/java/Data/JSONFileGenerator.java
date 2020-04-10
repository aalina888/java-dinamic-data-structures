package Data;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

public class JSONFileGenerator {
    public static City[] createCitiesArray() {
        City cities[] = new City[50];
        String[] postalCodes = {"AD/AD100", "US/20020", "AS/96799", "AT/1010", "AU/0200",
                "US/30301", "BE/1000", "RE/97400", "BR/01000-000", "US/60601",
                "US/10001", "US/27565", "DE/01067", "DK/0800", "US/90001",
                "ES/01001", "FI/00002", "FO/100", "FR/01000", "TR/01000",
                "GF/97300", "GG/GY1", "GL/2412", "GP/97100", "VA/00120",
                "GU/96910", "GY/97312", "HR/10000", "HU/1011", "IM/IM1",
                "IN/110001", "IS/101", "IT/00010", "JE/JE1", "JP/100-0001",
                "LI/9485", "LT/00001", "LU/L-1009", "MC/98000", "MD/MD-2000",
                "MH/96960", "MK/1000", "MP/96950", "MQ/97200", "MX/01000",
                "MY/01000", "NL/1000", "NO/0001", "NZ/0110", "PT/1000-001"
        };

        for (int counter = 0; counter < 50; counter++) {
            try {
                URL url = new URL("http://api.zippopotam.us/" + postalCodes[counter]);
                HttpURLConnection con = (HttpURLConnection) url.openConnection();
                con.setRequestMethod("GET");

                BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
                String inputLine;
                StringBuilder content = new StringBuilder();
                while ((inputLine = in.readLine()) != null) {
                    content.append(inputLine);
                }

                cities[counter] = new ObjectMapper().readValue(content.toString(), City.class);
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }

        return cities;
    }

    public static void createCitiesFile(City[] cities, String filename) {
        try(FileOutputStream outputStream = new FileOutputStream(new File(filename))) {
            for (int counter = 0; counter < 50; counter ++) {
                byte[] buffer = cities[counter].toString().getBytes();

                outputStream.write(buffer, 0, buffer.length);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
