package com.evan.progfun.week4

import java.util.NoSuchElementException

trait List[T]
{
	def isEmpty: Boolean
	def head: T
	def tail: List[T]
	def toString: String
	def nth(n: Int): T
}

class Cons[T](val head: T, val tail: List[T]) extends List[T]
{
	def isEmpty = false
	override def toString = head.toString + ", " + tail.toString
	def nth(n: Int): T =
		if (n == 0)
			head
		else if (n > 0)
			tail.nth(n -1)
		else
			throw new IndexOutOfBoundsException("Negative Index")
}

class Nil[T] extends List[T]
{
	def isEmpty = true
	def head: Nothing = throw new NoSuchElementException("Nil.head")
	def tail: Nothing = throw new NoSuchElementException("Nil.tail")
	override def toString = "NIL"
	def nth(n: Int): Nothing = throw new IndexOutOfBoundsException("Item not found!")
}

object List
{
	// List(1, 2) = list.apply(1,2)
	def apply[T](x1: T, x2: T): List[T] = new Cons[T](x1, new Cons[T](x2, new Nil))

	// List(1) = list.apply(1)
	def apply[T](x1: T): List[T] = new Cons[T](x1, new Nil)

	def apply[T](): List[T] = new Nil[T]
}


