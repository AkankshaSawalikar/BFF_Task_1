package book_service.book_service.model;

import org.apache.catalina.User;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Document(collection = "books")
public class Book {
    @Id
    private String id;
    private String name;
    private String author;
    private String publisher;
    private String publicationDate;
    private String userId;
    @ManyToOne
    @JoinColumn(name = "user_id") // This is the foreign key column in the book table
    private User user;

    // Getters and setters
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getPublicationDate() {
        return publicationDate;
    }

    public void setPublicationDate(String publicationDate) {
        this.publicationDate = publicationDate;
    }

    public String getAssignedUserId() {
        return userId;
    }

    public void setAssignedUserId(String userId) {
        this.userId = userId;
    }


}