package br.com.faculdadedonaduzzi.lab.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Optional;

import br.com.faculdadedonaduzzi.lab.entity.Task;
import br.com.faculdadedonaduzzi.lab.entity.TaskStatus;

import org.springframework.stereotype.Repository;


@Repository
public class TaskRepository  {
    private final Map<Long,Task> tasks = new LinkedHashMap<>();
    private Long nextId = 1L;


    public Task save(Task task){
        if (task.getId() == null){
            task.setId(nextId++);
        }
        tasks.put(task.getId(), task);
        return task;
    }

    public List<Task> findAll() {
        return new ArrayList<>(tasks.values());
    }


    public Optional<Task> findById(Long id) {
        return Optional.ofNullable(tasks.get(id));
    }

    public void deleteById(Long id) {
        tasks.remove(id);
    }

}
