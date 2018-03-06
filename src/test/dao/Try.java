package test.dao;

import org.junit.Test;

public class Try {
	@Test
	public void haha(){
		try{
			System.out.println("111");
			throw new Exception("错误");
//			System.out.println("2222");
			//通过验证，这段代码是不可抵达的代码
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
}
