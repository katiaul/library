package katiaul.util;

import com.google.gson.*;

@SuppressWarnings("unused")
public class Json {
    public static final Json instance = new Json();

    private final Gson gson = new GsonBuilder().setPrettyPrinting().create();

    public <T> T serialize(String json, Class<T> clazz) {
        return gson.fromJson(json, clazz);
    }

    public String deserialize(Object object) {
        return gson.toJson(object);
    }
}
