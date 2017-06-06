package com.swust.service;

import com.swust.base.BaseService;
import com.swust.domain.CourseProcess;

import java.util.List;

/**
 * Created by Administrator on 2017/6/6.
 */
public interface CourseProcessService  extends BaseService<CourseProcess, Integer> {
    List<CourseProcess> findByUid(Integer uid);
}
