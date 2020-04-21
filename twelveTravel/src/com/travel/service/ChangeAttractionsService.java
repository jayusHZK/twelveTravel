package com.travel.service;

import java.util.List;
import java.util.Map;

import com.travel.po.Attractions;
import com.travel.po.ResultPage;

public interface ChangeAttractionsService {
	List<Attractions> getAttractionsList(Integer attractions_id);
	ResultPage getAttractionstList(Integer index,String attractions_name,String beat_name);
	Attractions getAttractionsById(Integer attractions_id);
}
