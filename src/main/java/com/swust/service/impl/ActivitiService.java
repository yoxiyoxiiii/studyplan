package com.swust.service.impl;

import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.repository.Deployment;
import org.activiti.engine.repository.DeploymentQuery;
import org.activiti.engine.runtime.ProcessInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by jiangyan on 2017/6/3.
 */
@Service
@Transactional
public class ActivitiService {
    @Autowired
    private TaskService taskService;
    @Autowired
    private RuntimeService runtimeService;
    @Autowired
    private RepositoryService repositoryService;

    /**
     * 获得指定用户的流程处理列表
     */
    public void getProcessList() {
        DeploymentQuery DeploymentQuery = repositoryService.
                createDeploymentQuery().processDefinitionKey("");
    }

    /**
     * 流程部署
     */
    public Deployment deployment() {
        Deployment deployment = repositoryService.createDeployment()
                .addClasspathResource("").deploy();
        return deployment;
    }

    /**
     * 启动流程实例
     */
    public ProcessInstance startProcess(String processDefinitionId) {
        //设置流程变量
        Map<String, Object> var = new HashMap<String, Object>();
        //启动流程实例
       ProcessInstance processInstance = runtimeService.
               startProcessInstanceById(processDefinitionId, var);
       return  processInstance;
    }
}
