package word2vec;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.Iterator;
import java.util.List;

import org.ansj.domain.Term;
import org.ansj.splitWord.analysis.ToAnalysis;

import word2vec_codeRewrite.KeyWordComputer;
import word2vec_codeRewrite.Keyword;

public class word2vec {

	public static List<Term> getSplitedWords(String filePath){
	    String tt=new String();  
	    BufferedReader in = null;
		try {
			in = new BufferedReader(new InputStreamReader(new FileInputStream(filePath), "UTF8"));
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}  
	    String str;  
	    try {
			while ((str = in.readLine()) != null) {  
			    tt+=str;  
			}
		} catch (IOException e) {
			e.printStackTrace();
		}  
	    System.out.println(ToAnalysis.parse(tt));
	    return ToAnalysis.parse(tt);
	}
	
	public static void getKeyWords(String filePath){
		StringBuffer sb = new StringBuffer();
	    BufferedReader in = null;
		try {
			in = new BufferedReader(new InputStreamReader(new FileInputStream(filePath), "UTF8"));
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}  
	    String str;  
	    try {
			while ((str = in.readLine()) != null) {  
			    sb.append(str);  
			}
		} catch (IOException e) {
			e.printStackTrace();
		}  
	    KeyWordComputer key=new KeyWordComputer(10);  
        Iterator it = key.computeArticleTfidf(sb.toString()).iterator() ;  
        while(it.hasNext()) {  
            Keyword key2=(Keyword)it.next();  
            System.out.println(key2.toString() + "\t" + key2.getScore());      
        }    
	}
}
