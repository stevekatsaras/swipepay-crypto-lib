package io.swipepay.cryptoservicelib.client;

import java.io.IOException;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import io.swipepay.cryptoservicelib.exception.CryptoServiceClientException;
import io.swipepay.cryptoservicelib.payload.CryptoResponse;
import io.swipepay.cryptoservicelib.payload.DecryptRequest;
import io.swipepay.cryptoservicelib.payload.DecryptResponse;
import io.swipepay.cryptoservicelib.payload.EncryptRequest;
import io.swipepay.cryptoservicelib.payload.EncryptResponse;
import io.swipepay.cryptoservicelib.payload.KeyResponse;

public class CryptoServiceClient {
	private final RestTemplate restTemplate;
	
	public CryptoServiceClient(CryptoServiceClientProperties properties) {
		this.restTemplate = new RestTemplateBuilder()
				.rootUri(properties.getRootUri())
				.setConnectTimeout(Integer.parseInt(properties.getConnectTimeout()))
				.setReadTimeout(Integer.parseInt(properties.getReadTimeout()))
				.messageConverters(configureMessageConverter())
				.basicAuthorization(properties.getUsername(), properties.getPassword())
				.build();
	}
	
	public KeyResponse generateKey() throws CryptoServiceClientException {
		HttpHeaders httpHeaders = getDefaultHttpHeaders();
		HttpEntity<?> httpEntity = new HttpEntity<Object>(httpHeaders);
		
		KeyResponse keyResponse = null;
		try {
			keyResponse = restTemplate.postForObject("/key/generate", httpEntity, KeyResponse.class);
		}
		catch (HttpStatusCodeException exception) {
			throw new CryptoServiceClientException(
					"Generate key request failed", 
					exception, 
					unmarshal(exception.getResponseBodyAsString()));
		}
		catch (Exception exception) {
			throw new CryptoServiceClientException(
					"Generate key request failed", 
					exception, 
					null);
		}
		return keyResponse;
	}
	
	public EncryptResponse encrypt(EncryptRequest encryptRequest) throws CryptoServiceClientException {
		HttpHeaders httpHeaders = getDefaultHttpHeaders();
		HttpEntity<EncryptRequest> httpEntity = new HttpEntity<EncryptRequest>(encryptRequest, httpHeaders);
	
		EncryptResponse encryptResponse = null;
		try {
			encryptResponse = restTemplate.postForObject("/crypto/encrypt", httpEntity, EncryptResponse.class);
		}
		catch (HttpStatusCodeException exception) {
			throw new CryptoServiceClientException(
					"Encrypt request failed", 
					exception, 
					unmarshal(exception.getResponseBodyAsString()));
		}
		catch(Exception exception) {
			throw new CryptoServiceClientException(
					"Encrypt request failed", 
					exception, 
					null);
		}
		return encryptResponse;
	}
	
	public DecryptResponse decrypt(DecryptRequest decryptRequest) throws CryptoServiceClientException {
		HttpHeaders httpHeaders = getDefaultHttpHeaders();
		HttpEntity<DecryptRequest> httpEntity = new HttpEntity<DecryptRequest>(decryptRequest, httpHeaders);
		
		DecryptResponse decryptResponse = null;
		try {
			decryptResponse = restTemplate.postForObject("/crypto/decrypt", httpEntity, DecryptResponse.class);
		}
		catch (HttpStatusCodeException exception) {
			throw new CryptoServiceClientException(
					"Decrypt request failed", 
					exception, 
					unmarshal(exception.getResponseBodyAsString()));
		}
		catch(Exception exception) {
			throw new CryptoServiceClientException(
					"Decrypt request failed", 
					exception, 
					null);
		}
		return decryptResponse;
	}
	
	private MappingJackson2HttpMessageConverter configureMessageConverter() {
		MappingJackson2HttpMessageConverter messageConverter = new MappingJackson2HttpMessageConverter();
		messageConverter.getObjectMapper().configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
		return messageConverter;
	}
	
	private HttpHeaders getDefaultHttpHeaders() {
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.setContentType(MediaType.APPLICATION_JSON);
		return httpHeaders;
	}
	
	private CryptoResponse unmarshal(String responseBody) {
		CryptoResponse cryptoResponse;
		try {
			cryptoResponse = new ObjectMapper().readValue(responseBody, CryptoResponse.class);
		}
		catch (IOException e) {
			cryptoResponse = null;
		}
		return cryptoResponse;
	}
}