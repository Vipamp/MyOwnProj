# 代理模式：

## 代理类和被代理类，都是实现了同一个接口，被代理类写具体的方法实现，代理类，可以理解成一个中介，调用被代理类的方法，使用时，通过调用代理类的方法，间接调用被代理类

## 1、静态代理（StaticProxy）
   > * 手动实现代理类
   
## 2、动态代理（DynamicProxy）
   > * 通过 java.lang.reflect.Proxy 类，指定类加载器，接口方法，和句柄，动态生成一个代理类
   > * 动态代理，是 Spring 实现 AOP 的关键思路，动态代理模式，可以实现切面。

_具体的区别，详见 DynamicProxy.CalculatorProxy 和 StaticProxy.CalculatorProxy 的实现方式的不同。_
_使用方式基本相同，只是创建和获取代理对象的原理有所区别。_

