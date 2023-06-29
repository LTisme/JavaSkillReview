Lock比 synchronized 方法和 synchronized 代码块具有更广泛的锁定操作，
个人也更喜欢用这个。

【【【Lock、ReadWriteLock 是两个根接口，并为Lock提供了 ReentrantLock （可重入锁）实现类，为
ReadWriteLock 提供了 ReentrantReadWriteLock （可重入读写锁）实现类。】】】

【注意】Lock是一个接口，它有几个重要的方法
// 获取锁
void lock()

// 仅在调用时锁为空闲状态才获取该锁，可以响应中断
boolean tryLock()

// 如果锁在给定的等待时间内空闲，并且当前线程未被中断，则获取锁
boolean tryLock(long time, TimeUnit unit)

// 释放锁
void unlock()