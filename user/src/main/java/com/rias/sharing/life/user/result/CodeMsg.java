package com.rias.sharing.life.user.result;

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
     * 登录模块
     */
	public static CodeMsg TOKEN_ERROR = new CodeMsg(18010210, "Token不存在或者已经失效");
	public static CodeMsg PHONE_CODE_SEND_FAIL = new CodeMsg(18010211, "手机验证码发送失败");
	
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
