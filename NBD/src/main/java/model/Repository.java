package model;

import java.util.ArrayList;

public class Repository<T> {

    private int id;
    private ArrayList<T> repo = new ArrayList<>();

    public Repository() {}

    public Repository(int id) {
        this.id = id;
    }

    public T get(int index) {
        return repo.get(index);
    }

    public void add(T obj) {
        repo.add(obj);
    }

    public void remove(T obj) {
        repo.remove(obj);
    }

    public int size() {
        return repo.size();
    }

    public int getId() {
        return id;
    }
}
