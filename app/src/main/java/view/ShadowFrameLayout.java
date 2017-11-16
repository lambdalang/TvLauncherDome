package view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.support.annotation.AttrRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.FrameLayout;

import com.tvlauncherdome.R;


/**
 * Created by surge on 2017/11/16.
 */

public class ShadowFrameLayout extends FrameLayout {
    private Rect mBound;
    private Drawable mDrawable;
    private Rect mRect;

    public ShadowFrameLayout(@NonNull Context context) {
        super(context);
        init(context);
    }

    public ShadowFrameLayout(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public ShadowFrameLayout(@NonNull Context context, @Nullable AttributeSet attrs, @AttrRes int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    private void init(Context context) {
        //设置为false保证子view可超出父控件
        setClipChildren(false);
        setClipToPadding(false);
        mRect = new Rect();
        mBound = new Rect();
        //设置选中card的背景图片
        mDrawable = getResources().getDrawable(R.drawable.live_screen_focus_brething);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    @Override
    protected void dispatchDraw(Canvas canvas) {
        //当前view获取到焦点后放大画布
        if (hasFocus()) {
            Log.e("myframe", "HomeItemContainer focus : true ");
            super.getDrawingRect(mRect);
            //将获取到的原始Rect放大相应的尺寸
            mBound.set(-16 + mRect.left, -16 + mRect.top, 16 + mRect.right, 16 + mRect.bottom);
            mDrawable.setBounds(mBound);
            canvas.save();
            //放大后的Rect重新draw到画布canvas上
            mDrawable.draw(canvas);
            canvas.restore();
        } else {
            Log.e("myframe", "HomeItemContainer focus : felse ");
        }
        super.dispatchDraw(canvas);

    }
//    ViewGroup不会主动执行，需动态设置background后才会执行
//    @Override
//    protected void onDraw(Canvas canvas) {
//        if (hasFocus()) {
//            Log.e("myframe","HomeItemContainer focus : true ");
//            super.getDrawingRect(mRect);
//            mBound.set(-25+mRect.left, -20+mRect.top, 25+mRect.right, 25+mRect.bottom);
//            mDrawable.setBounds(mBound);
//            canvas.save();
//            mDrawable.draw(canvas);
//            canvas.restore();
//        }else{
//            Log.e("myframe","HomeItemContainer focus : felse ");
//        }
//        super.onDraw(canvas);
//    }
}
