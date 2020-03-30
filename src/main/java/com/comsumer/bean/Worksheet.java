package com.comsumer.bean;

import java.util.List;

/**
 * 类功能描述：Excel sheet Bean
 *
 * @author WangXueXing create at 19-4-13 下午10:21
 * @version 1.0.0
 */
public class Worksheet {
    private String sheet;
    private int columnNum;
    private int rowNum;
    private List<Row> rows;

    public String getSheet() {
        return sheet;
    }
    public void setSheet(String sheet) {
        this.sheet = sheet;
    }

    public List<Row> getRows() {
        return rows;
    }
    public void setRows(List<Row> rows) {
        this.rows = rows;
    }

    public int getColumnNum() {
        return columnNum;
    }
    public void setColumnNum(int columnNum) {
        this.columnNum = columnNum;
    }

    public int getRowNum() {
        return rowNum;
    }
    public void setRowNum(int rowNum) {
        this.rowNum = rowNum;
    }
}
