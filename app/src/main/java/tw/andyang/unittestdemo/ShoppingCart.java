package tw.andyang.unittestdemo;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ShoppingCart {

    List<Book> books = new ArrayList<Book>();

    public ShoppingCart() {
    }

    float getAmount() {

        float amount = 0.0f;

        Set<Book> bookSet = new HashSet<Book>();

        while (books.size() != 0) {
            bookSet.addAll(books);

            float discount;

            switch (bookSet.size()) {
                case 2:
                    discount = 0.95f;
                    break;
                case 3:
                    discount = 0.9f;
                    break;
                case 4:
                    discount = 0.8f;
                    break;
                case 5:
                    discount = 0.75f;
                    break;
                default:
                    discount = 1.0f;
                    break;
            }

            amount += bookSet.size() * 100 * discount;

            for (Book book : bookSet) {
                books.remove(book);
            }

            bookSet.clear();
        }
        return amount;
    }

    void addBooks(String bookName, int size) {
        for (int i = 0; i < size; i++) {
            books.add(new Book(bookName));
        }
    }
}