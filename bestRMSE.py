#f=open('bestresult.txt','r').readline() #read the first line
#print f
#print "====="
#g=open('bestresult.txt','r').readlines() #read the all file
#print g

month='201507'

file_path="../../data/sensor/SVM_sampling/"+month+"/"
bestresult=file_path+"bestresult.txt"
outresult=file_path+"gridSearch_bestResult.txt"
f=open(outresult,'w')
g=open(bestresult,'r').readlines()
#m=open('bestresult.txt','r').read()
#print len(g)
tmp=[]
tmp_2=[]
number=0.0
c=1
gamma=1
for line in g:
    tmp.append(line[34:-2])
for j in range(0,9):
    for i in range(j,len(g),10):
        number+=float(tmp[i])
    number=number/10.0
    print ("The average RMSE of c=%d gamma=%d is %f" % (c,gamma,number))
    f.write("The average RMSE of c=%d gamma=%d is %f" % (c,gamma,number))
    f.write("\n")
    tmp_2.append(number)
    number=0.0
    c+=3 
    if (c==10):
        c=1
    if (j%3==2):
        gamma+=1
        if gamma==4:
            gamma=1
       
f.close()
tmp_num=tmp_2[0]
count=0
count_2=0
count_3=0
for i in range(0,8):
    if (tmp_2[i]>=tmp_2[i+1]):
        tmp_num=tmp_2[i+1]
        count=i+1
count=count+1
#print "count=",count
print "The minimum RMSE =",tmp_num
if count%3==1:
    c=1
elif count%3==2:
    c=4
else: 
    c=7
count_2=count/3
if count_2==0:
   gamma=1
elif count_2==1:
   gamma=2
else: 
    gamma=3
print "The best c={}, gamma={}".format(c,gamma)
f=open(outresult,'w')
c=str(c)
gamma=str(gamma)
tmp_num=str(tmp_num)
f.write(c)
f.write("\n")
f.write(gamma)
f.write("\n")
f.write(tmp_num) #minumum RMSE
print ("Remember to check /SVM_sampling/%s/bestresult.txt has the right number of data" % month)
