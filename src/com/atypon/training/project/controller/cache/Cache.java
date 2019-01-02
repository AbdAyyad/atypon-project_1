package com.atypon.training.project.controller.cache;

import com.atypon.training.project.model.Identifiable;

import java.util.*;

public class Cache<T extends Identifiable> {
    private Map<Integer, T> data;
    private Queue<Integer> identities;
    private int maxNumberOfElements;
    private DiskStorage diskStorage;
    private String folder;

    protected Cache(int maxNumberOfElements, String folder) {
        this.maxNumberOfElements = maxNumberOfElements;
        data = new HashMap<>();
        identities = new LinkedList<>();
        diskStorage = DiskStorage.getInstance();
        this.folder = folder;
    }


    public void add(T element) {
        if (data.size() >= maxNumberOfElements) {
            removeFromCache();
        }
        addCache(element);
    }

    private void removeFromCache() {
        int id = identities.poll();
        diskStorage.write(folder, data.get(id));
        data.remove(id);
    }

    private void addCache(T element) {
        data.put(element.getId(), element);
        identities.add(element.getId());
    }

    public T get(int id) {
        if (data.containsKey(id)) {
            return data.get(id);
        }

        T element = (T) diskStorage.read(folder, id);
        add(element);
        return element;
    }

    public void update(T element) {
        data.put(element.getId(), element);
    }

    public void delete(int id) {
        if (data.containsKey(id)) {
            data.remove(id);
            identities.remove(id);
        }
        diskStorage.delete(folder, id);
    }

    public boolean contains(int id) {
        if (data.containsKey(id)) {
            return true;
        }
        return diskStorage.contains(folder, id);
    }
}
