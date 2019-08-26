package algorithm.dataStructure

import scala.collection.mutable.ArrayBuffer

object GomokuProblem {

  def main(args: Array[String]): Unit = {
    val rowSize = 11
    val colSize = 11
    val chessMap = Array.ofDim[Int](11,11)

    //初始化
    chessMap(1)(2) = 1
    chessMap(2)(3) = 2

    //打印
    for (elem <- chessMap) {

      for (elem2 <- elem) {
        printf("%d\t",elem2)
      }

      println()
    }

    //转为稀疏数组
    val a: ArrayBuffer[Node] = ArrayBuffer[Node]()
    val node = new Node(11,11,0)
    a.append(node)
    for ( i <- 0 until chessMap.length ){
      for ( j <- 0 until chessMap(i).length ){
        //判断该值是否为0
        if ( chessMap(i)(j) != 0 ){
          val node = new Node(i,j,chessMap(i)(j))
          //加入数组
          a.append(node)
        }
      }
    }

    //输出压缩后的数组
    for (elem <- a) {
      printf("%d\t%d\t%d\n",elem.col,elem.row,elem.value)
    }
  }
}

class Node(val row:Int,val col:Int,var value:Int){

}