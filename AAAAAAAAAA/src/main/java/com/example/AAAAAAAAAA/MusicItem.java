package com.example.AAAAAAAAAA;

public abstract class MusicItem {
    protected String title;

    public MusicItem(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public abstract String getInfo();
}