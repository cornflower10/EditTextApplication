package com.example.cornflower.edittextapplication;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.v7.widget.AppCompatEditText;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;

/**
 * Created by xiejingbao on 2015/12/4.
 */
public class LimitEditText extends AppCompatEditText implements TextWatcher{

    private int mCount;//字节数

    public LimitEditText(Context context) {
        this(context, null);
    }

    public LimitEditText(Context context, AttributeSet attrs) {
        this(context, attrs, android.support.v7.appcompat.R.attr.editTextStyle);
    }

    public LimitEditText(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        TypedArray typedArray = context.obtainStyledAttributes(attrs,R.styleable.LimitEditText);

        mCount = typedArray.getInteger(R.styleable.LimitEditText_text_count,-1);
        typedArray.recycle();

        /**
         * 如果不加这个监听afterTextChanged，beforeTextChanged方法不起作用
         */
        addTextChangedListener(this);
    }


    @Override
    public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
    }

    @Override
    public void onTextChanged(CharSequence text, int start, int lengthBefore, int lengthAfter) {

    }

    @Override
    public void afterTextChanged(Editable editable) {
        if(mCount<=0){
            return;
        }
        if(null!=editable&&editable.length()>0){
            String text =  editable.toString();
            int count = text.getBytes().length;
            setSelection(text.length());
            if(count>mCount){
                int index = getSelectionStart();
                editable.delete(index-1, index);
            }
        }

    }

}
