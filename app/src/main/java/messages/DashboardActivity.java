package messages;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageButton;

import com.improve10x.crud.R;
import com.improve10x.crud.templates.SeriesListActivity;
import com.improve10x.crud.templates.TemplatesActivity;

public class DashboardActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        getSupportActionBar().setTitle("Dashboard");
        ImageButton imageBtn = findViewById(R.id.image_btn);
        imageBtn.setOnClickListener(view -> {
            Intent intent = new Intent(this, MessagesActivity.class);
            startActivity(intent);
        });

        ImageButton templateImageBtn = findViewById(R.id.template_image_btn);
        templateImageBtn.setOnClickListener(view -> {
            Intent intent = new Intent(this, TemplatesActivity.class);
            startActivity(intent);
        });

        ImageButton seriesImageBtn = findViewById(R.id.series_image_btn);
        seriesImageBtn.setOnClickListener(view -> {
            Intent intent = new Intent(this, SeriesListActivity.class);
            startActivity(intent);
        });
    }
}