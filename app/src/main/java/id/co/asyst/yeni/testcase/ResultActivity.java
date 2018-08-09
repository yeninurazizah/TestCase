package id.co.asyst.yeni.testcase;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import id.co.asyst.yeni.testcase.utility.Constant;

public class ResultActivity extends AppCompatActivity implements View.OnClickListener {

    TextView winnerTeamTV, scoreWinnerTV;
    Button backButton;
    String winnerStr;
    int scoreStr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        winnerTeamTV = findViewById(R.id.winner_team_textview);
        scoreWinnerTV = findViewById(R.id.winner_team_score_textview);
        backButton = findViewById(R.id.back_button);

        backButton.setOnClickListener(this);

        if (getIntent().getExtras() != null) {

            if (getIntent().getExtras() != null) {
                winnerStr = getIntent().getExtras().getString(Constant.KEY_WINNER_TEAM);
                scoreStr = getIntent().getExtras().getInt(Constant.KEY_WINNER_SCORE);
            }
            winnerTeamTV.setText(winnerStr);
            scoreWinnerTV.setText(scoreStr + "");
        }


    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.back_button:

                Intent intent = new Intent(this, MainActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);

                break;
        }
    }
}

/*
if (getIntent().getExtras()!= null){
        Bundle bundle = getIntent().getExtras();
        winnerTeamTV.setText(bundle.getString(Constant.KEY_WINNER_TEAM, ""));
        scoreWinnerTV.setText(bundle.getString(Constant.KEY_WINNER_SCORE, ""));
        }*/
