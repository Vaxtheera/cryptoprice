package common;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClients;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.util.Map;

public class CommonService {
    private static final Logger logger = LogManager.getLogger(CommonService.class);
    public HttpResponse getRequest (String url, Map<String,String> headers){
        try {
            logger.info("header : " + new ObjectMapper().writeValueAsString(headers));
            logger.info("url    : " + url);

            HttpClient client = HttpClients.createSystem();
            HttpGet get = new HttpGet(url);

            //set header
            for (Map.Entry<String,String> headerEntry :headers.entrySet()) {
                get.setHeader(headerEntry.getKey(),headerEntry.getValue());
            }


            HttpResponse response = client.execute(get); // Use the initialized httpClient here

            return response;

        } catch (IOException e) {
            String msg = getErrorMsg(e);
            logger.error(msg);
            throw new ResponseException("ERROR_EXCEPTION_OCCURRED", msg);
        }
    }
    public static String getErrorMsg(Exception ex) {
        return ex.toString() + " occurred at " +
                ex.getStackTrace()[0].getClassName() + "." + ex.getStackTrace()[0].getMethodName() +
                " (Line no." + ex.getStackTrace()[0].getLineNumber() + ")";
    }
}
