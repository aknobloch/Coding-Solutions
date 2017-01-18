# Aaron Knobloch
# 2/2/2016
# https://projecteuler.net/problem=7

import sys


prime_nums = [2, 3]

# if the number is divisible by any preceding primes, it is not prime
# if the number is not, it must be prime itself.
def isPrime(num) :

	for x in prime_nums :
	
		if num % x == 0 :
			
			return False
			
	return True

# iterate through numbers up to the max number possible, stopping when finding the 10,001st
for x in range(4,sys.maxsize) :
	
	if isPrime(x) : 
		
		prime_nums.append(x) 
		
		print(x)
	
print(prime_nums[-1])