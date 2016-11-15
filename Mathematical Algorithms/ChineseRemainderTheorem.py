def chinese_remainder(n,a):
	sum=0
	prod=reduce(lambda a,b:a*b,n)

	for n_i,a_i in zip(n,a):
		p=prod/n_i
		sum+=a_i*mul_inv(p,n_i)*p
	return sum%prod

def mul_inv(a,b):
	for i in range(b):
		if a*i%b==1:
			print i
			return i


if __name__ == '__main__':
	N=int(raw_input('Enter number of equations'))
	n=[]
	a=[]

	for i in range(N):
		tmp=int(raw_input('Enter n '+str(i)))
		n.append(tmp)
	for i in range(N):
		tmp=int(raw_input('Enter a '+str(i)))
		a.append(tmp)
	print n,a
	print chinese_remainder(n,a)