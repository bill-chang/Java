package tw.bill.apps;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.Properties;

import org.json.JSONArray;
import org.json.JSONObject;

public class JsonInsertSql {

	public static void main(String[] args) {
		try {			
			URL url =new URL("http://data.coa.gov.tw/Service/OpenData/ODwsv/ODwsvTravelFood.aspx");
			HttpURLConnection conn=(HttpURLConnection)url.openConnection();
			conn.connect();
			BufferedReader reader=new BufferedReader(new InputStreamReader(conn.getInputStream()));
			StringBuffer sb=new StringBuffer();
			String line;
			while((line=reader.readLine())!=null) {
				sb.append(line);
			}
			
			reader.close();
			System.out.println("step 1 ok");
		}catch (Exception e) {
			System.out.println(e.toString());
		}
	}


	static void paresJSON(String json) {
		
		
		try {
			Properties properties=new Properties();
			properties.put("user", "root");
			properties.put("password", "root");
			properties.put("serverTimezone", "Asia/Taipei");
			Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/iii",properties);
			
//			Statement stmt=conn.createStatement(); 
//			stmt.execute("create table foodv2(id integer primary key auto_increment,fname varchar(10),tel varchar(10)"); //創資料庫
			
			String sql="INSERT INTO food(fname,tel,addr,city,town,lat,lng,pic)"+"VALUES(?,?,?,?,?,?,?,?)";
			PreparedStatement pstmt=conn.prepareStatement(sql);//預先準備
			
			
			JSONArray root=new JSONArray(json);
			for(int i=0;i<root.length();i++) {
				JSONObject row=root.getJSONObject(i);
				String fname=row.getString("Name");
				String tel=row.getString("Tel");
				String addr=row.getString("Address");
				String city=row.getString("City");
				String town=row.getString("Town");
				String latlng=row.getString("Coordinate");
				String lat="",lng="";
				try {
					String[] coor=latlng.split(",");
					lat=coor[0];
					lng=coor[1];
					
				}catch (Exception e) {
					lat=lng="";
					System.out.println(e.toString());
				}
				String pic=row.getString("PicURL");
				
				pstmt.setString(1, fname);
				pstmt.setString(2, tel);
				pstmt.setString(3, addr);
				pstmt.setString(4, city);
				pstmt.setString(5, town);
				pstmt.setString(6, lat);
				pstmt.setString(7, lng);
				pstmt.setString(8, pic);
				pstmt.executeUpdate();
			}
			System.out.println("step 2 ok");
			
			
		}catch (Exception e) {
			System.out.println(e.toString());
		}
	}
}
	
