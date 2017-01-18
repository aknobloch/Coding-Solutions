# Aaron Knobloch
# 2/2/2016
# https://projecteuler.net/problem=6

num_list = range(1,101)

# find the sum of the square of all numbers 1-100
sum_squares = 0

for num in num_list : 
	
	sum_squares += num**2
	
square_sum = 0

# find the square of the sum of all numbers 1-100
for num in num_list :
	
	square_sum += num
	
square_sum = square_sum**2

# print the difference in these values
print(square_sum - sum_squares)