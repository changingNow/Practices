package view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.media.AudioManager;
import android.media.SoundPool;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.LinearLayout;


import com.example.onyx_lw.flipdotview.R;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

/**
 * Created by Onyx-lw on 2016/10/17.
 */

public class FileDotView extends LinearLayout {


    Context mContext;
    private float mDotSize;
    private float mDotPadding;
    private int mWidthNum;
    private int mHeightNum;
    private boolean mSoundOn;
    private Drawable mDot;
    private Drawable mDotBack;

    List<List<Integer>> oldList = new ArrayList<>();
    SoundPool soundPool = new SoundPool(40, AudioManager.STREAM_MUSIC, 0);

    public FileDotView(Context context) {
        super(context);
    }

    public FileDotView(Context context, AttributeSet attrs) {
        super(context, attrs);
        setOrientation(LinearLayout.VERTICAL);//设置方向
        mContext = context;
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.FilpDot);//得到自定义属性的一个数组

        mDotSize = typedArray.getDimensionPixelSize(R.styleable.FilpDot_dotSize, 50);
        mDotPadding = typedArray.getDimensionPixelSize(R.styleable.FilpDot_dotPadding, 10);
        mWidthNum = typedArray.getInteger(R.styleable.FilpDot_widthNum, 10);
        mHeightNum = typedArray.getInteger(R.styleable.FilpDot_geightNum, 10);
        mSoundOn = typedArray.getBoolean(R.styleable.FilpDot_soundOn, true);
        mDot = typedArray.getDrawable(R.styleable.FilpDot_dotDrawable);
        mDotBack = typedArray.getDrawable(R.styleable.FilpDot_dotBackDrawable);

        typedArray.recycle();

        initStatus();
        initViews(context, attrs);
        initSound();
    }

    private void initSound() {
//        soundPoolMap.put(0, soundPool.load(mContext, R.raw.click_0, 1));
//        soundPoolMap.put(1, soundPool.load(mContext, R.raw.click_1, 2));
//        soundPoolMap.put(2, soundPool.load(mContext, R.raw.click_2, 3));
        //shui jiao
        //
    }

    private void initStatus() {
        oldList.clear();
        List<Integer> subList = new ArrayList<>();
        subList.clear();
        for (int j = 0; j < mWidthNum; j++) {
            subList.add(1);
        }
        oldList.add(subList);
    }

    private void initViews(Context context, AttributeSet attrs) {
        for (int i = 0; i < mHeightNum; i++) {
            LinearLayout ll = new LinearLayout(context);
            //ll.setOrientation(LinearLayout.HORIZONTAL);
            LayoutParams llParam = new LayoutParams((int) (mWidthNum * mDotSize), (int) mDotSize);
            ll.setLayoutParams(llParam);

            for (int j = 0; j < mWidthNum; j++) {
                ImageView iv = new ImageView(context);
                LayoutParams ivParam = new LayoutParams(
                        Math.round(mDotSize),
                        Math.round(mDotSize));
                iv.setLayoutParams(ivParam);
                int padding = (int) mDotPadding;
                iv.setPadding(padding, padding, padding, padding);
                iv.setImageDrawable(mDot);
                ll.addView(iv);
            }
            addView(ll);
        }
    }


}
