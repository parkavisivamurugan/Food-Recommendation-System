/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package frs;
import java.awt.*;
import java.awt.event.*;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import static java.awt.PageAttributes.MediaType.C1;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
/**
 *
 * @author ELCOT
 */
public class FRSMenu {
    JFrame j = new JFrame();
    public int totcost=0,flag;
    public String id;
    FRSMenu(String cid,int fl)
    {
        id = cid;
        System.out.println(id);
        flag = fl;
        //j = new JFrame();
        //j.setLayout(new BorderLayout());
        //JLabel background=new JLabel(new ImageIcon("F:\\ooad_image\\background3.jpeg"));
//j.add(background);
//background.setLayout(null);
//background.setSize(500,500);
        Connection con;
        PreparedStatement pst;
        String [][] arr = new String[100][100];
        String [][] arr1 = new String[100][100];
        String [] foodid = new String[100];
        String [] foodid1 = new String[100];
        try {
            /* Set the Nimbus look and feel */
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/frs","root","Parkavi@2003");
            //System.out.println("hi");
            Statement stmt=con.createStatement();
        String sql = "select * from menu";
        //System.out.println(sql);
        ResultSet r;
        r = stmt.executeQuery(sql);
        System.out.println(r);
        int i=0;
        int k=0;
        while(r.next())
        {
            String com = r.getString("foodtype");
           if(com.equals("NON-VEG"))
           {
              foodid[i]=r.getString("fid");
              arr[i][0]=r.getString("fname");
              arr[i][1]=r.getString("fcost");
              arr[i][2]=r.getString("fquan");
               i++;
           }
           else
           {
               foodid1[k]=r.getString("fid");
               arr1[k][0]=r.getString("fname");
               arr1[k][1]=r.getString("fcost");
               arr1[k][2]=r.getString("fquan");
               k++;
           }
        }
        int n=i;
        int n1 = k;
      
      JLabel t = new JLabel("Non - Veg");
      t.setBounds(600,10,200,30);
      t.setForeground(Color.RED);
      t.setFont(new Font("Arial",Font.PLAIN,30));
      
      JLabel food = new JLabel("FOOD");
      food.setBounds(300,50,500,30);
      food.setForeground(Color.blue);
      food.setFont(new Font("Arial",Font.PLAIN,30));
      j.add(food);
      
      JLabel cost = new JLabel("COST");
      cost.setBounds(600,50,500,30);
      cost.setForeground(Color.BLUE);
      cost.setFont(new Font("Arial",Font.PLAIN,30));
      j.add(cost);
      
      JLabel quan = new JLabel("QUANTITY");
      quan.setBounds(900,50,500,30);
      quan.setForeground(Color.BLUE);
      quan.setFont(new Font("Arial",Font.PLAIN,30));
      j.add(quan);
      
      int b = 0;
      int b1 = 50;
      
      JLabel[][] l= new JLabel[n][3];
      JSpinner[] nv = new JSpinner[n];
      for(i=0;i<n;i++)
      {
          b1=b1+50;
          //int h = arr[i][2];
          SpinnerModel value =  new SpinnerNumberModel(0,0,Integer.parseInt(arr[i][2]),1);
          //nv[i] = new JSpinner(value);
          for(k=0;k<3;k++)
          {
              b=b+300;
              l[i][k] = new JLabel(arr[i][k]);
              System.out.println(arr[i][k]);
              l[i][k].setBounds(b,b1,500,30);
              l[i][k].setFont(new Font("Arial",Font.PLAIN,28));
              j.add(l[i][k]);
          }
          b=b+300;
          nv[i] = new JSpinner(value);
          nv[i].setBounds(b,b1,100,30);
          j.add(nv[i]);
          b=0;
      }
      b1 = b1+50;
      JLabel t1 = new JLabel("Veg");
      t1.setBounds(600,b1,200,30);
      t1.setForeground(Color.RED);
      t1.setFont(new Font("Arial",Font.PLAIN,30));
      
      JLabel[][] veg= new JLabel[n1][3];
      JSpinner[] v = new JSpinner[n1];
      for(i=0;i<n1;i++)
      {
          b1=b1+50;
          SpinnerModel value =  new SpinnerNumberModel(0,0,Integer.parseInt(arr1[i][2]),1);
          for(k=0;k<3;k++)
          {
              b=b+300;
              veg[i][k] = new JLabel(arr1[i][k]);
              System.out.println(arr1[i][k]);
              veg[i][k].setBounds(b,b1,500,30);
              veg[i][k].setFont(new Font("Arial",Font.PLAIN,28));
              j.add(veg[i][k]);
          }
          b=b+300;
          v[i] = new JSpinner(value);
          v[i].setBounds(b,b1,100,30);
          j.add(v[i]);
          b=0;
      }
      JButton order = new JButton("ORDER");
      order.setBounds(550,500,300,30);
      order.setForeground(Color.RED);
      order.setFont(new Font("Arial",Font.PLAIN,30));
      
      order.addActionListener(new ActionListener(){  
@Override
public void actionPerformed(ActionEvent e){  
             
    try {
        
        totcost = 0;
        for(int i=0;i<n;i++)
        {
            Integer myint = (Integer) nv[i].getValue();
            totcost = totcost+(Integer.parseInt(arr[i][1])*myint);     
        }
        for(int i=0;i<n1;i++)
        {
            Integer myint = (Integer) v[i].getValue();
            totcost = totcost+(Integer.parseInt(arr1[i][1])*myint);
        }
        ResultSet a = stmt.executeQuery("select count(*)as c from orders");
        //System.out.println("hello");
        String count=null;
        while(a.next())
        {
             count = a.getString("c");
        }
        //System.out.println("hello");
        int coun = Integer.parseInt(count) + 1;
        String c = "O"+coun;
        System.out.println(c);
        int x=stmt.executeUpdate("insert into orders values('"+c+"','"+id+"','"+totcost+"')");
        String[][] pass = new String [10][10];
        int j=0;
        for(int i=0;i<n;i++)
        {
            Integer myint = (Integer) nv[i].getValue();
            if(myint>0)
            {
                String o = Integer.toString(myint);
                pass[j][0]=arr[i][0];
                pass[j][1]=arr[i][1];
                pass[j][2]= o;
                j++;
                System.out.println("hello"+foodid[i]+arr[i][0]+arr[i][1]+o);
                try {
                    
                    x=stmt.executeUpdate("insert into food values('"+id+"','"+foodid[i]+"','"+arr[i][0]+"','NON-VEG','"+arr[i][1]+"','"+myint+"','"+c+"')");
                    //String sqli = "insert into food (cid,fid,name,type,quan,cost)values(\"C1\",foodid[i],arr[i][0],\"NON-VEG\",Integer.parseInt(arr[i][1]),myint)";
                } catch (SQLException ex) {
                    Logger.getLogger(FRSMenu.class.getName()).log(Level.SEVERE, null, ex);
                }
                
            }
        }
        for(int i=0;i<n1;i++)
        {
            Integer myint = (Integer) v[i].getValue();
            if(myint>0)
            {
                String o = Integer.toString(myint);
                pass[j][0]=arr1[i][0];
                pass[j][1]=arr1[i][1];
                pass[j][2]= o;
                j++;
                try {
                   
                     x=stmt.executeUpdate("insert into food values('"+id+"','"+foodid1[i]+"','"+arr1[i][0]+"','VEG','"+arr1[i][1]+"','"+myint+"','"+c+"')");
                } catch (SQLException ex) {
                    Logger.getLogger(FRSMenu.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        new Payment(pass,totcost,j).setVisible(true);
        
    } catch (SQLException ex) {
        Logger.getLogger(FRSMenu.class.getName()).log(Level.SEVERE, null, ex);
    }
        j.dispose();
        }  
       
    }); 
      j.add(order);
      
      
      
      JButton rec = new JButton("RECOMMEND");
      rec.setBounds(200,500,300,30);
      rec.setForeground(Color.RED);
      rec.setFont(new Font("Arial",Font.PLAIN,30));
      rec.addActionListener(new ActionListener(){  
public void actionPerformed(ActionEvent e){  
    try {
        String sql1;
        //sql1 = "select fname from menu where fid in(select *from(select fid from food where cid = cid GROUP BY(FID) ORDER BY COUNT(*) DESC LIMIT 2)as t)" ;
        //System.out.println(sql);
        if(flag == 0)
        {
            System.out.println("Recommend"+id);
            sql1 = "select fname from menu where fid in ( select *from (select fid from food where cid = '"+id+"'  GROUP BY(FID) ORDER BY COUNT(*) DESC LIMIT 2)as t)";
            ResultSet r1;
            r1 = stmt.executeQuery(sql1);
            String[] a = new String[2];
            int i=0;
            while(r1.next())
            { 
                  a[i] = r1.getString("fname");
                  i++;
            }
            JDialog d = new JDialog(j,"RECOMMENDATION");
            Color color=new Color(255,255,255);
            d.getContentPane().setBackground(color); 
            JLabel recommend = new JLabel("YOUR FAVOURITE DISHES");
            recommend.setForeground(Color.PINK);
            recommend.setFont(new Font("Arial",Font.PLAIN,30));
            d.add(recommend);
        
            JLabel dish1 = new JLabel(a[0]);
            dish1.setForeground(Color.RED);
            dish1.setFont(new Font("Arial",Font.PLAIN,30));
            d.add(dish1);
        
            JLabel dispic1 = new JLabel();
            ImageIcon imgThisImg = new ImageIcon("C:\\Users\\ELCOT\\Downloads\\6th Sem\\OOAD\\OOAD\\"+a[0]+".jpeg");
            dispic1.setIcon(imgThisImg);
            d.add(dispic1);
        
            JLabel dish2 = new JLabel(a[1]);
            System.out.println(a[1]);
            dish1.setBounds(500,400,10,10);
            dish2.setForeground(Color.RED);
            dish2.setFont(new Font("Arial",Font.PLAIN,30));
            d.add(dish2);
        
            JLabel dispic2 = new JLabel();
            ImageIcon imgThisImg1 = new ImageIcon("C:\\Users\\ELCOT\\Downloads\\6th Sem\\OOAD\\OOAD\\"+a[1]+".jpeg");
            dispic2.setIcon(imgThisImg1);
            d.add(dispic2);
        
            d.setLayout(new FlowLayout(FlowLayout.LEFT,200,30));
            d.setSize(1000,700);
            d.setVisible(true);
        }
        else
        {
            sql1 = "select fname from food GROUP BY(FNAME) ORDER BY COUNT(*) DESC LIMIT 2";
            ResultSet r1;
            r1 = stmt.executeQuery(sql1);
            String[] a = new String[2];
            int i=0;
            while(r1.next())
            { 
                  a[i] = r1.getString("fname");
                  i++;
            }
            JDialog d = new JDialog(j,"RECOMMENDATION");
        
            JLabel recommend = new JLabel("YOU CAN TASTE !!!");
            recommend.setForeground(Color.BLUE);
            recommend.setFont(new Font("Arial",Font.PLAIN,30));
            d.add(recommend);
        
            JLabel dish1 = new JLabel(a[0]);
            dish1.setForeground(Color.RED);
            dish1.setFont(new Font("Arial",Font.PLAIN,30));
            d.add(dish1);
        
            JLabel dispic1 = new JLabel();
            ImageIcon imgThisImg = new ImageIcon("C:\\Users\\ELCOT\\Downloads\\6th Sem\\OOAD\\OOAD\\"+a[0]+".jpeg");
            dispic1.setIcon(imgThisImg);
            d.add(dispic1);
        
            JLabel dish2 = new JLabel(a[1]);
            System.out.println(a[1]);
            dish1.setBounds(500,400,10,10);
            dish2.setForeground(Color.RED);
            dish2.setFont(new Font("Arial",Font.PLAIN,30));
            d.add(dish2);
        
            JLabel dispic2 = new JLabel();
            ImageIcon imgThisImg1 = new ImageIcon("C:\\Users\\ELCOT\\Downloads\\6th Sem\\OOAD\\OOAD\\"+a[1]+".jpeg");
            dispic2.setIcon(imgThisImg1);
            d.add(dispic2);
        
            d.setLayout(new FlowLayout(FlowLayout.LEFT,200,30));
            d.setSize(1000,700);
            d.setVisible(true);
            
        }
    } catch (SQLException ex) {
        Logger.getLogger(FRSMenu.class.getName()).log(Level.SEVERE, null, ex);
    }
          
        }  
            }); 
      j.add(rec);
      
      JLabel cos = new JLabel("Cost");
      cos.setBounds(1200,500,300,30);
      cos.setForeground(Color.RED);
      cos.setFont(new Font("Arial",Font.PLAIN,30));
      j.add(cos);
      
      JButton tot = new JButton("TotAmt");
      tot.setBounds(900,500,250,30);
      tot.setForeground(Color.RED);
      tot.setFont(new Font("Arial",Font.PLAIN,30));
      tot.addActionListener(new ActionListener(){  
public void actionPerformed(ActionEvent e){  
             totcost = 0;
             for(int i=0;i<n;i++)
             {
                 Integer myint = (Integer) nv[i].getValue();
                 totcost = totcost+(Integer.parseInt(arr[i][1])*myint);
                 
             }
             for(int i=0;i<n1;i++)
             {
                 Integer myint = (Integer) v[i].getValue();
                 totcost = totcost+(Integer.parseInt(arr1[i][1])*myint);
             }
             String spinner;
             //spinner = totcost.toString();
             cos.setText(Integer.toString(totcost));
        }  
    }); 
      j.add(tot);
      
      /*JButton order = new JButton("ORDER");
      order.setBounds(600,b1+50,500,30);
      order.setForeground(Color.RED);
      order.setFont(new Font("Arial",Font.PLAIN,30));
      j.add(order);*/
      
      j.add(order);
      j.add(t1);
      j.add(t);
      j.setSize(1400,700);
      
      Color color=new Color(255,255,255);
      j.getContentPane().setBackground(color); 
      j.setLayout(null);
      j.setVisible(true);
       
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void main(String[] args)
    {
        Login l = new Login();
        if(args[1]=="0")
        {
            FRSMenu f = new FRSMenu(args[0],0);
        }
        else
        {
            System.out.println("new");
            //FRSMenu f = new FRSMenu(h.cid,h.flag);
            //System.out.println("me"+l.getCid());
            FRSMenu f = new FRSMenu(args[0],1);
        }
        
     
    }
}
