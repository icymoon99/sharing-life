package com.rias.sharing.life.user.result;

/**
 * @name: Result
 * @author: lucifinier
 * @date: 2018/4/24 16:35
 * @description: 请求返回类
 */
public class Result<T> {
    /**
     * 返回码
     */
	private int code;
    /**
     * 错误信息
     */
	private String msg;
    /**
     * 请求返回数据
     */
	private T data;
	
	/**
	 *  成功时候的调用
	 */
	public static  <T> Result<T> success(T data){
		return new Result<T>(data);
	}

    /**
     *  成功时候的调用
     */
    public static  <T> Result<T> success(){
        return new Result<T>(CodeMsg.SUCCESS.getCode(), null);
    }
	
	/**
	 *  失败时候的调用
	 */
	public static  <T> Result<T> error(CodeMsg codeMsg){
		return new Result<T>(codeMsg);
	}
	
	private Result(T data) {
	    this.code = CodeMsg.SUCCESS.getCode();
		this.data = data;
	}
	
	private Result(int code, String msg) {
		this.code = code;
		this.msg = msg;
	}
	
	private Result(CodeMsg codeMsg) {
		if(codeMsg != null) {
			this.code = codeMsg.getCode();
			this.msg = codeMsg.getMsg();
		}
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

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}
}
