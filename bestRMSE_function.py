#!/usr/bin/env python
import sys
#f=open('bestresult.txt','r').readline() #read the first line
#print f
#print "====="
#g=open('bestresult.txt','r').readlines() #read the all file
#print g

## =========================
## FUNC: choose best c,gamma
## =========================

def bestResult(Month,c_step):
    month=Month 
    c=float(c_step)
    #print type(Month),type(c_step)
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
    if c_step=='3':
        c_step=float(c_step)
    #    print 'c_step=3'
        c=1.0
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
    elif c_step=='5':
        c=float(c_step)
#        print 'c_step=5'
        c=1.0
        gamma=1
        for line in g:
            tmp.append(line[35:-2])
        for j in range(0,9):
            for i in range(j,len(g),10):
                number+=float(tmp[i])
            number=number/10.0
            print ("The average RMSE of c=%d gamma=%d is %f" % (c,gamma,number))
            f.write("The average RMSE of c=%d gamma=%d is %f" % (c,gamma,number))
            f.write("\n")
            tmp_2.append(number)
            number=0.0
            c+=5 
            if (c==16):
                c=1
            if (j%3==2):
                gamma+=2
                if gamma==7:
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
        print "The minimum RMSE =",tmp_num
        #print 'count= ',count
        if count%3==1:
            c=1
        elif count%3==2:
            c=6
        else: 
            c=11
        count_2=count/3
        if count_2==0:
           gamma=1
        elif count_2==1:
           gamma=3
        else: 
            gamma=5
        print "The best c={}, gamma={}".format(c,gamma)
        f=open(outresult,'w')
        c=str(c)
        gamma=str(gamma)
        tmp_num=str(tmp_num)
        f.write(c)
        f.write("\n")
        f.write(gamma)
        f.write("\n")
        f.write(tmp_num)

## =======================
## Check Input Parameters
## =======================
#print len(sys.argv)
if len(sys.argv) != 3:
  print "FORMAT: month c_step"
  exit()
Month = sys.argv[1]
print "> month=%s" % (Month)
c_step = sys.argv[2]
print "> c_step=%s" % (c_step)


#input_dir = "../../data/sensor/SVM_sampling/"
#output_dir ="../../data/sensor/SVM_sampling/"

#input_dir = input_dir + mon + "/"
#output_dir = output_dir + mon + "/"




## ====================
## Main 
## ==================== 

bestResult(Month,c_step)




print ("Remember to check /SVM_sampling/%s/bestresult.txt has the right number of data" % Month)
