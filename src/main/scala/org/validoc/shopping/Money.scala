package org.validoc.shopping

/** Money is very complicated. Let's keep all our money behaviour tightly controlled */
trait Money[T] {
  def zero: T

  def negate(t: T): T

  def sum(t1: T, t2: T): T
}

object Money {

  /** Initially we will treat money as an int which is the number of pennies */
  implicit object MoneyAsInt extends Money[Int] {
    override def sum(t1: Int, t2: Int): Int = t1 + t2

    override def zero: Int = 0

    override def negate(t: Int): Int = -t
  }

}
