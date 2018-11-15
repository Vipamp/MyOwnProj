# package：com.heqingsong.IgniteUtils.IgniteORM

## 1、类描述
    AbstractPojoModel：Ignite保存对象的pojo类模板，pojo对象类都需要继承该类，并重写里面的4个方法
    CacheBuilder：     依据pojo类名，创建对应的ignite cache对象
    CachePool：        用于注册管理Cache对象的对象池
    
## 2、CachePool解析：
    里面提供了两个对外的方法：
   > * initAndGetCachePool():   初始化CachePool，里面会创建一个Map，用于保存相关的容器
   > * getOrPushIgniteCache(Class clazz)：用于创建和获取指定类的Cache对象，如果该对象之前创建过，就直接获取，否则会自动创建Cache，并返回Cache对象的实例

## 3、使用实例：
    CachePool cachePool = CachePool.initAndGetCachePool();
    IgniteCache<String, AbstractPojoModel> classesIgniteCache = cachePool.getOrPushIgniteCache(Classes.class);
    IgniteCache<String, AbstractPojoModel> studentIgniteCache = cachePool.getOrPushIgniteCache(Student.class);
   
   不需要去管理底层的 Ignite 对象是怎么获取的，调用方法 CachePool.initAndGetCachePool() 后，会自依据IgniteConf.xml上的配置文件，在对应的Ignite集群中，创建后面对应的Cache
      