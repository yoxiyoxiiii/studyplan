package com.swust.test;

import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.Expression;
import org.activiti.engine.delegate.JavaDelegate;

/**
 * Created by Administrator on 2017/4/26.
 */
public class javaTask implements JavaDelegate {

    private Expression Hello;

    public void execute(DelegateExecution delegateExecution) throws Exception {
       String value=(String )Hello.getValue(delegateExecution);
       System.out.println("value="+value);
    }
}
