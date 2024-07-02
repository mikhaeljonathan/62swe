package org.example;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.ResourceBundle;

public class Main {
    public static void main(String[] args) {
//        String language = "en";
//        String country = "US";

        Locale indonesia = new Locale("id", "ID");
        Locale arab = new Locale("ar", "SA");

        System.out.println(indonesia.getLanguage());
        System.out.println(indonesia.getCountry());

        System.out.println(indonesia.getDisplayLanguage());
        System.out.println(indonesia.getDisplayCountry());

        ResourceBundle resourceBundle = ResourceBundle.getBundle("message", indonesia);
        System.out.println(resourceBundle.getString("hello"));
        System.out.println(resourceBundle.getString("goodbye"));

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("EEEE dd MMMM yyyy", arab);
        String format = simpleDateFormat.format(new Date());

        System.out.println(format);

        String pattern = "EEEE dd MMMM yyyy";
        SimpleDateFormat simpleDateFormat1 = new SimpleDateFormat(pattern, arab);

        try {
            Date date = simpleDateFormat1.parse("الأحد ٠٦ يونيو ٢٠٢١");
            System.out.println(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }

    }
}