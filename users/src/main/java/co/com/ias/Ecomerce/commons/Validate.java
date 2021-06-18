package co.com.ias.Ecomerce.commons;

public class Validate {
    public static void notNull(Object value,String message){
        if(value==null){
            throw new NullPointerException(message);
        }
    }
    public static void isTrue(boolean condition, String message){
        if(!condition){
            throw new IllegalArgumentException(message);
        }
    }
}
