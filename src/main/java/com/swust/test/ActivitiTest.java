package com.swust.test;

import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.repository.Deployment;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.lang.reflect.MalformedParameterizedTypeException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2017/4/26.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring/applicationContext-all.xml")
public class ActivitiTest{

    @Autowired
  private RepositoryService repositoryService;
    @Autowired
    private RuntimeService runtimeService;
    @Autowired
    private TaskService taskService;

    @Test
    public void  deploey(){
        repositoryService.createDeployment()
                .name("studyplan")
                .addClasspathResource("studyplan.bpmn")
                .deploy();
    }
    @Test
    public void  deploy2(){
        Deployment deployment =repositoryService.createDeployment()
                .addClasspathResource("userActiviti.bpmn")
                .addClasspathResource("userDemo.bpmn")
                .deploy();
        String id =deployment.getId();
    }

    @Test
    public void startProcess(){
        Map<String,Object> var =new HashMap<String,Object>();
        var.put("user","admin");
        runtimeService.startProcessInstanceByKey("studyplan",var);

    }

    @Test
    public  void next(){
        Map<String,Object> var =new HashMap<String,Object>();
        var.put("user","admin");
        taskService.complete("10005",var);
    }

    @Test
    public void complete(){
        taskService.complete("15002");

    }
}
