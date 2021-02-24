package com.ruoyi.web.controller.api.entity;

import io.swagger.annotations.ApiModelProperty;

public class ResponsePage<T> {

	@ApiModelProperty("返回结果")
	private T result;

	@ApiModelProperty("返回消息")
	private String message;

	@ApiModelProperty("返回状态 200成功")
	private int code;

	@ApiModelProperty("总条数")
	private long total;

	@ApiModelProperty("请求时间")
	private long timestamp;

	public ResponsePage() {
		this.timestamp = System.currentTimeMillis();
		this.code = 200;
	}

	public long getTotal() {
		return total;
	}

	public void setTotal(long total) {
		this.total = total;
	}

	public T getResult() {
		return result;
	}

	public String getMessage() {
		return message;
	}

	public int getCode() {
		return code;
	}

	public long getTimestamp() {
		return timestamp;
	}

	public void setErrorMessage(String message) {
		this.message = message;
		this.code = 500;
	}

	public void setResult(T value) {
		this.timestamp = System.currentTimeMillis() - this.timestamp;
		if (value != null) {
			this.code = 200;
		}
		this.result = value;
	}
}