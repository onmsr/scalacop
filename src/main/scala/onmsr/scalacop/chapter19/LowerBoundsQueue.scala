package onmsr.scalacop.chapter19

class HihenQueue[T](l: List[T]) {
  def head: T = l.head
  def enqueue(x: T): LowerBoundsQueue[T] = new LowerBoundsQueue(l:::List(x))
}

class LowerBoundsQueue[+T](l: List[T]) {
  def head: T = l.head
  def enqueue[U >: T](x: U): LowerBoundsQueue[U] = new LowerBoundsQueue(l:::List(x))
}

class Fruit {}
class Orange extends Fruit {}
class Apple extends Fruit {}
class Animal {}
class Human extends Animal {}
class Cat extends Animal {}
class Lion extends Cat {}
