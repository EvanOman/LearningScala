package com.evan.scalafp.Ch1

/* Functional Version, NO SIDE EFFECTS */

class Cafe_NoSideEffects
{
	/* Use the given card to buy a single coffee, return the coffee and the charge */
	def buyCoffee(cc: CreditCard): (Coffee, Charge) =
	{
		val cup = new Coffee()
		(cup, Charge(cc, cup.price))
	}

	/* Use the given card to buy n coffees, return the coffee and the agg charge */
	def buyCoffees(cc: CreditCard, n: Int): (List[Coffee], Charge) =
	{
		val purchases: List[(Coffee, Charge)] = List.fill(n)(buyCoffee(cc))
		val (coffees, charges) = purchases.unzip

		/* This works because we are folding together purchases with the same cc */
		(coffees, charges.reduce((c1, c2) => c1.combine(c2)))
	}

	/* Combines any same-card charges in the given list of Charges */
	def coalesce(charges: List[Charge]): List[Charge] =
	{
		charges.groupBy(_.cc).values.map(_.reduce(_ combine _)).toList
	}
}

/* Charge data structure containing a credit card and an amount to charge */
case class Charge(cc: CreditCard, amnt: Double)
{
	/* Folds the given charge into *this* charge, returns a new charge (no side-effects) */
	def combine(other: Charge): Charge =
	{
		if (cc == other.cc)
		{
			Charge(cc, amnt + other.amnt)
		}
		else
		{
			throw new Exception("Can't combine charges to different cards")
		}
	}
}

/* Dummy implementations of the other classes */

class CreditCard(val name: String, val cardNum: Int)
{
	def charge(amount: Double): Unit = println(s"Charging $name $$$amount")
}

class Coffee()
{
	val price = 2.50d
}