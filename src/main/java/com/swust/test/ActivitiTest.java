package com.swust.test;

import org.activiti.engine.RepositoryService;
import org.activiti.engine.repository.Deployment;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by Administrator on 2017/4/26.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring/applicationContext-all.xml")
public class ActivitiTest{

    @Autowired
  private RepositoryService repositoryService;

    @Test
    public void  deploey(){
        repositoryService.createDeployment().addClasspathResource("javaTask.bpmn")
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


}
