package com.tuanhk.di.component;

import com.tuanhk.demo.DemoFragment;
import com.tuanhk.di.module.DemoModule;
import com.tuanhk.splashscreen.SplashScreenFragment;
import com.tuanhk.util.anotation.CustomScope;

import dagger.Component;

@CustomScope
@Component(dependencies = ApplicationComponent.class, modules = {DemoModule.class})
public interface DemoComponent {
    void inject(DemoFragment demoFragment);
}
