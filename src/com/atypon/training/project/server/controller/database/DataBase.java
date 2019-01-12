package com.atypon.training.project.server.controller.database;

import com.atypon.training.project.server.model.Identifiable;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.LinkedBlockingQueue;

public class DataBase<T extends Identifiable> {
    private ConcurrentHashMap<Integer, T> data;
    private BlockingQueue<Integer> identities;
    private int maxNumberOfElements;
    private DiskStorage diskStorage;
    private String folder;

    protected DataBase(int maxNumberOfElements, String folder) {
        this.maxNumberOfElements = maxNumberOfElements;
        data = new ConcurrentHashMap<>();
        identities = new LinkedBlockingQueue<>();
        diskStorage = DiskStorage.getInstance();
        this.folder = folder;
    }


    public void add(T element) {
        addCache(element);
        diskStorage.write(folder, element);
    }

    private void addCache(T element) {
        if (data.size() >= maxNumberOfElements) {
            removeFromCache();
        }
        data.put(element.getId(), element);
        identities.add(element.getId());
    }

    private void removeFromCache() {
        try {
            int id = identities.take();
            data.remove(id);
        } catch (Exception e) {
        }
    }


    public T get(int id) {
        if (data.containsKey(id)) {
            return data.get(id);
        }

        T element = (T) diskStorage.read(folder, id);
        addCache(element);
        return element;
    }

    public void update(T element) {
        data.replace(element.getId(), element);
//        if (data.containsKey(element.getId())) {
//            data.put(element.getId(), element);
//        }
        diskStorage.write(folder, element);
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
