package tw.andyang.unittestdemo.livedemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import tw.andyang.unittestdemo.R;

public class LiveDemoActivity extends AppCompatActivity {
    private List<Book> books = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String[] number = new String[]{"0", "1", "2", "3", "4", "5"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_dropdown_item_1line, number);

        final Spinner spinnerI = (Spinner) findViewById(R.id.spinnerI);
        spinnerI.setAdapter(adapter);

        final Spinner spinnerII = (Spinner) findViewById(R.id.spinnerII);
        spinnerII.setAdapter(adapter);

        final Spinner spinnerIII = (Spinner) findViewById(R.id.spinnerIII);
        spinnerIII.setAdapter(adapter);

        final Spinner spinnerIIIV = (Spinner) findViewById(R.id.spinnerIV);
        spinnerIIIV.setAdapter(adapter);

        final Spinner spinnerV = (Spinner) findViewById(R.id.spinnerV);
        spinnerV.setAdapter(adapter);

        Button button = (Button) findViewById(R.id.btnCalculate);
        final TextView textPrice = (TextView) findViewById(R.id.textPrice);

        if (button != null) {
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    books.clear();

                    int book1Size = spinnerI.getSelectedItemPosition();
                    addBooks("Book1", book1Size);

                    int book2Size = spinnerII.getSelectedItemPosition();
                    addBooks("Book2", book2Size);

                    int book3Size = spinnerIII.getSelectedItemPosition();
                    addBooks("Book3", book3Size);

                    int book4Size = spinnerIIIV.getSelectedItemPosition();
                    addBooks("Book4", book4Size);

                    int book5Size = spinnerV.getSelectedItemPosition();
                    addBooks("Book5", book5Size);

                    float amount = 0.0f;

                    Set<Book> bookSet = new HashSet<>();

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

                    textPrice.setText(getString(R.string.price, (int) amount));
                }
            });
        }

    }

    private void addBooks(String bookName, int size) {
        for (int i = 0; i < size; i++) {
            books.add(new Book(bookName));
        }
    }

    class Book {
        private String name;

        public Book(String name) {
            this.name = name;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Book book = (Book) o;

            return name != null ? name.equals(book.name) : book.name == null;

        }

        @Override
        public int hashCode() {
            return name != null ? name.hashCode() : 0;
        }
    }
}
