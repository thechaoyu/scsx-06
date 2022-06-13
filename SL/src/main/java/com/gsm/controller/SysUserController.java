package com.gsm.controller;

import com.gsm.entity.SysUser;
import com.gsm.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.List;

// controller :返回的数据经过视图解析器,进入相应的页面
// restController:返回的数据直接返回数据
@Controller
public class SysUserController {

    @Resource
    private SysUserService SysUserService;

    /**
     * 返回数据
     * @return
     */
    @RequestMapping("/query")
    @ResponseBody
    private List<SysUser> querySysUser(){
        List<SysUser> list = SysUserService.query();
        return list;
    }

    /**
     * 经过视图解析器,进入index.jsp页面
     * @return
     */
    @RequestMapping("/queryModel")
    private ModelAndView queryModel(){
        ModelAndView mv = new ModelAndView("index");
        return mv;
    }

    /**
     * 经过视图解析器,进入SysUserQuery.jsp页面
     * @return
     */
    @RequestMapping("/queryModelSysUser")
    private ModelAndView queryModelSysUser(){
        //注意sysUserQuery首字母大小写，和实际必须对应
        ModelAndView mv = new ModelAndView("sysUserQuery");
        mv.addObject("p",SysUserService.query());
        return mv;
    }

    /**
     * 返回内容
     * @return
     */
    @RequestMapping("/queryString")
    @ResponseBody
    private String querySysUserString(){
        return "index";
    }
}
