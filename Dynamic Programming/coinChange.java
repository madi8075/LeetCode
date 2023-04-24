import java.util.Arrays;
// Incomplete... Need to re make as dp
public class coinChange {
	static int partition(int[] coins, int low, int high) {
		int pivot = coins[high];
		int temp = 0;
		int i = low - 1;

		for (int j = low; j < high; j++) {
			if (coins[j] < pivot) {
				i++;
				temp = coins[i];
				coins[i] = coins[j];
				coins[j] = temp;
			}
		}
		i++;
		temp = coins[i];
		coins[i] = coins[high];
		coins[high] = temp;
		return i;
	}
	static void quickSort(int coins[], int low, int high){
		if (low < high){
			int partIndex = partition(coins, low, high);
			quickSort(coins, low, partIndex - 1);
			quickSort(coins, partIndex + 1, high);
		}
	}

	public static int coinChange(int[] coins, int amount)
	{
		int numCoins = 0;
		int thisCoin = 0;
		quickSort(coins, 0, coins.length - 1);
		for(int i = coins.length - 1; i >= 0; i--)
		{
			thisCoin = amount / coins[i];
			amount -= thisCoin * coins[i];
			numCoins += thisCoin;
			if(amount == 0)
				return numCoins;
		}
		return -1;
	}

	public static void main(String args[])
	{
		int[] coins = {186, 419, 83, 408};
		System.out.println(coinChange(coins, 11));
	}
}
