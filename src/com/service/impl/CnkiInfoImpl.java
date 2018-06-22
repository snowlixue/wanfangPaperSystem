package com.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import javax.sound.midi.Soundbank;

import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import com.dao.CnkiinfoDAO;
import com.po.CnkiinfoPO;
import com.service.CnkiInfoInterface;
import com.hanlp.Hanlp;
import com.hanlp.Word2VECKeyWords;
@Service  //表示这是一个业务层，是service类， @Controller是用于标注控制层组件，Component是当某一个类不好归类的时候用 这个注解
public class CnkiInfoImpl implements CnkiInfoInterface{
	@Resource //自动装载，根据名称注入
	//定义dao类型的属性
	CnkiinfoDAO cdao;
	/**
	 * 验证登录
	 */
//	public List<Map> getlogin(Map map) {
//		//调dao里的方法
//		List<Map> cnkilogin=udao.login(map);
//		return cnkilogin;
//	}
	public CnkiinfoPO getlogin(CnkiinfoPO po) {
		//调dao里的方法
		CnkiinfoPO cnkiinfo = cdao.login(po);
		return cnkiinfo;
	}
	
	/**
	 * 根据用户名模糊查询，根据权限查询
	 */
	public List<Map> getselect(Map map) {
		List<Map> selectCnki = cdao.select(map);
		return selectCnki;
	}
	
	/**
	 * 查询用户列表
	 */
	public List<CnkiinfoPO> getcnkiList(CnkiinfoPO po) {
		List<CnkiinfoPO> cnkiinfo = cdao.cnkiList(po);
		return cnkiinfo;
	}
	/**
	 * 查询修改用户信息的id
	 */
	public List<CnkiinfoPO> getupdateid(CnkiinfoPO po) {
		List<CnkiinfoPO> updateid = cdao.updateid(po);
		return updateid;
	}
	/**
	 * 修改用户信息
	 */
	public String getupdate(CnkiinfoPO po) {
		//调dao里的方法
		int u = cdao.update(po);
		String message="";
		//数据库会返回一个int类型的数据，根据影响条数来判断操作是否成功
		if(u > 0){
			message = "修改成功";
		}else{
			message = "修改失败";
		}
		return message;
	}
	/**
	 * 添加用户信息
	 */
	public String getinsert(CnkiinfoPO po) {
		int i = cdao.insert(po);
		String message="";
		if(i > 0){
			message = "添加成功";
		}else{
			message = "添加失败";
		}
		return message;
	}
	/**
	 * 删除用户
	 */
	public String getdelete(int id) {
		int d = cdao.delete(id);
		String message="";
		if(d > 0){
			message = "删除成功";
		}else{
			message = "删除失败";
		}
		return message;
	}

	@Override
	public List<Map> selecttitle(CnkiinfoPO po) {
		// TODO Auto-generated method stub
        List<Map> selectCnki = new ArrayList<Map>();
		//调dao里的方法
		List<CnkiinfoPO> updateid = cdao.updateid(po);
        String needResult = updateid.get(0).getKeywords();
        System.out.println("needResult"+needResult);
        Hanlp hanlp = new Hanlp();
        List<String> result = hanlp.getkeywords(needResult);
		
        Word2VECKeyWords word2veckeywords = new Word2VECKeyWords();
        String distancewords[] = word2veckeywords.getDistanceWord(result.get(0).toString());
        System.out.println("distancewords[0]"+distancewords[0]);
        System.out.println("distancewords[1]"+distancewords[1]);
        
        Map map1 = new HashMap();
        map1.put("keywords", result.get(0).toString());
		List<Map> selectCnki1 = cdao.selecttitle(map1);
        
        Map map2 = new HashMap();
        map2.put("abstracts", distancewords[0]);
		List<Map> selectCnki2 = cdao.selecttitle(map2);
		
        Map map3 = new HashMap();
        map3.put("abstracts", distancewords[0]);
		List<Map> selectCnki3 = cdao.selecttitle(map3);
		
		//selectCnki.addAll(selectCnki1);
		selectCnki1.addAll(selectCnki2);
		selectCnki1.addAll(selectCnki3);
		return selectCnki1;
	}

	@Override
	public List<Map> selectabstract(String keyvalue) {
		// TODO Auto-generated method stub
		
        Map map = new HashMap();
        map.put("abstracts", keyvalue);
        List<Map> selectCnki = cdao.selectabstract(map);
		return selectCnki;
	}
	
}
