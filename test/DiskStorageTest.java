import com.atypon.training.project.server.controller.database.DiskStorage;
import com.atypon.training.project.server.model.content.BaseContent;
import com.atypon.training.project.server.model.content.PublicationContent;
import com.atypon.training.project.server.model.jouranl.Journal;
import com.atypon.training.project.server.model.liscense.BaseLicense;
import com.atypon.training.project.server.model.liscense.ContentLicense;
import com.atypon.training.project.server.model.liscense.DateLicense;
import com.atypon.training.project.server.model.liscense.JournalLicense;
import com.atypon.training.project.server.model.user.*;
import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

public class DiskStorageTest {
    @Test
    public void TestContentLicense() {
        DiskStorage diskStorage = DiskStorage.getInstance();
        LocalDate now = LocalDate.now();
        Set<Integer> s = new HashSet<>();
        s.add(1);
        s.add(2);
        s.add(3);
        final String xml = "<ContentLicense>\n" +
                "  <licenseId>1</licenseId>\n" +
                "  <timeStamp>" + now.toString() + "</timeStamp>\n" +
                "  <contentIdSet>\n" +
                "    <int>1</int>\n" +
                "    <int>2</int>\n" +
                "    <int>3</int>\n" +
                "  </contentIdSet>\n" +
                "</ContentLicense>";
        BaseLicense l = new ContentLicense(1, now, s);
        Assert.assertEquals(xml, diskStorage.testXml(l));
    }

    @Test
    public void TestJournalLicense() {
        DiskStorage diskStorage = DiskStorage.getInstance();
        LocalDate now = LocalDate.now();
        BaseLicense l = new JournalLicense(3, now, 1);
        final String xml = "<JournalLicense>\n" +
                "  <licenseId>3</licenseId>\n" +
                "  <timeStamp>" + now.toString() + "</timeStamp>\n" +
                "  <journalId>1</journalId>\n" +
                "</JournalLicense>";

        Assert.assertEquals(xml, diskStorage.testXml(l));

    }

    @Test
    public void TestDateLicense() {
        DiskStorage diskStorage = DiskStorage.getInstance();
        LocalDate now = LocalDate.now();
        LocalDate after = LocalDate.now().plusMonths(1);
        BaseLicense l = new DateLicense(2, now, after);
        final String xml = "<DateLicense>\n" +
                "  <licenseId>2</licenseId>\n" +
                "  <timeStamp>" + now.toString() + "</timeStamp>\n" +
                "  <endDate>" + after.toString() + "</endDate>\n" +
                "</DateLicense>";

        Assert.assertEquals(xml, diskStorage.testXml(l));
    }

    @Test
    public void TestPublicationContent() {
        DiskStorage diskStorage = DiskStorage.getInstance();
        LocalDate now = LocalDate.now();
        BaseContent content = new PublicationContent(1, now, 1, 1, "title", "body");
        final String xml = "<PublicationContent>\n" +
                "  <contentId>1</contentId>\n" +
                "  <timeStamp>" + now.toString() + "</timeStamp>\n" +
                "  <journalId>1</journalId>\n" +
                "  <authorId>1</authorId>\n" +
                "  <title>title</title>\n" +
                "  <body>body</body>\n" +
                "</PublicationContent>";
        Assert.assertEquals(xml, diskStorage.testXml(content));

    }

    @Test
    public void TestJournal() {
        DiskStorage diskStorage = DiskStorage.getInstance();
        LocalDate now = LocalDate.now();
        Journal journal = new Journal(1, "journal", now);
        final String xml = "<Journal>\n" +
                "  <journalId>1</journalId>\n" +
                "  <journalName>journal</journalName>\n" +
                "  <timeStamp>" + now.toString() + "</timeStamp>\n" +
                "</Journal>";
        Assert.assertEquals(xml, diskStorage.testXml(journal));

    }

    @Test
    public void TestUser() {
        DiskStorage diskStorage = DiskStorage.getInstance();
        LocalDate now = LocalDate.now();
        BaseUser user = new User(1, "name", "pass", now, 1, UserPrivilege.BasePrivilege);
        final String xml = "<User>\n" +
                "  <userId>1</userId>\n" +
                "  <userName>name</userName>\n" +
                "  <password>pass</password>\n" +
                "  <timeStamp>" + now.toString() + "</timeStamp>\n" +
                "  <licenceId>1</licenceId>\n" +
                "  <privilege>BasePrivilege</privilege>\n" +
                "</User>";
        Assert.assertEquals(xml, diskStorage.testXml(user));
    }

    @Test
    public void TestAdmin() {
        DiskStorage diskStorage = DiskStorage.getInstance();
        LocalDate now = LocalDate.now();
        BaseUser user = new Admin(1, "name", "pass", now, AdminPrivilege.BasePrivilege);
        final String xml = "<Admin>\n" +
                "  <userId>1</userId>\n" +
                "  <userName>name</userName>\n" +
                "  <password>pass</password>\n" +
                "  <timeStamp>" + now.toString() + "</timeStamp>\n" +
                "  <privilege>BasePrivilege</privilege>\n" +
                "</Admin>";
        Assert.assertEquals(xml, diskStorage.testXml(user));
    }

    @Test
    public void TestReadAdmin(){
        DiskStorage diskStorage = DiskStorage.getInstance();
        LocalDate now = LocalDate.now();
        BaseUser user = new Admin(1, "name", "pass", now, AdminPrivilege.BasePrivilege);

        final String xml = "<Admin>\n" +
                "  <userId>1</userId>\n" +
                "  <userName>name</userName>\n" +
                "  <password>pass</password>\n" +
                "  <timeStamp>" + now.toString() + "</timeStamp>\n" +
                "  <privilege>BasePrivilege</privilege>\n" +
                "</Admin>";

        Assert.assertEquals(user, diskStorage.fromXml(xml));

    }

    @Test
    public void TestReadContentLicense(){
        DiskStorage diskStorage = DiskStorage.getInstance();
        LocalDate now = LocalDate.now();
        Set<Integer> s = new HashSet<>();
        s.add(1);
        s.add(2);
        s.add(3);
        final String xml = "<ContentLicense>\n" +
                "  <licenseId>1</licenseId>\n" +
                "  <timeStamp>" + now.toString() + "</timeStamp>\n" +
                "  <contentIdSet>\n" +
                "    <int>1</int>\n" +
                "    <int>2</int>\n" +
                "    <int>3</int>\n" +
                "  </contentIdSet>\n" +
                "</ContentLicense>";
        BaseLicense l = new ContentLicense(1, now, s);

        Assert.assertEquals(l, diskStorage.fromXml(xml));

    }

}
