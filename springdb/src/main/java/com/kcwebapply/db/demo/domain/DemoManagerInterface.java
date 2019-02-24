package com.kcwebapply.db.demo.domain;

import java.util.List;

public interface DemoManagerInterface {
	public List<DemoTable> getDemoData();

	public List<DemoTable> getDemoDataByID(int i);

}
