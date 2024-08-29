package br.ufc.quixada.aula290824firebase;

import android.os.Bundle;
import android.util.Log;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import br.ufc.quixada.aula290824firebase.models.Usuario;

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
        FirebaseDatabase fbDatabase = FirebaseDatabase.getInstance();
        DatabaseReference dbAulaRef = fbDatabase.getReference();
        List<Usuario> usuarios = new ArrayList<>();
        dbAulaRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot statusSnapshot: snapshot.child("usuarios").getChildren()) {
                    Usuario usuario = statusSnapshot.getValue(Usuario.class);
                    Log.d("aula-app", String.valueOf(Integer.parseInt(Objects.requireNonNull(statusSnapshot.getKey()))));
                    if (Integer.parseInt(Objects.requireNonNull(statusSnapshot.getKey())) > usuarios.size()) {
                        usuarios.add(usuario);
                        return;
                    }
                    usuarios.set(Integer.parseInt(Objects.requireNonNull(statusSnapshot.getKey())),usuario);
                }
                StringBuilder textoDoLog = new StringBuilder("{\"usuarios\":[");
                for ( Usuario usuario: usuarios) {
                    textoDoLog.append("{\"nome\":\"").append(usuario.getNome()).append("\",\"email\":\"").append(usuario.getEmail()).append("\"},");
                }
                textoDoLog.append("]}");
               Log.d("aula-app", textoDoLog.toString().replace(",]","]"));
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Log.d("aula-app", "Erro ao ler database:" + error.getMessage());
            }
        });

    }
}