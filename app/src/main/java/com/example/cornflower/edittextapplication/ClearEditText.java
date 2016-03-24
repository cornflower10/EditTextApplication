package com.example.cornflower.edittextapplication;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.AppCompatEditText;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by xiejingbao on 2016/3/23.
 */
public class ClearEditText extends AppCompatEditText implements View.OnFocusChangeListener{

    private Drawable mDrawable;

    public ClearEditText(Context context) {
        this(context,null);
    }

    public ClearEditText(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public ClearEditText(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);


        init(context);
    }

    private void init(Context context) {
     Drawable [] drawable =  getCompoundDrawables();
        if(drawable[2]==null){
            mDrawable = getResources().getDrawable(R.mipmap.ic_clear);
        }else
            mDrawable = drawable[2];

        setCompoundDrawable(mDrawable);

        setClearIconVisible(false);

    }

    public void setCompoundDrawable(Drawable drawable){
        setCompoundDrawablesWithIntrinsicBounds(null,null,drawable,null);
    }


    public void setClearIconVisible(boolean b){
        if(b){
            setCompoundDrawable(mDrawable);
        }else
            setCompoundDrawable(null);

    }

    @Override
    public void onTextChanged(CharSequence text, int start, int lengthBefore, int lengthAfter) {
        super.onTextChanged(text, start, lengthBefore, lengthAfter);
        setClearIconVisible(text.length()>0);
        Log.e("text..",text.toString());
    }


    @Override
    public boolean onTouchEvent(MotionEvent event) {
          if(event.getAction()==MotionEvent.ACTION_UP){

              float x = event.getX();
              Log.e("x..",x+"");
              Log.e("x..getWidth()",getWidth()+"");
              Log.e("getWidth() - getTotal.",(getWidth() - getTotalPaddingRight())+"");
              Log.e("getWidth()-getPadding.",(getWidth()-getPaddingRight())+"");

            if(x > getWidth() - getTotalPaddingRight()
                    && x < getWidth()-getPaddingRight()){
               this.setText("");
            }

          }

        return super.onTouchEvent(event);
    }


    @Override
    public void onFocusChange(View v, boolean hasFocus) {
        if (hasFocus) {
            setClearIconVisible(getText().length() > 0);
        } else {
            setClearIconVisible(false);
        }

    }
}
