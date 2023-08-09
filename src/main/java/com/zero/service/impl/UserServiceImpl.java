//package com.zero.service.impl;
//
//import java.util.Date;
//import java.util.HashMap;
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import com.zero.mapper.UserMapper;
//import com.zero.pojo.Pager;
//import com.zero.pojo.User;
//import com.zero.service.UserService;
//
//import cn.hutool.core.util.IdUtil;
//import cn.hutool.crypto.digest.Digester;
//
//@Service
//public class UserServiceImpl implements UserService {
//	@Autowired
//	private UserMapper userMapper;
//
//	@Override
//	public List<User> findAll() {
////		return this.userMapper.selectList(null);
//		return this.userMapper.findAll();
//	}
//
//	@Override
//	public Pager<User> findByPager(int page, int size) {
//		HashMap<String, Object> params = new HashMap<String, Object>();
//
//		params.put("page", (page - 1) * size);
//		params.put("size", size);
//		List<User> usersList = this.userMapper.findByPager(params);
//
//		long total = this.userMapper.count();
//
//		Pager<User> pager = new Pager<User>().setRows(usersList).setTotal(total)
//				.setPage(page).setSize(size);
//
//		return pager;
//	}
//
//	@Override
//	public User findUserByUsername(String username) {
//		User userInfo = this.userMapper.findUserInfoByUserName(username);
//		return userInfo;
//	}
//
//	@Override
//	public int saveUser(User user) {
//		// 让随机字符串作为加密盐
//		String salt = IdUtil.randomUUID();
//		String hexPassWordWithSalt = this.convertPassWord(user.getPassword(), salt);
//
//		Date currentTime = new Date();
//		user.setPassword(hexPassWordWithSalt).setSalt(salt).setCreatedUser(user.getUsername())
//				.setModifiedUser(user.getCreatedUser()).setValid(1).setCreatedTime(currentTime)
//				.setModifiedTime(currentTime);
//
//		if (this.userMapper.saveUser(user) > 0) {
//			// 手动添加IdCard以及Mobile
//			String tempIdCard = new StringBuilder().append("610102xxxxxxxx00").append(user.getId()).toString();
//			user.setIdcard(tempIdCard).setMobile("152xxxxxxxx");
//			if (this.userMapper.updateUser(user) > 0) {
//				return 1;
//			}
//		}
//
//		return 0;
//	}
//
//	@Override
//	public int updateUser(User userInput) {
//		User userInfo = this.userMapper.findUserInfoByUserName(userInput.getUsername());
//
//		String password = userInput.getPassword();
//		String email = userInput.getEmail();
//		if (password != null) {
//			// 让随机字符串作为加密盐
//			String salt = IdUtil.randomUUID();
//			String hexPassWordWithSalt = this.convertPassWord(password, salt);
//			userInfo.setPassword(hexPassWordWithSalt).setSalt(salt);
//		}
//		if (email != null) {
//			userInfo.setEmail(email);
//		}
//		Date currentTime = new Date();
//		System.err.println(currentTime);
//		userInfo.setModifiedTime(currentTime);
//		System.err.println(userInfo);
//		return this.userMapper.updateUser(userInfo);
//	}
//
//	@Override
//	public int deleteUserById(int id) {
//		return this.userMapper.deleteById(id);
//	}
//
//	/**
//	 * @param passWord
//	 * @param salt
//	 * @return hexPassWordWithSalt
//	 */
//	private String convertPassWord(String password, String salt) {
//		// 此处使用HuTool
//		// 密码加密(本次算法使用md5加密->特点：不可逆，相同内容加密结果一定相同)
//		Digester md5Digester = new Digester("MD5");
//		// 设置加盐内容
//		md5Digester.setSalt(salt.getBytes());
//		// 此处需要注意 入库密码为加盐密码 作为Shiro后续验证的依据(必须给密码加盐！！！)
//		// 默认加密次数为1次
//		String hexPassWordWithSalt = md5Digester.digestHex(password);
//
//		return hexPassWordWithSalt;
//	}
//}
