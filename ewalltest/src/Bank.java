
public class Bank {
	private double bankBalance;
	
	public double getBalance() {
		return bankBalance;
	}

	public void setBalance(double recharge) {
		this.bankBalance = recharge;
	}
	public double getCredits(double credits){
		if(bankBalance>credits){
		this.bankBalance -= credits;
		return credits;
		}else
			return 0;
	}
	
}
