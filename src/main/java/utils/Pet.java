package utils;

import java.util.ArrayList;
import java.util.List;

public class Pet {


    private int id;

    private Category category;

    private String name;

    private List<String> photoUrls;

    private List<Tag> tags;

    private String status;

    // Constructors
    public Pet() {
    }


    public Pet(int id, Category category, String name, List<String> photoUrls, List<Tag> tags, String status) {
        this.id = id;
        this.category = category;
        this.name = name;
        this.photoUrls = photoUrls;
        this.tags = tags;
        this.status = status;
    }

    // Getters and Setters
    public int getId() {
        return id;
    }


    public void setId(int id) {
        this.id = id;
    }


    public Category getCategory() {
        return category;
    }


    public void setCategory(Category category) {
        this.category = category;
    }


    public String getName() {
        return name;
    }


    public void setName(String name) {
        this.name = name;

    }


    public List<String> getPhotoUrls() {
        return photoUrls;

    }


    public void setPhotoUrls(ArrayList<String> photoUrls) {
        this.photoUrls = photoUrls;
    }


    public List<Tag> getTags() {
        return tags;
    }


    public void setTags(List<Tag> tags) {
        this.tags = tags;
    }


    public String getStatus() {
        return status;
    }


    public void setStatus(String status) {
        this.status = status;
    }

    // Inner classes


    public static class Category {
        private int id;
        private String name;
        // Constructors

        public Category() {
        }


        public Category(int id, String name) {
            this.id = id;
            this.name = name;
        }

        public int getId() {
            return id;
        }


        public void setId(int id) {
            this.id = id;
        }


        public String getName() {
            return name;
        }


        public void setName(String name) {
            this.name = name;
        }
    }


    public static class Tag {
        private int id;
        private String name;

        // Constructors
        public Tag() {
        }

        public Tag(int id, String name) {
            this.id = id;
            this.name = name;
        }

        // Getters and Setters

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

}

