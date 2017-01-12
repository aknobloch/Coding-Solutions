# Aaron Knobloch
# 2/10/2016
# https://projecteuler.net/problem=10

prime_list = [2,3,5,7,11,13]


for x in range (14, 2000000) :

	for i in range(0,len(prime_list)) :
		
		if x % prime_list[i] == 0 :
		
			break
		
		if prime_list[i]**2 > x :
		
			prime_list.append(x)
			break
			
			
			

print("Done")
print("Sum: " + str(sum(prime_list)))