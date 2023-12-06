package com.globallogic.prueba.model.response;

import java.time.LocalDateTime;

public class MessageRs {
	private LocalDateTime timestamp;
	private Integer codigo;
	private String detail;

	public LocalDateTime getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(LocalDateTime timestamp) {
		this.timestamp = timestamp;
	}

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

	@Override
	public String toString() {
		return "{\"timestamp\":\"" + timestamp + "\", \"codigo\":\"" + codigo + "\", \"detail\":\"" + detail + "\"}";
	}

}
