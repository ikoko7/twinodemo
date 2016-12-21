package ge.twino.utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * Created by SHEMO on 12/21/2016.
 */
public class GsonUtils {
    public static String defaultDateTimeFormat = "yyyy-MM-dd'T'HH:mm:ssZ";
    private static GsonBuilder gsonBuilder = new GsonBuilder().setDateFormat(defaultDateTimeFormat);

    /***
     * Creates a GSON instance from the builder with the default date/time format
     *
     * @return the GSON instance
     */
    public static Gson createGson() {
        // Create with default params
        gsonBuilder = gsonBuilder.setDateFormat(defaultDateTimeFormat);
        return gsonBuilder.create();
    }

    /***
     * Creates a GSON instance from the builder specifying custom date/time format
     *
     * @return the GSON instance
     */
    public static Gson createGson(String dateTimeFormat) {
        // Create with the specified dateTimeFormat
        gsonBuilder = gsonBuilder.setDateFormat(dateTimeFormat);
        return gsonBuilder.create();
    }
}
