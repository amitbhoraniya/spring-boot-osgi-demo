# Spring Boot OSGi Demo

This is demo application that shows how to use OSGi with Spring Boot.

### Build Application
Execute below maven command, which will create a bundle in `target/deploy` directory and can be deployed in Apache Karaf Container. 

```
mvn clean install
```

### calc-core
Here, calc-core bundle is providing service of Calculator and itself implementing Addition Service. 

After deploying only calc-core bundle if we call below Rest API.

```
http://localhost:8013/calculator
```
Then, its response would be like

```
["Addition"]
```

### calc-plugin
Here, calc-plugin is implementing Calculator Service and providing support for Subtraction also. This plugin is dependent on calc-core plugin.

After deploying calc-core, if we again call same Rest API.

```
http://localhost:8013/calculator
```
Then, its response would be like

```
["Addition","Subtraction"]
```
To perform calculator operation, call below RestAPI.

```
http://localhost:8013/calculator/{operation}?n1={n1}&n2={n2}
```

For Example,

```
http://localhost:8013/calculator/addition?n1=12&n2=12
```
