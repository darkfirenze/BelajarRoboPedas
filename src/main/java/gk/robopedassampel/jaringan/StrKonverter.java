package gk.robopedassampel.jaringan;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Type;

import retrofit.converter.ConversionException;
import retrofit.converter.Converter;
import retrofit.mime.TypedInput;
import retrofit.mime.TypedOutput;

/**
 * Created by Kucing Imut on 8/7/15.
 */


public class StrKonverter implements Converter {


    @Override
    public Object fromBody(TypedInput body, Type type) throws ConversionException {

        String strteks = "";

        try {

            strteks = fromStream(body.in());

        }
        catch (Exception ex) {
            ex.printStackTrace();
            strteks = "";
        }

        return strteks;
    }

    @Override
    public TypedOutput toBody(Object object) {
        return null;
    }


    public static String fromStream(InputStream in) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(in));
        StringBuilder out = new StringBuilder();
        String newLine = System.getProperty("line.separator");
        String line;
        while ((line = reader.readLine()) != null) {
            out.append(line);
            out.append(newLine);
        }
        return out.toString();
    }


}
