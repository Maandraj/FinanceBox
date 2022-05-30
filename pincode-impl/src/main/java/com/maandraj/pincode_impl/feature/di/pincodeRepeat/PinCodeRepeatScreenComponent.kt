package com.maandraj.pincode_impl.feature.di.pincodeRepeat

import androidx.annotation.RestrictTo
import dagger.Component
import javax.inject.Scope
import kotlin.properties.Delegates

@Component(dependencies = [PinCodeRepeatScreenDeps::class])
@PinCodeAgainScreenScope
interface PinCodeRepeatScreenComponent {
    @Component.Builder
    interface Builder {

        fun pinCodeAgainScreenDeps(pinCodeScreenDeps: PinCodeRepeatScreenDeps): Builder

        fun build(): PinCodeRepeatScreenComponent
    }

}

interface PinCodeRepeatScreenDeps {
}

interface PinCodeRepeatDepsProvider {
    @get:RestrictTo(RestrictTo.Scope.LIBRARY)
    val deps: PinCodeRepeatScreenDeps

    companion object : PinCodeRepeatDepsProvider by PinCodeRepeatScreenDepsStore
}

object PinCodeRepeatScreenDepsStore : PinCodeRepeatDepsProvider {
    override var deps: PinCodeRepeatScreenDeps by Delegates.notNull()
}

@Scope
@kotlin.annotation.Retention(AnnotationRetention.RUNTIME)
annotation class PinCodeAgainScreenScope