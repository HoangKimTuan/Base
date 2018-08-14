package com.tuanhk.di.component;

import com.tuanhk.di.module.UserModule;
import com.tuanhk.utils.anotation.CustomScope;

import dagger.Component;

/**
 * Created by cpu10225 on 14/11/2017.
 */

@CustomScope
@Component(dependencies = ApplicationComponent.class, modules = {UserModule.class})
public interface UserComponent {

}
