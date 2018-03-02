package kr.co.shj.mongo.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Component;

import kr.co.shj.mongo.vo.MongoTestVo;

@Component
public class MongoTestDao {
	
	@Autowired
	private MongoTemplate mongoTemplate;
	
	public void saveMongoData(MongoTestVo mongoTestVo) {
		mongoTemplate.save(mongoTestVo); //save를 이용하여 저장하기.
	}
	
	public MongoTestVo findMongoData(String key, String value) {
		//MongoTemplate에서 조건을 검색하기 위해 Criteria클래스를 사용
		Criteria criteria=new Criteria(key);
		criteria.is(value); //일치하는 값을 찾기 위해 is메소드를 사용
		
		//쿼리 객체 작성
		Query query=new Query(criteria);
		
		MongoTestVo vo=mongoTemplate.findOne(query, MongoTestVo.class); 
		//MongoTestVo.class는 제네릭 타입 지정한 것(자바에서 제공하는 객체들을 자료로 관리할수있는 하나의 형식)
		
		return vo;
	}
} 
