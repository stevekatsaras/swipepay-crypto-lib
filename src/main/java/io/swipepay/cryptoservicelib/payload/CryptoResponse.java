package io.swipepay.cryptoservicelib.payload;

import java.io.Serializable;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import io.swipepay.cryptoservicelib.payload.dto.StatusDto;

public class CryptoResponse implements Serializable {
	private static final long serialVersionUID = 1L;
	private StatusDto status;
	
	public StatusDto getStatus() {
		return status;
	}

	public void setStatus(StatusDto status) {
		this.status = status;
	}
	
	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
	}
}