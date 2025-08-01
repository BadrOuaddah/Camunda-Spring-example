package com.example.workflow.controller;

import com.example.workflow.dto.TaskDto;
import com.example.workflow.service.ProcessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/process")
public class ProcessController {

    @Autowired
    private ProcessService processService;

    public ProcessController(ProcessService processService) {
        this.processService = processService;
    }

    @PostMapping("/start")
    public ResponseEntity<String> startProcess(@RequestParam("employeeName") String employeeName) {
        String processId = processService.startProcess(employeeName);
        return ResponseEntity.ok("Process started with ID: " + processId);
    }

    @GetMapping("/tasks")
    public List<TaskDto> getTasks() {
        return processService.getPendingTasks();
    }

    @PostMapping("/tasks/{taskId}/complete")
    public ResponseEntity<String> completeTask(@PathVariable("taskId") String taskId,
                                               @RequestParam("approved") boolean approved) {
        processService.completeTask(taskId, approved);
        return ResponseEntity.ok("Task completed.");
    }

}
