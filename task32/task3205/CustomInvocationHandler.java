package com.javarush.task.task32.task3205;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * Created by locuser on 11.03.2017.
 */
public class CustomInvocationHandler implements InvocationHandler{

    private SomeInterfaceWithMethods original;

    public CustomInvocationHandler(SomeInterfaceWithMethods siwm) {
    this.original = siwm;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {


        System.out.println(method.getName() + " in");
            method.invoke(original,args);
        System.out.println(method.getName() + " out");

        return  method.invoke(original,args);
    }
}
