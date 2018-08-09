package id.co.asyst.yeni.testcase.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import id.co.asyst.yeni.testcase.R;
import id.co.asyst.yeni.testcase.utility.Constant;


public class MatchFragment extends Fragment implements View.OnClickListener {

    Button nextBtn;
    Button plusOneTeamABtn, plusTwoTeamABtn, plusThreeTeamABtn;
    Button plusOneTeamBBtn, plusTwoTeamBBtn, plusThreeTeamBBtn;
    TextView quarterTV, timATV, timBTV, scoreTeamATV, scoreTeamBTV;
    // TODO: Rename and change types of parameters
    private String timAName;
    private String timBName;
    private int quarter;
    private int scoreTeamA;
    private int scoreTeamB;
    private OnButtonNextClickedListener mListener;

    public MatchFragment() {
        // Required empty public constructor
    }


    // TODO: Rename and change types and number of parameters
    public static MatchFragment newInstance(String timA, String timB, int quarter, int scoreTeamA, int scoreTeamB) {
        MatchFragment fragment = new MatchFragment();
        Bundle args = new Bundle();
        args.putString(Constant.KEY_TEAM_A_NAME, timA);
        args.putString(Constant.KEY_TEAM_B_NAME, timB);
        args.putInt(Constant.KEY_QUARTER, quarter);
        args.putInt(Constant.KEY_SCORE_TEAM_A, scoreTeamA);
        args.putInt(Constant.KEY_SCORE_TEAM_B, scoreTeamB);

        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            timAName = getArguments().getString(Constant.KEY_TEAM_A_NAME);
            timBName = getArguments().getString(Constant.KEY_TEAM_B_NAME);
            quarter = getArguments().getInt(Constant.KEY_QUARTER);
            scoreTeamA = getArguments().getInt(Constant.KEY_SCORE_TEAM_A);
            scoreTeamB = getArguments().getInt(Constant.KEY_SCORE_TEAM_B);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_match, container, false);

        nextBtn = view.findViewById(R.id.next_button);
        plusOneTeamABtn = view.findViewById(R.id.plus_one_team_a_button);
        plusTwoTeamABtn = view.findViewById(R.id.plus_two_team_a_button);
        plusThreeTeamABtn = view.findViewById(R.id.plus_three_team_a_button);
        plusOneTeamBBtn = view.findViewById(R.id.plus_one_team_b_button);
        plusTwoTeamBBtn = view.findViewById(R.id.plus_two_team_b_button);
        plusThreeTeamBBtn = view.findViewById(R.id.plus_three_team_b_button);

        quarterTV = view.findViewById(R.id.quarter_textview);
        timATV = view.findViewById(R.id.tim_a_textview);
        timBTV = view.findViewById(R.id.tim_b_textview);
        scoreTeamATV = view.findViewById(R.id.team_a_score_textview);
        scoreTeamBTV = view.findViewById(R.id.team_b_score_textview);

        nextBtn.setOnClickListener(this);
        plusOneTeamABtn.setOnClickListener(this);
        plusTwoTeamABtn.setOnClickListener(this);
        plusThreeTeamABtn.setOnClickListener(this);
        plusOneTeamBBtn.setOnClickListener(this);
        plusTwoTeamBBtn.setOnClickListener(this);
        plusThreeTeamBBtn.setOnClickListener(this);

        switch (quarter) {
            case 1:
                quarterTV.setText("1st");
                break;
            case 2:
                quarterTV.setText("2nd");
                break;
            case 3:
                quarterTV.setText("3rd");
                break;
            case 4:
                quarterTV.setText("4th");
                break;
        }
        timATV.setText(timAName);
        timBTV.setText(timBName);

        scoreTeamATV.setText(scoreTeamA + "");
        scoreTeamBTV.setText(scoreTeamB + "");

        return view;

    }

    // TODO: Rename method, update argument and hook method into UI event
    /*public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onButtonNextClicked(0,0);
        }
    }*/

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnButtonNextClickedListener) {
            mListener = (OnButtonNextClickedListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnButtonNextClickedListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.plus_one_team_a_button:
                scoreTeamA += 1;
                break;

            case R.id.plus_two_team_a_button:
                scoreTeamA += 2;
                break;

            case R.id.plus_three_team_a_button:
                scoreTeamA += 3;
                break;

            case R.id.plus_one_team_b_button:
                scoreTeamB += 1;
                break;

            case R.id.plus_two_team_b_button:
                scoreTeamB += 2;
                break;

            case R.id.plus_three_team_b_button:
                scoreTeamB += 3;
                break;

            case R.id.next_button:
                mListener.onButtonNextClicked(scoreTeamA, scoreTeamB);
                getActivity().getSupportFragmentManager().popBackStack();
                break;

        }
        scoreTeamATV.setText(scoreTeamA + "");
        scoreTeamBTV.setText(scoreTeamB + "");

    }


    public interface OnButtonNextClickedListener {
        void onButtonNextClicked(int scoreTeamA, int scoreTeamB);
    }
}
