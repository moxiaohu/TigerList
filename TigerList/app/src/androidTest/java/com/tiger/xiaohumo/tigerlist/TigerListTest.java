package com.tiger.xiaohumo.tigerlist;

import android.test.ActivityInstrumentationTestCase2;
import android.widget.EditText;

import com.robotium.solo.Solo;

/**
 * Created by xiaohu on 31/07/15.
 */
public class TigerListTest  extends ActivityInstrumentationTestCase2<MainActivity> {
    public TigerListTest(String pkg, Class<MainActivity> activityClass) {
        super(pkg, activityClass);
    }

    private Solo solo;

    @Override
    public void setUp() throws Exception {
        //setUp() is run before a test case is started.
        //This is where the solo object is created.
        solo = new Solo(getInstrumentation(), getActivity());
    }

    @Override
    public void tearDown() throws Exception {
        //tearDown() is run after a test case has finished.
        //finishOpenedActivities() will finish all the activities that have been opened during the test execution.
        solo.finishOpenedActivities();
    }

    public void testAddList() throws Exception {
        //Unlock the lock screen
        solo.unlockScreen();
        solo.waitForActivity(MainActivity.class);

        solo.enterText((EditText) solo.getView(R.id.input_dream), "tiger");
        solo.clickLongOnView(solo.getView(R.id.input_ok));
    }
}
