# Aaron Knobloch
# 2/2/2016
# https://projecteuler.net/problem=4

# Generate numbers 100-999 to multiplyy
list_one = range(100,1000)
list_two = range(100,1000)

max_num = 9009

# Checks if number is palindrome
def isPalindrome(val) :

	num = str(val)
	
	if num[0:] == num[-1::-1] :
		return True
		
	return False

	
# start at the -1st value of list one (999)
for x in range(1, len(list_one)) :
	
	# start at the -1st value of list two (999)
	for j in range(1, len(list_two)) :
		
		# reverse iterate through list two, multiplying every value by the value at list one current index
		# check if the value is greater than current max palindrome first to save time. 
		# if it is, then check palindrome. 
		if (list_one[-x] * list_two[-j]) > max_num and isPalindrome(list_one[-x] * list_two[-j]) :
		
			max_num = list_one[-x] * list_two[-j]
			

print(max_num)