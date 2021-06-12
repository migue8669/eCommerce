package co.com.ias.eComerce.commons;

public class StringUtils {
    public static boolean nonBlank(String value){
        String trimmed=value.trim();
        return trimmed.length()>0;
    }
}
