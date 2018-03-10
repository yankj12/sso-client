package com.yan.access.util;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URI;
import java.nio.charset.Charset;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpResponseException;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.entity.ContentType;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.yan.access.vo.ResponseVo;

public class HttpJsonUtil {

	public static ResponseVo sendGetRequest(URI uri) {
		ResponseVo responseVo = null;
		CloseableHttpClient httpClient = HttpClients.createDefault();
		HttpGet httpget = null;
		
		try {
			httpget = new HttpGet(uri);
			ResponseHandler<ResponseVo> rh = new ResponseHandler<ResponseVo>() {  
			  
			    @Override  
			    public ResponseVo handleResponse(  
			            final HttpResponse response) throws IOException {  
			        StatusLine statusLine = response.getStatusLine();  
			        HttpEntity entity = response.getEntity();  
			        if (statusLine.getStatusCode() >= 300) {  
			            throw new HttpResponseException(  
			                    statusLine.getStatusCode(),  
			                    statusLine.getReasonPhrase());  
			        }  
			        if (entity == null) {  
			            throw new ClientProtocolException("Response contains no content");  
			        }  
			        Gson gson = new GsonBuilder().create();  
			        ContentType contentType = ContentType.getOrDefault(entity);  
			        Charset charset = contentType.getCharset();  
			        Reader reader = new InputStreamReader(entity.getContent(), charset);  
			        return gson.fromJson(reader, ResponseVo.class);  
			    }
			};  
			responseVo = httpClient.execute(httpget, rh); 
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
            try {
                httpClient.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
		return responseVo;
	}
}
