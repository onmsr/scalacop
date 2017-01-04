package onmsr.scalacop.chapter12

import scala.language.implicitConversions
import scala.collection.mutable.ArrayBuffer

trait IntQueue {
  def get(): Int
  def put(x: Int): Unit
}

class BasicIntQueue extends IntQueue {
  private val buf = new ArrayBuffer[Int]
  def get(): Int = buf.remove(0)
  def put(x: Int): Unit = buf += x
}

trait Doubling extends IntQueue {
  abstract override def put(x: Int): Unit = super.put(2*x)
}

trait Incrementing extends IntQueue {
  abstract override def put(x: Int): Unit = super.put(x+1)
}

trait Filtering extends IntQueue {
  abstract override def put(x: Int): Unit = if (x >= 0) super.put(x)
}


// Proxyパターンのscala的実装例
trait ProxyInterface {
  def getResult(): Int
}

class ProxyImpl extends ProxyInterface {
  def getResult(): Int = {
    println("called getResult")
    1
  }
}

// トレイトの積み重ね的手法を利用した場合
trait CacheProxy extends ProxyInterface {
  var result: Option[Int] = None
  abstract override def getResult(): Int = {
    result.orElse { result = Some(super.getResult); result } get
  }
}

// javaのような方法の場合
class CacheProxyWithTransfer extends ProxyInterface {
  val impl = new ProxyImpl
  lazy val result: Option[Int] = Some(impl.getResult)
  def getResult(): Int = result.get
}

/**
 * new BasicIntQueue with Incrementing with Filtering
 * のように積み重ねて利用する
 */

/* コンパニオンはprivate[this]じゃなければアクセスできる
package p {
  object Outer {
    class A {
      private def hoge = {
        A.fuga 
        1
      }
    }
    object A {
      private def fuga = 1 
    }
  }
}
 */
