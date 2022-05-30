package com.maandraj.pincode_impl.feature.di.pincodeMain

import com.maandraj.pincode_impl.feature.screen.pincodeMain.PinCodeScreenVM
import dagger.Module
import dagger.Provides

@Module
class PinCodeScreenModule {

    @Provides
    @PinCodeScreenScope
    fun provideViewModel() : PinCodeScreenVM = PinCodeScreenVM()
}