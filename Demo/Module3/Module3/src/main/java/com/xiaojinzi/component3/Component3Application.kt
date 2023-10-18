package com.xiaojinzi.component3

import android.app.Application
import com.xiaojinzi.component.anno.ModuleAppAnno
import com.xiaojinzi.component.application.IApplicationLifecycle

@ModuleAppAnno()
class Component3Application : IApplicationLifecycle {

    override fun onCreate(app: Application) {
    }

    override fun onDestroy() {
    }

}
