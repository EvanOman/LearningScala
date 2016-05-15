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

