# Java入门

### 一、历史与特点

#### 什么是程序

> 模拟现实世界，解决现实问题的计算机指令的有序集合

#### Java历史

> 95年诞生，创始人：詹姆斯.高斯林
>
> 04年，划分三个稳定的平台版本：JavaSE，JavaEE，JavaME
>
> 09年卖给了Oracle公司
>
> 14年，8.0版本（常用，稳定，免费）

#### 特点

> 面向对象：java世界，万物皆对象
>
> 简单性：   自动管理内存（C/C++需要手动管理，很麻烦）
>
> 跨平台： 跨操作系统（例如：window下开发的程序，可直接拿到linux执行）

### 二、执行机制

#### 计算机执行机制

> 执行机制1：
>
> 先将源文件编译成机器码文件，再通过独立的操作系统执行
>
> 好处：执行效率高       弊端：不可跨平台     特点：一次编译，多次运行

> 执行机制2：
>
> 直接将源文件在不同的操作系统中解释并执行
>
> 好处：跨平台               弊端：执行效率低

#### Java的执行机制

> 执行机制：先将java文件编译成字节码(class文件)，再将字节码解释成不同平台都能执行的指令
>
> 好处：执行效率高，跨平台
>
> 特点：一次编译，到处运行

### 三、JDK安装

#### 名词解释

> JDK：Java开发工具箱，包括JRE+类库+工具包
>
> JRE：Java的运行环境，包含JVM+解释器
>
> JVM：Java虚拟机，运行Java代码的工具

#### 安装与校验

> 下载jdk8.0，直接安装即可； 建议jdk和jre的路径同级
>
> 校验：进入到安装路径的bin目录下，输入：javac验证是否安装成功

#### 配置环境变量

> 目的：在任何DOS位置都能直接使用JDK指令
>
> 配置步骤：
>
> 我的电脑-->右键属性-->高级系统设置-->环境变量
>
> 系统配置中：
>
> 新建： JAVA_HOME:   C:\Program Files\Java\jdk1.8.0_131
>
> 双击Path：  新建--  %JAVA_HOME%\bin
>
> 验证：直接打开cmd，输入javac，验证成功

### 四、第一个Java程序

#### 编写代码

```java
//创建公开的类，名叫Hello  //是单行注释：解释说明，给人看的
public class Hello{
    //入口函数：有且只有一个；程序最先执行的入口
	public static void main(String[] args){
		//系统的打印输出   注意：每行都需要缩进-tab键
		System.out.println("hello,world");
	}
}
```

#### 编译运行

> 打开cmd，切换判断，通过cd指令定位到java文件位置
>
> 编译：javac Hello.java
>
> 运行：java   Hello

#### 规范

> 类名首字母大写，且类名与文件名一致
>
> 每行代码需要缩进（按tab键）
>
> 注意符号都是英文的
>
> 注意中文不识别的配置：
>
> 原因：notepad++的编码与DOS窗口编码不一致，则会出现乱码报错；
>
> 解决方案：将notepad++也改成ansi和DOS一致即可

#### 命名规范

> 1)、名称只能由字母、数字、下划线、$符号组成
>
> 2)、不能以数字开头
>
> 3)、名称不能使用JAVA中的关键字。
>
> 4)、坚决不允许出现中文及拼音命名。

#### 报错问题

> 1.非法字符：在程序中出现了中文的特殊符号
>
> 2.找不到符号：指定的符号名写错了
>
> 3.找不到main方法：入口函数未写或写错
>
> 4.类名hello是公开的： 说明类名和文件名不一致报错

### 五、总结与作业

#### 总结

```
1.java的历史与特点
什么是程序；  
历史：95年诞生，java之父，常用版本jdk8版本
特点：面向对象，自动管理内存，跨平台（重点）
2.执行机制
计算机执行机制：先编译后执行；源文件解释执行
java的执行机制：先编译后解释（重点）
3.jdk的安装
名词解释：JDK，JRE，JVM
安装JDK：安装后使用javac校验
配置环境变量：在任意位置都可执行javac
4.第一个java程序（重点）
编写代码，编译运行；代码的规范及报错的整理
```

#### 作业

```
1.熟练编写今天的打印第一个程序，将打印内容改为打印自我介绍信息
2.打印一个动物图形，注意：如果编写了'\'符号，两个'\\'代表一个
```

```
1.
public class Main {
    public static void main(String[] args) {
        System.out.println("自我介绍：");
        myslef m = new myslef();
        m.name = "袁阿文";
        m.age = 23;
        m.hobbby = "敲代码";
        m.home = "江西宜春";
        m.school = "师大科院";
        m.dream = "年入百万";

        System.out.println("我的名字是："+m.name+"，我的年龄是："+m.age+"，我的家乡是："+m.home+"，我的梦想是："+m.dream);
    }
}
class myslef{
    String name;
    String hobbby;
    String home;
    String dream;
    String school;
    int age;

}
```

```
2.
public class Pet{
	public static void main(String[] args){
		System.out.println("╭︿︿︿╮");
		System.out.println("{/ o  o /} ");
		System.out.println(" ( (oo) ) ");
		System.out.println("︶︶︶");
	}
}
```

