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

    public void write(Identifiable object) {
    }

    public Identifiable read(int id) {
        return null;
    }

    public void delete(int id) {

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
