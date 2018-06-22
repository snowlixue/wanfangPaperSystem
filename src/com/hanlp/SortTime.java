package com.hanlp;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;
import java.util.HashMap;
import com.po.CnkiinfoPO;

public class SortTime {

	public List<Map> sort(List<Map> stid){
		//利用正则删除不符合日期结构的数据
		String pattern = "\\d+年\\d+月\\d+日";
        for(int i = 0;i<stid.size();i++) {      
        	if(!Pattern.matches(pattern, ((CnkiinfoPO) stid.get(i)).getTime())) {
                System.out.println("------------------"+((CnkiinfoPO) stid.get(i)).getTime());
                stid.remove(i);
        	}
        }
		return stid;
	}
} 