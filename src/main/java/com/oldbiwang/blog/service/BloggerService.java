package com.oldbiwang.blog.service;

import com.oldbiwang.blog.pojo.Blogger;

/**
 * @Description Service
 * @author oldbiwang
 *
 */
public interface BloggerService {
	
	public Blogger getByUsername(String username);

}