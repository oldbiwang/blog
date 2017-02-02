package com.oldbiwang.blog.dao;

import com.oldbiwang.blog.pojo.Blogger;

/**
 * @Description 博主dao接口
 * @author  oldbiwang
 *
 */
public interface BloggerDao {
	
	//通过用户名查询用户
	public Blogger getByUsername(String username);
}