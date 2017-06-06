package com.swust.mapper;

import com.swust.base.BaseMapper;
import com.swust.domain.CourseProcess;

import java.util.List;

public interface CourseProcessMapper extends BaseMapper<CourseProcess,Integer> {

    List<CourseProcess> findByUid(Integer uid);
}