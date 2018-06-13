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
    	System.out.print("��������Ŀ��:");
    	String PNO = br.readLine();
    	sql = "select ESSN from project,employee where employee.DNO=project.DNO and PNO='"+ PNO +"'";//SQL���  
        db1 = new DBHandler(sql);//����DBHelper����  
         try {  
             ret = db1.pst.executeQuery();//ִ����䣬�õ������ 
             if(!ret.next())
            	 System.out.println("��ѯ������Ϣ");
             while (ret.next()) {  
                 String ESSN = ret.getString(1);  
                 System.out.println(ESSN);  
                 
             }//��ʾ���� 
             System.out.print("\n");
             ret.close();  
             db1.close();//�ر�����  
         } catch (SQLException e) {  
             e.printStackTrace();  
         }  
     }  
    
    public static void task2() throws IOException
    {
    	System.out.print("��������Ŀ����:");
    	String PNAME = br.readLine();
    	sql = "select ENAME from project,employee where employee.DNO=project.DNO and PNAME='"+ PNAME +"'";//SQL���  
        db1 = new DBHandler(sql);//����DBHelper����  
         try {  
             ret = db1.pst.executeQuery();//ִ����䣬�õ������ 
             if(!ret.next())
            	 System.out.println("��ѯ������Ϣ");
             while (ret.next()) {  
                 String ENAME = ret.getString(1);  
                 System.out.println(ENAME);  
             }//��ʾ���� 
             System.out.print("\n");
             ret.close();  
             db1.close();//�ر�����  
         } catch (SQLException e) {  
             e.printStackTrace();  
         }  
     }
    
    public static void task3() throws IOException
    {
    	System.out.print("�����벿������:");
    	String DNAME = br.readLine();
    	sql = "select ENAME,ADDRESS from department,employee where employee.DNO=department.DNO and DNAME='"+ DNAME +"'";//SQL���  
        db1 = new DBHandler(sql);//����DBHelper����  
         try {  
             ret = db1.pst.executeQuery();//ִ����䣬�õ������ 
             if(!ret.next())
            	 System.out.println("��ѯ������Ϣ");
             while (ret.next()) {  
                 String ENAME = ret.getString(1); 
                 String ADDRESS = ret.getString(2);
                 System.out.println(ENAME + "\t" + ADDRESS);  
             }//��ʾ���� 
             System.out.print("\n");
             ret.close();  
             db1.close();//�ر�����  
         } catch (SQLException e) {  
             e.printStackTrace();  
         }  
     }
    
    public static void task4() throws IOException
    {
    	System.out.print("�����벿������:");
    	String DNAME = br.readLine();
    	System.out.print("�����빤��:");
    	String SALARY = br.readLine();
    	sql = "select ENAME,ADDRESS from department,employee where employee.DNO=department.DNO"
    			+ " and SALARY<"+SALARY+" and DNAME='"+ DNAME +"'";//SQL���  
        db1 = new DBHandler(sql);//����DBHelper����  
         try {  
             ret = db1.pst.executeQuery();//ִ����䣬�õ������
             if(!ret.next())
            	 System.out.println("��ѯ������Ϣ");
             while (ret.next()) {  
                 String ENAME = ret.getString(1); 
                 String ADDRESS = ret.getString(2);
                 System.out.println(ENAME + "\t" + ADDRESS);  
             }//��ʾ���� 
             System.out.print("\n");
             ret.close();  
             db1.close();//�ر�����  
         } catch (SQLException e) {  
             e.printStackTrace();  
         }  
     }
    
    public static void task5() throws IOException
    {
    	System.out.print("��������Ŀ���:");
    	String PNO = br.readLine();
    	sql = "select ENAME from employee where ESSN not in (select ESSN from works_on where PNO='"+ PNO +"')";//SQL���  
        db1 = new DBHandler(sql);//����DBHelper����  
         try {  
             ret = db1.pst.executeQuery();//ִ����䣬�õ������ 
             if(!ret.next())
            	 System.out.println("��ѯ������Ϣ");
             while (ret.next()) {  
                 String ENAME = ret.getString(1); 
                 System.out.println(ENAME);  
             }//��ʾ���� 
             System.out.print("\n");
             ret.close();  
             db1.close();//�ر�����  
         } catch (SQLException e) {  
             e.printStackTrace();  
         }  
     }
    
    public static void task6() throws IOException
    {
    	System.out.print("�������쵼����:");
    	String MNAME = br.readLine();
    	sql = "select ENAME,DNAME from employee,department where employee.DNO=department.DNO and "+
    		"employee.SUPERSSN=department.MGRSSN and employee.SUPERSSN in (select ESSN from employee "+
    		"where ENAME='"+MNAME+"')";
        db1 = new DBHandler(sql);//����DBHelper����  
         try {  
             ret = db1.pst.executeQuery();//ִ����䣬�õ������ 
             if(!ret.next())
            	 System.out.println("��ѯ������Ϣ");
             while (ret.next()) {  
                 String ENAME = ret.getString(1); 
                 String DNAME = ret.getString(2); 
                 System.out.println(ENAME + "\t" + DNAME);  
             }//��ʾ���� 
             System.out.print("\n");
             ret.close();  
             db1.close();//�ر�����  
         } catch (SQLException e) {  
             e.printStackTrace();  
         }  
     }
    
    public static void task7() throws IOException
    {
    	System.out.print("��������Ŀ���:");
    	String Pro1 = br.readLine();
    	String Pro2 = br.readLine();
    	sql = "select ESSN from works_on where PNO='"+Pro1+
    		"' and ESSN in (select ESSN from works_on where PNO='"+Pro2+"')";
    		
        db1 = new DBHandler(sql);//����DBHelper����  
         try {  
             ret = db1.pst.executeQuery();//ִ����䣬�õ������ 
             if(!ret.next())
            	 System.out.println("��ѯ������Ϣ");
             while (ret.next()) {  
                 String ESSN = ret.getString(1); 
                 System.out.println(ESSN);  
             }//��ʾ���� 
             System.out.print("\n");
             ret.close();  
             db1.close();//�ر�����  
         } catch (SQLException e) {  
             e.printStackTrace();  
         }  
     }
    
    public static void task8() throws IOException
    {
    	System.out.print("�����빤��:");
    	String SALARY = br.readLine();
    	sql = "select DNAME from department where DNO in "
    			+ "(select DNO from employee group by DNO having AVG(SALARY)<"+SALARY+")";
    		
        db1 = new DBHandler(sql);//����DBHelper����  
         try {  
             ret = db1.pst.executeQuery();//ִ����䣬�õ������ 
             if(!ret.next())
            	 System.out.println("��ѯ������Ϣ");
             while (ret.next()) {  
                 String DNAME = ret.getString(1); 
                 System.out.println(DNAME);  
             }//��ʾ���� 
             System.out.print("\n");
             ret.close();  
             db1.close();//�ر�����  
         } catch (SQLException e) {  
             e.printStackTrace();  
         }  
     }
    
    public static void task9() throws IOException
    {
    	System.out.print("��������Ŀ��:");
    	String N = br.readLine();
    	System.out.print("������ʱ���ܶ�:");
    	String HOURS = br.readLine();
    	sql = "select ENAME from employee natural join works_on group by ENAME "+
    		"having sum(HOURS)<"+HOURS+" and count(PNO)>="+N;
    		
        db1 = new DBHandler(sql);//����DBHelper����  
         try {  
             ret = db1.pst.executeQuery();//ִ����䣬�õ������ 
             if(!ret.next())
            	 System.out.println("��ѯ������Ϣ");
             while (ret.next()) {  
                 String ENAME = ret.getString(1); 
                 System.out.println(ENAME);  
             }//��ʾ���� 
             System.out.print("\n");
             ret.close();  
             db1.close();//�ر�����  
         } catch (SQLException e) {  
             e.printStackTrace();  
         }  
     }
    
    public static void menu()
    {
    	System.out.print("\n*****************************\n");
    	System.out.print("1����ѯ�μ�����Ŀ���ΪPNO����Ŀ��Ա����\n");
    	System.out.print("2����ѯ�μ�����Ŀ��ΪPNAME��Ա������\n");
    	System.out.print("3����ѯ��DNAME���������й�����Ա�����ֺ͵�ַ\n");
    	System.out.print("4����ѯ��DNAME�����ҹ��ʵ���SALARYԪ��Ա�����ֺ͵�ַ\n");
    	System.out.print("5.��ѯû�вμ���Ŀ���ΪPNO����Ŀ��Ա������\n");
    	System.out.print("6.��ѯ��ENAME�쵼�Ĺ�����Ա�����������ڲ��ŵ�����\n");
    	System.out.print("7.��ѯ���ٲμ�����Ŀ���ΪPNO1��PNO2����Ŀ��Ա����\n");
    	System.out.print("8.��ѯԱ��ƽ�����ʵ���SALARYԪ�Ĳ�������\n");
    	System.out.print("9.��ѯ���ٲ�����N����Ŀ�ҹ�����ʱ�䲻����HOURSСʱ��Ա������\n");
    	System.out.print("0����������\n");
    	System.out.print("������ѡ��:\n");
    }
    
    public static void main(String[] args) throws IOException {  
    	System.out.print("ʵ���:ʹ�ø߼����Բ���MySQL���ݿ�");
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
		    	case 0:flag=false;System.out.print("ллʹ��");break;
			    default:
			    	System.out.print("�������\n");
	    	}
    	}
    }
}