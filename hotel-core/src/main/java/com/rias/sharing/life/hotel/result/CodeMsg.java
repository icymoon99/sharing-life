package com.rias.sharing.life.hotel.result;

/**
 * @name: CodeMsg
 * @author: lucifinier
 * @date: 2018/4/24 16:35
 * @description: 返回码
 */
public class CodeMsg {
	
	private int code;
	private String msg;

	public static CodeMsg SUCCESS = new CodeMsg(0, "请求成功");

    /**
     * 通用的错误码
     */
	public static CodeMsg SERVER_ERROR = new CodeMsg(10000100, "服务端异常");
	public static CodeMsg BIND_ERROR = new CodeMsg(10000101, "参数校验异常：%s");

    /**
     * 酒店模块
     */
	public static CodeMsg NO_REGION_BY_ID = new CodeMsg(18120210, "通过ID查询地域不存在");
	
	private CodeMsg( ) {
	}
			
	private CodeMsg( int code,String msg ) {
		this.code = code;
		this.msg = msg;
	}
	
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	
	public CodeMsg fillArgs(Object... args) {
		int code = this.code;
		String message = String.format(this.msg, args);
		return new CodeMsg(code, message);
	}

	@Override
	public String toString() {
		return "CodeMsg [code=" + code + ", msg=" + msg + "]";
	}
	
	
}
