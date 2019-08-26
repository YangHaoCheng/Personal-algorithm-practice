package algorithm.dataStructure

import scala.io.StdIn

object ArrayQueueDemo {
  def main(args: Array[String]): Unit = {

    val demo = new ArrayQueueDemo(3)
    var key = ""

    while (true) {

      println("+++++++++请选择操作++++++++")
      println("show: 内容展示")
      println("add : 添加数据")
      println("get : 选择数据")
      println("head: 展示头元素")
      println("tail: 展示尾元素")
      println("exit: 退出操作")

      key = StdIn.readLine()
      key match {
        case "show" => demo.showQueue()
        case "exit" => System.exit(0)
        case "add" => {
          print("输入添加的元素：__")
          val num: Int = StdIn.readInt()
          demo.addQueue(num)
        }
        case "get" => {
          print("输入获取的元素：__")
          val num: Int = StdIn.readInt()
          val result: Any = demo.get(num)
          if(result.isInstanceOf[Exception]){
            println(result.asInstanceOf[Exception].getMessage)
          } else {
            println(s"第${num}位元素是 ${result.asInstanceOf[Int]}")
          }
        }

      }

    }

  }
}

//创建-遍历-删除
class ArrayQueueDemo(arrMaxSize:Int){
  //指定队列大小
  val maxSize = arrMaxSize
  //数组模拟队列
  val arr = new Array[Int](maxSize)
  //front 初始化为-1，表示队列的头，但是约定不包含头元素，即指向队列的第一个元素的前一个位置
  var front = -1
  //rear 初始化-1 ，指向队列尾部包含最后这个元素
  var rear = -1

  //判满
  def isFull():Boolean = {
    rear == maxSize - 1
  }

  //判空
  def isEmpty():Boolean = {
    front == rear
  }

  def addQueue(num:Int): Unit ={
    if(isFull()){
      println("The queue is full")
      return
    }

    //将rear后移
    rear += 1
    arr(rear) = num

  }

  //遍历队列
  def showQueue(): Unit ={
    if(isEmpty()){
      println("The Queue is empty")
      return
    }

    //遍历
    for ( i <- front + 1 to rear){
      printf("arr(%d)=%d \n",i,arr(i))
    }
  }

  //获得某位元素
  def get(index:Int): Any ={
    if ( rear < index || isEmpty() ) {
      return new Exception("the data does not exist in the queue")
    }
    front += 1
    return arr(index)
  }

}