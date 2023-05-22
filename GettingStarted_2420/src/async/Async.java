package async;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Async {

	public static int square(int n) {
		return n * n;
	}

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		ExecutorService threadpool = Executors.newCachedThreadPool();
		int number = 20;
		Future<Integer> futureTask = threadpool.submit(() -> square(number));

		while (!futureTask.isDone()) {
			System.out.println("FutureTask is not finished yet...");
		}
		Integer result = futureTask.get();

		System.out.println("Result = " + result);

		threadpool.shutdown();
	}
}
