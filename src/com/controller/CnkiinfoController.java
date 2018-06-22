package com.controller;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.po.CnkiinfoPO;
import com.service.CnkiInfoInterface;
import com.hanlp.SortTime;
import com.hanlp.Hanlp;
@Controller  //标注这是一个控制类，类名不能和注解名一样
@RequestMapping("/uc")   //设置访问路径
public class CnkiinfoController {
	
	
	/**
	 * 验证登录
	 */
	@Autowired
	//定义service类型的属性
	CnkiInfoInterface cnkivice;
	Hanlp hanlp = new Hanlp();
	

	@RequestMapping("/login")//为方法设置访问路径	
	public String ulogin(HttpServletRequest request){
			return "/uc/user";    
	}
	
	/**
	 * 查询目录明细
	 */
	
	@RequestMapping("/user")//为方法设置访问路径
	public String userList(HttpServletRequest request, CnkiinfoPO po){
		//调service里的方法
		List<CnkiinfoPO> clist = cnkivice.getcnkiList(po);
		//cutlist = hanlp.Hanlp_cutlist(clist);
		//System.out.println(cutlist);
		//把值存到request作用域里，传到页面上
		request.setAttribute("clist", clist);
		//跳转的mian.jsp页面
		return "/main.jsp";
	}
	
	/**
	 * 查询输入字条
	 */
	@RequestMapping("/cnki")//为方法设置访问路径
	public String cnkiList(HttpServletRequest request, CnkiinfoPO po){
		//调service里的方法
		List<CnkiinfoPO> clist = cnkivice.getcnkiList(po);
		//把值存到request作用域里，传到页面上
		request.setAttribute("clist", clist);
		//跳转的mian.jsp页面
		return "/main.jsp";
	}
	
	/**
	 * 查询修改用户信息的id
	 */
	@RequestMapping("/cid")//为方法设置访问路径
	public String updateid(HttpServletRequest request, CnkiinfoPO po){
		List<CnkiinfoPO> cid = cnkivice.getupdateid(po);
		request.setAttribute("cid", cid);
		return "/update.jsp";
	}
	/**
	 * 修改用户信息
	 */
	@RequestMapping(value="/update")//为方法设置访问路径
	public String update(HttpServletRequest request, CnkiinfoPO po){		
		String updateCnki = cnkivice.getupdate(po);		
		request.setAttribute("updateCnki", updateCnki);
		//修改信息后留在当前页
		return "/uc/cid";		
	}
	
	/**
	 * 添加用户信息
	 */
	@RequestMapping("/insert")//为方法设置访问路径
	public String insert(HttpServletRequest request, CnkiinfoPO po){
		String inserCnki = cnkivice.getinsert(po);
		request.setAttribute("inserCnki", inserCnki);
		return "/insert.jsp";
	}
	
	/**
	 * 删除用户 ，根据id删除
	 */
	//后面传了一个要删除的id值，比如要删除id是30的用户，整体路径是/uc/delete/30
	@RequestMapping(value="/delete/{id}")
	public ModelAndView delete(@PathVariable("id")int id){
		String deleteCnki=cnkivice.getdelete(id);
		ModelAndView mav=new ModelAndView();
		mav.addObject("deleteCnki", deleteCnki);
		//跳到提醒页，返回service里定义的方法，提醒删除成功还是失败
		mav.setViewName("/tx.jsp");
		return mav;
	}
	
	/**
	 * 根据标题模糊查询
	 */
	@RequestMapping("/select")//为方法设置访问路径
	public ModelAndView mav(@RequestParam(required=false) Map map){
		List<Map> selectCnki = cnkivice.getselect(map);
		ModelAndView mav=new ModelAndView();
		mav.addObject("clist", selectCnki);
		mav.setViewName("/main.jsp");
		return mav;
	}
	
	/**
	 * 根据标题查询相似文章
	 * @param request
	 * @param po
	 * @return
	 */
	@RequestMapping(value="/selecttitle")
	public ModelAndView selecttitle(HttpServletRequest request, CnkiinfoPO po){
		List<Map> stid = cnkivice.selecttitle(po);
		ModelAndView mav=new ModelAndView();
		mav.addObject("stid", stid);
		mav.setViewName("/recommendtitle.jsp");
		return mav;
	}
	
	/**
	 * 根据关键字生成故事线
	 */
	@RequestMapping("/story")//为方法设置访问路径
	public ModelAndView mavS(HttpServletRequest request,HttpServletRequest respose){
		List<Map> stid = cnkivice.selectabstract(request.getParameter("keyvalue"));
		SortTime sorttime = new SortTime();
		List<Map> sstid = sorttime.sort(stid);
		ModelAndView mav=new ModelAndView();
		mav.addObject("stid", sstid);
		mav.setViewName("/story.jsp");
		return mav;
	}
	
}
