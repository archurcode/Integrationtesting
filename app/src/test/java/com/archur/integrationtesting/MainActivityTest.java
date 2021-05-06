package com.archur.integrationtesting;


import android.content.Intent;
import android.widget.Button;
import android.widget.EditText;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.RuntimeEnvironment;
import org.robolectric.annotation.Config;

import static org.junit.Assert.assertEquals;
import static org.robolectric.Shadows.shadowOf;

@RunWith(RobolectricTestRunner.class)
@Config(sdk=29)
public class MainActivityTest {

    @Test
    public void testFor() {
        MainActivity activity = Robolectric.buildActivity(MainActivity.class).create().get();
        EditText et1 = activity.findViewById(R.id.first);
        EditText et2 = activity.findViewById(R.id.second);
        EditText et3 = activity.findViewById(R.id.result_main);
        Button btn = activity.findViewById(R.id.button);
        et1.setText("1");
        et2.setText("2");
        btn.performClick();

        Intent expectedIntent = new Intent(activity, SecondActivity.class);
        Intent actual = shadowOf(RuntimeEnvironment.application).getNextStartedActivity();
        System.out.println(expectedIntent.getComponent() + " " + actual.getComponent());
        assertEquals(expectedIntent.getComponent(), actual.getComponent());
        assertEquals("1", et1.getText().toString());
        assertEquals("2", et2.getText().toString());
        assertEquals("3", et3.getText().toString());
    }
}
