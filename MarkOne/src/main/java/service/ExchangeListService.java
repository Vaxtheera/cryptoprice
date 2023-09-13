package service;

import common.CommonService;
import org.apache.http.HttpEntity;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClients;

import java.util.Map;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import org.apache.http.HttpResponse;

import org.apache.http.util.EntityUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ExchangeListService extends CommonService {
        private static final Logger logger = LogManager.getLogger(ExchangeListService.class);
        String url = "https://api.coingecko.com/api/v3/exchanges/list";
        ExchangeListService list = new ExchangeListService();
        try{
                String reqSCB = mapper().writeValueAsString(requestFraudSCBDTO);
                HttpResponse response = postRequest(reqSCB, url, headers);
                HttpEntity responseEntity = response.getEntity();
                String responseString = EntityUtils.toString(responseEntity,"UTF-8");
                logger.info(responseString);
        }


}
