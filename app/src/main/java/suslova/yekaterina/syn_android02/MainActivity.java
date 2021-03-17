package suslova.yekaterina.syn_android02;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText editText_x; // Переменная для доступа к компоненту со значением "x"
    EditText editText_a; // Переменная для доступа к компоненту со значением "a"
    EditText editText_b; // Переменная для доступа к компоненту со значением "b"
    TextView textView_calc; // Переменная для доступа к компоненту со значением результата
    Button buttonCalc; // Переменная для доступа к компоненту кнопки

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Доступ к компонентам окна
        editText_x = findViewById(R.id.editText_x);
        editText_a = findViewById(R.id.editText_a);
        editText_b = findViewById(R.id.editText_b);
        textView_calc = findViewById(R.id.textView_calc);
        buttonCalc = findViewById(R.id.buttonCalc);

        if (savedInstanceState != null) {
            textView_calc.setText(savedInstanceState.getString("calc"));

        }
    }

    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        // Сохранение нужных нам значений компонент при перевороте экрана
        outState.putString("calc", textView_calc.getText().toString());
        }

    // МЕТОД КНОПКИ РАСЧЕТА
    public void onClick(View v) {
        // Объявление локальных переменных
        double x, a, b, y;

        try { // НАЧАЛО ЗАЩИЩЕННОГО БЛОКА

            // Чтение данных из компонент
            x = Double.parseDouble(editText_x.getText().toString().trim());
            a = Double.parseDouble(editText_a.getText().toString().trim());
            b = Double.parseDouble(editText_b.getText().toString().trim());

            // Основной алгоритм
            if (x>6) {
                y = (a/x)+(b/(x*x));
            }
            else {
                y = a*a*(x+b);
            }

            // Вывод полученного значения в компонент
            textView_calc.setText(String.valueOf(y));

        } catch (Exception e) { // ЧТО ДЕЛАТЬ ЕСЛИ ВОЗНИКНЕТ ОШИБКА В БЛОКЕ МЕЖДУ "TRY" И "CATCH":

            // Вывод сообщения об ошибке
            textView_calc.setText("Неверные входные данные для расчета!");

        }  // КОНЕЦ ЗАЩИЩЕННОГО БЛОКА

    }

}