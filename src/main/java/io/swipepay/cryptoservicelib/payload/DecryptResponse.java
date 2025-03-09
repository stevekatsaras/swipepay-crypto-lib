package io.swipepay.cryptoservicelib.payload;

import java.io.Serializable;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringExclude;
import org.apache.commons.lang3.builder.ToStringStyle;

public class DecryptResponse extends CryptoResponse implements Serializable {
	private static final long serialVersionUID = 1L;
	private String cipherDataKey;
	
	@ToStringExclude
	private String plainTextData;
	
	public String getCipherDataKey() {
		return cipherDataKey;
	}
	
	public void setCipherDataKey(String cipherDataKey) {
		this.cipherDataKey = cipherDataKey;
	}
	
	public String getPlainTextData() {
		return plainTextData;
	}
	
	public void setPlainTextData(String plainTextData) {
		this.plainTextData = plainTextData;
	}
	
	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
	}
}