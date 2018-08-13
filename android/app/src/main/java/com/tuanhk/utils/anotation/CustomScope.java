package com.tuanhk.utils.anotation;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Scope;

/**
 * Created by cpu10225 on 14/11/2017.
 */

@Scope
@Documented
@Retention(RetentionPolicy.RUNTIME)
public @interface CustomScope {
}
