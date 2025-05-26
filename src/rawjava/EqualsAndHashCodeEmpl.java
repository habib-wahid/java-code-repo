package rawjava;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

class Book {
    String title;
    public Book(String title) {
        this.title = title;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;

        if (obj == null || getClass() != obj.getClass())
            return false;

        Book book = (Book) obj;

        return this.title.equals(book.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title);
    }
}

public class EqualsAndHashCodeEmpl {

    public static void main(String[] args) {
        Set<Book> books = new HashSet<>();
        System.out.println(new Book("Book 1").getClass());
        books.add(new Book("Java Programming"));
        books.add(new Book("Java Programming"));
        System.out.println(books.size());
    }
}
