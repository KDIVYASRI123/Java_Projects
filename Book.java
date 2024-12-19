package models;

public class Book {
    private int bookId;
    private String details;
    private String title;
    private Integer page_num;
    private Integer rating;

    public Book(int id, String details, String title) {
        bookId = id;
        this.details = details;
        this.title = title;
        this.page_num = 0;
        this.rating = null;
    }

    public int getId() {
        return bookId;
    }

    public String getDetails() {
        return details;
    }

    public String getTitle() {
        return title;
    }

    public Integer getPageNum() {
        return this.page_num;
    }

    public void setPageNum(Integer page_num) {
        this.page_num = page_num;
    }

    public Integer getRating() {
        return rating;
    }

    public void rateBook(int rating) {
        if (rating >= 1 && rating <= 5) {
            this.rating = rating;
            System.out.println("Book " + title + " rated with " + rating + " stars.");
        } else {
            System.out.println("Invalid rating. Please provide a rating between 1 and 5.");
        }
    }

    @Override
    public String toString() {
        return  this.bookId + "." + this.title + "(" + this.details + ")";
    }
}
