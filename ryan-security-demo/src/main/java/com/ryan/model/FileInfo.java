package com.ryan.model;

import lombok.Getter;
import lombok.Setter;

/**
 * @author ryan
 * @version Id: FileInfo, v 0.1 2022/4/7 8:49 PM ryan Exp $
 */
public class FileInfo {

    public FileInfo(String path){
        this.path = path;
    }

    private String path;

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

}
