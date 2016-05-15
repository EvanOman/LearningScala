package com.evan.scalafp.Ch1

// Version of Cafe with side effects

class Cafe1
{
	def buyCoffee(cc: CreditCard, p: Payments): Coffee =
	{
		val cup = new Coffee()
		p.charge(cc, cup.price) // SIDE EFFECT
		cup
	}

	class CreditCard(val name: String, val cardNum: Int)
	{
		def charge(amount: Double): Unit = println(s"Charging $name $$$amount")
	}

	class Coffee()
	{
		val price = 2.50d
	}

	class Payments
	{
		def charge(cc: CreditCard, amount: Double): Unit = {val name = cc.name; println(s"Charging $name $$$amount")}
	}

}
