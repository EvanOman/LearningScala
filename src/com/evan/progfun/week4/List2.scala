package com.evan.progfun.week4

import com.evan.progfun.week4._

object List2
{
	def List() = new Nil()
	def List[T](a: T) = new Cons[T](a, new Nil)
	def List[T](a: T, b: T) = new Cons[T](a, new Cons[T](b, new Nil))
}