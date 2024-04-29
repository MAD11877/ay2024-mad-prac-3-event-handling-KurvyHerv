package sg.edu.np.mad.madpractical3;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Random;

public class ListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_list);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        View imageBtn = findViewById(R.id.imageBtn);
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        int random = new Random().nextInt(9999999);
        String profileName = "MAD " + random;
        imageBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                builder.setMessage("MADness")
                        .setTitle("Profile")
                        .setPositiveButton("VIEW", new DialogInterface.OnClickListener() {

                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Intent intent = (new Intent(v.getContext(), MainActivity.class));
                                intent.putExtra("profileName", profileName);
                                startActivity(intent);
                            }
                        })
                        .setNegativeButton("CLOSE", null);
                AlertDialog alert = builder.create();
                alert.show();
            }
        });
    }
}