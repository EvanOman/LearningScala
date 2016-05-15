package com.evan.progfun.week3

class Rational(x: Int, y: Int)
{
	def numer = x
	def denom = y

	def add(that: Rational): Rational =
	{
		new Rational(
			numer * that.denom + that.numer * denom,
			denom * that.denom
		)
	}

	def sub(that: Rational): Rational =
	{
		add(that.neg)
	}

	override def toString: String = numer + "/" + denom

	def neg: Rational = new Rational(-1 * numer, denom)
}