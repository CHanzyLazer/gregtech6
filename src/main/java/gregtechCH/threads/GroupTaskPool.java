package gregtechCH.threads;

import java.util.Collection;
import java.util.concurrent.*;

import static gregapi.data.CS.OUT;

/**
 * @author CHanzy
 * 提供直接分组提交任务的线程池，并且调用提交任务后会直接等待直到任务完成
 */
public class GroupTaskPool {
    private final ExecutorService mThreadPool;
    private CountDownLatch mLatch = null;
    private final Timer mTimer = new Timer(500) {
        @Override
        public StoppableAndTimeoutable getSubTimer(Object aObject) {
            return new StoppableAndTimeoutable() {
                @Override public void doTimeOut(int aTime) {
                    OUT.println("WARNING: GroupTaskPool '" + aObject + "' just takes too much time to runAll (more than " + aTime+" ms)");
                }
            };
        }
    };
    
    public GroupTaskPool(int MaxPoolSize) {
        mThreadPool = new ThreadPoolExecutor(1, MaxPoolSize, 100L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue<>());
    }
    
    public void runAll(Collection<? extends CountRunnable> aTasks) {
        mLatch = new CountDownLatch(aTasks.size());
        for (Runnable task : aTasks) mThreadPool.execute(task);
        mTimer.reset(this);
        try {mLatch.await();} catch (InterruptedException ignored) {}
        mTimer.check();
    }
    
    public abstract class CountRunnable implements Runnable {
        public abstract void run2();
        public void doCatch(Throwable e) {/**/}
        public void doFinal() {/**/}
        @Override
        public final void run() {
            try {run2();}
            catch (Throwable e) {doCatch(e);}
            finally {doFinal(); mLatch.countDown();}
        }
    }
    
    public void close() {
        mThreadPool.shutdown();
        mTimer.close();
    }
}
