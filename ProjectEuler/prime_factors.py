# Jory Alexander
# Aaron Knobloch
# 2/2/2016
# https://projecteuler.net/problem=3

import sys

factor_list = []
numbers_list = [int(sys.argv[1])]

# while there are numbers in the list to process
while len(numbers_list) > 0 :
	
	# get next number on list
	num = numbers_list[0]
	
	# if the number is less than or equal to three, must be prime.
	if num <= 3 :
		factor_list.append(num)
		numbers_list.remove(num)
		
	# iterate starting with 2 up to half the number
	for x in range(2, int((num / 2) + 1) ) :
		
		if num % x == 0 :
			
			# If divisable, then add quotient and divisor into numbers to process and remove dividend
			numbers_list.remove(num)
			numbers_list.append(num / x)
			numbers_list.append(x)
			break
		
		elif x >= int(num / 2) :
			
			# If you reach num / 2, numbers must be prime. Remove and add to prime list
			numbers_list.remove(num)
			factor_list.append(num)
			

# print all factors
#print(factor_list)

#print max factor
print(max(factor_list))

