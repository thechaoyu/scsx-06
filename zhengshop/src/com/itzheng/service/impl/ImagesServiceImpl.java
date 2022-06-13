package com.itzheng.service.impl;

import com.itzheng.dao.ImagesDao;
import com.itzheng.dao.impl.ImagesDaoImpl;
import com.itzheng.entity.Images;
import com.itzheng.service.ImagesService;

public class ImagesServiceImpl implements ImagesService {
	
	ImagesDao imagesDao = new ImagesDaoImpl();

	@Override
	public Images getImageByImageCode(String goodimagecode) {
		// TODO Auto-generated method stub
		return imagesDao.getImageByImageCode(goodimagecode);
	}

	@Override
	public boolean deleteImageByimagecode(String goodimagecode) {
		// TODO Auto-generated method stub
		return imagesDao.deleteImageByimagecode(goodimagecode);
	}

}
