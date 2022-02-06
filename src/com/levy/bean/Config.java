package com.levy.bean;

/**
 * @description：Config的bean
 * @author：LevyXie
 * @create：2022-02-04 22:29
 */
public class Config {
    private int id;
    private String key;
    private String value;

    public Config(int id, String key, String value) {
        this.id = id;
        this.key = key;
        this.value = value;
    }

    public Config(String key, String value) {
        this.key = key;
        this.value = value;
    }

    public Config() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Config{" +
                "id=" + id +
                ", key='" + key + '\'' +
                ", value='" + value + '\'' +
                '}';
    }
}
