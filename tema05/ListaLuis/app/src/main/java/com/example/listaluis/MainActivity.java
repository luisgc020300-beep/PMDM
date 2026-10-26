package com.example.listaluis;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        ArrayList<Coche> coches = new ArrayList<>();
        coches.add(new Coche("Golf", "Volkswagen", R.drawable.coche));
        coches.add(new Coche("Model 3", "Tesla", R.drawable.electrico));
        coches.add(new Coche("Transit", "Ford", R.drawable.furgoneta));
        coches.add(new Coche("Prius", "Toyota", R.drawable.taxi));
        coches.add(new Coche("León", "SEAT", R.drawable.coche));
        coches.add(new Coche("Leaf", "Nissan", R.drawable.electrico));
        coches.add(new Coche("Sprinter", "Mercedes-Benz", R.drawable.furgoneta));
        coches.add(new Coche("Octavia", "Skoda", R.drawable.taxi));

        RecyclerView rvLista = findViewById(R.id.rvLista);
        rvLista.setLayoutManager(new LinearLayoutManager(this));
        rvLista.setAdapter(new AdaptadorCoches(coches));
    }
}