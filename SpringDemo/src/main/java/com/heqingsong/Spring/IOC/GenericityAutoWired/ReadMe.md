# 1、泛型依赖注入

比如 实例中，BaseService类有一个属性BaseComponent<T> baseComponent，是泛型类对象，通过依赖注入的方式完成的
UserService继承了BaseService, 泛型类型是User，则其对应的component属性，类型是UserComponent<User>

也就是说，如果父类有泛型对象，子类继承时，也会有其对应的泛型对象，并且其泛型类型T的真实类型也是一样的。
如果父类的泛型对象是通过依赖注入的方式装配的，子类的泛型对象，也会依据此自动装配子类该对应的泛型对象，泛型T的类型保持同步。


