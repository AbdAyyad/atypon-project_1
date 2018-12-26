package com.atypon.training.project.model.content;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

public class PublicationContent extends BaseContent implements Serializable, Comparable {
    private String title;
    private String body;

    public PublicationContent(int contentId, Date timeStamp, int journalId, int authorId, String title, String body) {
        super(contentId, timeStamp, journalId, authorId);
        this.title = title;
        this.body = body;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    @Override
    public int compareTo(Object o) {
        PublicationContent publicationContent = (PublicationContent) o;
        return Integer.compare(getContentId(), publicationContent.getContentId());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        PublicationContent that = (PublicationContent) o;
        return title.equals(that.title) &&
                body.equals(that.body);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), title, body);
    }
}
