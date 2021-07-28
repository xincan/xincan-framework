package cn.com.xincan.xincanframework.utils.random;

import java.security.SecureRandom;

/**
 * copyright (C), 2021, 北京同创永益科技发展有限公司
 * @program xincan-framework
 * @description 随机生成字符串
 * @author JiangXincan
 * @create 2021/7/27 10:53
 * @version 2.0.0
 */
public class UUIDUtils {

    public static final String ALL_CHART_STRING = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ!@#$%^&*()_+";
    public static final String ALL_CHART = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
    public static final String LETTER_CHART = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
    public static final String NUMBER_CHART = "0123456789";
    public static final String SPECIAL_CHART = "!@#$%^&*()_+";

    /**
     * 返回一个定长的随机字符串(只包含大小写字母、数字)
     *
     * @author JiangXincan
     * @date 2021/7/27 10:59
     * @return java.lang.String
     */
    public static String generateUUIDString() {
        return generateInteger(19);
    }

    /**
     * 返回一个定长的随机字符串(只包含大小写字母、数字)
     *
     * @param length 随机字符串长度
     * @author JiangXincan
     * @date 2021/7/27 10:59
     * @return java.lang.String
     */
    public static String generateInteger(int length) {
        StringBuilder sb = new StringBuilder();
        SecureRandom random = new SecureRandom();
        for (int i = 0; i < length; i++) {
            sb.append(NUMBER_CHART.charAt(random.nextInt(NUMBER_CHART.length())));
        }
        return sb.toString();
    }

    /**
     * 返回一个定长的随机字符串(只包含大小写字母、数字)
     *
     * @param length 随机字符串长度
     * @author JiangXincan
     * @date 2021/7/27 10:59
     * @return java.lang.String
     */
    public static String generateString(int length) {
        StringBuilder sb = new StringBuilder();
        SecureRandom random = new SecureRandom();
        for (int i = 0; i < length; i++) {
            sb.append(ALL_CHART.charAt(random.nextInt(ALL_CHART.length())));
        }
        return sb.toString();
    }

    /**
     * 返回一个定长的随机字符串(只包含大小写字母、数字)
     *
     * @param length 随机字符串长度
     * @author JiangXincan
     * @date 2021/7/27 10:59
     * @return java.lang.String
     */
    public static String generateAllString(int length) {
        StringBuilder sb = new StringBuilder();
        SecureRandom random = new SecureRandom();
        for (int i = 0; i < length; i++) {
            sb.append(ALL_CHART_STRING.charAt(random.nextInt(ALL_CHART_STRING.length())));
        }
        return sb.toString();
    }

    /**
     * 返回一个定长的随机纯字母字符串(只包含大小写字母)
     *
     * @param length 随机字符串长度
     * @author JiangXincan
     * @date 2021/7/27 10:59
     * @return java.lang.String
     */
    public static String generateMixString(int length) {
        StringBuilder sb = new StringBuilder();
        SecureRandom random = new SecureRandom();
        for (int i = 0; i < length; i++) {
            sb.append(ALL_CHART.charAt(random.nextInt(LETTER_CHART.length())));
        }
        return sb.toString();
    }

    /**
     * 返回一个定长的随机纯大写字母字符串(只包含大小写字母)
     *
     * @param length 随机字符串长度
     * @author JiangXincan
     * @date 2021/7/27 10:59
     * @return java.lang.String
     */
    public static String generateLowerString(int length) {
        return generateMixString(length).toLowerCase();
    }

    /**
     * 返回一个定长的随机纯小写字母字符串(只包含大小写字母)
     *
     * @param length 随机字符串长度
     * @author JiangXincan
     * @date 2021/7/27 10:59
     * @return java.lang.String
     */
    public static String generateUpperString(int length) {
        return generateMixString(length).toUpperCase();
    }

    /**
     * 生成一个定长的纯0字符串
     *
     * @param length 字符串长度
     * @author JiangXincan
     * @date 2021/7/27 10:59
     * @return java.lang.String
     */
    public static String generateZeroString(int length) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length; i++) {
            sb.append('0');
        }
        return sb.toString();
    }

    /**
     * 根据数字生成一个定长的字符串，长度不够前面补0
     *
     * @param num 数字
     * @param fixedlength 字符串长度
     * @author JiangXincan
     * @date 2021/7/27 10:59
     * @return java.lang.String
     */
    public static String toFixedLengthString(int num, int fixedlength) {
        StringBuilder sb = new StringBuilder();
        String strNum = String.valueOf(num);
        if (fixedlength - strNum.length() >= 0) {
            sb.append(generateZeroString(fixedlength - strNum.length()));
        } else {
            throw new RuntimeException("将数字" + num + "转化为长度为" + fixedlength + "的字符串发生异常！");
        }
        sb.append(strNum);
        return sb.toString();
    }

    /**
     * 八位数字+字母+特殊字符随机密码生成
     * @author JiangXincan
     * @date 2021/7/27 10:59
     * @return java.lang.String
     **/
    public static String generatePasswordToString() {
        StringBuilder sb = new StringBuilder();
        SecureRandom random = new SecureRandom();
        for (int i = 0; i < 3; i++) {
            sb.append(ALL_CHART.charAt(random.nextInt(LETTER_CHART.length())));
            sb.append(NUMBER_CHART.charAt(random.nextInt(NUMBER_CHART.length())));
        }
        for (int i = 0; i < 2; i++) {
            sb.append(SPECIAL_CHART.charAt(random.nextInt(SPECIAL_CHART.length())));
        }
        return sb.toString();
    }

    public static void main(String[] args){

    }

}
