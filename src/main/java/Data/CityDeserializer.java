package Data;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;

import java.io.IOException;

public class CityDeserializer extends StdDeserializer<City> {

    public CityDeserializer() {
        this(null);
    }

    public CityDeserializer(Class<?> vc) {
        super(vc);
    }

    @Override
    public City deserialize(JsonParser jp, DeserializationContext ctxt) throws IOException, JsonProcessingException {
        JsonNode node = jp.getCodec().readTree(jp);

        String name = node.get("places").get(0).get("place name").asText();
        String country = node.get("country").asText();
        String postalCode = node.get("post code").asText();
        double longitude = node.get("places").get(0).get("longitude").asDouble();
        double latitude = node.get("places").get(0).get("latitude").asDouble();

        return new City(name, country, postalCode, longitude, latitude);
    }
}
