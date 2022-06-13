package com.itzheng.service.impl;

import java.util.ArrayList;

import com.itzheng.dao.GoodTypeDao;
import com.itzheng.dao.GoodsDao;
import com.itzheng.dao.ImagesDao;
import com.itzheng.dao.UserDao;
import com.itzheng.dao.impl.GoodTypeDaoImpl;
import com.itzheng.dao.impl.GoodsDaoImpl;
import com.itzheng.dao.impl.ImagesDaoImpl;
import com.itzheng.dao.impl.UserDaoImpl;
import com.itzheng.entity.GoodType;
import com.itzheng.entity.Goods;
import com.itzheng.entity.Images;
import com.itzheng.entity.User;
import com.itzheng.entity.list.GoodsL;
import com.itzheng.service.GoodsService;

public class GoodsServiceImpl implements GoodsService {

	GoodsDao gooddao = new GoodsDaoImpl();

	UserDao userdao = new UserDaoImpl();

	GoodTypeDao goodtypedao = new GoodTypeDaoImpl();

	ImagesDao imagesdao = new ImagesDaoImpl();

	@Override
	public int findCountAllGoodsByNameOrType(String goodname, String goodtypecode) {
		// TODO Auto-generated method stub
		return gooddao.findCountAllGoodsByNameOrType(goodname, goodtypecode);
	}

	@Override
	public ArrayList<Goods> findAllGoodsByNameOrType(String goodname, String goodtypecode, int pagenumber, int page) {
		// TODO Auto-generated method stub

		ArrayList<Goods> goodlist = gooddao.findAllGoodsByNameOrType(goodname, goodtypecode, pagenumber, page);

		if (goodlist == null) {
			return null;
		}

		for (Goods goods : goodlist) {
			// 通过用户code查询用户
			String usercode = goods.getGoodusercode();

			User user1 = userdao.findUserByusercode(usercode);

			// 设置

			String goodtycode1 = goods.getGoodtypecode();

			GoodType goodtype = goodtypedao.findGoodBygoodtypecode(goodtycode1);

			String imagecode = goods.getGoodimagecode();

			Images image = imagesdao.findImageBuimagecode(imagecode);

			goods.setGoodimagecode(image.getImage1());

			goods.setGoodType(goodtype);

			goods.setGoodusercode(user1.getName());

		}
		return goodlist;
	}

	@Override
	public boolean addGood(Goods goods) {

		// 先从数组当中把图片的路径数组取出来存放当中图片表当中

		String[] imageurl = goods.getGoodiamgecodearray();

		String imageusercode = goods.getGoodusercode();

		String imagecode = goods.getGoodimagecode();

		Images images = new Images();

		images.setImagecode(imagecode);

		images.setUsercodecode(imageusercode);

		if (imageurl[0] != null) {
			images.setImage1(imageurl[0]);
		}
		if (imageurl[1] != null) {
			images.setImage2(imageurl[1]);
		}
		if (imageurl[2] != null) {
			images.setImage3(imageurl[2]);
		}
		if (imageurl[3] != null) {
			images.setImage4(imageurl[3]);
		}
		if (imageurl[4] != null) {
			images.setImage5(imageurl[4]);
		}
		boolean imageflag = imagesdao.addImages(images);

		// 将商品添加到商品表当中

		boolean goodflag = gooddao.addGood(goods);

		return imageflag && goodflag;
	}

	@Override
	public Goods findGoodDetailBygoodcode(String goodcode) {
		// TODO Auto-generated method stub

		Goods goods = gooddao.findGoodBygoodcode(goodcode);

		String usercode = goods.getGoodusercode();

		User user = userdao.findUserByusercode(usercode);

		GoodType goodType = goodtypedao.findGoodBygoodtypecode(goods.getGoodtypecode());

		goods.setGoodusercode(user.getName());

		goods.setGoodtypecode(goodType.getTypename());

		return goods;
	}

	@Override
	public Goods findGoodDetailBygoodcodegoodtypecode(String goodcode) {

		Goods goods = gooddao.findGoodBygoodcode(goodcode);

		String usercode = goods.getGoodusercode();

		User user = userdao.findUserByusercode(usercode);

		GoodType goodType = goodtypedao.findGoodBygoodtypecode(goods.getGoodtypecode());

		goods.setGoodusercode(user.getName());

		goods.setGoodtypecode(goodType.getGoodtypecode());

		return goods;
	}

	@Override
	public boolean updateGood(Goods goods) {
		// 先从数组当中把图片的路径数组取出来存放当中图片表当中

		String[] imageurl = goods.getGoodiamgecodearray();

		String imageusercode = goods.getGoodusercode();

		String imagecode = goods.getGoodimagecode();

		Images images = new Images();

		boolean imageflag = false;

		images.setImagecode(imagecode);

		images.setUsercodecode(imageusercode);

		if (imageurl[0] != null) {
			images.setImage1(imageurl[0]);
		}
		if (imageurl[1] != null) {
			images.setImage2(imageurl[1]);
		}
		if (imageurl[2] != null) {
			images.setImage3(imageurl[2]);
		}
		if (imageurl[3] != null) {
			images.setImage4(imageurl[3]);
		}
		if (imageurl[4] != null) {
			images.setImage5(imageurl[4]);
		}

		System.out.println("2222222222222222222222222222222222222222222");

		System.out.println(images);

		System.out.println(imageurl);

		if (images.getImage1() != null || images.getImage2() != null || images.getImage3() != null
				|| images.getImage4() != null || images.getImage5() != null) {

			imageflag = imagesdao.updateImage(images);
		}

		boolean goodflag = gooddao.updateGood(goods);

		return imageflag && goodflag;
	}

	@Override
	public boolean deleteGoodBygoodcode(String goodcode) {
		// TODO Auto-generated method stub
		return gooddao.deleteGoodBygoodcode(goodcode);
	}

	@Override
	public boolean approvedGoodBygoodcode(String goodcode, String approved) {
		// TODO Auto-generated method stub
		return gooddao.approvedGoodBygoodcode(goodcode, approved);
	}

	@Override
	public int findCountAllGoodsByNameOrTypeUser1(String goodname, String goodtypecode, String usercode) {
		// TODO Auto-generated method stub
		return gooddao.findCountAllGoodsByNameOrTypeUser1(goodname, goodtypecode, usercode);
	}

	@Override
	public int findCountAllGoodsByNameOrTypePut(String goodname, String goodtypecode) {
		// TODO Auto-generated method stub
		return gooddao.findCountAllGoodsByNameOrTypePut(goodname, goodtypecode);
	}

	@Override
	public ArrayList<Goods> findAllGoodsByNameOrTypePut(String goodname, String goodtypecode, int pagenumber, int page) {
		// TODO Auto-generated method stub

		ArrayList<Goods> goodlist = gooddao.findAllGoodsByNameOrTypePut(goodname, goodtypecode, pagenumber, page);

		if (goodlist == null) {
			return null;
		}

		for (Goods goods : goodlist) {
			// 通过用户code查询用户
			String usercode = goods.getGoodusercode();

			User user1 = userdao.findUserByusercode(usercode);

			// 设置

			String goodtycode1 = goods.getGoodtypecode();

			GoodType goodtype = goodtypedao.findGoodBygoodtypecode(goodtycode1);

			String imagecode = goods.getGoodimagecode();

			Images image = imagesdao.findImageBuimagecode(imagecode);

			goods.setGoodimagecode(image.getImage1());

			goods.setGoodType(goodtype);

			goods.setGoodusercode(user1.getName());

		}
		return goodlist;
	}

}
