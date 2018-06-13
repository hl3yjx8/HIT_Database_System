package com.function;  
  
import java.sql.ResultSet;  
import java.sql.SQLException;
import java.util.Scanner;
import com.mysql.DBHandler;  
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
  
public class EX2_main {  
  
    static String sql = null;  
    static DBHandler db1 = null;  
    static ResultSet ret = null;  
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  
    public static void task1() throws IOException
    {
    	System.out.print("请输入项目号:");
    	String PNO = br.readLine();
    	sql = "select ESSN from project,employee where employee.DNO=project.DNO and PNO='"+ PNO +"'";//SQL语句  
        db1 = new DBHandler(sql);//创建DBHelper对象  
         try {  
             ret = db1.pst.executeQuery();//执行语句，得到结果集 
             if(!ret.next())
            	 System.out.println("查询不到信息");
             while (ret.next()) {  
                 String ESSN = ret.getString(1);  
                 System.out.println(ESSN);  
                 
             }//显示数据 
             System.out.print("\n");
             ret.close();  
             db1.close();//关闭连接  
         } catch (SQLException e) {  
             e.printStackTrace();  
         }  
     }  
    
    public static void task2() throws IOException
    {
    	System.out.print("请输入项目名称:");
    	String PNAME = br.readLine();
    	sql = "select ENAME from project,employee where employee.DNO=project.DNO and PNAME='"+ PNAME +"'";//SQL语句  
        db1 = new DBHandler(sql);//创建DBHelper对象  
         try {  
             ret = db1.pst.executeQuery();//执行语句，得到结果集 
             if(!ret.next())
            	 System.out.println("查询不到信息");
             while (ret.next()) {  
                 String ENAME = ret.getString(1);  
                 System.out.println(ENAME);  
             }//显示数据 
             System.out.print("\n");
             ret.close();  
             db1.close();//关闭连接  
         } catch (SQLException e) {  
             e.printStackTrace();  
         }  
     }
    
    public static void task3() throws IOException
    {
    	System.out.print("请输入部门名称:");
    	String DNAME = br.readLine();
    	sql = "select ENAME,ADDRESS from department,employee where employee.DNO=department.DNO and DNAME='"+ DNAME +"'";//SQL语句  
        db1 = new DBHandler(sql);//创建DBHelper对象  
         try {  
             ret = db1.pst.executeQuery();//执行语句，得到结果集 
             if(!ret.next())
            	 System.out.println("查询不到信息");
             while (ret.next()) {  
                 String ENAME = ret.getString(1); 
                 String ADDRESS = ret.getString(2);
                 System.out.println(ENAME + "\t" + ADDRESS);  
             }//显示数据 
             System.out.print("\n");
             ret.close();  
             db1.close();//关闭连接  
         } catch (SQLException e) {  
             e.printStackTrace();  
         }  
     }
    
    public static void task4() throws IOException
    {
    	System.out.print("请输入部门名称:");
    	String DNAME = br.readLine();
    	System.out.print("请输入工资:");
    	String SALARY = br.readLine();
    	sql = "select ENAME,ADDRESS from department,employee where employee.DNO=department.DNO"
    			+ " and SALARY<"+SALARY+" and DNAME='"+ DNAME +"'";//SQL语句  
        db1 = new DBHandler(sql);//创建DBHelper对象  
         try {  
             ret = db1.pst.executeQuery();//执行语句，得到结果集
             if(!ret.next())
            	 System.out.println("查询不到信息");
             while (ret.next()) {  
                 String ENAME = ret.getString(1); 
                 String ADDRESS = ret.getString(2);
                 System.out.println(ENAME + "\t" + ADDRESS);  
             }//显示数据 
             System.out.print("\n");
             ret.close();  
             db1.close();//关闭连接  
         } catch (SQLException e) {  
             e.printStackTrace();  
         }  
     }
    
    public static void task5() throws IOException
    {
    	System.out.print("请输入项目编号:");
    	String PNO = br.readLine();
    	sql = "select ENAME from employee where ESSN not in (select ESSN from works_on where PNO='"+ PNO +"')";//SQL语句  
        db1 = new DBHandler(sql);//创建DBHelper对象  
         try {  
             ret = db1.pst.executeQuery();//执行语句，得到结果集 
             if(!ret.next())
            	 System.out.println("查询不到信息");
             while (ret.next()) {  
                 String ENAME = ret.getString(1); 
                 System.out.println(ENAME);  
             }//显示数据 
             System.out.print("\n");
             ret.close();  
             db1.close();//关闭连接  
         } catch (SQLException e) {  
             e.printStackTrace();  
         }  
     }
    
    public static void task6() throws IOException
    {
    	System.out.print("请输入领导名字:");
    	String MNAME = br.readLine();
    	sql = "select ENAME,DNAME from employee,department where employee.DNO=department.DNO and "+
    		"employee.SUPERSSN=department.MGRSSN and employee.SUPERSSN in (select ESSN from employee "+
    		"where ENAME='"+MNAME+"')";
        db1 = new DBHandler(sql);//创建DBHelper对象  
         try {  
             ret = db1.pst.executeQuery();//执行语句，得到结果集 
             if(!ret.next())
            	 System.out.println("查询不到信息");
             while (ret.next()) {  
                 String ENAME = ret.getString(1); 
                 String DNAME = ret.getString(2); 
                 System.out.println(ENAME + "\t" + DNAME);  
             }//显示数据 
             System.out.print("\n");
             ret.close();  
             db1.close();//关闭连接  
         } catch (SQLException e) {  
             e.printStackTrace();  
         }  
     }
    
    public static void task7() throws IOException
    {
    	System.out.print("请输入项目编号:");
    	String Pro1 = br.readLine();
    	String Pro2 = br.readLine();
    	sql = "select ESSN from works_on where PNO='"+Pro1+
    		"' and ESSN in (select ESSN from works_on where PNO='"+Pro2+"')";
    		
        db1 = new DBHandler(sql);//创建DBHelper对象  
         try {  
             ret = db1.pst.executeQuery();//执行语句，得到结果集 
             if(!ret.next())
            	 System.out.println("查询不到信息");
             while (ret.next()) {  
                 String ESSN = ret.getString(1); 
                 System.out.println(ESSN);  
             }//显示数据 
             System.out.print("\n");
             ret.close();  
             db1.close();//关闭连接  
         } catch (SQLException e) {  
             e.printStackTrace();  
         }  
     }
    
    public static void task8() throws IOException
    {
    	System.out.print("请输入工资:");
    	String SALARY = br.readLine();
    	sql = "select DNAME from department where DNO in "
    			+ "(select DNO from employee group by DNO having AVG(SALARY)<"+SALARY+")";
    		
        db1 = new DBHandler(sql);//创建DBHelper对象  
         try {  
             ret = db1.pst.executeQuery();//执行语句，得到结果集 
             if(!ret.next())
            	 System.out.println("查询不到信息");
             while (ret.next()) {  
                 String DNAME = ret.getString(1); 
                 System.out.println(DNAME);  
             }//显示数据 
             System.out.print("\n");
             ret.close();  
             db1.close();//关闭连接  
         } catch (SQLException e) {  
             e.printStackTrace();  
         }  
     }
    
    public static void task9() throws IOException
    {
    	System.out.print("请输入项目数:");
    	String N = br.readLine();
    	System.out.print("请输入时间总额:");
    	String HOURS = br.readLine();
    	sql = "select ENAME from employee natural join works_on group by ENAME "+
    		"having sum(HOURS)<"+HOURS+" and count(PNO)>="+N;
    		
        db1 = new DBHandler(sql);//创建DBHelper对象  
         try {  
             ret = db1.pst.executeQuery();//执行语句，得到结果集 
             if(!ret.next())
            	 System.out.println("查询不到信息");
             while (ret.next()) {  
                 String ENAME = ret.getString(1); 
                 System.out.println(ENAME);  
             }//显示数据 
             System.out.print("\n");
             ret.close();  
             db1.close();//关闭连接  
         } catch (SQLException e) {  
             e.printStackTrace();  
         }  
     }
    
    public static void menu()
    {
    	System.out.print("\n*****************************\n");
    	System.out.print("1。查询参加了项目编号为PNO的项目的员工号\n");
    	System.out.print("2。查询参加了项目名为PNAME的员工名字\n");
    	System.out.print("3。查询在DNAME工作的所有工作人员的名字和地址\n");
    	System.out.print("4。查询在DNAME工作且工资低于SALARY元的员工名字和地址\n");
    	System.out.print("5.查询没有参加项目编号为PNO的项目的员工姓名\n");
    	System.out.print("6.查询由ENAME领导的工作人员的姓名和所在部门的名字\n");
    	System.out.print("7.查询至少参加了项目编号为PNO1和PNO2的项目的员工号\n");
    	System.out.print("8.查询员工平均工资低于SALARY元的部门名称\n");
    	System.out.print("9.查询至少参与了N个项目且工作总时间不超过HOURS小时的员工名字\n");
    	System.out.print("0。结束程序\n");
    	System.out.print("请输入选项:\n");
    }
    
    public static void main(String[] args) throws IOException {  
    	System.out.print("实验二:使用高级语言操作MySQL数据库");
    	Scanner in = new Scanner(System.in);
    	boolean flag = true;
    	while(flag)
    	{
	    	menu();
	    	int choose = in.nextInt();
	    	switch(choose)
	    	{
		    	case 1:task1();break;
		    	case 2:task2();break;
		    	case 3:task3();break;
		    	case 4:task4();break;
		    	case 5:task5();break;
		    	case 6:task6();break;
		    	case 7:task7();break;
		    	case 8:task8();break;
		    	case 9:task9();break;
		    	case 0:flag=false;System.out.print("谢谢使用");break;
			    default:
			    	System.out.print("输入错误\n");
	    	}
    	}
    }
}