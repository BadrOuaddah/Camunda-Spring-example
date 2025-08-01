package com.example.workflow.delegate;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.stereotype.Component;

@Component("updateApprovalDelegate")
public class UpdateApprovalDelegate implements JavaDelegate {

    @Override
    public void execute(DelegateExecution execution) {
        String name = (String) execution.getVariable("employeeName");
        System.out.println("✅ Approved: " + name);
    }

}