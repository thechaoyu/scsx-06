package com.itzheng.utils;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.List;
import java.util.Random;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.lang.RandomStringUtils;

import com.itzheng.entity.Goods;
import com.itzheng.entity.User;
import com.itzheng.servlet.UserServlet;

public class UpdateFile {

	public User uploadFileOneUserUpdate(HttpServletRequest request, HttpServletResponse response,
			UserServlet userServlet) {
		// TODO Auto-generated method stub
		// 创建接受文件的工厂类
		DiskFileItemFactory factory = new DiskFileItemFactory();
		// 创建解析对象
		ServletFileUpload upload = new ServletFileUpload(factory);
		User user = new User();
		try {
			List<FileItem> list = upload.parseRequest(request);// 获取请求当中所有的内容，并放置到集合当中

			for (FileItem item : list) {

				// 判定是否是普通的表单 如果是 返回true 如果不是返回false
				if (item.isFormField()) {// 判断当前是普通表单

					if (item.getFieldName().equals("id")) {// 获取当前集合当中的元，并获取和表单当中的元素 的名称是一样的表单元素

						String ids = item.getString("utf-8");// 设置其编码格式为utf-8
						// 操作数据库将表单的内容保存到数据库当中
						user.setId(Integer.parseInt(ids));

					}
					if (item.getFieldName().equals("usercode")) {// 获取当前集合当中的元，并获取和表单当中的元素 的名称是一样的表单元素

						String usercode = item.getString("utf-8");// 设置其编码格式为utf-8
						// 操作数据库将表单的内容保存到数据库当中
						user.setUsercode(usercode);

					}
					if (item.getFieldName().equals("username")) {// 获取当前集合当中的元，并获取和表单当中的元素 的名称是一样的表单元素

						String username = item.getString("utf-8");// 设置其编码格式为utf-8
						// 操作数据库将表单的内容保存到数据库当中
						user.setUsername(username);

					}
					if (item.getFieldName().equals("password")) {// 获取当前集合当中的元，并获取和表单当中的元素 的名称是一样的表单元素

						String password = item.getString("utf-8");// 设置其编码格式为utf-8
						// 操作数据库将表单的内容保存到数据库当中
						user.setPassword(password);

					}
					if (item.getFieldName().equals("name")) {// 获取当前集合当中的元，并获取和表单当中的元素 的名称是一样的表单元素

						String name = item.getString("utf-8");// 设置其编码格式为utf-8
						// 操作数据库将表单的内容保存到数据库当中
						user.setName(name);

					}
					if (item.getFieldName().equals("email")) {// 获取当前集合当中的元，并获取和表单当中的元素 的名称是一样的表单元素

						String email = item.getString("utf-8");// 设置其编码格式为utf-8
						// 操作数据库将表单的内容保存到数据库当中
						user.setEmail(email);

					}
					if (item.getFieldName().equals("phone")) {// 获取当前集合当中的元，并获取和表单当中的元素 的名称是一样的表单元素

						String phone = item.getString("utf-8");// 设置其编码格式为utf-8
						// 操作数据库将表单的内容保存到数据库当中
						user.setPhone(phone);

					}
					if (item.getFieldName().equals("usertype")) {// 获取当前集合当中的元，并获取和表单当中的元素 的名称是一样的表单元素

						String usertype = item.getString("utf-8");// 设置其编码格式为utf-8
						// 操作数据库将表单的内容保存到数据库当中
						user.setUsertype(usertype);

					}
					if (item.getFieldName().equals("state")) {// 获取当前集合当中的元，并获取和表单当中的元素 的名称是一样的表单元素

						String state = item.getString("utf-8");// 设置其编码格式为utf-8
						// 操作数据库将表单的内容保存到数据库当中
						user.setState(state);

					}

					if (item.getFieldName().equals("date")) {// 获取当前集合当中的元，并获取和表单当中的元素 的名称是一样的表单元素

						String date = item.getString("utf-8");// 设置其编码格式为utf-8
						// 操作数据库将表单的内容保存到数据库当中
						user.setDate(date);

					}

				} else {
					String filename = item.getName();
					if (!filename.equals("")) {

						Random random = new Random();

						Date date = new Date();
						System.out.println(date);

						long d = date.getTime();

						filename = d + random.nextInt() + filename.substring(filename.lastIndexOf("\\") + 1);

						filename = getCode() + filename;

						filename = filename.replaceAll("[\u4e00-\u9fa5]", "");

						System.out.println(filename);
						String dataBasefilename = "/image/upload/" + filename;

						request.setAttribute("dataBasefilename", dataBasefilename);

						user.setImage("upload/" + filename);

						// 将这个文件名称加路径保存到数据库当中
						// 使用文件接受的最终文件路径写入我们的内容当中
						String path = userServlet.getServletContext().getRealPath("/image/upload/");

						System.out.println(path);

						File file = new File(path, filename);
						item.write(file);
					}

				}

			}

		} catch (FileUploadException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return user;
	}

	public User uploadFileOneUser(HttpServletRequest request, HttpServletResponse response, HttpServlet hs) {

		// TODO Auto-generated method stub
		// 创建接受文件的工厂类
		DiskFileItemFactory factory = new DiskFileItemFactory();
		// 创建解析对象
		ServletFileUpload upload = new ServletFileUpload(factory);
		User user = new User();
		try {
			List<FileItem> list = upload.parseRequest(request);// 获取请求当中所有的内容，并放置到集合当中

			for (FileItem item : list) {

				// 判定是否是普通的表单 如果是 返回true 如果不是返回false
				if (item.isFormField()) {// 判断当前是普通表单

					if (item.getFieldName().equals("username")) {// 获取当前集合当中的元，并获取和表单当中的元素 的名称是一样的表单元素

						String username = item.getString("utf-8");// 设置其编码格式为utf-8
						// 操作数据库将表单的内容保存到数据库当中
						user.setUsername(username);

					}
					if (item.getFieldName().equals("password")) {// 获取当前集合当中的元，并获取和表单当中的元素 的名称是一样的表单元素

						String password = item.getString("utf-8");// 设置其编码格式为utf-8
						// 操作数据库将表单的内容保存到数据库当中
						user.setPassword(password);

					}
					if (item.getFieldName().equals("name")) {// 获取当前集合当中的元，并获取和表单当中的元素 的名称是一样的表单元素

						String name = item.getString("utf-8");// 设置其编码格式为utf-8
						// 操作数据库将表单的内容保存到数据库当中
						user.setName(name);

					}
					if (item.getFieldName().equals("email")) {// 获取当前集合当中的元，并获取和表单当中的元素 的名称是一样的表单元素

						String email = item.getString("utf-8");// 设置其编码格式为utf-8
						// 操作数据库将表单的内容保存到数据库当中
						user.setEmail(email);

					}
					if (item.getFieldName().equals("phone")) {// 获取当前集合当中的元，并获取和表单当中的元素 的名称是一样的表单元素

						String phone = item.getString("utf-8");// 设置其编码格式为utf-8
						// 操作数据库将表单的内容保存到数据库当中
						user.setPhone(phone);

					}
					if (item.getFieldName().equals("usertype")) {// 获取当前集合当中的元，并获取和表单当中的元素 的名称是一样的表单元素

						String usertype = item.getString("utf-8");// 设置其编码格式为utf-8
						// 操作数据库将表单的内容保存到数据库当中
						user.setUsertype(usertype);

					}
					if (item.getFieldName().equals("state")) {// 获取当前集合当中的元，并获取和表单当中的元素 的名称是一样的表单元素

						String state = item.getString("utf-8");// 设置其编码格式为utf-8
						// 操作数据库将表单的内容保存到数据库当中
						user.setState(state);

					}

					if (item.getFieldName().equals("date")) {// 获取当前集合当中的元，并获取和表单当中的元素 的名称是一样的表单元素

						String date = item.getString("utf-8");// 设置其编码格式为utf-8
						// 操作数据库将表单的内容保存到数据库当中
						user.setDate(date);

					}

				} else {

					String filename = item.getName();

					Random random = new Random();

					Date date = new Date();
					System.out.println(date);

					long d = date.getTime();

					filename = d + random.nextInt() + filename.substring(filename.lastIndexOf("\\") + 1);

					filename = getCode() + filename;

					filename = filename.replaceAll("[\u4e00-\u9fa5]", "");

					System.out.println(filename);
					String dataBasefilename = "/image/upload/" + filename;

					request.setAttribute("dataBasefilename", dataBasefilename);

					user.setImage("upload/" + filename);

					// 将这个文件名称加路径保存到数据库当中
					// 使用文件接受的最终文件路径写入我们的内容当中
					String path = hs.getServletContext().getRealPath("/image/upload/");

					System.out.println(path);

					File file = new File(path, filename);
					item.write(file);
				}

			}

		} catch (FileUploadException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return user;
	}

	public Goods uploadFileGood(HttpServletRequest request, HttpServletResponse response, HttpServlet hs) {

		// TODO Auto-generated method stub
		// 创建接受文件的工厂类
		DiskFileItemFactory factory = new DiskFileItemFactory();
		// 创建解析对象
		ServletFileUpload upload = new ServletFileUpload(factory);
		Goods goods = new Goods();
		String[] imgarr = goods.getGoodiamgecodearray();
		try {
			List<FileItem> list = upload.parseRequest(request);// 获取请求当中所有的内容，并放置到集合当中

			int i = 0;
			for (FileItem item : list) {

				// 判定是否是普通的表单 如果是 返回true 如果不是返回false
				if (item.isFormField()) {// 判断当前是普通表单

					if (item.getFieldName().equals("goodname")) {// 获取当前集合当中的元，并获取和表单当中的元素 的名称是一样的表单元素

						String goodname = item.getString("utf-8");// 设置其编码格式为utf-8
						// 操作数据库将表单的内容保存到数据库当中
						goods.setGoodname(goodname);

					}
					if (item.getFieldName().equals("gooddetail")) {// 获取当前集合当中的元，并获取和表单当中的元素 的名称是一样的表单元素

						String gooddetail = item.getString("utf-8");// 设置其编码格式为utf-8
						// 操作数据库将表单的内容保存到数据库当中
						goods.setGooddetail(gooddetail);

					}
					if (item.getFieldName().equals("goodprice")) {// 获取当前集合当中的元，并获取和表单当中的元素 的名称是一样的表单元素

						String goodprice = item.getString("utf-8");// 设置其编码格式为utf-8
						// 操作数据库将表单的内容保存到数据库当中
						goods.setGoodprice(goodprice);

					}
					if (item.getFieldName().equals("gooddiscount")) {// 获取当前集合当中的元，并获取和表单当中的元素 的名称是一样的表单元素

						String gooddiscount = item.getString("utf-8");// 设置其编码格式为utf-8
						// 操作数据库将表单的内容保存到数据库当中
						goods.setGooddiscount(gooddiscount);

					}
					if (item.getFieldName().equals("goodtypecode")) {// 获取当前集合当中的元，并获取和表单当中的元素 的名称是一样的表单元素

						String goodtypecode = item.getString("utf-8");// 设置其编码格式为utf-8
						// 操作数据库将表单的内容保存到数据库当中
						goods.setGoodtypecode(goodtypecode);

					}

				} else {

					String filename = item.getName();

					Random random = new Random();

					Date date = new Date();
					System.out.println(date);

					long d = date.getTime();

					filename = d + random.nextInt() + filename.substring(filename.lastIndexOf("\\") + 1);

					filename = getCode() + filename;

					filename = filename.replaceAll("[\u4e00-\u9fa5]", "");

					System.out.println(filename);
					String dataBasefilename = "/image/upload/good/" + filename;

					request.setAttribute("dataBasefilename", dataBasefilename);

					imgarr[i] = filename;

					// 将这个文件名称加路径保存到数据库当中
					// 使用文件接受的最终文件路径写入我们的内容当中
					String path = hs.getServletContext().getRealPath("/image/upload/good/");

					System.out.println(path);

					File file = new File(path, filename);
					item.write(file);
					i++;
				}

			}

		} catch (FileUploadException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		goods.setGoodiamgecodearray(imgarr);

		return goods;
	}

	public Goods uploadFileOneGoodUpdate(HttpServletRequest request, HttpServletResponse response,
			HttpServlet hs) {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		// 创建接受文件的工厂类
		DiskFileItemFactory factory = new DiskFileItemFactory();
		// 创建解析对象
		ServletFileUpload upload = new ServletFileUpload(factory);
		Goods goods = new Goods();
		String[] imgarr = goods.getGoodiamgecodearray();
		try {
			List<FileItem> list = upload.parseRequest(request);// 获取请求当中所有的内容，并放置到集合当中
			int i = 0;
			for (FileItem item : list) {

				// 判定是否是普通的表单 如果是 返回true 如果不是返回false
				if (item.isFormField()) {// 判断当前是普通表单
					

					if (item.getFieldName().equals("id")) {// 获取当前集合当中的元，并获取和表单当中的元素 的名称是一样的表单元素

						int id = Integer.parseInt(item.getString("utf-8"));// 设置其编码格式为utf-8
						// 操作数据库将表单的内容保存到数据库当中
						goods.setId(id);

					}
					
					if (item.getFieldName().equals("goodcode")) {// 获取当前集合当中的元，并获取和表单当中的元素 的名称是一样的表单元素

						String goodcode = item.getString("utf-8");// 设置其编码格式为utf-8
						// 操作数据库将表单的内容保存到数据库当中
						goods.setGoodcode(goodcode);

					}
					

					if (item.getFieldName().equals("goodname")) {// 获取当前集合当中的元，并获取和表单当中的元素 的名称是一样的表单元素

						String goodname = item.getString("utf-8");// 设置其编码格式为utf-8
						// 操作数据库将表单的内容保存到数据库当中
						goods.setGoodname(goodname);

					}
					if (item.getFieldName().equals("gooddetail")) {// 获取当前集合当中的元，并获取和表单当中的元素 的名称是一样的表单元素

						String gooddetail = item.getString("utf-8");// 设置其编码格式为utf-8
						// 操作数据库将表单的内容保存到数据库当中
						goods.setGooddetail(gooddetail);

					}
					if (item.getFieldName().equals("goodprice")) {// 获取当前集合当中的元，并获取和表单当中的元素 的名称是一样的表单元素

						String goodprice = item.getString("utf-8");// 设置其编码格式为utf-8
						// 操作数据库将表单的内容保存到数据库当中
						goods.setGoodprice(goodprice);

					}
					if (item.getFieldName().equals("gooddiscount")) {// 获取当前集合当中的元，并获取和表单当中的元素 的名称是一样的表单元素

						String gooddiscount = item.getString("utf-8");// 设置其编码格式为utf-8
						// 操作数据库将表单的内容保存到数据库当中
						goods.setGooddiscount(gooddiscount);

					}
					if (item.getFieldName().equals("goodtypecode")) {// 获取当前集合当中的元，并获取和表单当中的元素 的名称是一样的表单元素

						String goodtypecode = item.getString("utf-8");// 设置其编码格式为utf-8
						// 操作数据库将表单的内容保存到数据库当中
						goods.setGoodtypecode(goodtypecode);

					}
					if (item.getFieldName().equals("goodimagecode")) {// 获取当前集合当中的元，并获取和表单当中的元素 的名称是一样的表单元素
						
						String goodimagecode = item.getString("utf-8");// 设置其编码格式为utf-8
						// 操作数据库将表单的内容保存到数据库当中
						goods.setGoodimagecode(goodimagecode);
						
					}

				} else {
					String filename = item.getName();
					if (!filename.equals("")) {
						Random random = new Random();

						Date date = new Date();
						System.out.println(date);

						long d = date.getTime();

						filename = d + random.nextInt() + filename.substring(filename.lastIndexOf("\\") + 1);

						filename = getCode() + filename;

						filename = filename.replaceAll("[\u4e00-\u9fa5]", "");

						System.out.println(filename);
						String dataBasefilename = "/image/upload/good/" + filename;

						request.setAttribute("dataBasefilename", dataBasefilename);

						imgarr[i] = filename;

						// 将这个文件名称加路径保存到数据库当中
						// 使用文件接受的最终文件路径写入我们的内容当中
						String path = hs.getServletContext().getRealPath("/image/upload/good/");

						System.out.println(path);

						File file = new File(path, filename);
						item.write(file);
						i++;
					}

				}

			}

		} catch (FileUploadException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return goods;
	}

	public String getCode() {
		String a = RandomStringUtils.random(16, "abcdefghijklmnopqrstuvwxyz1234567890");
		System.out.println(a);
		return a;
	}
	
	public static String getCodeUtils() {
		String a = RandomStringUtils.random(16, "abcdefghijklmnopqrstuvwxyz1234567890");
		System.out.println(a);
		return a;
	}

}
