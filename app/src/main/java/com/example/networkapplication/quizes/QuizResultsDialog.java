package com.example.networkapplication.quizes;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AppCompatDialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.networkapplication.R;

public class QuizResultsDialog extends AppCompatDialogFragment {

    private TextView mCorrectCount;
    private TextView mIncorrectCount;
    private ImageView mImageView;
    private QuizResultsDialogListener mListener;

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        android.app.AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        LayoutInflater inflater = getActivity().getLayoutInflater();
        View view = inflater.inflate(R.layout.dialog_quiz_results, null);

        builder.setView(view)
                .setTitle("Results")
                .setPositiveButton("ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        mListener.finishActivity();
                    }
                });

        initUI(view);

        return builder.create();
    }

    private void initUI(View view) {
        mCorrectCount = (TextView) view.findViewById(R.id.correct_count);
        mIncorrectCount = (TextView) view.findViewById(R.id.incorrect_count);
        mImageView = (ImageView) view.findViewById(R.id.share);

        mCorrectCount.setText(getArguments().getString("correct"));
        mIncorrectCount.setText(getArguments().getString("incorrect"));

        startAnimation();
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        try {
            mListener = (QuizResultsDialogListener) context;
        } catch (ClassCastException e) {
            throw new ClassCastException(context.toString() + "must implement QuizResultsDialogListener");
        }
    }

    private void startAnimation() {
        Animation animation = AnimationUtils.loadAnimation(getActivity(), R.anim.rotate);
        mImageView.startAnimation(animation);
    }
}
