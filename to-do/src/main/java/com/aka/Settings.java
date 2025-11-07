package com.aka;

import com.fasterxml.jackson.annotation.JsonCreator;

public class Settings {
    private String saveFilePath;
    private SortBy sortBy;
    
    @JsonCreator
    public Settings(String saveFilePath,SortBy sortBy) {
        this.saveFilePath = saveFilePath;
        this.sortBy = sortBy;
    }
    
    public void setSaveFilePath(String saveFilePath) {
        this.saveFilePath = saveFilePath;
    }
    
    public String getSaveFilePath() {
        return saveFilePath;
    }
    
    public void setSortBy(SortBy sortBy) {
        this.sortBy = sortBy;
    }
    
    public SortBy getSortBy() {
        return sortBy;
    }
}
