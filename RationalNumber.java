public class RationalNumber extends Number {
  private int numerator, denominator;

  /**Initialize the RationalNumber with the provided values
  *  if the denominator is 0, make the fraction 0/1 instead
  *@param nume the numerator
  *@param deno the denominator
  */
  public RationalNumber(int nume, int deno){
    numerator = nume;
    denominator = deno;
    if(numerator == 0 || denominator == 0){
      numerator = 0;
      denominator = 1;
    }
    reduce();
  }

  public double getValue(){
    return (double)numerator / (double) denominator;
  }

  /**
  *@return the numerator
  */
  public int getNumerator(){
    return numerator;
  }
  /**
  *@return the denominator
  */
  public int getDenominator(){
    return denominator;
  }
  /**
  *@return a new RationalNumber that has the same numerator
  *and denominator as this RationalNumber but reversed.
  */
  public RationalNumber reciprocal(){
    RationalNumber x = new RationalNumber(denominator,numerator);
    return x;
  }
  /**
  *@return true when the RationalNumbers have the same numerators and denominators, false otherwise.
  */
  public boolean equals(RationalNumber other){
    return (numerator == other.getNumerator()) && (denominator == other.getDenominator());
  }

  /**
  *@return the value expressed as "3/4" or "8/3"
  */
  public String toString(){
    return "" + getNumerator() + "/" + getDenominator();
  }

  /**Calculate the GCD of two integers.
  *@param a the first integers
  *@param b the second integer
  *@return the value of the GCD
  */
  private static int gcd(int a, int b){
    int x = 0;
    while(a % b != 0){
      x = a % b;
      a = b;
      b = x;
    }
    return b;
  }

  /**
  *Divide the numerator and denominator by the GCD
  *This must be used to maintain that all RationalNumbers are
  *reduced after construction.
  */
  private void reduce(){
    int x = gcd(numerator,denominator);
    numerator = numerator / x;
    denominator = denominator / x;
    if (denominator < 0){
      denominator = Math.abs(denominator);
      numerator = numerator * -1;
    }
  }
  /******************Operations Return a new RationalNumber!!!!****************/
  /**
  *Return a new RationalNumber that is the product of this and the other
  */
  public RationalNumber multiply(RationalNumber other){
    RationalNumber x = new RationalNumber(numerator * other.getNumerator(), denominator * other.getDenominator());
    reduce();
    return x;
  }

  /**
  *Return a new RationalNumber that is the this divided by the other
  */
  public RationalNumber divide(RationalNumber other){
    RationalNumber x = new RationalNumber(numerator * other.getDenominator(), denominator * other.getNumerator());
    reduce();
    return x;
  }

  /**
  *Return a new RationalNumber that is the sum of this and the other
  */
  public RationalNumber add(RationalNumber other){
    int x = numerator * other.getDenominator() + other.getNumerator() * denominator;
    int y = denominator * other.getDenominator();
    int z = gcd(x,y);
    RationalNumber a = new RationalNumber(x/z, y/z);
    return a;
  }
  /**
  *Return a new RationalNumber that this minus the other
  */
  public RationalNumber subtract(RationalNumber other){
    int x = numerator * other.getDenominator() - other.getNumerator() * denominator;
    int y = denominator * other.getDenominator();
    int z = gcd(x,y);
    RationalNumber a = new RationalNumber(x/z, y/z);
    return a;
  }
}
