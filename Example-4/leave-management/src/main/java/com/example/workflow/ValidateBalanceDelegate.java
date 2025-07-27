package com.example.workflow;

import camunda_bpm.LoggerDelegate;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;

import java.util.logging.Logger;

public class ValidateBalanceDelegate implements JavaDelegate {

    private final Logger LOGGER = Logger.getLogger(LoggerDelegate.class.getName());

    @Override
    public void execute(DelegateExecution execution) throws Exception {
        String leaveType = (String) execution.getVariable("leaveType");
        LOGGER.info("Leave type is >>> :" + leaveType);
        LOGGER.info("\n\n  ... Validate Balance Delegate invoked by "
                + "activtyName='" + execution.getCurrentActivityName() + "'"
                + ", activtyId=" + execution.getCurrentActivityId()
                + ", processDefinitionId=" + execution.getProcessDefinitionId()
                + ", processInstanceId=" + execution.getProcessInstanceId()
                + ", businessKey=" + execution.getProcessBusinessKey()
                + ", executionId=" + execution.getId()
                + ", variables=" + execution.getVariables()
                + " \n\n");
    }

}
