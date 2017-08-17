package in.abc;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class U {
    public final static String URL = "http://localhost:8010/product-app";

    public static String post(String urlStr, String data) {
        try{
            java.net.URL url = new URL(urlStr);
            HttpURLConnection cn = (HttpURLConnection) url.openConnection();
            cn.setDoOutput(true);
            cn.getOutputStream().write(data.getBytes());
            cn.getOutputStream().flush();

            return  getString(cn.getInputStream());

        }catch (Exception ex) {
            System.out.println("Error in U::post() " + ex);
        }
        return "";
    }


    public static String getString(InputStream inputStream) {
        try(BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream))) {
            String line = null;
            StringBuilder sb = new StringBuilder();

            while (( line = reader.readLine())!=null) {
                sb.append(line);
            }
           return  sb.toString();
        }catch (Exception ex) {
            System.out.println("Error in U::getString() : " + ex);
        }
        return  "";
    }

}
