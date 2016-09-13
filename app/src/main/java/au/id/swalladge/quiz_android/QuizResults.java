package au.id.swalladge.quiz_android;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.util.Objects;

public class QuizResults extends AppCompatActivity {
    public static final String PREFS_NAME = "data";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_results);

        displayResults();
    }

    protected void displayResults() {
        SharedPreferences settings = getSharedPreferences(PREFS_NAME, 0);
        Resources res = getResources();


        TypedArray questions = res.obtainTypedArray(R.array.questions);

        double total = questions.length();
        double score = 0;

        // iterate over questions and process each
        for (int i=0; i<total; ++i) {
            String answered = settings.getString(String.format("q%d", i+1),"opt0");
            String[] question = res.getStringArray(questions.getResourceId(i, -1));

            // TODO: add to UI
            if (Objects.equals(question[5], answered)) {
                // add to score if correct
                ++score;
            } else {
                // don't add to score
            }
        }

        // convert to percent score
        score = (score/total) * 100;

        // display the score in the title
        TextView t = (TextView) findViewById(R.id.resultsTitle);
        t.setText(String.format(getString(R.string.resultsTitle), score ));

        // save the score
        if (score > settings.getFloat("highscore", 0)) {
            // TODO: new highscore message in UI
            SharedPreferences.Editor editor = settings.edit();
            editor.putFloat("highscore", (float) score);
            editor.apply();
        } else {
            // TODO: no new highscore message in UI?
        }

    }

    /**
     * override back button to go directly back to main activity
     * (don't want ability to just jump back to the previous question)
     */
    @Override
    public void onBackPressed() {
        backToMenu(null);
    }

    /**
     * return to the main screen
     * @param view
     */
    public void backToMenu(View view) {
        Intent main = new Intent(this, MainActivity.class);
        startActivity(main);
    }
}
