package scorecard.project.com.scorecard;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import java.util.Random;

import static scorecard.project.com.scorecard.R.id.wickets;

public class MainActivity extends AppCompatActivity {
    int score;
    TextView run;
    TextView fallofwicket;
    int wick=0;
    int balls;
    int target_score;
    int extras;
    TextView comment;
    TextView InningExtras;
    TextView overLeft;
    TextView targetScore;

    public void addOne(View view) {

        score++;
        run.setText("Runs - " + score);
        overLeft.setText(Integer.toString(--balls));
         checkScore();

    }

    public void addTwo(View view) {

        score += 2;
        run.setText("Runs - " + score);
        overLeft.setText(Integer.toString(--balls));
         checkScore();

    }

    public void addThree(View view) {

        score += 3;
        run.setText("Runs - " + score);
        overLeft.setText(Integer.toString(--balls));
          checkScore();

    }

    public void addFour(View view) {

        score += 4;
        run.setText("Runs - " + score);
        overLeft.setText(Integer.toString(--balls));
         checkScore();

    }

    public void addSix(View view) {

        score += 6;
        run.setText("Runs - " + score);
        overLeft.setText(Integer.toString(--balls));
         checkScore();

    }

    public void wicket(View view) {
        if (wick < 10) {
            ++wick;
            fallofwicket.setText("Wickets - " + wick);
            overLeft.setText(Integer.toString(balls--));
        } else {
            comment.setText("Innings End");
            Intent i = new Intent(MainActivity.this, summary.class);
            i.putExtra("Summary", "You Lost");
            startActivity(i);
        }
    }

    public void wide(View view) {


        ++score;
        run.setText("Runs - " + score);
        ++extras;
        InningExtras.setText("Inning extras - " + extras);
        comment.setText("Wide ball");

         checkScore();

    }


    public void noBall(View View) {
        String message = "No Ball";
        comment.setText(message);
          checkScore();

    }

    public void resetScore(View view) {
        score = 0;
        balls = 300;
        wick = 0;
        extras = 0;
        run.setText("Runs - " + score);
        comment.setText("New Innings");
        overLeft.setText(Integer.toString(balls));
        fallofwicket.setText("Wickets - " + wick);
        Random random = new Random();
        target_score = random.nextInt(10) + 1;
        targetScore.setText("Target Score is " + target_score + "Runs");
    }

    public void dotBall(View view) {

        --balls;

        overLeft.setText(Integer.toString(balls));
         checkScore();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        score = 0;
        wick = 0;
        extras = 0;
        balls = 300;
        run = (TextView) findViewById(R.id.runsOnBoard);
        fallofwicket = (TextView) findViewById(wickets);
        InningExtras = (TextView) findViewById(R.id.extraScore);
        comment = (TextView) findViewById(R.id.comment);
        overLeft = (TextView) findViewById(R.id.oversLeft);
        targetScore = (TextView) findViewById(R.id.targetScore);

        //Generating some random Score to chase;
        Random random = new Random();
        target_score = random.nextInt(450) + 1;
        targetScore.setText("Target Score is " + target_score + "Runs");

    }

    public void checkScore() {
        if (target_score < score) {
            Intent i = new Intent(MainActivity.this, summary.class);
            i.putExtra("Summary", "You Won");
            startActivity(i);
        }


    }
}

