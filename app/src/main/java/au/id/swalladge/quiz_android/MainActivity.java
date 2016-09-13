package au.id.swalladge.quiz_android;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioGroup;
import android.widget.TextView;

// main activity is where most of the stuff is
public class MainActivity extends Activity {
    public static final String PREFS_NAME = "data";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // display highscore here
        SharedPreferences settings = getSharedPreferences(PREFS_NAME, 0);
        double highscore = settings.getFloat("highscore", 0);
        String textScore = String.format(getString(R.string.highscore), highscore);
        ((TextView) findViewById(R.id.highscore)).setText(textScore);
    }

    /**
     * resets any saved answers
     * @param view
     */
    public void resetAnswers(View view) {
        SharedPreferences settings = getSharedPreferences(PREFS_NAME, 0);
        SharedPreferences.Editor editor = settings.edit();

        int total = getResources().obtainTypedArray(R.array.questions).length();
        for (int i=1; i<=total; ++i) {
            RadioGroup r = (RadioGroup) findViewById(R.id.options);
            editor.remove(String.format("q%d",i));
        }

        editor.commit();
    }

    /**
     * runs the quiz! should go straight to first question page
     * @param view
     */
    public void takeQuiz(View view) {

        // set up the data to send
        Bundle data = new Bundle();
        data.putInt("questionNumber", 1);

        // make the intent
        Intent quiz = new Intent(this, QuizQuestion.class);

        // add the data and start the activity
        quiz.putExtras(data);
        startActivity(quiz);
    }
}
