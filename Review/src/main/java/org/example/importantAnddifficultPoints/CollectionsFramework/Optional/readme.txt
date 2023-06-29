Optional类是Java8为了解决null值判断问题，借鉴google guava类库的Optional类而引入的一个同名Optional类，
使用Optional类可以避免显式的null值判断（null的防御性检查），从而避免null导致的NPE（NullPointerException）。

Optional类提供了三个静态方法empty()、of(T value)、ofNullable(T value)来创建Optinal对象，示例如下：

// 1、创建一个包装对象值为空的Optional对象
Optional<String> optStr = Optional.empty();
// 2、创建包装对象值非空的Optional对象
Optional<String> optStr1 = Optional.of("optional");
// 3、创建包装对象值允许为空的Optional对象
Optional<String> optStr2 = Optional.ofNullable(null);