public class SlaveThreads extends Thread {

	private double[] nums;
	private int low;
	private int high;
	
	private double partialSum;

	public SlaveThreads(double[] nums, int low, int high) {
		this.nums = nums;
		this.low = low;
		this.high = Math.min(high, nums.length);
	}

	public double getPartialSum() {
		return partialSum;
	}

	@Override
	public void run() {
		
		partialSum = 0;

		for (int i = low; i < high; i++) {
			partialSum += nums[i];
		}
	}
}
