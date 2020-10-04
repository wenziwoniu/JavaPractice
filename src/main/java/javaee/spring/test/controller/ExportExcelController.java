package javaee.spring.test.controller;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javaee.spring.test.pojo.Person;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.jxls.transformer.XLSTransformer;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.support.ServletContextResource;


/**
 * 功能 ：导出excel
 * 参考资料： http://blog.csdn.net/xiejx618/article/details/38906683
 * @author zwwang  2015-12-2 下午9:01:13
 */
@Controller
@RequestMapping(value = "/excel")
public class ExportExcelController {
	
	@RequestMapping(value = "/exportExcel")
	public void export(HttpServletRequest request, HttpServletResponse response) {
		//excel模板位置
		String templateFileName = this.getClass().getClassLoader().getResource("/").getPath() + "excel-template/templateFileName.xls";
		//生成的excel文件名称
		String destFileName = "destFileName.xls";
		//模拟数据
		List<Person> staff = new ArrayList<Person>();
		Person person = new Person();
		person.setFirstName("wang");
		person.setLastName("ziwen");
		staff.add(person);
		Map<String, Object> beans = new HashMap<String, Object>();
		beans.put("employees", staff);
		XLSTransformer transformer = new XLSTransformer();
		InputStream in = null;
		OutputStream out = null;
		response.setHeader("Content-Disposition", "attachment;filename=" + destFileName);
		response.setContentType("application/vnd.ms-excel");
		try {
			in = new BufferedInputStream(new FileInputStream(templateFileName));
			Workbook workbook = transformer.transformXLS(in, beans);
			out = response.getOutputStream();
			workbook.write(out);
			out.flush();
		} catch (InvalidFormatException e) {
			e.printStackTrace();
		} catch (IOException  e) {
			e.printStackTrace();
		} finally {
			if (in != null) {
				try {
					in.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (out != null) {
				try {
					out.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

}
