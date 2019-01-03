package com.atypon.training.project.controller.cache;

import com.atypon.training.project.model.Identifiable;
import com.atypon.training.project.model.jouranl.Journal;
import com.atypon.training.project.model.content.PublicationContent;
import com.atypon.training.project.model.liscense.ContentLicense;
import com.atypon.training.project.model.liscense.DateLicense;
import com.atypon.training.project.model.liscense.JournalLicense;
import com.atypon.training.project.model.user.Admin;
import com.atypon.training.project.model.user.User;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class DiskStorage {
    private static DiskStorage ourInstance = new DiskStorage();
    private XStream xStream;

    public static DiskStorage getInstance() {
        return ourInstance;
    }

    private DiskStorage() {
        initializeXStream();
    }

    private void initializeXStream() {
        xStream = new XStream(new DomDriver());
        mapLicenseToXStream();
        mapUserToXStream();
        mapContentToXStream();
    }

    private void mapLicenseToXStream() {
        xStream.alias("ContentLicense", ContentLicense.class);
        xStream.alias("DateLicense", DateLicense.class);
        xStream.alias("JournalLicense", JournalLicense.class);
    }

    private void mapUserToXStream() {
        xStream.alias("User", User.class);
        xStream.alias("Admin", Admin.class);
    }

    private void mapContentToXStream() {
        xStream.alias("Journal", Journal.class);
        xStream.alias("PublicationContent", PublicationContent.class);

    }

    private String getFileName(int id) {
        StringBuilder fileName = new StringBuilder();
        fileName.append(id);
        fileName.append(".xml");
        return fileName.toString();
    }

    public void write(String folder, Identifiable object) {
        try {
            writeWithException(folder, object);
        } catch (IOException e) {
        }
    }

    private void writeWithException(String folder, Identifiable object) throws IOException {
        Path file = Paths.get(folder, getFileName(object.getId()));
        Files.write(file, xStream.toXML(object).getBytes());
    }

    public Identifiable read(String folder, int id) {
        File file = Paths.get(folder, getFileName(id)).toFile();
        return (Identifiable) xStream.fromXML(file);
    }

    public void delete(String folder, int id) {
        try {
            deleteWithException(folder, id);
        } catch (IOException e) {
        }
    }

    private void deleteWithException(String folder, int id) throws IOException {
        Path file = Paths.get(folder, getFileName(id));
        Files.delete(file);
    }

    public boolean contains(String folder, int id) {
        String fileName = String.valueOf(id) + ".xml";
        Path file = Paths.get(folder, fileName);
        return Files.exists(file);
    }

    /**
     * @Deprecated
     **/
    public String testXml(Object o) {
        return xStream.toXML(o);
    }

    public Object fromXml(String xml) {
        return xStream.fromXML(xml);
    }
}
