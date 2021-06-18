package co.com.ias.Ecomerce.commons;

public class StringUtils {
    public static boolean nonBlank(String value){
        String trimmed=value.trim();
        return trimmed.length()>0;
    }
}
