package com.example.dhananjay.dailygoals;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.CoordinatorLayout;
import android.support.v4.view.ViewCompat;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

import static java.lang.Math.max;
import static java.lang.Math.min;

public class BottomNavigationBehavior extends CoordinatorLayout.Behavior<BottomNavigationView> {

        /**
         * Default constructor for instantiating the behavior
         */
    public BottomNavigationBehavior() {
        super();
    }

    /**
     * Default constructor for inflating behaviors from the layout
     *
     * @param context
     * @param attrs
     */

    public BottomNavigationBehavior(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    /**
     * @param coordinatorLayout the CoordinatorLayout with which the behavior is associated
     * @param child             the child view of the CoordinatorLayout this behavior is associated with
     * @param directTargetChild the child view of the CoordinatorLayout that either is or contains the view that is the target of nested
     *                          scrolling operation
     * @param target            the descendant of the CoordinatorLayout initiating the scroll operation
     * @param axes              the axis of scrolling - horizontal or vertical
     * @param type              type of input event that caused the scrolling
     * @return true if behavior wishes to accept this nested scroll
     */
    @Override
    public boolean onStartNestedScroll(@NonNull CoordinatorLayout coordinatorLayout, @NonNull BottomNavigationView child, @NonNull View directTargetChild, @NonNull View target, int axes, int type) {
        Log.v("Tag", target.getClass().toString());
        return axes == ViewCompat.SCROLL_AXIS_VERTICAL;
    }


    /**
     * @param coordinatorLayout
     * @param child
     * @param target
     * @param dx                the horizontal number of pixels that the user attempted to scroll
     * @param dy                the vertical number of pixels that the user attempted to scroll
     * @param consumed          an integer array where consumed[0] should be set to dx , consumer[1] should be set
     *                          to dy
     * @param type
     */
    @Override
    public void onNestedPreScroll(@NonNull CoordinatorLayout coordinatorLayout, @NonNull BottomNavigationView child, @NonNull View target, int dx, int dy, @NonNull int[] consumed, int type) {
        super.onNestedPreScroll(coordinatorLayout, child, target, dx, dy, consumed, type);
        child.setTranslationY(max(0f, min(((float) child.getHeight()), child.getTranslationY() + dy)));
    }

}
