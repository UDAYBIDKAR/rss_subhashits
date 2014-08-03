package com.rss.subhashit;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;

public class MainActivity extends Activity {
	private TextView mSubhashitView;
	private int mCurrentSubhashit;
	private String[] mSubhashits;
	private View mPrevButton;
	private View mNextButton;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        mSubhashits = getResources().getStringArray(R.array.subhashit);
        mSubhashitView = (TextView)findViewById(R.id.text_subhashit);
        mSubhashitView.setText(mSubhashits[0]);
        mPrevButton = findViewById(R.id.button_prev);  
        mPrevButton.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				mCurrentSubhashit--;
				mSubhashitView.setText(mSubhashits[mCurrentSubhashit]);
				mNextButton.setEnabled(true);
				if(mCurrentSubhashit-1 < 0){
					mPrevButton.setEnabled(false);
				}
			}
		});
        mPrevButton.setEnabled(false);
        mNextButton = findViewById(R.id.button_next);
        mNextButton.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				mCurrentSubhashit++;
				mSubhashitView.setText(mSubhashits[mCurrentSubhashit]);
				mPrevButton.setEnabled(true);
				if(mCurrentSubhashit+1 >= mSubhashits.length){
					mNextButton.setEnabled(false);	
				}
			}
		});
    }
}
