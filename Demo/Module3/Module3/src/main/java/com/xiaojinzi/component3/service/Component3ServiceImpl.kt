package com.xiaojinzi.component3.service

import android.app.Application
import android.content.Context
import android.widget.Toast
import com.xiaojinzi.component.anno.ServiceAnno
import java.util.Random

@ServiceAnno(Component3Service::class)
class Component3ServiceImpl(app: Application) : Component3Service {
    private val r = Random()
    private val context: Context

    init {
        context = app
        Toast.makeText(app, "创建了 Component3Service 服务", Toast.LENGTH_SHORT).show()
    }

    override fun doSomeThing() {
        Toast.makeText(context, "调用了 doSomeThing 方法", Toast.LENGTH_SHORT).show()
    }
}
