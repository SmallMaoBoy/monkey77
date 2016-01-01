package com.monkey.my;

import android.content.Context;  
import android.util.AttributeSet;  
import android.view.GestureDetector;  
import android.view.GestureDetector.SimpleOnGestureListener;  
import android.view.MotionEvent;  
import android.view.View;  
import android.widget.ScrollView;  
  
/** 
 * @author kincai 
 *  
 * @todo �Զ���scrollview ���scrollview��viewpage ���ƻ������� 
 *  
 * @package com.kincai.store.view.custom 
 *  
 * @time 2015-6-22 ����4:49:52 
 *  
 */  
public class MyScrollView extends ScrollView {  
  
    private GestureDetector mGestureDetector;  
    View.OnTouchListener mGestureListener;  
  
    public MyScrollView(Context context) {  
        this(context, null);  
    }  
  
    public MyScrollView(Context context, AttributeSet attrs) {  
        this(context, attrs, 0);  
    }  
  
    public MyScrollView(Context context, AttributeSet attrs, int defStyle) {  
        super(context, attrs, defStyle);  
        mGestureDetector = new GestureDetector(context, new YScrollDetector());  
    }  
  
    /** 
     * �������ش����¼� 
     * һ������True�������¼��ڵ�ǰ��viewGroup�лᱻ�����������´���֮·���ضϣ������ӿؼ���û�л������Touch�¼����� 
     * ͬʱ���¼����ݸ���ǰ�Ŀؼ���onTouchEvent()��������false������¼������ӿؼ���onInterceptTouchEvent() 
     *  
     *  
     * onInterceptTouchEvent�����ǹؼ�����д�������ʹ���ScrollView��touch�¼�ʱ�������أ� 
     * ����ֻҪScrollView��touch�¼����ȴ��������ͱ�֤�˻����������� 
     */  
    @Override  
    public boolean onInterceptTouchEvent(MotionEvent ev) {  
        return super.onInterceptTouchEvent(ev)  
                && mGestureDetector.onTouchEvent(ev);  
    }  
  
    class YScrollDetector extends SimpleOnGestureListener {  
        @Override  
        public boolean onScroll(MotionEvent e1, MotionEvent e2,  
                float distanceX, float distanceY) {  
            if (Math.abs(distanceY) > Math.abs(distanceX)) {  
                return true;  
            }  
            return false;  
        }  
    }  
  
}