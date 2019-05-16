package com.hkdemircan;

public class Category {
    private String upCategory;
    private String title;

    public Category(String title) {
        this.title = title;
    }

    public String getUpCategory() {
        return upCategory;
    }

    public void setUpCategory(String upCategory) {
        this.upCategory = upCategory;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
