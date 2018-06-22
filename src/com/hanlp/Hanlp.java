package com.hanlp;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.List;

import com.hankcs.hanlp.HanLP;
import com.hankcs.hanlp.seg.common.Term;
import com.hankcs.hanlp.suggest.Suggester;
import com.hankcs.hanlp.tokenizer.NLPTokenizer;

public class Hanlp {
    public List<String> getkeywords(String keywords) {
        String[] myArray = new String[5000];  //100：这个值你自己定义，但不宜过大，要根据你文件的大小了，或者文件的行数
        
        try {
            System.out.println(System.in);

            FileReader fileReader = new FileReader("D:\\stopwords.txt");
            BufferedReader buf = new BufferedReader(fileReader);

            int i = 0;
            String bufToString = "";
            String readLine = "";
            while((readLine = buf.readLine()) != null){
                myArray[i] = readLine;
                i++;
            }
       }
        catch (Exception e) {
            e.printStackTrace();
        }        
        List<String> keywordList = HanLP.extractKeyword(keywords, 2);       
    	return keywordList;
    }
}