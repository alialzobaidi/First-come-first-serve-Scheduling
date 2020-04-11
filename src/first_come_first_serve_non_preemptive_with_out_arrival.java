import java.util.Scanner;

public class first_come_first_serve_non_preemptive_with_out_arrival {

	private static float sumwait, sumturn;
	private static int n, CpuTime, ar[], br[], wait_time[], turn_time[];
	private static String id[];
	private static Scanner r;

	public static void main(String[] args) {
		r = new Scanner(System.in);
		System.out.println("input number process");
		n = r.nextInt();
		ar = new int[n];
		br = new int[n];
		wait_time = new int[n];
		turn_time = new int[n];
		id = new String[n];

		read();
		fcfs();
		print();
	}

	private static void read() {
		for (int i = 0; i < n; i++) {
			System.out.println("input name ID and BursTime");
			id[i] = r.next();
			ar[i] = 0;
			br[i] = r.nextInt();
		}

	}

	private static void fcfs() {
		for (int i = 1; i < n; i++) {

			CpuTime += br[i - 1];
			wait_time[i] = CpuTime - ar[i];
			sumwait += wait_time[i];
			if (i == 1) {
				wait_time[0] = 0;
				turn_time[i - 1] = wait_time[i - 1] + br[i - 1];
				sumturn += turn_time[i - 1];
			}
			turn_time[i] = wait_time[i] + br[i];
			sumturn += turn_time[i];

		}
	}

	private static void print() {

		System.out.println("Process \t ArTime \t BTime \t WaitTime \t TurnTime");
		for (int i = 0; i < n; i++) {
			System.out.println(
					"   " + id[i] + "\t\t" + ar[i] + "\t\t" + br[i] + "\t\t" + wait_time[i] + "\t\t" + turn_time[i]);

		}
		System.out.println("Avwait_time :" + sumwait / n + "\nAvturn_time :" + sumturn / n);

	}

}
