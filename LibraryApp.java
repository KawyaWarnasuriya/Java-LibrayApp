import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Book {
    private int id;
    private String title;
    private String author;
    private String category;

    public Book(int id, String title, String author, String category) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.category = category;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getCategory() {
        return category;
    }

    @Override
    public String toString() {
        return "Book ID: " + id + ", Title: " + title + ", Author: " + author + ", Category: " + category;
    }
}

class Member {
    private String id;
    private String name;
    private Book borrowedBook;

    public Member(String id, String name) {
        this.id = id;
        this.name = name;
        this.borrowedBook = null;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public boolean borrowBook(Book book) {
        if (this.borrowedBook == null) {
            this.borrowedBook = book;
            return true;
        }
        return false;
    }

    public boolean returnBook(int bookID) {
        if (this.borrowedBook != null && this.borrowedBook.getId() == bookID) {
            this.borrowedBook = null;
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "Member ID: " + id + ", Name: " + name + (borrowedBook != null ? ", Borrowed Book: " + borrowedBook.getTitle() : ", No Book Borrowed");
    }
}

class Library {
    private List<Book> books;
    private List<Member> members;

    public Library() {
        books = new ArrayList<>();
        members = new ArrayList<>();
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public void addMember(Member member) {
        members.add(member);
    }

    public void displayAllBooks() {
        if (books.isEmpty()) {
            System.out.println("No books available.");
            return;
        }
        System.out.println("Books in Library:");
        for (Book book : books) {
            System.out.println(book);
        }
    }

    public void displayBooksByCategory(String category) {
        boolean found = false;
        for (Book book : books) {
            if (book.getCategory().equalsIgnoreCase(category)) {
                System.out.println(book);
                found = true;
            }
        }
        if (!found) {
            System.out.println("No books found in category: " + category);
        }
    }

    public void displayAllMembers() {
        if (members.isEmpty()) {
            System.out.println("No members available.");
            return;
        }
        System.out.println("Library Members:");
        for (Member member : members) {
            System.out.println(member);
        }
    }

    public void borrowBook(int bookID, String memberID) {
        Book bookToBorrow = null;
        for (Book book : books) {
            if (book.getId() == bookID) {
                bookToBorrow = book;
                break;
            }
        }

        if (bookToBorrow == null) {
            System.out.println("Book ID " + bookID + " not found.");
            return;
        }

        for (Member member : members) {
            if (member.getId().equals(memberID)) {
                if (member.borrowBook(bookToBorrow)) {
                    System.out.println("Book '" + bookToBorrow.getTitle() + "' borrowed by " + member.getName());
                } else {
                    System.out.println("Member has already borrowed a book.");
                }
                return;
            }
        }

        System.out.println("Member ID " + memberID + " not found.");
    }

    public void returnBook(int bookID) {
        for (Member member : members) {
            if (member.returnBook(bookID)) {
                System.out.println("Book ID " + bookID + " has been returned.");
                return;
            }
        }
        System.out.println("No member found with this borrowed book ID.");
    }
}

public class LibraryApp {
    public static void main(String[] args) {
        Library library = new Library();
        Scanner scanner = new Scanner(System.in);

        // Adding sample books
        library.addBook(new Book(1, "Madol Duuwa", "Martin Wickramasinghe", "Novels"));
        library.addBook(new Book(2, "Tharuu", "Sujeewa Prasannarachchi", "Novels"));
        library.addBook(new Book(3, "Sen Kottan", "Mahinda Prasad Masibula", "Novels"));
        library.addBook(new Book(4, "Diyamanthi Otunna", "Sherlock Holmes", "Detective-Stories"));
        library.addBook(new Book(5, "Mara Ugula", "Sherlock Holmes", "Detective-Stories"));
		library.addBook(new Book(6, "Rusiyanu Oththukaraya", "Sharlok Homes", "Detective-stories"));
        library.addBook(new Book(7, "Mara Ugula", "Sharlok Homes", "Detective-stories"));
		library.addBook(new Book(8, "Ran Dewagana", "Sharlok Homes", "Detective-stories"));
		library.addBook(new Book(9, "Bihisunu Nimnaya", "Sharlok Homes", "Detective-stories"));
		
		library.addBook(new Book(10, "O/L Pass Paper Book - Science (2018-2024)", "Master Gride", "Past-Paper"));
		library.addBook(new Book(11, "O/L Pass Paper Book - Maths (2018-2024)", "Master Gride", "Past-Paper"));
		library.addBook(new Book(12, "O/L Pass Paper Book - Sinhala (2018-2024)", "Master Gride", "Past-Paper"));
		library.addBook(new Book(13, "O/L Pass Paper Book - History (2018-2024)", "Master Gride", "Past-Paper"));
		library.addBook(new Book(14, "O/L Pass Paper Book - English (2018-2024)", "Master Gride", "Past-Paper"));
		library.addBook(new Book(15, "O/L Pass Paper Book - Commerces (2018-2024)", "Master Gride", "Past-Paper"));
		library.addBook(new Book(16, "O/L Pass Paper Book - IT (2018-2024)", "Master Gride", "Past-Paper"));
		
		library.addBook(new Book(17, "Hath pana", "Kumarathunga Munidasa", "Children's-Book"));
		library.addBook(new Book(18, "Magul Kema", "Kumarathunga Munidasa", "Children's-Book"));
		library.addBook(new Book(19, "Aba Yaluwo", "T.B. Ilangarathna", "Children's-Book"));
		library.addBook(new Book(20, "Hapana", "T.B.Ilangarathna", "Children's-Book"));
		
		library.addBook(new Book(21, "Mahawanshaya", "Buddhist Cultural Center", "Historical-Book"));
		library.addBook(new Book(22, "Rajawaliya", "A.V.Suraweera", "Historical-Book"));
		library.addBook(new Book(23, "Nuwara Yugaye Sinhala Bawa", "Michecl Robat", "Historical-Book"));
		
		

        // Adding sample members
        library.addMember(new Member("M001", "Kawya Warnasuriya"));
        library.addMember(new Member("M002", "Sandeepani Warnasuriya"));
		library.addMember(new Member("M003", "Dew Pramodi"));
		library.addMember(new Member("M004", "Dilini Dissanyaka"));
		library.addMember(new Member("M005", "Duminda Warnasuriya"));
		library.addMember(new Member("M006", "Nethu Senadeera"));
		library.addMember(new Member("M007", "Nisal Gajadeera"));
		library.addMember(new Member("M008", "Dushen Senanayka"));
		library.addMember(new Member("M009", "Dinith Perera"));

        while (true) {
            System.out.println("\nLibrary Management System");
            System.out.println("1. Display all books");
            System.out.println("2. Display books by category");
            System.out.println("3. Display all members");
            System.out.println("4. Borrow a book");
            System.out.println("5. Return a book");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    library.displayAllBooks();
                    break;
                case 2:
                    System.out.print("Enter category(e.g: Novels, Detective-Stories, Historical-Book,Past-Paper,Children's-Book) :");
                    scanner.nextLine(); // Consume newline
                    String category = scanner.nextLine();
                    library.displayBooksByCategory(category);
                    break;
                case 3:
                    library.displayAllMembers();
                    break;
                case 4:
                    System.out.print("Enter Member ID: ");
                    String memberID = scanner.next();
                    System.out.print("Enter Book ID: ");
                    int bookID = scanner.nextInt();
                    library.borrowBook(bookID, memberID);
                    break;
                case 5:
                    System.out.print("Enter Book ID to return: ");
                    int returnBookID = scanner.nextInt();
                    library.returnBook(returnBookID);
                    break;
                case 6:
                    System.out.println("Exiting the Library Management System.");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
