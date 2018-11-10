package com.ehi.componentdemo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import com.ehi.base.ComponentEnum;
import com.ehi.base.EHiServiceContainer;
import com.ehi.base.service.component1.Component1Service;
import com.ehi.component.ComponentConfig;
import com.ehi.component.anno.EHiRouterAnno;
import com.ehi.component.impl.EHiModuleManager;
import com.ehi.component.impl.EHiRxRouter;

import io.reactivex.functions.Consumer;

@EHiRouterAnno(value = "main", desc = "主界面")
public class MainAct extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_act);

        ComponentConfig.init(true);

        EHiModuleManager.getInstance().register(ComponentEnum.App.getModuleName());
        EHiModuleManager.getInstance().register(ComponentEnum.Component1.getModuleName());
        EHiModuleManager.getInstance().register(ComponentEnum.Component2.getModuleName());

        System.out.println(EHiModuleManager.getInstance());

    }

    public void registerComponent1(View view) {

        EHiModuleManager.getInstance().register(ComponentEnum.Component1.getModuleName());

    }

    public void unregisterComponent1(View view) {

        EHiModuleManager.getInstance().unregister(ComponentEnum.Component1.getModuleName());

    }

    public void registerComponent2(View view) {

        EHiModuleManager.getInstance().register(ComponentEnum.Component2.getModuleName());

    }

    public void unregisterComponent2(View view) {

        EHiModuleManager.getInstance().unregister(ComponentEnum.Component2.getModuleName());

    }

    public void goToComponent1MainView(View view) {

        /*EHiRouter
                .with(this)
                .host("component1")
                .path("test")
                .query("name","xiaojinzi")
                .query("pass","321")
                .requestCode(123)
                .navigate();*/

        EHiRxRouter.Builder builder = EHiRxRouter
                .with(this)
                .host("component1")
                .path("test")
                .query("name", "xiaojinzi")
                .query("pass", "321")
                .requestCode(123);

        builder.go()
                .subscribe(new Consumer<Intent>() {
                    @Override
                    public void accept(Intent intent) throws Exception {
                        System.out.println("result = " + intent.getStringExtra("data"));
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        System.out.println("result = " + throwable.getMessage());
                    }
                });

        builder.go()
                .subscribe(new Consumer<Intent>() {
                    @Override
                    public void accept(Intent intent) throws Exception {
                        System.out.println("result = " + intent.getStringExtra("data"));
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        System.out.println("result = " + throwable.getMessage());
                    }
                });

        /*SingleTransformer<Object, Intent> transformer = EHiRxRouter.with(this).host("component1").path("test")
                .query("name", "xiaojinzi")
                .query("pass", "321")
                .requestCode(123).newTransformer();

        Single
                .just(new Object())
                .compose(transformer)
                .subscribe(new Consumer<Intent>() {
                    @Override
                    public void accept(Intent intent) throws Exception {
                        System.out.println("result = " + intent.getStringExtra("data"));
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        System.out.println("throwable");
                    }
                });*/


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 123 && resultCode == RESULT_OK) {
            Toast.makeText(this, "返回数据啦", Toast.LENGTH_SHORT).show();
        }
    }

    public void loadComponent1Fragment(View view) {

        Component1Service service = EHiServiceContainer.get(Component1Service.class);

        if (service == null) {
            Toast.makeText(this, "服务没找到", Toast.LENGTH_SHORT).show();
            return;
        }

        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.fl, service.getFragment());
        ft.commit();

    }

}
