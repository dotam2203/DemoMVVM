package com.mvvm

import android.view.View
import android.widget.Button

interface OnClickButton {
    fun onCLickSum(view:View)
    fun onCLickSub(view: View)
    fun onCLickMul()
    fun onCLickDiv()
}