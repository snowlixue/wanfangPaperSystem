package com.service;

import java.util.List;
import java.util.Map;

import com.po.CnkiinfoPO;

public interface CnkiInfoInterface {
	//验证登录
//	public List<Map> getlogin(Map map);
//	public CnkiinfoPO getlogin(CnkiinfoPO po);
	//查询用户列表
	public List<CnkiinfoPO> getcnkiList(CnkiinfoPO po);
	//查询修改用户信息的id
	public List<CnkiinfoPO> getupdateid(CnkiinfoPO po);
	//修改用户信息
	public String getupdate(CnkiinfoPO po);
	//添加用户信息
	public String getinsert(CnkiinfoPO po);
	//删除用户
	public String getdelete(int id);
	//根据标题模糊查询
	public List<Map> getselect(Map map);
	//根据关键词推荐，
	public List<Map> selecttitle(CnkiinfoPO po);
	//根据摘要推荐
	public List<Map> selectabstract(String keyvalue);
}
