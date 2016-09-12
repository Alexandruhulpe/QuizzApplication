package au.id.swalladge.quiz_android;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

// main activity is where most of the stuff is
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    /**
     * resets any saved answers
     * @param view
     */
    public void resetAnswers(View view) {
        // TODO
        // connect to database/wherever answers are saved
        // and reset to default
    }

    /**
     * runs the quiz! should go straight to first question page
     * @param view
     */
    public void takeQuiz(View view) {
        // TODO
        // run the quiz question activity
    }
}
