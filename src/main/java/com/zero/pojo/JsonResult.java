package com.zero.pojo;

import java.io.Serializable;
import java.util.ArrayList;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * 基于此对象封装服务端要响应到客户端的数据，这个数据包含: 1)状态码 (表示这个响应结果是正确的还是错误) 2)状态信息(状态码对象的状态消息)
 * 3)正常的响应数据(例如一个查询结果) POJO:(VO-View Object 封装了表现层要呈现的数据)
 */

@Data
@Accessors(chain = true)
@AllArgsConstructor
@NoArgsConstructor
public class JsonResult implements Serializable {
	private static final long serialVersionUID = 2533582947345162836L;

	private boolean success;
	private Object data; // 服务器返回业务数据
//	private ArrayList<String> messages; // 服务器提示信息

	public static JsonResult success(Object data) {
		return new JsonResult(true, data);
	}

}
