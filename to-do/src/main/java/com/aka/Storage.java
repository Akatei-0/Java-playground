package com.aka;

import java.io.IOException;
import java.util.List;

public interface Storage {
    void saveTasks(List<Task> tasks) throws IOException;
    List<Task> loadTasks() throws IOException;

}
