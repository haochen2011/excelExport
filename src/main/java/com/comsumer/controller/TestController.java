package com.comsumer.controller;

import com.comsumer.bean.Row;
import net.sf.jxls.transformer.XLSTransformer;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

@RestController
public class TestController {
    @RequestMapping("/get")
    public void export(HttpServletResponse response) throws InvalidFormatException, IOException {
        response.setHeader("Content-Disposition", "attachment;filename=" + "ex.xslx");
        String contentType = "application/vnd.ms-excel";
        response.setContentType(contentType);
        FileInputStream fis = null;
        int maxRowNum=60000;
        try {
            fis = new FileInputStream("src/main/resources/template/exportYongjin.xlsx");

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        List<Row> student_list = new ArrayList<Row>();//数据源1
        ArrayList<List> objects = new ArrayList<List>();//添加数据到objects中
        for(int j=0;j<maxRowNum;j++){
            Row row = new Row();
            row.setName1(""+new Random().nextInt(100000));
            row.setName2(""+j);
            row.setName3("san"+""+j);
            student_list.add(row);
        }
        objects.add(student_list);
       List<String> sheetNameList = new ArrayList<String>();//sheet名字列表，和objects大小相等，几个sheet数据源就有几个                                                                                                     //sheet名字

        sheetNameList.add("学生a");
        XLSTransformer transformer = new XLSTransformer();
         HashMap<String, Object> param2 = new HashMap<String, Object>();
         param2.put("root2", student_list );
        Workbook workbook = transformer.transformMultipleSheetsList(fis, objects, sheetNameList, "root", param2, 0);
        OutputStream out = null;
        try {
            out = response.getOutputStream();
        } catch (IOException e) {
            e.printStackTrace();
        }
        workbook.write(out);
        out.flush();
        out.close();
    }
}
