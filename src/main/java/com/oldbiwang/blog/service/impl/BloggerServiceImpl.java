package com.oldbiwang.blog.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.oldbiwang.blog.dao.BloggerDao;
import com.oldbiwang.blog.pojo.Blogger;
import com.oldbiwang.blog.service.BloggerService;

/**
 * @Description ServiceImpl
 * @author oldbiwang
 *
 */
@Service("bloggerService")
public class BloggerServiceImpl implements BloggerService {
	
	@Resource
	private BloggerDao bloggerDao;
	
	public Blogger getByUsername(String username) {
		return bloggerDao.getByUsername(username);
	}

}