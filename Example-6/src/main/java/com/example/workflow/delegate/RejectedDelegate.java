package com.example.workflow.delegate;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.stereotype.Component;

@Component("rejectedDelegate")
public class RejectedDelegate implements JavaDelegate {

    @Override
    public void execute(DelegateExecution execution) {
        String name = (String) execution.getVariable("employeeName");
        System.out.println("❌ Rejected: " + name);
    }

}
