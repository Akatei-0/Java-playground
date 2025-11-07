package com.aka;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.nio.file.Path;
import java.nio.file.Files;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.exc.MismatchedInputException;

public class JsonStorage implements Storage {
    private final ObjectMapper OBJECT_MAPPER;
    private final Path SAVEFILE;

    public JsonStorage(String saveFilePath) {
        OBJECT_MAPPER = new ObjectMapper();
        SAVEFILE = Path.of(saveFilePath);
        OBJECT_MAPPER.enable(SerializationFeature.INDENT_OUTPUT);
    }
    
    
    @Override
    public List<Task> loadTasks() {
        try {
            List<TaskDTO> dtos = OBJECT_MAPPER.readValue(SAVEFILE.toFile(), new TypeReference<List<TaskDTO>>() {});
            return dtosToDomain(dtos);
        }
        catch (IOException e) {
            System.out.println("Save not found. Creating a new one.");
            System.out.println("error" + e);
            return new ArrayList<>();
        }
    }
    
    @Override
    public void saveTasks(List<Task> tasks) {
        try {
            OBJECT_MAPPER.writeValue(SAVEFILE.toFile(), domainToDTOs(tasks));
        }
        catch (IOException e) {
            System.out.println("Error: " + e);
        }
    }
    
    private List<Task> dtosToDomain(List<TaskDTO> dtos) {
        List<Task> tasks = new ArrayList<>();
        for (TaskDTO dto: dtos) {
            Task task = TaskMapper.dtoToDomain(dto);
            tasks.add(task);
        }
        return tasks;
    }

    private List<TaskDTO> domainToDTOs (List<Task> tasks) {
        List<TaskDTO> dtos = new ArrayList<>();
        for (Task task: tasks) {
            TaskDTO dto = TaskMapper.domainToDTO(task);
            dtos.add(dto);
        }
        return dtos;
    }

}
