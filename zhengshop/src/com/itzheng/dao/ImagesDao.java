package com.itzheng.dao;

import com.itzheng.entity.Images;

public interface ImagesDao {

	Images findImageBuimagecode(String imagecode);

	boolean addImages(Images images);

	Images getImageByImageCode(String goodimagecode);

	boolean updateImage(Images images);

	boolean deleteImageByimagecode(String goodimagecode);

}
