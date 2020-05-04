public class MasterThread {

	private SlaveThreads[] partialSums;
	private int numOfThreads;
	
	public MasterThread(int numOfThreads) {
		this.partialSums = new SlaveThreads[numOfThreads];
		this.numOfThreads = numOfThreads;
	}
	
	public double parallelSum(double[] numsArr) {
		
                //The work that every thread will be do 
		int size = (int)Math.ceil(numsArr.length / numOfThreads);
		
                //Give each thread to summation intervals
		for (int i = 0; i < numOfThreads; i++) {
			partialSums[i] = new SlaveThreads(numsArr, i * size, (i + 1) * size);
			partialSums[i].start();
		}

		try {
			for (SlaveThreads sum : partialSums) {
				sum.join();
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		double total = 0;

		for (SlaveThreads sum : partialSums) {
			total += sum.getPartialSum();
		}

		return total;
	}
}
