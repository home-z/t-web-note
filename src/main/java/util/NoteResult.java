package util;

import java.io.Serializable;

@SuppressWarnings("serial")
public class NoteResult implements Serializable{
	private String message;
	private Object data;
	private Integer stat;
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}
	public Integer getStat() {
		return stat;
	}
	public void setStat(Integer stat) {
		this.stat = stat;
	}
	
	
}
