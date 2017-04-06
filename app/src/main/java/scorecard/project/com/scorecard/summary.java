package scorecard.project.com.scorecard;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

public class summary extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_summary);
        Intent i=getIntent();
        String result=i.getStringExtra("Summary");
        Log.i("result",result);
        TextView textView=(TextView)findViewById(R.id.summary);
        textView.setText(result);
    }
}
