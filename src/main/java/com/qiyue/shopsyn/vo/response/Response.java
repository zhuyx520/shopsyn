package com.qiyue.shopsyn.vo.response;

import java.io.Serializable;

public class Response implements Serializable {

	private static final long serialVersionUID = 1L;

	private int code;
	private int count;
	private String msg;
	private Object data;
	private long timeStamp;

	public static Response ok() {
		Response r = new Response();
		r.setCode(0);
		r.setTimeStamp(System.currentTimeMillis());
		return r;
	}

	public static Response ok(Object data) {
		Response r = new Response();
		r.setCode(0);
		r.setData(data);
		return r;
	}

	public static Response displayOk(Object data) {
		Response r = new Response();
		r.setCode(0);
		r.setMsg("ok");
		r.setData(data);
		r.setTimeStamp(System.currentTimeMillis());
		return r;
	}

	public static Response error(int code, String msg) {
		Response r = new Response();
		r.setCode(code);
		r.setMsg(msg);
		return r;
	}

	public static Response contentOk(Object data) {
		Response r = new Response();
		r.setCode(0);
		r.setData(data);
		return r;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}
	
	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	public long getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(long timeStamp) {
		this.timeStamp = timeStamp;
	}

	/**
	 * 服务请求成功
	 * 
	 * @param code
	 *            响应状态码
	 * @param message
	 *            响应提示信息
	 * @param data
	 *            响应消息体
	 * @return
	 */
	public static Response response(int code, int count, String msg, Object data) {
		Response r = new Response();
		r.setCode(code);
		r.setCount(count);
		r.setMsg(msg);
		r.setData(data);
		r.setTimeStamp(System.currentTimeMillis());
		return r;
	}

	/**
	 * 服务异常
	 * 
	 * @param code
	 *            响应状态码
	 * @param message
	 *            响应提示信息
	 * @param data
	 *            响应消息体
	 * @return
	 */
	public static Response exception(int code, String msg, Object data) {
		Response r = new Response();
		r.setCode(code);
		r.setData(data);
		r.setMsg(msg);
		r.setTimeStamp(System.currentTimeMillis());
		return r;
	}
}
