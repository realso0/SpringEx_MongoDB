package kr.co.shj.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.co.shj.mongo.dao.MongoTestDao;
import kr.co.shj.mongo.vo.MongoTestVo;

@Controller
public class MongoTestController {

	@Autowired
	private MongoTestDao mongoTestDao;
	
	@RequestMapping(value="/save")
	@ResponseBody
	public String saveTest() {
		
		MongoTestVo mongoTestVo=new MongoTestVo();
		mongoTestVo.set_id("1");
		mongoTestVo.setData1("데이터1");
		mongoTestVo.setData2("myData2");
		
		mongoTestDao.saveMongoData(mongoTestVo);
		return mongoTestVo.toString()+" saved !";
	}
	
	//저장 됬는지 확인하려면 cmd 창에 use spring > show collections > db.spring_ex.find().pretty()
	
	@RequestMapping(value="/find")
	@ResponseBody
	public String findTest() {
		return mongoTestDao.findMongoData("_id","1").toString()+" find !";
	}
}
