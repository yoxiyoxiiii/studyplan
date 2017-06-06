package com.swust.controller;

import com.swust.domain.Course;
import com.swust.domain.CourseProcess;
import com.swust.domain.CourseProcessBean;
import com.swust.service.CourseProcessService;
import com.swust.service.CourseService;
import com.swust.service.impl.ActivitiService;
import com.swust.shiro.ShiroUtils;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jiangyan on 2017/6/3.
 * 学习流程管理
 */

@Controller
@RequestMapping("/process")
public class StudyplanController {

    @Autowired
    private ActivitiService activitiService;

    @Autowired
    private CourseProcessService courseProcessService;

    @Autowired
    private CourseService courseService;


    /**
     * 流程列表
     *
     * @return
     */
    @RequestMapping("/list")
    public ModelAndView list(ModelAndView modelAndView) {
        List<CourseProcessBean> beans =new ArrayList<CourseProcessBean>();
        Integer uid = ShiroUtils.getUserId();
        List<CourseProcess> list = courseProcessService.findByUid(uid);
        CourseProcessBean courseProcessBean =null;
        for (CourseProcess courseProcess : list) {
            courseProcessBean =new CourseProcessBean();
            Integer cid = courseProcess.getCid();
            Course course =courseService.findById(cid);
            courseProcessBean.setCourseName(course.getName());
            courseProcessBean.setId(courseProcess.getId());
            courseProcessBean.setPid(courseProcess.getPid());
            beans.add(courseProcessBean);
        }

        modelAndView.addObject("beans",beans);
        modelAndView.setViewName("admin/process/list");
        return modelAndView;
    }
}
