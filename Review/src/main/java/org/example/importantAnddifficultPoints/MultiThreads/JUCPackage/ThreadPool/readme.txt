Java 5 以前，得手动自创线程池，之后有内建的线程池，需要线程池的理由很简单————创建线程的开销很大，不如那么多线程别销毁了，让它们多干点活。

使用 Executors 工厂类来产生线程池：

newCachedThreadPool 创建一个可缓存线程池，如果线程池长度超过处理需要，可灵活回收空闲线程，若无可回收，则新建线程。

newFixedThreadPool 创建一个定长线程池，可控制线程最大并发数，超出的线程会在队列中等待。

newScheduledThreadPool 创建一个定长线程池，支持定时及周期性任务执行。

newSingleThreadExecutor 创建一个单线程化的线程池，它只会用唯一的工作线程来执行任务，保证所有任务按照指定顺序执行。它就是 newFixedThreadPool 传入1