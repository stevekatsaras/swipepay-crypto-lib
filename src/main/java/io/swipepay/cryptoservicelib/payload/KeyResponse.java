package io.swipepay.cryptoservicelib.payload;

import java.io.Serializable;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public class KeyResponse extends CryptoResponse implements Serializable {
	private static final long serialVersionUID = 1L;
	private String cipherDataKey;
	
	public String getCipherDataKey() {
		return cipherDataKey;
	}

	public void setCipherDataKey(String cipherDataKey) {
		this.cipherDataKey = cipherDataKey;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
	}
}