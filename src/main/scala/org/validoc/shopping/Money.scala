package org.validoc.shopping

trait Money[T] {
  def zero: T

  def negate(t: T): T

  def sum(t1: T, t2: T): T
}

object Money {

  implicit object MoneyAsInt extends Money[Int] {
    override def sum(t1: Int, t2: Int): Int = t1 + t2

    override def zero: Int = 0

    override def negate(t: Int): Int = -t
  }

}
