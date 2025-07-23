package com.example.workflow.service;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.stereotype.Service;

@Service
public class EmailService implements JavaDelegate {
    @Override
    public void execute(DelegateExecution execution) {
        System.out.println("✅ Sending Welcome Email to Candidate: " + execution.getVariable("candidateName"));
    }
}
