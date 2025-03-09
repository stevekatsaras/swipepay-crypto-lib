package io.swipepay.cryptoservicelib.client;

import org.junit.Before;
import org.junit.Test;

import io.swipepay.cryptoservicelib.exception.CryptoServiceClientException;
import io.swipepay.cryptoservicelib.payload.DecryptRequest;
import io.swipepay.cryptoservicelib.payload.DecryptResponse;
import io.swipepay.cryptoservicelib.payload.EncryptRequest;
import io.swipepay.cryptoservicelib.payload.EncryptResponse;
import io.swipepay.cryptoservicelib.payload.KeyResponse;

public class CryptoServiceClientTest {
	CryptoServiceClientProperties properties;
	
	@Before
	public void setUp() {
		properties = new CryptoServiceClientProperties(
				"http://localhost:8080", 
				"15000", 
				"15000", 
				"cryptoserviceauthuser", 
				"cuXC=4!Kj2KD@3VT");
	}
	
	@Test
	public void testGenerateKey() {
		CryptoServiceClient client = new CryptoServiceClient(properties);
		try {
			KeyResponse keyResponse = client.generateKey();
			System.out.println(keyResponse);
		}
		catch (CryptoServiceClientException exception) {
			System.out.println(exception.getCryptoResponse());
		}
	}
	
	@Test
	public void testEncryptData() {
		CryptoServiceClient client = new CryptoServiceClient(properties);
		try {
			EncryptResponse encryptResponse = client.encrypt(new EncryptRequest(
					"AQEDAHh4m0iiDfRZYxrBQRrQ8d2YCazn0jZOC7ScxJMJSxaJ8wAAAG4wbAYJKoZIhvcNAQcGoF8wXQIBADBYBgkqhkiG9w0BBwEwHgYJYIZIAWUDBAEuMBEEDMLooB1/WZd/UpAraQIBEIArTJmj6SZO7QkbzHv+dvtcgRjiDXpodSMyWJ/+nqZGTsj4EBiuywgN+qYykQ==", 
					"4444333322221111"));
			System.out.println(encryptResponse);
		}
		catch (CryptoServiceClientException exception) {
			System.out.println(exception.getCryptoResponse());
		}
	}
	
	@Test
	public void testDecryptData() {
		CryptoServiceClient client = new CryptoServiceClient(properties);
		try {
			DecryptResponse decryptResponse = client.decrypt(new DecryptRequest(
					"AQEDAHh4m0iiDfRZYxrBQRrQ8d2YCazn0jZOC7ScxJMJSxaJ8wAAAG4wbAYJKoZIhvcNAQcGoF8wXQIBADBYBgkqhkiG9w0BBwEwHgYJYIZIAWUDBAEuMBEEDMLooB1/WZd/UpAraQIBEIArTJmj6SZO7QkbzHv+dvtcgRjiDXpodSMyWJ/+nqZGTsj4EBiuywgN+qYykQ==", 
					"Zzc5BaR3YuNnJiq+JxpWaD0kZz6KsEo88hniTzzRAC8="));
			System.out.println(decryptResponse);
		}
		catch (CryptoServiceClientException exception) {
			System.out.println(exception.getCryptoResponse());
		}
	}
}