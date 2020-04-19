public interface Queue<E> extends Collection<E> {
   	/*
	添加方法 成功true 失败false
	抛出异常：队列空间不足（底层采用数组）
		  限制元素类型 
		  限制null元素
		  限制元素的对象属性
	*/
	 boolean add(E var1);
 	/*
	添加方法 
	*/
   	 boolean offer(E var1);
 	/*
	删除元素
	返回被删除的元素
	异常 如果队列为空
	*/
   	 E remove();
 	/*
	删除方法 
	如果队列为空 返回null
	*/
   	 E poll();
 	/*
	访问对头元素 如果队列为空异常
	*/
   	 E element();
 	/*
	访问队头元素 如果为空 返回null
	*/
   	 E peek();
}
