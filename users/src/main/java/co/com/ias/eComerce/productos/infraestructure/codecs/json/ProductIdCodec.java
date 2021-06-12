package co.com.ias.eComerce.productos.infraestructure.codecs.json;

import co.com.ias.eComerce.productos.application.domain.ProductId;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import org.springframework.boot.jackson.JsonComponent;

import java.io.IOException;

@JsonComponent

public class ProductIdCodec {
    public static class ProductIdEncoder extends JsonSerializer<ProductId> {

        @Override
        public void serialize(ProductId identificationNumber, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
            jsonGenerator.writeString(identificationNumber.getValue());
        }
    }

    public static class ProductIdDecoder extends JsonDeserializer<ProductId> {

        @Override
        public ProductId deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
            final String valueAsString = jsonParser.getValueAsString();
            return ProductId.parse(valueAsString, "inputData").get();
        }
    }
}
