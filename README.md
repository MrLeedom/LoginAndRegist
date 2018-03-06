# LoginAndRegist
how to construct logining and registing page?
dao/UserDao.java:
xpath查询--xpath即为xml路径语言，它是一种用来确定xml文档中某部分位置的语言。xpath基于xml的树状结构，有不同类型的节点，包括元素节点，属性节点和文本节点，提供在数据结构树中找寻节点的能力。
XML 实例文档
我们将在下面的例子中使用这个 XML 文档：
<?xml version="1.0" encoding="ISO-8859-1"?>

<bookstore>

<book>
  <title lang="eng">Harry Potter</title>
  <price>29.99</price>
</book>

<book>
  <title lang="eng">Learning XML</title>
  <price>39.95</price>
</book>

</bookstore>
选取节点
XPath 使用路径表达式在 XML 文档中选取节点。节点是通过沿着路径或者 step 来选取的。
下面列出了最有用的路径表达式：
表达式 描述
nodename 选取此节点的所有子节点。
/ 从根节点选取。
// 从匹配选择的当前节点选择文档中的节点，而不考虑它们的位置。
. 选取当前节点。
.. 选取当前节点的父节点。
@ 选取属性。
实例
在下面的表格中，我们已列出了一些路径表达式以及表达式的结果：
路径表达式 结果
bookstore 选取 bookstore 元素的所有子节点。
/bookstore 选取根元素 bookstore。注释：假如路径起始于正斜杠( / )，则此路径始终代表到某元素的绝对路径！
bookstore/book 选取属于 bookstore 的子元素的所有 book 元素。
//book 选取所有 book 子元素，而不管它们在文档中的位置。
bookstore//book 选择属于 bookstore 元素的后代的所有 book 元素，而不管它们位于 bookstore 之下的什么位置。
//@lang 选取名为 lang 的所有属性。
SAX是一种XML解析的替代方法，它逐行扫描文档，一边扫描一边解析。
两个方法，一个是根据用户名进行查找；另一个是添加一个用户。
紧接着我们需要对与数据库打交道的userdao进行测试，这边我们重新书写一个类：test.dao，里面我们写了一个相对应的测试类。其中需要重点关注的是XML文件的写入操作，如何对于格式进行控制其实已经被封装好了，只需要用XMLWriter来操作。
domain/User.java:
这个Java文件主要写的是关于实体类的一些声明，是符合bean规范的。
service/UserException.java:
自定义异常类，只是给出父类中的构造器，用来创建对象。
service/UserService.java:
主要写了两个功能，一个是注册功能，一个是登录功能。
注册功能目的是将传递过来的到调用数据库的方法进行比对，如果存在这个人的话，就抛出异常说明这个人存在于数据库，根本不需要进行注册，如果没有这个人的话，就直接在我们的库中添加一个用户。
登录功能我们主要是首先根据用户名进行一次查找，如果查找成功，紧接着判断密码是否一致，如果不一致会抛出密码错误的异常信息。
web.servlet/LoginServlet.java:
关于登录的一个servlet，主要是对于视图部分进行处理，我们将表单数据封装为User，这一块我们可能需要学习一下经常用到的toBean方法，紧接着我们进行登陆是否成功的判断，成功了就会通过session中存储登陆信息，重定向到welcome.jsp页面中，有错误的话在request域中存储错误信息以及相关的用户输入表单信息，转发到login.jsp中。
web.servlet/RegistServlet.java:
第一步是封存表单数据，然后创建一个Map集合存储错误信息，对用户名进行校验，对密码进行校验，对验证码进行校验，再对这个map集合errors进行判断，如果存放有错误信息，将其转发到regist.jsp页面，与此同时结束此方法，不在向下执行。接着，我们执行注册方法，注册成功我们在页面显示相关信息，注册失败返回相关信息。
web.servlet/VeriifyServlet.java:
是一个验证码图图片的处理，因为这边涉及到了一个请求，跟我们常规的请求不是一块的。

我们这里将相关的jsp文件全部存入WebRoot/user文件夹中。导入相关的jar包：
commons-beanutils.jar是apache开源组织提供的用于操作JavaBean的工具包，使用commons-beanutils，我们可以很方便的对bean对象的属性进行操作。
commons-logging.jar是用来记录程序运行时的活动日志记录
itcast-tools.jar存放了图形验证码随机生成以及获取的文件
dom4j.jar存放的是用来读写XML文件的，dom4j是一个非常优秀的Java XML API，具有性能优异、功能强大和极端易用的特点。它依赖于以下这个jar包：
jaxen-1.1-beta.jar

