
package book_service.book_service.dto;

public class BookDto {
    private String name;
    private String author;
    private String publisher;
    private String publicationDate;
    private String userId;

    public BookDto() {
    }

    public BookDto(String name, String author, String publisher, String publicationDate, String userId) {
        this.name = name;
        this.author = author;
        this.publisher = publisher;
        this.publicationDate = publicationDate;
        this.userId = userId;
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

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
