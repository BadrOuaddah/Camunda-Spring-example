package com.example.workflow.delegate;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.stereotype.Component;

@Component("serviceDelegate")
public class ServiceDelegate implements JavaDelegate {

    @Override
    public void execute(DelegateExecution execution) throws Exception {
        String employeeName = (String) execution.getVariable("employeeName");
        Boolean approved = (Boolean) execution.getVariable("approved");

        System.out.println("Service Task is executing...");
        System.out.println("Employee Name: " + employeeName);
        System.out.println("Approved: " + approved);
        System.out.println("Service Task is ending...");
    }

}