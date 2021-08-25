package com.pizzaitemslist;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import com.pizzaitemslist.Entity.Pizza;
import com.pizzaitemslist.customAdapter.PizzaItemAdapter;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private ListView lvPizzaList;
    private List<Pizza> pizzas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();
        initData();
        attachedAdapter();
    }

    private void attachedAdapter() {
        PizzaItemAdapter adapter = new PizzaItemAdapter(this,R.layout.pizza_item, pizzas);
        lvPizzaList.setAdapter(adapter);
    }

    private void initViews() {
        lvPizzaList = findViewById(R.id.lvPizzaList);
    }

    private void initData(){
        pizzas = new ArrayList<>();

        pizzas.add(new Pizza(
                "Овочева Фея",
                30,
                "https://mavrapizza.com/wp-content/uploads/vegi-feya.png",
                "Склад: Соус Песто, моцарелла, грибі, кукуруза, перец болгарский, айсберг, помидорі черри",
                700,
                89
        ));

        pizzas.add(new Pizza(
                "Качка Теріякі",
                30,
                "https://mavrapizza.com/wp-content/uploads/terijaki.png",
                "Соус Пелаті, моцарелла, качка Конфі,ананас, соус Теріякі, кунжут.",
                600,
                120
        ));

        pizzas.add(new Pizza(
                "Жульєн",
                30,
                "https://media-cdn.tripadvisor.com/media/photo-s/05/c7/f4/19/l-atelier-de-julien.jpg",
                "Куряче філе, моцарел, гриби, цибулева карамель, пармезан, вершковий соус.",
                550,
                77
        ));

        pizzas.add(new Pizza(
                "По-баварськи",
                30,
                "https://origami.lviv.ua/image/vmmcrksfcd/bavarska-small.jpg",
                "Баварські ковбаски, шинка, гриби, моцарела, огірок маринований, соус пілаті.",
                520,
                72
        ));
    }
}