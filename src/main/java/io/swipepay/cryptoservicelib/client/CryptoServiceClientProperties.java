package io.swipepay.cryptoservicelib.client;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.hibernate.validator.constraints.NotBlank;

public class CryptoServiceClientProperties {
	@NotBlank(message = "Root uri is required")
	private String rootUri;
	
	@NotBlank(message = "Connect timeout is required")
	private String connectTimeout;
	
	@NotBlank(message = "Read timeout is required")
	private String readTimeout;
	
	@NotBlank(message = "Username is required")
	private String username;
	
	@NotBlank(message = "Password is required")
	private String password;
	
	public CryptoServiceClientProperties() {
		
	}

	public CryptoServiceClientProperties(
			String rootUri, 
			String connectTimeout, 
			String readTimeout, 
			String username,
			String password) {
		this.rootUri = rootUri;
		this.connectTimeout = connectTimeout;
		this.readTimeout = readTimeout;
		this.username = username;
		this.password = password;
	}
	
	public String getRootUri() {
		return rootUri;
	}

	public void setRootUri(String rootUri) {
		this.rootUri = rootUri;
	}

	public String getConnectTimeout() {
		return connectTimeout;
	}

	public void setConnectTimeout(String connectTimeout) {
		this.connectTimeout = connectTimeout;
	}

	public String getReadTimeout() {
		return readTimeout;
	}

	public void setReadTimeout(String readTimeout) {
		this.readTimeout = readTimeout;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
	}		  
}