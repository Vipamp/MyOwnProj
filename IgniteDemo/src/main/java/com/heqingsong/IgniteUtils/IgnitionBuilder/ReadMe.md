# package: IngitionBuilder

## 1、类描述：
   > * EmbeddedIgniteInstance: 用于创建嵌入形式的ignition连接对象，使用单例模式
   > * RemoteIgniteInstance：  用于创建连接ignite集群的Ignition的连接对象，使用单例模式
   > * IGNITETYPE：            枚举类型，即ignition的两种类型，一个是embedded类型，一个是remote类型
   > * IgniteConfParse：       用于解析ignite的配置文件 IgniteConf.xml
   > * IgniteUtils：           对外提供接口，用于获取两种不同类型的ignite对象  
    
 
## 2、IgniteUtils解析：
   调用IgniteConfParse的方法，解析配置文件IgniteConf.xml文件，转换成map读取map中的配置信息，
   > * 如果是embedded类型，就在EmbeddedIgniteInstance类中创建单例对象</li>
   > * 如果是remote类型，就在RemoteIgniteInstance类中创建单例对象</li>


## 3、使用案例：
   > * IgniteConf.xml配置文件
   
    <?xml version = "1.0" encoding = "utf-8"?>
    <Params>
        <IgniteConf>
            <IgnitationType>REMOTE</IgnitationType>
            <uriConf>
                <hostname>ubuntu</hostname>
                <port>47500..47509</port>
            </uriConf>
        </IgniteConf>
    </Params>
   
   > * 代码实例：
   
     Ignite ignite = IgniteUtils.getIgniteInstance();
   
   > * 效果：
   
    会自动依据配置文件 IgniteConf.xml 上的 ignition type 和 对应的url配置，创建相对应的ignite对象
