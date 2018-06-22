package com.dao;

import java.util.List;
import java.util.Map;

import com.po.CnkiinfoPO;

/**
 * DAO接口
 * @author lenovo
 *
 */
public interface CnkiinfoDAO {
	//验证登录
//	public List<Map> login(Map map);
	public CnkiinfoPO login(CnkiinfoPO po);
	//查询用户列表
	public List<CnkiinfoPO> cnkiList(CnkiinfoPO po);
	//查询修改用户信息的id
	public List<CnkiinfoPO> updateid(CnkiinfoPO po);
	//修改用户信息
	public int update(CnkiinfoPO po);
	//添加用户信息
	public int insert(CnkiinfoPO po);
	//删除用户
	public int delete(int id);
	//根据用户名模糊查询，根据权限查询
	public List<Map> select(Map map);
	//根据关键词模糊查询
	public List<Map> selecttitle(Map map);
	//根据摘要查询
	public List<Map> selectabstract(Map map);
}
