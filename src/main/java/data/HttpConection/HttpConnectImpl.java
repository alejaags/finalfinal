package data.HttpConection;

import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

@Service
public class HttpConnectImpl implements HttpConnect {


    //http://www.omdbapi.com/?t=Guardians+of+the+Galaxy+Vol.+2&y=2017&apikey=28075c2c
    private static final String USER_AGENT = "Mozilla/5.0";
    private static final String GET_URL = "http://www.omdbapi.com/?t=%s&y=%s&apikey=28075c2c";

    @Override
    public StringBuffer httpcenter(String empresa, String date) throws IOException {
        URL url = new URL(String.format(GET_URL,empresa,date));
        return conectorCenterData(url);
    }

    public StringBuffer conectorCenterData(URL ulr) throws IOException {
        HttpURLConnection con = (HttpURLConnection) ulr.openConnection();
        con.setRequestMethod("GET");
        con.setRequestProperty("User-Agent", USER_AGENT);

        //The following invocation perform the connection implicitly before getting the code
        int responseCode = con.getResponseCode();
        System.out.println("GET Response Code :: " + responseCode);

        StringBuffer response = new StringBuffer();

        if (responseCode == HttpURLConnection.HTTP_OK) { // success
            BufferedReader in = new BufferedReader(new InputStreamReader(
                    con.getInputStream()));
            String inputLine;

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();

            // print result
            System.out.println(response.toString());
        } else {
            System.out.println("GET request not worked");
        }
        return response;
    }


}
