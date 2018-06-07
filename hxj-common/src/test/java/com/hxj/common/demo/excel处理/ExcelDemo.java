package com.hxj.common.demo.excel处理;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

import com.alibaba.excel.ExcelReader;
import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.metadata.Sheet;
import com.alibaba.excel.read.context.AnalysisContext;
import com.alibaba.excel.read.event.AnalysisEventListener;
import com.alibaba.excel.support.ExcelTypeEnum;
import com.hxj.common.tools.FileTools;

public class ExcelDemo {

	public static void main(String[] args) throws Exception {

		// 直接读excel();
		// 读后返回java模型();
		写excel();
	}

	/**
	 * 无java模型直接把excel解析的每行结果以List<String>返回，在AnalysisEventListener获取解析结果
	 * 
	 * @author huangxj 2018年4月23日
	 *
	 * @version v1.0
	 */
	public static void 直接读excel() throws FileNotFoundException {

		InputStream inputStream = FileTools.getResourceAsStream("2003.xls");
		try {
			ExcelReader excelReader = new ExcelReader(inputStream, ExcelTypeEnum.XLS, null,
					new AnalysisEventListener<List<String>>() {

						@Override
						public void invoke(List<String> object, AnalysisContext context) {
							System.out.println("当前行：" + context.getCurrentRowNum());
							System.out.println(object);
						}

						@Override
						public void doAfterAllAnalysed(AnalysisContext context) {
							// datas.clear();//解析结束销毁不用的资源
						}
					});
			excelReader.read();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				inputStream.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * 读后返回java模型
	 * 
	 * @author huangxj 2018年4月23日 
	 *
	 * @version v1.0
	 */
	public static void 读后返回java模型() {

		InputStream inputStream = FileTools.getResourceAsStream("2007WithModelMultipleSheet.xlsx");
		try {
			ExcelReader reader = new ExcelReader(inputStream, ExcelTypeEnum.XLSX, null,
					new AnalysisEventListener<ExcelRowJavaModel>() {

						@Override
						public void invoke(ExcelRowJavaModel object, AnalysisContext context) {
							System.out.println(object);
						}

						@Override
						public void doAfterAllAnalysed(AnalysisContext context) {

						}
					});
			List<Sheet> sheets = reader.getSheets();
			for (Sheet sheet : sheets) {
				sheet.setHeadLineMun(2);
				sheet.setClazz(ExcelRowJavaModel.class);
				reader.read(sheet);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				inputStream.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public static void 写excel() throws FileNotFoundException {

		OutputStream out = new FileOutputStream("C://78.xlsx");
		try {
			ExcelWriter writer = new ExcelWriter(out, ExcelTypeEnum.XLSX);
			Sheet sheet1 = new Sheet(1, 0, ExcelPropertyIndexModel.class);
			writer.write(getData(), sheet1);
			writer.finish();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				out.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public static List<ExcelPropertyIndexModel> getData() {
		List<ExcelPropertyIndexModel> datas = new ArrayList<ExcelPropertyIndexModel>();
		ExcelPropertyIndexModel model = new ExcelPropertyIndexModel();
		model.setAddress("杭州");
		model.setAge("11");
		model.setEmail("7827323@qq.com");
		model.setSax("男");
		model.setHeigh("1123");
		datas.add(model);
		return datas;
	}
}
