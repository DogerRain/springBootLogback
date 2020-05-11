```java
public class SuperClass {
    static {
        System.out.println("SuperClass init!");
    }

    public static int vaule = 123;
}

class SubClass extends SuperClass {
    static {
        System.out.println("SubClass init!");
    }
}

class test {
    public static void main(String[] args) {
        System.out.println(SubClass.vaule);
    }
}
```
 

 输出：
>  
>          SuperClass init!
>          123


对于静态字段，只有直接定义这个字段的类才会被初始化，因此通过其子类来引用父类中定义的静态字段，只会触发父类的初始化而不会触发子类的初始化。
称为被动引用。