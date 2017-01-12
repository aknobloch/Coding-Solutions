# Aaron Knobloch 
# 2/09/2016
# https://projecteuler.net/problem=9


from math import sqrt
import sys

for b in range(0,500) :

	for a in range(0, b) :
	
		if(a + b + sqrt(a**2 + b**2) == 1000) :

			print(str(a))
			print(str(b))
			print(str(sqrt(a**2 + b**2)))
			sys.exit()
			
			
