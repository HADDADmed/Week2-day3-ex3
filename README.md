# Week2-day3-ex3
# Week  2 Day 3 Exercic 2

**Spring AOP (Aspect-Oriented Programming)** is a powerful feature of the Spring Framework that allows developers to add cross-cutting concerns (such as logging, transaction management, security, etc.) to their application without modifying the actual business logic.

# **Key Concepts of Spring AOP**

**Aspect**: A modularization of a concern that cuts across multiple classes. An aspect can be implemented using regular classes or annotations.

**Join Point**: A point during the execution of a program, such as the execution of a method or the handling of an exception. In **Spring AOP**, a join point always represents a method execution.

**Advice**: Action taken by an aspect at a particular join point. Different types of advice include:

- **Before advice**: Executed before a join point.
- **After advice**: Executed after a join point, regardless of its outcome.
- **After returning advice**: Executed after a join point completes normally.
- **After throwing advice**: Executed if a method exits by throwing an exception.
- **Around advice**: Executed around a join point, allowing to control the method execution and the result.

**Pointcut**: A predicate that matches join points. A pointcut expression determines where advice should be applied.

**Introduction**: Adding new methods or fields to existing classes.

**Target Object**: The object being advised by one or more aspects; it is always a proxied object in Spring AOP.

**AOP Proxy**: The object created by the AOP framework to implement the aspect contracts (advise method executions, etc.) that are specified.

I implemented an aspect using **Spring AOP** to measure the execution time of methods annotated with `@TimeIt`.

### **Key Steps I Took**

1. **Created the `@TimeIt` Annotation**:
    - Defined a custom annotation to mark methods that need timing.
2. **Built the Aspect**:
    - Used `@Aspect` to declare the aspect class.
    - Defined a pointcut with `@Pointcut` to target methods annotated with `@TimeIt`.
    - Implemented `@Around` advice to measure execution time.
3. **Configured Spring for AOP**:
    - Enabled AspectJ auto-proxying with `@EnableAspectJAutoProxy`.
    - Scanned components to detect the aspect and service classes.
4. **Tested the Aspect**:
    - Created a service method annotated with `@TimeIt`.
    - Verified the aspect logs the execution time.

### **Challenges I Faced**

- **Dependency Configuration**: Initially forgot to include `aspectjweaver`, causing the aspect to be ignored.
- **Pointcut Syntax**: Debugged incorrect pointcut expressions that failed to match annotated methods.

### **What is AOP?**

AOP is a programming paradigm that allows you to modularize **cross-cutting concerns** in your application. Cross-cutting concerns are functionalities that span across multiple parts of your application, such as:

- **Logging**
- **Security**
- **Transaction management**
- **Performance monitoring**
- **Error handling**

Instead of scattering these concerns across your codebase, AOP allows you to centralize them in **aspects**, making your code cleaner, more modular, and easier to maintain.

### **4. Pointcut**

A **pointcut** is an expression that defines where an aspect should be applied. It matches specific join points (e.g., methods) in your application. For example:

- `@annotation(com.example.TimeIt)` matches methods annotated with `@TimeIt`.
- `execution(* com.example.service.*.*(..))` matches all methods in the `com.example.service` package.

### **5. Weaving**

**Weaving** is the process of applying aspects to the target objects (e.g., classes or methods) to create advised objects. In Spring AOP, weaving is done at runtime using **proxies**.

---

### **How AOP Works in Spring**

Spring AOP uses **dynamic proxies** to apply aspects to beans. When you define an aspect and a pointcut, Spring creates a proxy for the target bean. The proxy intercepts method calls and applies the aspect's advice.

**Exercise 2 (0H30): Discover Spring AOP**

### 

mplement an **aspect** that will print **after** the **execution** of a method the time that took the method to be executed.

This aspect will run only if the methode is annotated with an annotation **@TimeIt**

### **First i created a Maven Project**

1. **File → New → Project → Maven → Java**.

![image.png](../../../../../Downloads/bfd0422b-feaf-404b-bad9-22651867ec11_Export-183da656-bce1-4ca1-b6c6-701878ea33af/image.png)

### **2. Add Dependencies to `pom.xml`**

```xml
<project xmlns="http://maven.apache.org/POM/4.0.0"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>

    <groupId>com.apress.prospring5.ch02</groupId>
    <artifactId>spring-aop-timeit</artifactId>
    <version>5.0-SNAPSHOT</version>

    <properties>
        <maven.compiler.source>17</maven.compiler.source>
        <maven.compiler.target>17</maven.compiler.target>
        <spring.version>6.1.14</spring.version>
        <aspectj.version>1.9.7</aspectj.version>
    </properties>

    <dependencies>
        <!-- Spring Context and AOP -->
        <dependency>
            <groupId>org.springframework</groupId>
            <artifactId>spring-context</artifactId>
            <version>6.1.14</version>
        </dependency>
        <dependency>
            <groupId>org.aspectj</groupId>
            <artifactId>aspectjweaver</artifactId>
            <version>1.9.7</version>
        </dependency>

        <!-- Logging Dependencies -->
        <dependency>
            <groupId>org.slf4j</groupId>
            <artifactId>slf4j-api</artifactId>
            <version>2.0.12</version>
        </dependency>
        <dependency>
            <groupId>ch.qos.logback</groupId>
            <artifactId>logback-classic</artifactId>
            <version>1.5.6</version>
        </dependency>
        <dependency>
            <groupId>org.springframework</groupId>
            <artifactId>spring-context</artifactId>
            <version>${spring.version}</version>
        </dependency>
        <dependency>
            <groupId>org.aspectj</groupId>
            <artifactId>aspectjweaver</artifactId>
            <version>${aspectj.version}</version>
        </dependency>
    </dependencies>
</project>
```

### then i created  **the `@TimeIt` Annotation**

![image.png](../../../../../Downloads/bfd0422b-feaf-404b-bad9-22651867ec11_Export-183da656-bce1-4ca1-b6c6-701878ea33af/image%201.png)

**Then i  Create the Aspect**

![image.png](../../../../../Downloads/bfd0422b-feaf-404b-bad9-22651867ec11_Export-183da656-bce1-4ca1-b6c6-701878ea33af/image%202.png)

**Configured Spring to Enable AOP**

![image.png](../../../../../Downloads/bfd0422b-feaf-404b-bad9-22651867ec11_Export-183da656-bce1-4ca1-b6c6-701878ea33af/image%203.png)

**Then  i created a Service Class to Test**

![image.png](../../../../../Downloads/bfd0422b-feaf-404b-bad9-22651867ec11_Export-183da656-bce1-4ca1-b6c6-701878ea33af/image%204.png)

**Finaly i created  a Main Class**

![image.png](../../../../../Downloads/bfd0422b-feaf-404b-bad9-22651867ec11_Export-183da656-bce1-4ca1-b6c6-701878ea33af/image%205.png)

and the result were

![image.png](../../../../../Downloads/bfd0422b-feaf-404b-bad9-22651867ec11_Export-183da656-bce1-4ca1-b6c6-701878ea33af/image%206.png)