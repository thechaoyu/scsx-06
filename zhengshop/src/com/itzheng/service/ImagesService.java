package com.itzheng.service;

import com.itzheng.entity.Images;

public interface ImagesService {

	Images getImageByImageCode(String goodimagecode);

	boolean deleteImageByimagecode(String goodimagecode);

}
