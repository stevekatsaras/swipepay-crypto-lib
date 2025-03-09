package io.swipepay.cryptoservicelib.payload;

import java.io.Serializable;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public class EncryptResponse extends CryptoResponse implements Serializable {
	private static final long serialVersionUID = 1L;
	private String cipherDataKey;
	private String cipherTextData;
	
	public String getCipherDataKey() {
		return cipherDataKey;
	}
	
	public void setCipherDataKey(String cipherDataKey) {
		this.cipherDataKey = cipherDataKey;
	}
	
	public String getCipherTextData() {
		return cipherTextData;
	}
	public void setCipherTextData(String cipherTextData) {
		this.cipherTextData = cipherTextData;
	}
	
	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
	}
}