package au.id.swalladge.quiz_android;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class QuizQuestion extends AppCompatActivity {
    Integer questionNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_question);

        Bundle data = this.getIntent().getExtras();
        displayQuestion(data.getInt("questionNumber"));

    }

    /**
     * displays the question for the question number
     * @param n
     */
    private void displayQuestion(Integer n) {
        questionNumber = n;
        TextView t = (TextView) findViewById(R.id.questionNumber);
        t.setText(String.format(getString(R.string.questionNumber), n.toString()));

        // TODO
        // get the question info from the database
        // populate the radio boxes
        // disable/enable buttons depending on whether at first or last question
    }

    /**
     * saves the selected answer to the question number given
     * @param n
     */
    private void saveAnswer(Integer n) {
        // TODO
        // save to database somewhere
    }

    /**
     * save the answer and navigate to the previous question
     * @param view
     */
    public void previous(View view) {
        saveAnswer(questionNumber);
        displayQuestion(questionNumber-1);
    }

    /**
     * save the answer and navigate to the next question
     * @param view
     */
    public void next(View view) {
        saveAnswer(questionNumber);
        displayQuestion(questionNumber+1);
    }

    /**
     * submit the quiz for marking
     * @param view
     */
    public void submit(View view) {
        // TODO
        // ask for confirmation (dialog popup)
        // tally results
        // switch to results activity
    }
}
