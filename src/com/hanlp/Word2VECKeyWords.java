package com.hanlp;

import java.io.IOException;


import com.hanlp.Word2VEC;

public class Word2VECKeyWords {
	public static String[] getDistanceWord(String word) {
        Word2VEC w1 = new Word2VEC() ;
        
        try {
			w1.loadJavaModel("D:\\workspace\\eclipse-workspace\\cnki\\library\\AbstractVector") ;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

        String[] distance = new String[2];
        distance[0] = (w1.distance(word).toArray()[0].toString());
        distance[1] = (w1.distance(word).toArray()[1].toString());
       
        return distance;
    }
	
	//public static void main(String[] args) {
	//	String[] words = Word2VECKeyWords.getDistanceWord("教育");
	//	System.out.println(words[1]);
	//}
}
