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
     * 通用的错误码 5001XX
     */
	public static CodeMsg SERVER_ERROR = new CodeMsg(10000100, "服务端异常");
	public static CodeMsg BIND_ERROR = new CodeMsg(10000101, "参数校验异常：%s");

    /**
     * 登录模块 5002XX
     */
	public static CodeMsg TOKEN_ERROR = new CodeMsg(18010210, "Token不存在或者已经失效");
	public static CodeMsg PHONE_CODE_SEND_FAIL = new CodeMsg(18010211, "手机验证码发送失败");
	public static CodeMsg MOBILE_EMPTY = new CodeMsg(18010212, "手机号不能为空");
	public static CodeMsg MOBILE_ERROR = new CodeMsg(18010213, "手机号格式错误");
	public static CodeMsg MOBILE_NOT_EXIST = new CodeMsg(18010214, "手机号不存在");
	public static CodeMsg PASSWORD_ERROR = new CodeMsg(18010215, "密码错误");
	
	//商品模块 5003XX
	
	//订单模块 5004XX
	
	//秒杀模块 5005XX
	
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
