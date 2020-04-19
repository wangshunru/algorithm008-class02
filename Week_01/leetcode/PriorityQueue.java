//PriorityQueue 
public class PriorityQueue<E> extends AbstractQueue<E>
    implements java.io.Serializable {
    transient Object[] queue;    //队列容器
    private int size = 0;  //队列长度
    private final Comparator<? super E> comparator;  //队列比较器， 为null使用自然排序
}
//从源码上看PriorityQueue的入列操作并没对所有加入的元素进行优先级排序。仅仅保证数组第一个元素是最小的。
//入列
public boolean offer(E e) {
        if (e == null)
            throw new NullPointerException();
        modCount++;
        int i = size;
        if (i >= queue.length)
            grow(i + 1);      //当队列长度大于等于容量值时，自动拓展
        size = i + 1;
        if (i == 0)
            queue[0] = e;
        else
            siftUp(i, e); //
        return true;
    }
private void siftUp(int k, E x) {
        if (comparator != null)
            siftUpUsingComparator(k, x);   //指定比较器
        else
            siftUpComparable(k, x);   //没有指定比较器，使用默认的自然比较器
    }
    
   //出列
   public E poll() {
        if (size == 0)
            return null;
        int s = --size;
        modCount++;
        E result = (E) queue[0];
        E x = (E) queue[s];
        queue[s] = null;
        if (s != 0)
            siftDown(0, x);
        return result;
    }
//PriorityQueue并不是线程安全队列，因为offer/poll都没有对队列进行锁定，所以，如果要拥有线程安全的优先级队列，需要额外进行加锁操作。
