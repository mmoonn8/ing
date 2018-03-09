package total.service;

import java.util.HashMap;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class memberService {
	@Autowired
	SqlSessionTemplate template;
	
	public boolean create(Map map) {
		try {
		template.insert("member.create", map);
			return true;
		}catch(Exception e){
			e.getStackTrace();
			return false;
		}
		
	}
	public boolean login(String id, String pw) {
		Map map=new HashMap<>();
		map.put("id", id);
		map.put("password", pw);
		try {
		template.selectOne("member.loginCheck", map);
			return true;
		}catch(Exception e){
			e.getStackTrace();
			return false;
		}
		
	}
	
	
}
