package com.lsm.travelPlan.database;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.lsm.travelPlan.entity.HotelDetail;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class HotelMfromExcell {
	public static void saveHotelFExcel(){
		String excelFileName = "src/main/resources/全国星级酒店及联系方式名录(1800家).xls";
		Workbook rwb = null;
		Cell cell = null;
		// 创建输入流
		InputStream stream;
		try {
			stream = new FileInputStream(new File(excelFileName));
			rwb = Workbook.getWorkbook(stream);
			// 获取文件的指定工作表 默认的第一个
			Sheet sheet = rwb.getSheet(0);
			String[] str=new String[sheet.getColumns()];
			HotelDetail hotelDetail=new HotelDetail();
			for(int i=1;i<sheet.getRows();i++){
				for(int j=0;j<sheet.getColumns();j++){
					cell=sheet.getCell(j, i);
					str[j]=cell.getContents();
				}
				hotelDetail.setName(str[0]);
				hotelDetail.setStarLevel(str[1]);
				hotelDetail.setRoomNum(str[2]);
				hotelDetail.setAddress(str[3]);
				hotelDetail.setTel(str[4]);
				HotelMfromExcell.saveHotelFExcel(hotelDetail);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// 获取Excel文件对象
		
	}
	public static void saveHotelFExcel(HotelDetail hotelDetail){
		 String sql="insert into starHotelInfo(name,starlevel,roomNum,address,tel)values(?,?,?,?,?)";
		   try {
			PreparedStatement ps=TravelPlanDatabase.getConnection().prepareStatement(sql);
			ps.setString(1, hotelDetail.getName());
			ps.setString(2, hotelDetail.getStarLevel());
			ps.setString(3, hotelDetail.getRoomNum());
			ps.setString(4, hotelDetail.getAddress());
			ps.setString(5, hotelDetail.getTel());
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public static List<String[]> readExcel(File excelFile, int rowNum)
			throws BiffException, IOException {
		// 创建一个list 用来存储读取的内容
		List<String[]> list = new ArrayList<String[]>();
		Workbook rwb = null;
		Cell cell = null;
		// 创建输入流
		InputStream stream = new FileInputStream(excelFile);
		// 获取Excel文件对象
		rwb = Workbook.getWorkbook(stream);
		// 获取文件的指定工作表 默认的第一个
		Sheet sheet = rwb.getSheet(0);
		// 行数(表头的目录不需要，从1开始)
		for (int i = rowNum - 1; i < 4; i++) {
			// 创建一个数组 用来存储每一列的值
			String[] str = new String[sheet.getColumns()];
			// 列数
			
			for (int j = 0; j < sheet.getColumns(); j++) {
				// 获取第i行，第j列的值
				cell = sheet.getCell(j, i);
				str[j] = cell.getContents();
			}
			// 把刚获取的列存入list
			list.add(str);
		}
		// 返回值集合
		return list;
	}

	public static void main(String[] args) {
		/*String excelFileName = "src/main/resources/全国星级酒店及联系方式名录(1800家).xls";
		try {
			List<String[]> list = HotelMfromExcell.readExcel(new File(
					excelFileName), 2);
			for (int i = 0; i < list.size(); i++) {
				String[] str = (String[]) list.get(i);
				for (int j = 0; j < str.length; j++) {
					System.out.println(str[j]);
				}
			}
		} catch (BiffException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}*/
		HotelMfromExcell.saveHotelFExcel();
	}
  
}
