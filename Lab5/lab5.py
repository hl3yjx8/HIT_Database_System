
# -*- coding: utf-8 -*-
class tree:
    def __init__(self):
        self.thing = ''
        self.condition=''
        self.lchild=-1
        self.rchild=-1

def draw(new):
    for i in new:
        if i.thing=='sel' or i.thing=='Pro':
            print '             ',i.thing,i.condition
            print '                   '
            print '                       |           '
        if i.thing=='Join':
            print '                     ',i.thing
            print '                 /             \ '
            print '             ',new[i.lchild].thing,new[i.lchild].condition,'         ',new[i.rchild].thing,new[i.rchild].condition

def opt(testquery):
    query_tree=tree()
    new = []
    for i in range(0,len(testquery)):
        if testquery[i]=='SELECT':
            query_tree=tree()
            query_tree.thing='sel'
            j=i
            while 1:
                if testquery[j]!=']':
                    j=j+1
                else:
                    break
            for q in range(i+2,j):
                query_tree.condition+=testquery[q]
            i=j+1
            new.append(query_tree)
            #print new.index(query_tree)
            if new.index(query_tree)!=0:
                new[-2].lchild=new.index(query_tree)
            continue
        elif testquery[i]=='PROJECTION':
            query_tree=tree()
            query_tree.thing='Pro'
            j=i
            while 1:
                if testquery[j]!=']':
                    j=j+1
                else:
                    break
            for q in range(i+2,j):
                query_tree.condition+=testquery[q]
            i=j+1
            new.append(query_tree)
            if new.index(query_tree)!=0:
                new[-2].lchild=new.index(query_tree)
            continue
        elif testquery[i]=='JOIN':
            query_tree=tree()
            query_tree.thing='Join'
            query_ltree=tree()
            query_ltree.thing=testquery[i-1].strip('(')
            query_rtree=tree()
            query_rtree.thing=testquery[i+1].strip(')')
            new.append(query_tree)
            new[-2].lchild=new.index(query_tree)
            query_tree.lchild=new.index(query_tree)+1
            query_tree.rchild=new.index(query_tree)+2
            new.append(query_ltree)
            new.append(query_rtree)

    draw(new)
    print "\n启发式优化"
    temp_S = []
    temp_P = []
    temp_chart = []
    flag=-1
    P=""
    for item in new:
        if item.thing == 'sel':
            T = []
            T=(item.condition.split('&'))
            for i in T:
                temp_S.append(i)
        if item.thing == 'Pro':
            flag+=1
            T = []
            T=(item.condition.split(','))
            for i in T:
                temp_P.append(i)
        elif item.thing =='Join':
            temp_chart.append(new[item.lchild].thing)
            temp_chart.append(new[item.rchild].thing)
            if (flag!=-1):
                P='DNO->'


    for guanxi in temp_chart:
        h=0
        if temp_chart.index(guanxi) != 0:#从第二个关系开始
            if(flag!=-1):
                for pro_shuxing in temp_P:
                    print pro_shuxing,
                    h+=1;
                    if(h!=len(temp_P)):
                        print ",",
            print '->',
            print "join<"
        print "     ",
        for sel_shuxing in temp_S:#输出一行的关系,用字典进行判断
            T = []
            T = sel_shuxing.split('=')
            if T[0] in dic[guanxi]:
                print sel_shuxing,"->",
            
        for pro_shuxing in temp_P:
            T = []
            T = pro_shuxing.split('=')
            if T[0] in dic[guanxi]:
                print pro_shuxing,",",
        print P,

        print "(",guanxi,")"#输出关系

    print "\n======================================================\n"

sql1 = "SELECT [ ENAME = 'Mary' & DNAME = 'Research' ] ( EMPLOYEE JOIN DEPARTMENT )"
sql2 = "PROJECTION [ BDATE ] ( SELECT [ ENAME = 'John' & DNAME = 'Research' ] ( EMPLOYEE JOIN DEPARTMENT ) )"
sql3 = "SELECT [ ESSN = '01' ] ( PROJECTION [ ESSN , PNAME ] ( WORKS_ON JOIN PROJECT ) )"

dic = dict()
fp = open("./table.txt",'r')
for line in fp.readlines():
    line = line.strip()
    line = line.split(',')
    dic[line[0]]=[]
    for i in range(1,len(line)):
        dic[line[0]].append(line[i])
fp.close()
print(dic)
opt(sql1.split(' '))
opt(sql2.split(' '))
opt(sql3.split(' '))
