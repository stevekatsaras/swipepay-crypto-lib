package io.swipepay.cryptoservicelib.exception;

import io.swipepay.cryptoservicelib.payload.CryptoResponse;

public class CryptoServiceClientException extends RuntimeException {
	private static final long serialVersionUID = 1L;
	private CryptoResponse cryptoResponse;
	
	public CryptoServiceClientException(String message, Throwable cause, CryptoResponse cryptoResponse) {
		super(message, cause);
		this.cryptoResponse = cryptoResponse;
	}
	
	public CryptoResponse getCryptoResponse() {
		return cryptoResponse;
	}
}