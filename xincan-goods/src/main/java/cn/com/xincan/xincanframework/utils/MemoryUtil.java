package cn.com.xincan.xincanframework.utils;
import com.alibaba.fastjson.JSONObject;

/**
 * copyright (C), 2021, 北京同创永益科技发展有限公司
 * @program xincan-framework
 * @description
 * @author JiangXincan
 * @create 2021/9/9 13:42
 * @version 2.0.0
 */
public class MemoryUtil {

    public static Runtime run = Runtime.getRuntime();
    private static  String FORMAT = "memory totol: %s, free: %s, use: %s";

    public static JSONObject getMemory(){
        long total=run.totalMemory();
        long free=run.freeMemory();
        System.out.println(String.format(FORMAT,
                ByteUnitConversionUtil.convert(total, ByteUnitConversionUtil.Units.MB),
                ByteUnitConversionUtil.convert(free, ByteUnitConversionUtil.Units.MB),
                ByteUnitConversionUtil.convert(total-free, ByteUnitConversionUtil.Units.MB)));
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("total", ByteUnitConversionUtil.convert(total, ByteUnitConversionUtil.Units.MB));
        jsonObject.put("free", ByteUnitConversionUtil.convert(free, ByteUnitConversionUtil.Units.MB));
        jsonObject.put("use", ByteUnitConversionUtil.convert(total-free, ByteUnitConversionUtil.Units.MB));
        return jsonObject;
    }

    public static void main(String[] args) {


    }

}
