package com.evan.progfun

import com.evan.progfun.week3.Rational
import com.evan.progfun.week4.{Cons, Nil, List2}


object test
{

	def main(): Unit =
	{
		println("This is progfun's test file")
		testWeek4()
	}

	def testWeek4(): Unit =
	{
		def singleton[T](elem: T) = new Cons[T](elem, new Nil[T])

		val a = new Cons(1, new Cons(2, new Cons(3, new Nil)))

		println(s"This is what a looks like : $a")

		val b = a.nth(0)

		println(s"This is what b looks like : $b")


		// Using new syntax:
		val a2 = List2.List(1,2)

		println(a2)
	}


	def testWeek3(): Unit =
	{
		val a = new Rational(3, 4)
		val b = new Rational(5, 4)
		val c = a.add(b)

		println(s"This is a: $a")
		println(s"This is b: $b")
		println(s"This is a + b: $c")

	}
}

