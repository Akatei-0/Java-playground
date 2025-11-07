package com.aka;

import java.util.UUID;

public class TaskMapper {
    
    public static Task dtoToDomain(TaskDTO dto) {
        return new Task (UUID.fromString(dto.id), dto.title, Priority.valueOf(dto.priority), dto.done);
    }
    
    public static TaskDTO domainToDTO(Task task) {
        return new TaskDTO(task.getId().toString(), task.getTitle(), task.getPriority().toString(), task.getDone());
    }

}
