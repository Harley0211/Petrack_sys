package com.example.petrack_sys;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;


public class CenterFABBehavior extends CoordinatorLayout.Behavior<FloatingActionButton>{
    public CenterFABBehavior(Context context, AttributeSet attrs) {
        super(context, attrs);
    }
    @Override
    public boolean layoutDependsOn(@NonNull CoordinatorLayout parent, @NonNull FloatingActionButton child, @NonNull View dependency) {
        return dependency instanceof BottomNavigationView; // Check if the dependency is our BottomNavigationView
    }
    @Override
    public boolean onDependentViewChanged(@NonNull CoordinatorLayout parent, @NonNull FloatingActionButton child, @NonNull View dependency) {
        // Calculate the center position based on BottomNavigationView's position and width
        int centerX = dependency.getLeft() + (dependency.getWidth() / 2) - (child.getWidth() / 2);

        // Set the FAB's X position to achieve centering
        child.setX(centerX);

        // Adjust Y position if needed, for example, to account for FAB's height or BottomAppBar configuration
        return true;
    }
}
