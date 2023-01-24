package com.example.demo.controller;

import com.example.demo.Pojo.Task;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RequestMapping("/api/v1")
@RestController
public class controller {
    ArrayList<Task> al = new ArrayList<Task>();
   @GetMapping("/task")
   public ArrayList<Task> geeTask(){
       return al;
   }


    @PostMapping("/add")
    public String addTask(@RequestBody Task task ){
      al.add(task);
      return "added done";
    }

    @PutMapping("/update/{index}")
    public  String updateTask(@PathVariable int index, @RequestBody Task task ){
         al.set(index,task);
       return " task  has been updated";
    }

    @DeleteMapping("/delete/{index}")
    public String deleteTask(@PathVariable int index){
       al.remove(index);
       return "task  has been deleted";
}
    @GetMapping("/statue/{index}")
    public String changeStatue(@PathVariable int index,@RequestBody Task task){
        if(task.getStatus()=="not don")
            task.setStatus("done");
        al.set(index,task);
        return "  task status has been updated";
    }
    @GetMapping("/search/{title}")
    public ArrayList<Task> search(@PathVariable String title){
        return al;
    }

}
