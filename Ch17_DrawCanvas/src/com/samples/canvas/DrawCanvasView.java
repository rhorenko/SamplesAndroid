package com.samples.canvas;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.ShapeDrawable;
import android.view.View;

class DrawCanvasView extends View {    
 
    private static final int START_X = 10;
    private static final int START_Y = 10;
    private ShapeDrawable mDrawable; 

    public DrawCanvasView(Context context) { 
        super(context); 
        setFocusable(true);  
        mDrawable = new ShapeDrawable();
    }
     
    public void setDrawable(ShapeDrawable shape) {
    	mDrawable = shape;
        mDrawable.setBounds(START_X, START_Y, 
        		START_X + mDrawable.getIntrinsicWidth(), 
        		START_Y + mDrawable.getIntrinsicHeight() );
    	this.getHeight();
    	invalidate();
    }
    
    @Override 
    protected void onDraw(Canvas canvas) { 
        mDrawable.draw(canvas);
    }
}