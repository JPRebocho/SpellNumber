

import java.lang.Math; 


public class SpellNumber
{
  public static void main(String[] args)
  {
    int input = 1049875;
    
    NumberToSpell myObject = new NumberToSpell(input);
    System.out.print(myObject.spell());
  }
}

public class NumberToSpell
{
  private String result;
  private boolean done = false;
  private int num = 0;
  private int size = 0;
  
  
  //spells a number from 0 up to 1billion
  //starts spelling from the least significant digit till the most significant digit
  public NumberToSpell(int n)
  {
    num = n;    
    int d = 0;
    int u = 0;
    
    u = GetNextDigit();
    d = GetNextDigit();   
    result = SmartSpell(d,u);
    
    u = GetNextDigit();
    if (!done && u!=0){
    	result = SmartSpell(0,u) + " hundred " + result;
    }
    
    u = GetNextDigit();
    if (!done){
        d = GetNextDigit();
    	result = SmartSpell(d,u) + " thousand " + result;
      
    }
    
    u = GetNextDigit();
    if (!done && u!=0){
    	result = SmartSpell(0,u) + " hundred " + result;
    }
    
    u = GetNextDigit();
    if (!done){
        d = GetNextDigit();
    	result = SmartSpell(d,u) + " million " + result;
    }
    
    u = GetNextDigit();
    if (!done && u!=0){
    	result = SmartSpell(0,u) + " hundred " + result;
    }
    
  }
  
  //returns next digit from a number (always the least significant digit)
  //activates the flag "done" when no more digits are left
  public int GetNextDigit(){
    int n = 0;
    if (num > 0) {
     	n = num % 10;
    	num = num / 10;
    } else {
    done = true;
    }
    return n;
  }
  
  
  // returns a string spelling numbers between 0 and 19
  public String SpellDigit(int num)
  {  
    switch(num){
     case 0:
      return "";     
     case 1:
      return "one";      
     case 2:
      return "two";       
     case 3:
      return "three";    
     case 4:
      return "four";      
     case 5: 
      return "five";      
     case 6: 
      return "six";      
     case 7: 
      return "seven";      
     case 8: 
      return "eight";      
     case 9: 
      return "nine";
     case 10: 
      return "ten";
     case 11: 
      return "eleven";
     case 12: 
      return "twelve";
     case 13: 
      return "thirteen";
     case 14: 
      return "fourteen";
     case 15: 
      return "fifteen";
     case 16: 
      return "sixteen";
     case 17: 
      return "seventeen";
     case 18: 
      return "eighteen"; 
     case 19: 
      return "nineteen";
    }
    
    return "error";
  }
  
  // returns string spelling the dezenas part of numbers higher than 19
  public String SpellDoubleDigit(int num)
  {
    switch(num){
     case 0:
      return "error";     
     case 1:
      return "error";      
     case 2:
      return "twenty";       
     case 3:
      return "thirty";    
     case 4:
      return "forty";      
     case 5: 
      return "fifty";      
     case 6: 
      return "sixty";      
     case 7: 
      return "seventy";      
     case 8: 
      return "eighty";      
     case 9: 
      return "ninety";
    }
    
    return "error";
  }
  
  // given a number from 1 till 99, with dezenas part d and unidade part u, it decides which method to use and spells it correctly
  // returns string spelling the number from 1 up to 99
  public String SmartSpell(int d, int u)
  {
   int num =d*10 + u;			// full number
   String str = "";

     
   if (num<20){
	str = SpellDigit(num);					// 1 till 19
    }
    else {
      str = SpellDoubleDigit(d);				// 20 30 40 50 60....
      
      if (u!=0){
       str = str + "-" + SpellDigit(u); 	// 2x 3x 4x 5x 6x... (x!=0)
      }
    
    }
    return str;
  }
  
  // returns final result
  public String spell()
  {
    return result;
 }
  
}
