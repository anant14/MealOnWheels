package com.c2.mealonwheels;

import android.app.Activity;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;

/**
 * Created by anant bansal on 3/24/2018.
 */

public class perman {

    //interface basically defines the function name but its defination is not given
    //we override these function when we need them
    //we define these fuction as per our need like the on click listner we define as per our wish

    interface OnPermissionResultListner
    {
        void OnGranted(String forperm);
        void OnDenied(String forperm);
    }

    private static OnPermissionResultListner sopr1;

    static void askForPermission(Activity act, String perm, OnPermissionResultListner opr1)
    {
        sopr1=opr1;
        ActivityCompat.requestPermissions(act,new String[]{perm},111);
    }

    static void onPermResult(int reqCode,String[] perms,int[] resCodes)
    {

        if(reqCode==111)
        {
            if (resCodes[0]== PackageManager.PERMISSION_GRANTED)
            {
                sopr1.OnGranted(null);
            }
            else
            {
                sopr1.OnDenied(null);
            }
        }
    }

}
