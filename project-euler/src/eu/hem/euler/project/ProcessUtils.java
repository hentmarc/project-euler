package eu.hem.euler.project;

import java.time.Duration;

public class ProcessUtils {

	public static long cpuDuration() {
		return ProcessHandle.current().info().totalCpuDuration().orElse(Duration.ofMillis(0)).toMillis();
	}
	
	public static void printDuration() {
		System.out.println("duration=" + cpuDuration() + "ms");
	}
}
