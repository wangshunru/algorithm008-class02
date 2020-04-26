HashMap的存储结构
   jdk7.0中的HashMap采用数组+链表形式进行存储，但是如果一个数组对应的链表长度过大 时，通过key进行查询时效率较低;为了提高效率，jdk8.0中HashMap最大的优化亮点就在 于采用了数组 + 链表 + 红黑树的 存储方式 。
   jdk8.0的HashMap 底层结构依然是一个数组(默认长度为16)也称为哈希表，同样的数组元素 是一个单向的链表，每一个数组存储的元素代表的是每一个链表的头结点;但是当数组中某 并且一个链表长度>=8，数组的长度不小于 64 时，会将此链表转换为红黑树的存储方式。
   
HashMap内部实现原理机制
  public class HashMap<K, V> extends AbstractMap<K, V> implements Map<K, V>, Cloneable, Serializable {
    /*
     默认的初始容量为：16
     1 << 4 代表将1左移4位：2^4 = 16
    */
    static final int DEFAULT_INITIAL_CAPACITY = 1 << 4; // aka 16

    //最大容量为2^30 = 1024*1024*1024 = 1073741824
    static final int MAXIMUM_CAPACITY = 1 << 30;
    /* 默认的负载因子
      负载因子表示一个散列空间的使用程度。
      当向集合容器中添加元素的时候，会判断当前容器的个数：
      如果当前容器的个数 > 阈(yu)值：即底层数组长度*负载因子
       */
    static final float DEFAULT_LOAD_FACTOR = 0.75f;

    /*新增：
    如果数组某一个元素中的链表节点数 >= 8时，
    需要转换为 红黑树形式存储
    */
    static final int TREEIFY_THRESHOLD = 8;
    /*新增：
    如果数值中某一个 元素转换为红黑树存储之后，在之后的操作中
    检测到节点数 <6 时，则解散红黑树存储，再 转换为 链表形式
    进行存储
    */
    static final int UNTREEIFY_THRESHOLD = 6;
    /*新增：
    如果数组某一个元素中的链表节点数 >= 8时，需要转换为
    红黑树形式存储，但是 同时 需要 还满足此时的数组长度
    不能不小 64 ，否则也不会转换为 红黑树形式存储
    */
    static final int MIN_TREEIFY_CAPACITY = 64;

    /*改变：
    jdk8.0中底层数组类型由 Entry 类型改变为 Node 类型
    但是 Node 为 Map.Entry接口的实现类
    */

    // Map集合中键值对的 个数
    transient int size;

    // 记录对集合中元素修改的次数
    transient int modCount;
    /* 扩容的临界值(阈值)，或者所能容纳的key-value对的极限。
          当size>threshold的时候就会扩容
       */
    int threshold;
    
    
put方法实现的原理如下：
(1) 调用 hash方法 获取 key 对应 的 哈希码值
(2) 如果 table 为空，则先新建一个table数组
(3) 如果根据key的哈希码值和table数组长度获取的存储下标位置上没有任何
 数据，则直接存储即可
(4) 如果需要存储的table对应下标位置上已有元素，则需要判断是否有冲突key：
 a. 先判断数组对应位置上，第一个节点是否存在冲突，冲突直接获取此节点
 b. 再判断是否采用的红黑树存储，是-则利用红黑树中的方法存储键值对
 c. 采用链式存储，则需要遍历的判断链表中是否有冲突的 key
 I. 如果到最后一个节点，还没有发现有冲突的key，则新建一个节点插入到尾部
 同时在这个步骤中判断链表是否需要转换为红黑树进行存储，依据为链表长度
 是否大于等于8 
 II. 如果循环过程中，发现有冲突的key，则获取该节点，同时结束循环
 d. 如果存在有冲突的 key，则新值替换旧值
 
 
get方法的实现
final Node<K,V> getNode(int hash, Object key) {
    Node<K,V>[] tab; Node<K,V> first, e; int n; K k;
    // 如果table不为空，同时table长度大于0，同时数组对应下标存储内容不为null
    if ((tab = table) != null && (n = tab.length) > 0 &&
       (first = tab[(n - 1) & hash]) != null) {
        // 如果 数组对应下标的第一个节点中的key 和 要查找的key相同
        if (first.hash == hash && // always check first node
           ((k = first.key) == key || (key != null &&
                                        key.equals(k))))
            // 直接返回第一个节点
            return first;
        // 如果第一个节点的key和要查找的key不同，同时后面还有其他节点
        if ((e = first.next) != null) {
            // 如果采用的是红黑树方式进行存储的
            if (first instanceof TreeNode)
                // 通过 红黑树 获取 key 对应的Node
                return ((TreeNode<K,V>)first).getTreeNode(hash,key);
            // 不是红黑树，则需要遍历节点，查找和 key相同的节点
            do {
                // 如果查找到和key相同的节点，返回该节点
                if (e.hash == hash &&
                   ((k = e.key) == key || (key != null && key.equals(k))))
                    return e;
           } while ((e = e.next) != null);
           
