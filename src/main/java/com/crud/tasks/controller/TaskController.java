package com.crud.tasks.controller;

import com.crud.tasks.domain.TaskDto;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/v1/task")
public class TaskController {

    @RequestMapping(method = RequestMethod.GET, value = "getTasks")
    public List<TaskDto> getTasks(){
        TaskDto taskDto1 = new TaskDto((long)25,"Titttttle","Summary");
        TaskDto taskDto2 = new TaskDto((long)1,"Titttttle","Summary");
        List<TaskDto> list = new ArrayList<>();
        list.add(taskDto1);
        list.add(taskDto2);
        return list;
    }

    @RequestMapping(method = RequestMethod.GET, value = "getTask")
    public TaskDto getTask(String taskId){
        return new TaskDto((long)5,"Title","Summary");
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "deleteTask")
    public String deleteTask(String taskId){
        return "Deleted task with ID: "+taskId;
    }

    @RequestMapping(method = RequestMethod.GET, value = "updateTask")
    public TaskDto updateTask(TaskDto taskDto){
        return new TaskDto((long)5, "New title", "Summary");
    }

    @RequestMapping(method = RequestMethod.GET, value = "createTask")
    public void createTask(TaskDto taskDto){
        System.out.println("Created new task.");
    }
}
