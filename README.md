# VneedU-Server - A Simple SOA application

| Author | Jakes Lee |
|---|---|
| Email | jakeslee66#gmail |

# Introduction

The project is designed for graduation design.The main purpose of this is learning how to build a RESTful API server with Spring MVC and MyBatis frameworks and create a corresponding App with React Native.
As described above, the project is not ready for production, not recommend to use for business if you clone this repository.

The project was adjusted for SOA pattern by integrating [dubbox](https://github.com/dangdangdotcom/dubbox) after v0.1.BETA released. 


# Features

Here is a list of features:

- Use gradle to manage the dependencies and building ctasks  
- Multi-project structure of source tree  
- SOA pattern practicing  
- RESTful API practicing  
- Verify by JWT(JSON Web Token)  
- etc.

# TODOs

- [ ] Push notification
- [ ] Messages notification
- [ ] Order/Requirement management
- [ ] Optimise requirements algorithm

# Prerequisites

[Git](http://help.github.com/set-up-git-redirect) and [JDK 8 update 20 or later](http://www.oracle.com/technetwork/java/javase/downloads)

Be sure that your JAVA_HOME environment variable points to the jdk1.8.0 folder extracted from the JDK download.

# How to get source code

I maintain the source code at GitHub: https://github.com/jakeslee/VneedU-Server

To get the latest source code, run following command:

```
$ git clone https://github.com/jakeslee/VneedU-Server.git
```

This will create VneedU-Server directory in your current directory and source files are stored there.

# How to build

The project is written in Java and uses gradle to solve dependencies. 

In order to build and deploy the project, you need to install gradle in system.

### Executing a build with the Wrapper

The Gradle wrapper is distributing with this project, you can build the project without installing gradle beforehand.

To solve dependencies and build, run the following command:

```
$ ./gradlew build
```

If you have installed gradle correctly, run:

```
$ gradle build
```

### Deploy Service Provider

The service provider is sub-project named _service_. Dubbox has provide a container to run service provider. 

To assemble and distribute the service, run the following command:
```
$ gradle :vneedu-service:assembleDist
```
This will generate a zip file compressed all libs and executable starter scripts in **service/build/distributions** directory. 

Before start provider, you need to install [ZooKeeper](https://zookeeper.apache.org/).

Copy the generated zip to distributed server, unzip the archive, then run:
```
$ sh bin/vneedu-service
```

By default, the provider will try to register to registry hosted at 127.0.0.1:2181. If you want to override default settings, create a new empty application.properties stored in bin/ directory then add items which you want to override.

**Example:**

I want to change the registry's port, the properties file will be:

```
app.soa.registry.address=127.0.0.1:1218
```

##### Default properties

file: _application.properties_

```
app.name=vneedu
app.production.mode.enabled=false
# CDN config
app.storage.cdn.enabled=true
app.storage.cdn.bucket=local

# Qiniu Cloud Storage configurations
app.storage.cdn.qiniu.name=vneedu
app.storage.cdn.qiniu.proto=qiniu
app.storage.cdn.qiniu.urlPath=
app.storage.cdn.qiniu.ACCESS_KEY=
app.storage.cdn.qiniu.SECRET_KEY=
app.storage.cdn.qiniu.uploader=http://upload.qiniu.com/
app.storage.cdn.qiniu.callback=

# Local Storage
app.storage.cdn.local.name=local
app.storage.cdn.local.urlPath=127.0.0.1:8080
app.storage.cdn.local.storeInDir=static

# SOA Configurations
app.soa.registry.address=127.0.0.1:2181     # Registry address
app.soa.registry.root.password=root         # Root passkey for registry
app.soa.registry.guest.password=guest       # Guest passkey for registry
app.soa.protocol.dubbo.port=20808           # Dubbo protocol port 
```

file: _jdbc-mysql.properties_

```
jdbc.driverClassName=com.mysql.jdbc.Driver
jdbc.url=jdbc:mysql://localhost:3306/vneedu?useUnicode=true&characterEncoding=UTF-8&zeroDateTimeBehavior=convertToNull
jdbc.username=root
jdbc.password=12345678
validationQuery=SELECT 1

#c3p0
jdbc.maxPoolSize=50
jdbc.minPoolSize=10
jdbc.maxStatements=100
jdbc.testConnection=true

# 通用Mapper配置
mapper.plugin = tk.mybatis.mapper.generator.MapperPlugin
mapper.Mapper = tk.mybatis.mapper.common.Mapper
```

### Deploy Service Consumer(API Server)

The consumer is web app, so consumer can run in jetty, tomcat or resin container. To build war pack, run the following command:

```
$ gradle :vneedu-server:war
```

The command will create a war file in **server/build/libs** directory. Deploy war file as ordinary.

# License

The project is released under version 2.0 of the [Apache License](http://www.apache.org/licenses/LICENSE-2.0) .
