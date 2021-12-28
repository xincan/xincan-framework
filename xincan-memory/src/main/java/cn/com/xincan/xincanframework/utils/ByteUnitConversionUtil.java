package cn.com.xincan.xincanframework.utils;


import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * copyright (C), 2021, 北京同创永益科技发展有限公司
 * @program xincan-framework
 * @description 字节转化类
 * @author JiangXincan
 * @create 2021/9/9 14:05
 * @version 2.0.0
 */
public class ByteUnitConversionUtil {
    private static BigDecimal kb = new BigDecimal("1000");
    private static BigDecimal kib = new BigDecimal("1024");
    private static BigDecimal base = new BigDecimal("1");
    private static List<BigDecimal> kbValue= new ArrayList<>();
    private static List<BigDecimal> kibValue = new ArrayList<>();
    private static String DEFAULT_FORMAT="%.5f";

    public static enum Units{
        B(0,false),
        KB(1,false),
        KiB(1,true),
        MB(2,false),
        MiB(2,true),
        GB(3,false),
        GiB(3,true),
        TB(4,false),
        TiB(4,true),
        PB(5,false),
        PiB(5,true),
        EB(6,false),
        EiB(6,true),
        ZB(7,false),
        ZiB(7,true),
        YB(8,false),
        YiB(8,true),
        BB(9,false),
        BiB(9,true),
        NB(10,false),
        NiB(10,true),
        DB(11,false),
        DiB(11,true);
        private int index;
        private boolean isKib;
        private Units(int index, boolean isKib){
            this.index=index;
            this.isKib=isKib;
        }
        public int value(){
            return this.index;
        }

        public boolean isKib(){
            return this.isKib;
        }
        public boolean equals(Units other){
            return this.value()==other.value();
        }
    }

    private ByteUnitConversionUtil(){}
    static{
        init();
    };

    private static void init(){
        for(Units units:Units.values()){
            if(units.equals(Units.B)){
                kbValue.add(units.value(), base);
                kibValue.add(units.value(),base);
            }else if(units.isKib()){
                kibValue.add(units.value(),kibValue.get(units.value()-1).multiply(kib));
            }else{
                kbValue.add(units.value(), kbValue.get(units.value()-1).multiply(kb));
            }
        }
    }

    public static String convert(int value,Units unit){
        return convert(value,unit,DEFAULT_FORMAT);
    }
    public static String convert(int value,Units unit,String format){
        return convert(new BigDecimal(String.valueOf(value)),unit,format);
    }

    public static String convert(long value,Units unit){
        return convert(value,unit,DEFAULT_FORMAT);
    }
    public static String convert(long value,Units unit,String format){
        return convert(new BigDecimal(String.valueOf(value)),unit,format);
    }

    public static String convert(BigDecimal value,Units unit){
        return convert(value,unit,DEFAULT_FORMAT);
    }
    public static String convert(BigDecimal value,Units unit,String format){
        return doConvert(value,unit,format);
    }

    private static String doConvert(BigDecimal value,Units unit,String format){
        if(unit.equals(Units.B)){
            return value.toString().split("\\.",2)[0]+unit;
        }else{
            BigDecimal divisor= unit.isKib()?kibValue.get(unit.value()):kbValue.get(unit.value());
            return String.format(format,value.divide(divisor).doubleValue())+unit;
        }
    }
}
