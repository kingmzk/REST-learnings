package com.telusko.RestDemo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class AlienRepository
{

//	List <Alien> aliens;
//	
//	
//	public AlienRepository()
//	{
//		aliens = new ArrayList<>();
//
//		System.out.println("it is WOrking");
//		Alien a1 = new Alien();
//		a1.setName("MOHAMMED ZAKRIA KHAN");
//		a1.setPoints(90);
//		a1.setId(101);
//		
//		Alien a2 = new Alien();
//		a2.setName("KHIZAR AYUB");
//		a2.setPoints(82);
//		a2.setId(102);
//		
//		aliens.add(a1);
//		aliens.add(a2);
//	
//	}
//		
//		public List<Alien> getAliens()
//		{
//			return aliens;
//		}
//	
//		public Alien getAlien(int id)
//		{
//			
//			for(Alien a : aliens)
//			{
//				 if(a.getId()==id)
//					 return a;
//			}
//			 return null ;
//			
//		}
//
//		public void Create(Alien a1)
//		{
//			// TODO Auto-generated method stub
//			aliens.add(a1);
//			
//		}
	
	Connection con = null;
	
	public AlienRepository() 
	{
		String url = "jdbc:mysql://localhost:3306/restdb";
		String username = "root";
		String password = "zakria@1999";
		
		try
		{
			Class.forName("com.mysql.jdbc.Driver");  
			con = DriverManager.getConnection(url,username,password);
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
		
		public List<Alien> getAliens()
		{
			List<Alien> aliens = new ArrayList<>();
			String sql = "select * from alien";
			try 
			{
				Statement st =  con.createStatement();
				ResultSet rs = st.executeQuery(sql);
				
				while(rs.next())
				{
					Alien a = new Alien();
					a.setId(rs.getInt(1));
					a.setName(rs.getString(2));
					a.setPoints(rs.getInt(3));
					
					aliens.add(a); 
				}
				
			}
			catch(Exception e)
			{
				System.out.println(e);
			}
			
			return aliens;
		}
		
		
		
		
		public Alien getAlien(int id)
	{
		
			String sql = "select * from alien where id="+id;
			Alien a = new Alien();
			try 
			{
				Statement st =  con.createStatement();
				ResultSet rs = st.executeQuery(sql);
				
				if(rs.next())
				{
				
					a.setId(rs.getInt(1));
					a.setName(rs.getString(2));
					a.setPoints(rs.getInt(3));
					
			
				}
				
			}
			catch(Exception e)
			{
				System.out.println(e);
			}
			
			return a;
	}
		
		
		
		
	public void Create(Alien a1)
	{
			
	String sql = "insert into alien values(?,?,?)";
		try 
		{
			PreparedStatement st =  con.prepareStatement(sql);
			
			st.setInt(1,a1.getId());
			st.setString(2,a1.getName());
			st.setInt(3, a1.getPoints());
			st.executeUpdate();
			
			
			
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		
		
		
	}
		
		
	
	
	public void update(Alien a1)
	{
			
	String sql = "update alien set name=?, points=? WHERE id=?";
		try 
		{
			PreparedStatement st =  con.prepareStatement(sql);
			
			
			st.setString(1, a1.getName());
			st.setInt(2, a1.getPoints());
			st.setInt(3,a1.getId());
			st.executeUpdate();
			
			
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		
		
	}

	public void delete(int id)
	{
		
		String sql = "delete from alien WHERE id=?";
		try 
		{
			PreparedStatement st =  con.prepareStatement(sql);
				
			st.setInt(1,id);
			st.executeUpdate();
			
						
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		
	}
	
	
	
		
	}

	

