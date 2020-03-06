package queueDriver;

import java.util.Random;

/**
 * Simulate print queues and print jobs assigned to queues. Shorter print jobs
 * are handled first.
 * 
 * @author (sdb)
 * @version (Dec 2018)
 */
public class PrintPriorityQueues {
	private Printer printer1;

	public static void main(String[] args) {
		PrintPriorityQueues printer = new PrintPriorityQueues();
		printer.testPrinters();
	}
	 
	public PrintPriorityQueues() {
		printer1 = new Printer(3, "ROB 312"); // print speed is 3 blocks per step
	}

	public void testPrinters() {
		printer1.add(new Doc(13));
		printer1.add(new Doc(7));
		printer1.add(new Doc(5));

		for (int i = 0; i < 3; i++) // 3 steps
			printer1.print();

		printer1.add(new Doc(12));

		for (int i = 0; i < 25; i++) // 25 more steps
			printer1.print();
	}

}
