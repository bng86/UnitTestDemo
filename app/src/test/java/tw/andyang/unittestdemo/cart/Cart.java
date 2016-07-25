package tw.andyang.unittestdemo.cart;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Cart {

    private List<Book> books;

    public float getPrice() {

        float amount = 0.0f;

        Set<Book> bookSet = new HashSet<>();
        while (books.size() != 0) {
            bookSet.addAll(books);
            amount += bookSet.size() * 100 * getDiscount(bookSet.size());

            for (Book book : bookSet) {
                books.remove(book);
            }

            bookSet.clear();
        }

        return amount;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    private float getDiscount(int size) {

        switch (size) {
            case 2:
                return 0.95f;
            case 3:
                return 0.9f;
            case 4:
                return 0.8f;
            case 5:
                return 0.75f;
            default:
                return 1.0f;
        }
    }
}
