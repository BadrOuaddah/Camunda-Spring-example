package com.example.workflow.service;

import com.example.workflow.dto.TaskDto;
import org.camunda.bpm.engine.RuntimeService;
import org.camunda.bpm.engine.TaskService;
import org.camunda.bpm.engine.runtime.ProcessInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ProcessService {

    @Autowired
    private RuntimeService runtimeService;

    @Autowired
    private TaskService taskService;

    public String startProcess(String employeeName) {
        Map<String, Object> variables = new HashMap<>();
        variables.put("employeeName", employeeName);
        ProcessInstance instance = runtimeService.startProcessInstanceByKey("demoProcess", variables);
        return instance.getId();
    }

    public List<TaskDto> getPendingTasks() {
        return taskService.createTaskQuery()
                .taskName("Approve Request")
                .list()
                .stream()
                .map(task -> new TaskDto(task.getId(), task.getName(), task.getAssignee()))
                .toList();
    }

    public void completeTask(String taskId, boolean approved) {
        Map<String, Object> vars = new HashMap<>();
        vars.put("approved", approved);
        taskService.complete(taskId, vars);
    }
}
