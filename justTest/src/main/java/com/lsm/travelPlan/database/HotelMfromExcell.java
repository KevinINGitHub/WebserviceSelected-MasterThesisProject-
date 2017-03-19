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
		String excelFileName = "src/main/resources/ȫ���Ǽ��Ƶ꼰��ϵ��ʽ��¼(1800��).xls";
		Workbook rwb = null;
		Cell cell = null;
		// ����������
		InputStream stream;
		try {
			stream = new FileInputStream(new File(excelFileName));
			rwb = Workbook.getWorkbook(stream);
			// ��ȡ�ļ���ָ�������� Ĭ�ϵĵ�һ��
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
		// ��ȡExcel�ļ�����
		
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
		// ����һ��list �����洢��ȡ������
		List<String[]> list = new ArrayList<String[]>();
		Workbook rwb = null;
		Cell cell = null;
		// ����������
		InputStream stream = new FileInputStream(excelFile);
		// ��ȡExcel�ļ�����
		rwb = Workbook.getWorkbook(stream);
		// ��ȡ�ļ���ָ�������� Ĭ�ϵĵ�һ��
		Sheet sheet = rwb.getSheet(0);
		// ����(��ͷ��Ŀ¼����Ҫ����1��ʼ)
		for (int i = rowNum - 1; i < 4; i++) {
			// ����һ������ �����洢ÿһ�е�ֵ
			String[] str = new String[sheet.getColumns()];
			// ����
			
			for (int j = 0; j < sheet.getColumns(); j++) {
				// ��ȡ��i�У���j�е�ֵ
				cell = sheet.getCell(j, i);
				str[j] = cell.getContents();
			}
			// �Ѹջ�ȡ���д���list
			list.add(str);
		}
		// ����ֵ����
		return list;
	}

	public static void main(String[] args) {
		/*String excelFileName = "src/main/resources/ȫ���Ǽ��Ƶ꼰��ϵ��ʽ��¼(1800��).xls";
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
