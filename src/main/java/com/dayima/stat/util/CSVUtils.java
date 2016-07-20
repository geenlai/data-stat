package com.dayima.stat.util;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.List;
import java.util.Map;

/**   
 * CSV操作
 */
public class CSVUtils {
    
    /**
     * 导出
     * 
     * @param file csv文件(路径+文件名)，csv文件不存在会自动创建
     * @param dataList 数据
     * @return
     */
    public static boolean exportTmCsv(File file, List<Map<String, Object>> dataList){
        boolean isSucess=false;
        
        FileOutputStream out=null;
        OutputStreamWriter osw=null;
        BufferedWriter bw=null;
        try {
            out = new FileOutputStream(file);
            osw = new OutputStreamWriter(out, "GBK");
            bw = new BufferedWriter(osw, 1024);
            String header = "date,goodsId,productName,goodsPrice,count,midCount,categoryName\r\n";
            bw.append(header);
            if(dataList!=null && !dataList.isEmpty()){
                for(Map<String, Object> m : dataList){
                	String date = "" + m.get("date");
                	String goodsId = "" + m.get("goodsId");
                	String productName = "" + m.get("productName");
                	String goodsPrice = "" + m.get("goodsPrice");
                	String count = "" + m.get("count");
                	String midCount = "" + m.get("midCount");
                	String categoryName = "" + m.get("categoryName");
                	
                	String data = date + "," + goodsId + "," + productName + "," + goodsPrice + "," + count + "," + midCount + "," + categoryName + "\r\n";
                    bw.append(data);
                }
            }
            isSucess=true;
        } catch (Exception e) {
        	e.printStackTrace();
            isSucess=false;
        }finally{
            if(bw!=null){
                try {
                    bw.close();
                    bw=null;
                } catch (IOException e) {
                    e.printStackTrace();
                } 
            }
            if(osw!=null){
                try {
                    osw.close();
                    osw=null;
                } catch (IOException e) {
                    e.printStackTrace();
                } 
            }
            if(out!=null){
                try {
                    out.close();
                    out=null;
                } catch (IOException e) {
                    e.printStackTrace();
                } 
            }
        }
        
        return isSucess;
    }
    
    /**
     * 导出
     * 
     * @param file csv文件(路径+文件名)，csv文件不存在会自动创建
     * @param dataList 数据
     * @return
     */
    public static boolean exportMisCsv(File file, List<Map<String, Object>> dataList){
        boolean isSucess=false;
        
        FileOutputStream out=null;
        OutputStreamWriter osw=null;
        BufferedWriter bw=null;
        try {
            out = new FileOutputStream(file);
            osw = new OutputStreamWriter(out, "GBK");
            bw = new BufferedWriter(osw, 1024);
            String header = "date,goodsId,productName,goodsPrice,missPeriod,count,midCount,categoryName\r\n";
            bw.append(header);
            if(dataList!=null && !dataList.isEmpty()){
                for(Map<String, Object> m : dataList){
                	String date = "" + m.get("date");
                	String goodsId = "" + m.get("goodsId");
                	String productName = "" + m.get("productName");
                	String goodsPrice = "" + m.get("goodsPrice");
                	String missPeriod = "" + m.get("missPeriod");
                	String count = "" + m.get("count");
                	String midCount = "" + m.get("midCount");
                	String categoryName = "" + m.get("categoryName");
                	
                	String data = date + "," + goodsId + "," + productName + "," + goodsPrice + "," + missPeriod + "," + count + "," + midCount + "," + categoryName + "\r\n";
                    bw.append(data);
                }
            }
            isSucess=true;
        } catch (Exception e) {
        	e.printStackTrace();
            isSucess=false;
        }finally{
            if(bw!=null){
                try {
                    bw.close();
                    bw=null;
                } catch (IOException e) {
                    e.printStackTrace();
                } 
            }
            if(osw!=null){
                try {
                    osw.close();
                    osw=null;
                } catch (IOException e) {
                    e.printStackTrace();
                } 
            }
            if(out!=null){
                try {
                    out.close();
                    out=null;
                } catch (IOException e) {
                    e.printStackTrace();
                } 
            }
        }
        
        return isSucess;
    }
    
}