package com.swust.service.impl;

import com.swust.base.PageInfo;
import com.swust.domain.CourseProcess;
import com.swust.mapper.CourseProcessMapper;
import com.swust.service.CourseProcessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by jiangyan on 2017/6/6.
 */
@Service
@Transactional
public class CourseProcessImpl implements CourseProcessService {
    @Autowired
    private CourseProcessMapper courseProcessMapper;
    public CourseProcess findById(Integer id) {
        return courseProcessMapper.findById(id);
    }

    public boolean save(CourseProcess entity) {
        courseProcessMapper.save(entity);
        return true;
    }

    public boolean deleteById(Integer id) {
        courseProcessMapper.deleteById(id);
        return true;
    }

    public boolean update(CourseProcess entity) {
        courseProcessMapper.update(entity);
        return true;
    }

    public List<PageInfo<CourseProcess>> findByPage(PageInfo<CourseProcess> pageInfo) {
        return null;
    }

    public List<CourseProcess> findByUid(Integer uid) {
        List<CourseProcess>list=courseProcessMapper.findByUid(uid);
        return list;
    }
}
