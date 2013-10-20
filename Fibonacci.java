import java.util.*;	

class Fibonacci 
{

	public static void main(String[] args)
	{
		int n = Integer.parseInt(args[0]);
		//Memoized version 
		long startTime2 = System.currentTimeMillis();
		
		System.out.println("mem_fib(" + n + ") = " + (memoized_fib(n)));
		
		long endTime2 = System.currentTimeMillis();

		System.out.println("Total execution time for memoized version: " + (endTime2 - startTime2) );


		//Normal version 
		long startTime = System.currentTimeMillis();
		
		System.out.println("fib(" + n + ") = " + fib(n));
		
		long endTime = System.currentTimeMillis();

		System.out.println("Total execution time for normal version: " + (endTime - startTime) );
		
	}

	//Fibonacci sequence 
	public static long fib(int n)
	{
		if (n == 0 || n == 1) return n; 
		
		return fib(n-1) + fib(n - 2); 
	}
	

	//Fibonacci memoization 
	private static long fib_help(int n, HashMap<Integer, Long> map)
	{
		if (n == 0 || n == 1) return n; 
		
		if (!map.containsKey(n)) map.put(n, fib(n-1) + fib(n - 2));  

		return map.get(n); 
	}
	public static long memoized_fib(int n)
	{
		HashMap<Integer, Long> map = new HashMap<Integer, Long>(); 
		map.put(0, (long) 0);
		map.put(1, (long) 1); 
		
		return fib_help(n, map); 
	}

}

