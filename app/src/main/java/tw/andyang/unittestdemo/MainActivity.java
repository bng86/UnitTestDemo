package tw.andyang.unittestdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private final ShoppingCart shoppingCart = new ShoppingCart();

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

                    shoppingCart.books.clear();

                    int book1Size = spinnerI.getSelectedItemPosition();
                    shoppingCart.addBooks("Book1", book1Size);

                    int book2Size = spinnerII.getSelectedItemPosition();
                    shoppingCart.addBooks("Book2", book2Size);

                    int book3Size = spinnerIII.getSelectedItemPosition();
                    shoppingCart.addBooks("Book3", book3Size);

                    int book4Size = spinnerIIIV.getSelectedItemPosition();
                    shoppingCart.addBooks("Book4", book4Size);

                    int book5Size = spinnerV.getSelectedItemPosition();
                    shoppingCart.addBooks("Book5", book5Size);

                    float amount = shoppingCart.getAmount();

                    textPrice.setText(getString(R.string.price, (int) amount));
                }
            });
        }

    }
}
