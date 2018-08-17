package com.tuanhk.di.component;

import com.tuanhk.data.cache.AppStore;
import com.tuanhk.data.cache.UserConfig;
import com.tuanhk.di.anotation.UserScope;
import com.tuanhk.di.module.UserModule;
import com.tuanhk.home.calls.CallsFragment;
import com.tuanhk.home.contacts.ContactsFragment;

import dagger.Component;

/**
 * Created by cpu10225 on 14/11/2017.
 */

@UserScope
@Component(dependencies = ApplicationComponent.class, modules = {UserModule.class})
public interface UserComponent {

    void inject(CallsFragment callsFragment);
    void inject(ContactsFragment contactsFragment);
}
