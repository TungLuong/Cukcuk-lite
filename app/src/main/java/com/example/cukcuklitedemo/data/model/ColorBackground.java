package com.example.cukcuklitedemo.data.model;

import java.io.Serializable;

public class ColorBackground  implements Serializable {
    int id;
    String content;

    public ColorBackground() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
