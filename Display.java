package models;

public class Display {
    private Book activeBook;
    private User activeUser;
    private int pageNumber = 0;

    public void setActiveUser(User user) {
        activeUser = user;
        Integer activeBookId = user.getActiveBookId();
        
        if (activeBookId == null) {
            System.out.println("User " + user.getName() + " has no active book.");
            return; 
        }

        activeBook = user.getUserLib().find(activeBookId);
        if (activeBook == null) {
            System.out.println("No book found with ID: " + activeBookId);
        }
    }

    public void displayUser(User user) {
        activeUser = user;
        refreshUsername();
    }

    public void displayBook(User user) {
        Integer activeBookId = user.getActiveBookId();
        
        if (activeBookId == null) {
            System.out.println("User " + user.getName() + " has no active book.");
            return;
        }

        activeBook = user.getUserLib().find(activeBookId);
        if (activeBook == null) {
            System.out.println("No book found for user " + user.getName() + ".");
            return;
        }

        pageNumber = activeBook.getPageNum();
        refreshTitle();
        refreshDetails();
        refreshPage();
    }

    public void turnPageForward() {
        if (activeBook == null) {
            System.out.println("No active book to turn pages.");
            return;
        }
        
        pageNumber++;
        activeBook.setPageNum(pageNumber);
        System.out.println("Turning forward to page no " + pageNumber + " of book having title " + activeBook.getTitle());
        refreshPage();
    }

    public void turnPageBackward() {
        if (activeBook == null) {
            System.out.println("No active book to turn pages.");
            return;
        }

        pageNumber--;
        activeBook.setPageNum(pageNumber);
        System.out.println("Turning backward to page no " + pageNumber + " of book having title " + activeBook.getTitle());
        refreshPage();
    }

    public void refreshUsername() {
        System.out.println("User name " + activeUser.getName() + " is refreshed");
    }

    public void refreshTitle() {
        System.out.println("Title of the book " + activeBook.getTitle() + " refreshed");
    }

    public void refreshDetails() {
        System.out.println("Details of the book " + activeBook.getTitle() + " refreshed");
    }

    public void refreshPage() {
        System.out.println("Page no " + pageNumber + " refreshed");
    }

    public void showReadingProgress() {
        int totalPages = 100;  
        double progress = (double) pageNumber / totalPages * 100;
        System.out.println("Reading progress: " + progress + "%");
    }
}
