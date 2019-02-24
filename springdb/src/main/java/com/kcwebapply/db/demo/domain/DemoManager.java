package com.kcwebapply.db.demo.domain;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("DemoManager")
public class DemoManager implements DemoManagerInterface{

	@Autowired
	DemoRepository demoRepository;

	@Override
	public List<DemoTable> getDemoData() {
		// TODO 自動生成されたメソッド・スタブ
		return demoRepository.findAll();
	}

	@Override
	public List<DemoTable> getDemoDataByID(int i) {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}

}
