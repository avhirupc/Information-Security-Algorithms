
def GCD():
	x=int(raw_input("Enter number1 :"))
	y=int(raw_input("Enter number2 :"))
	x=euclidean_gcd(x,y)		
	print x	
	return True

def GCDExtendedEuclidean():
	x=int(raw_input("Enter number1 :"))
	y=int(raw_input("Enter number2 :"))
	x,t1,t2=extended_euclidean(x,y)		
	print(x)	

def euclidean_gcd(a,b):
	print(a,b)
	if(b==0):
		return a
	return euclidean_gcd(b,a%b)

def extended_euclidean(x,y):
	r1=x
	r2=y
	r=0
	q=0
	s1=1
	s2=0
	s=0
	t1=0
	t2=1
	t=0
	ex_t2=0
	ex_t=0
	print("q r1 r2 r s1 s2 s t1 t2 t ")
	while True:
		if(r2==0 ):
			#s=s1-q*s2
			#s1=s2
			#s2=s
			ex_t2=t1
			ex_t=t2
			#t=t1-t2*s1
			#t1=t2
			#t2=t
			break
		#print(r1,r2)
		q=int(r1/r2)
		r=r1%r2
		s=s1-q*s2
		t=t1-t2*q
		print(q,r1,r2,r,s1,s2,s,t1,t2,t)
		r1=r2
		r2=r
		s1=s2
		s2=s
		t1=t2
		t2=t
	s=s1
	t=t1
	#print s,t
	#print s*x+t*y
	return s*x+t*y,ex_t2,ex_t

def MultiplicativeInverse():
	x=int(raw_input("Enter number1 :"))
	y=int(raw_input("Enter number2 :"))
	gcd,t2,t=extended_euclidean(x,y)
	if(not gcd==1):
		print("MultiplicativeInverse not possible")
		return
	print t2,t
	
	if(t2<0):
		print("Possible Inverses are",t2,t2+t)
	else:
		print("Possible Inverses are",t2%t) 



options = {1 : GCD,
           2 : GCDExtendedEuclidean,
           3 : MultiplicativeInverse,
}




#main code
while(True):
	print ("Menu:\n1:Euclidean GCD\n2:GCD Extended Euclidean\n3:Multiplicative Inverse\n4:Exit")
	opt=int(raw_input())
	if(opt==4):
		break
	options[opt]()

