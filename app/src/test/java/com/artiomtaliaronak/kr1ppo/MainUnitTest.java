package com.artiomtaliaronak.kr1ppo;

import static org.mockito.Mockito.verify;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import static org.junit.Assert.*;

import android.os.Bundle;

import androidx.constraintlayout.utils.widget.MockView;

public class MainUnitTest {

    @Test
    public void advancedTest(){
        Advanced advanced = Mockito.mock(Advanced.class);
        MainActivity mainActivity = Mockito.mock(MainActivity.class);
        mainActivity.replaceFragment(advanced);
        verify(mainActivity).replaceFragment(advanced);
    }

    @Test
    public void simplifiedTest(){
        Simplified simplified = Mockito.mock(Simplified.class);
        MainActivity mainActivity = Mockito.mock(MainActivity.class);
        mainActivity.replaceFragment(simplified);
        verify(mainActivity).replaceFragment(simplified);
    }

    @Test
    public void simplifiedUpdateTextTest(){
        Simplified simplified = Mockito.mock(Simplified.class);
        simplified.updateText("1");
        verify(simplified).updateText("1");
    }

    @Test
    public void advancedUpdateTextTest(){
        Advanced advanced = Mockito.mock(Advanced.class);
        advanced.updateText("1");
        verify(advanced).updateText("1");
    }

}