package com.travel.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.travel.dao.ChangeAttractionsDao;
import com.travel.po.Attractions;
import com.travel.po.Beat;
import com.travel.po.ResultPage;
import com.travel.service.ChangeAttractionsService;

@Service
public class ChangeAttractionsServiceImpl implements ChangeAttractionsService {
	@Autowired
	private ChangeAttractionsDao changeAttractionsDao;
	@Override 
	public List<Attractions> getAttractionsList(Integer attractions_id) {
		// TODO Auto-generated method stub
		return changeAttractionsDao.getAttractionsList(attractions_id);
	}
	@Override
	public ResultPage getAttractionstList(Integer index,
			String attractions_name, String beat_name) {
		// TODO Auto-generated method stub
		Attractions   vo=new  Attractions();
		vo.setAttractions_name(attractions_name);
		//vo.se

		ResultPage rp=new ResultPage();
		//����
		PageHelper.startPage(index, 5);
		
		List<Attractions>  list=changeAttractionsDao.getAttractionsListCount(vo);
		
		PageInfo<Attractions> page=new PageInfo<Attractions>(list);
		//���page��������page.getPages() ��ʾ��ҳ��
		//���page��������page.getTotal() ��ʾ������
		
		
		//rp.setIndex(index);
		//rp.setSize(size)
		rp.setObj(page.getList());
		rp.setIndex(index);
		rp.setSize(5);
		rp.setPageCount(page.getPages());
		rp.setCount((int)page.getTotal());
		System.out.println(page);
		
//		rp.setSize(10);
//		rp.setIndex(index);
//		
//		Map<String,Object> map=new HashMap<String,Object>();
//		map.put("start", (index-1)*rp.getSize());
//		map.put("end",rp.getSize());
//		map.put("attractions_name", attractions_name);
//		map.put("beat_name", beat_name);
//		rp.setObj(changeAttractionsDao.getAttractionsListCount(map));
//		
//		//��һ�� ���������ѯ������
//		rp.setCount(changeAttractionsDao.getAttractionsListCount(map).intValue());
//		
//		rp.setPageCount((int)Math.ceil((double)rp.getCount()/rp.getSize()));
		
		//���������ѯ��ǰҳ�����
		
		
		return rp;
	}
	@Override
	public Attractions getAttractionsById(Integer attractions_id) {
		
		return changeAttractionsDao.getAttractionsById(attractions_id);
	}

}
