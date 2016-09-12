package au.id.swalladge.quiz_android;

import android.content.Intent;
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
