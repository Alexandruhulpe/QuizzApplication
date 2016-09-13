package au.id.swalladge.quiz_android;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.util.Objects;

public class QuizQuestion extends Activity {
    int questionNumber;
    public static final String PREFS_NAME = "data";

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
    private void displayQuestion(int n) {
        questionNumber = n;

        // disable/enable buttons
        if (n == Integer.parseInt(getString(R.string.totalQuestions))) {
            ((Button) findViewById(R.id.nextBtn)).setEnabled(false);
        } else {
            ((Button) findViewById(R.id.nextBtn)).setEnabled(true);
        }
        if (n == 1) {
            ((Button) findViewById(R.id.previousBtn)).setEnabled(false);
        } else {
            ((Button) findViewById(R.id.previousBtn)).setEnabled(true);
        }

        // show the question number
        TextView t = (TextView) findViewById(R.id.questionNumber);
        t.setText(String.format(getString(R.string.questionNumber), n, getString(R.string.totalQuestions)));

        String q = String.format("q%d%%s",n);
        String questionID = String.format("q%d", n);
        String question = getString(getResources().getIdentifier(String.format(q,""),"string", this.getPackageName()));
        ((TextView) findViewById(R.id.qDescription)).setText(question);


        // select the don't know option by default
        ((RadioButton) findViewById(R.id.opt0)).setChecked(true);

        // TODO: use string array in resources to optimize this
        for (int i=1; i<5; ++i) {
            String optID = String.format("opt%d", i);
            String rID = String.format(q, optID);
            RadioButton r = (RadioButton) findViewById(getResources().getIdentifier(optID, "id", this.getPackageName()));
            r.setText(getResources().getIdentifier(rID, "string", this.getPackageName()));
            r.setChecked(false);

        }
        SharedPreferences settings = getSharedPreferences(PREFS_NAME, 0);
        RadioButton r = (RadioButton) findViewById(getResources().getIdentifier(settings.getString(questionID, "opt0"), "id", this.getPackageName()));
        r.setChecked(true);
    }

    /**
     * saves the selected answer to the question number given
     * @param n
     */
    private void saveAnswer(int n) {
        SharedPreferences settings = getSharedPreferences(PREFS_NAME, 0);
        SharedPreferences.Editor editor = settings.edit();
        RadioGroup r = (RadioGroup) findViewById(R.id.options);
        editor.putString(String.format("q%d",n), getResources().getResourceEntryName(r.getCheckedRadioButtonId()));
        editor.commit();
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
        // must save the current answer first!
        saveAnswer(questionNumber);

        // TODO: ask for confirmation (dialog popup)

        // switch to the results activity (that also handles score tally and highscores)
        Intent results = new Intent(this, QuizResults.class);
        startActivity(results);
    }

    /**
     * return to the main screen
     * @param view
     */
    public void backToMenu(View view) {
        finish();
    }
}
