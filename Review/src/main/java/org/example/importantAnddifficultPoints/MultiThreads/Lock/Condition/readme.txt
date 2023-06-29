如果程序不使用 synchronized 关键字来保证同步，而是直接使用 Lock 对象来保证同步的话，
系统中不存在隐式的同步监视器，也就不能使用 wait() 、 notify() 和 notifyAll() 方法来实现线程间通信了。

此时Java提供了一个Condition类来保持协调，Condition实例被绑定在一个Lock对象上。要获得特定Lock实例
的Condition实例，调用Lock对象的 newCondition() 方法即可。

Condition类提供了如下3个方法：
await() ：类似于 wait() ，此方法导致该线程等待，直到其他线程调用该Condition的 signal() 方法或
    signalAll() 方法来唤醒该线程。该 await() 方法有很多变体，如 long awaitNanos(long
    nanosTimeout) 、 void awaitUninterruptibly() 、 awaitUntil(Date deadline) 等，可以完成更丰富
    的等待操作
signal() ：唤醒在此Lock对象上等待的单个线程。如果所有线程都在该Lock对象上等待，则任意选择其中
    一个唤醒。只有当前线程放弃对该Lock对象的锁定后，也就是说只有当前线程使用了 await() 方法后才可以
    执行被唤醒的线程。
signalAll() ：唤醒在此Lock对象上等待的所有线程。