package com.zero.pojo;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
@AllArgsConstructor
@NoArgsConstructor
public class Pager<T> {
	/** 分页起始页 */
	private int page;
	/** 每页记录数 */
	private int size;
	/** 返回的记录集合 */
	private List<T> rows;
	/** 总记录条数 */
	private long total;
}
