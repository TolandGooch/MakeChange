/* In the cash register we will calculate the amount of change returned to a 
* customer based on the purchase price and the amount tendered. We will also 
* notify the attendant how many of each piece of currency ($20 ,$10 ,$5 ,$1, 
* .25c, .10c, .05c, .01c) is needed to make the change for the customer. 
* Change should be provided using the largest bill and coin denominations as 
* possible. Denominations that are not used should not be displayed.
* 
* Grading
*
* This is a graded project. You are expected to have your project completed 
* by the start of class on Monday morning.
*
* You will be given either a pass or fail based on whether your code works 
* given all of the following test conditions:
*
*Amount: .67, Tendered: .50, Result: Error message
*Amount: .67, Tendered: 1.00, Result: 1 quarter, 1 nickel, 3 pennies.
*Amount: .59, Tendered: 1.00, Result: 1 quarter, 1 dime, 1 nickel, 1 penny.
*Amount: 3.96, Tendered: 20.00, Result: 1 ten dollar bill, 1 five dollar bill, 
*		1 one dollar bill, 4 pennies.
* 
*/
package change;
import java.util.Scanner;
import java.lang.Math;

public class CashRegister {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		float tender = 0F;

		System.out.print(" Please enter the tender the customer provided: $");
		tender = scanner.nextFloat();
		
		float returnMoney = customerMoney(tender, scanner);
		// System.out.println(returnMoney);  // debug statement
		float tenderOut = customerCash(returnMoney);
		
	}

	// The user is prompted asking for the price of the item.
	public static float customerMoney(float tender, Scanner scanner) {
		float costOfPurchase = -10F;
		float customerChange = -10F;

		// System.out.println(tender); // debug statement
		while (tender <= 0) {
			System.out.print(" Please re-enter the tender for your purchase: $");
			tender = scanner.nextFloat();
		}

		// The user is then prompted asking how much money was tendered by the
		// customer.
		if (tender > 0) {
			System.out.print(" Please provide the total cost of this items: $");
			costOfPurchase = scanner.nextFloat();
			while (costOfPurchase <= 0F) {
				System.out.print(" Please re-enter the total of purchase: $");
				costOfPurchase = scanner.nextFloat();
			}
		}
		customerChange = tender - costOfPurchase;

		// Display an appropriate message if the customer provided too little
		// money
		// or the exact amount.
		if (customerChange < 0) {
			float additionalMoney = 0F;
			// System.out.println(customerChange); // debug statement
			System.out.println(" Please provide additional amount of $" + -customerChange);
			System.out.print(" Additional tender provided $");
			additionalMoney = scanner.nextFloat();
			tender = tender + additionalMoney;
			customerChange = tender - costOfPurchase;
			System.out.println(customerChange);
		}
		return customerChange;
	}

	// If the amount tendered is more than the cost of the item, display the
	// number of bills and coins that should be given to the customer.
	public static float customerCash(float returnMoney) {
		int twenty = 0;
		int ten = 0;
		int five = 0;
		int one = 0;
		double quarter = 0;
		double dime = 0;
		double nickel = 0;
		double penny = 0;

		// System.out.println("1:" + returnMoney); // debug statement
		while (returnMoney > 20) {
			twenty++;
			returnMoney = returnMoney - 20;
		//	System.out.println(twenty); // debug statement
		}
		// System.out.println("2:" + returnMoney); // debug statement
		while (returnMoney > 10) {
			ten++;
			returnMoney = returnMoney - 10;
		//	System.out.println(ten); // debug statement
		}
		// System.out.println("3:" + returnMoney); // debug statement
		while (returnMoney > 5) {
			five++;
			returnMoney = returnMoney - 5;
		//	System.out.println(five); // debug statement
		}
		// System.out.println("4:" + returnMoney); // debug statement
		while (returnMoney >= 1) {
			one++;
			returnMoney = returnMoney - 1;
		//	System.out.println(one); // debug statement
		}
		// System.out.println("5:" + returnMoney); // debug statement	
		while ( returnMoney < 1.00 && returnMoney >= 0.25 ){
			quarter++;
			returnMoney = (float)((returnMoney - 0.25) %  0.25);
		//	System.out.println(quarter); // debug statement
		}	
		// System.out.println("6:" + returnMoney); // debug statement		
		while ( returnMoney < 0.25 && returnMoney >= 0.10 ){
			dime++;
			returnMoney = (float)((returnMoney - 0.10) % 0.10);
		//	System.out.println(dime); // debug statement
		}		
		returnMoney = (float)(Math.round(returnMoney * 100.0) / 100.0);
		// System.out.println("7:" + returnMoney); // debug statement	
		while ( returnMoney < 0.10 && returnMoney >= 0.05){
			nickel++;
			returnMoney = (float)((returnMoney - 0.05) % 0.05);
		//	System.out.println(nickel); // debug statement
		}	
	
		returnMoney = (float)(Math.round(returnMoney * 100.0) / 100.0);
		// System.out.println("8:" + returnMoney); // debug statement		
		while ( returnMoney < 0.05 && returnMoney >= .00){
			penny++;
			returnMoney = (float)(returnMoney - 0.01);
		//	System.out.println(penny); // debug statement
		}		
		// System.out.print(twenty + "; "+ ten +"; "+  five + "; " + one +"; "+  quarter +"; "+  dime +"; "+  nickel +"; "+  penny); // debug statement
		System.out.print(" Results: ");
		if ( twenty > 0){
			System.out.print( twenty + " twenty dollar bill, ");
		}
		else {
		}
		if ( ten > 0){
			System.out.print( ten + " ten dollar bill, ");
		}
		else{
		}
		if ( five > 0){
			System.out.print( five + " five dollar bill, ");
		}
		else{
		}
		if ( one > 0){
			System.out.print( one + " one dollar bill, ");
		}
		else{
		}
		if ( quarter > 1){
			System.out.print( quarter + " quarters, ");
		}
		else if ( quarter == 1){
			System.out.print( quarter + " quarter, ");
		}
		else {
		}
		if ( dime > 1){
			System.out.print( dime + " dimes, ");
		}
		else if ( dime == 1){
			System.out.print( dime + " dime, ");
		}
		else {
		}
		if ( nickel > 1){
			System.out.print( quarter + " nickels, ");
		}
		else if ( nickel ==1){
			System.out.print( nickel + " nickel, ");
		}
		else {
		}
		if ( penny > 1){
			System.out.print( penny + " pennies.");
		}
		else if ( penny == 1 ){
			System.out.print( penny + " penny.");
		}
		else {
		}
		System.out.print("\b\b\.");
		
		

return returnMoney;
	} // end of customerCash method
	
} // end of program
