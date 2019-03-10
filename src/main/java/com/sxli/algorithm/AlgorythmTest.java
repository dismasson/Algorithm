package main.java.com.sxli.algorithm;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * 算法练习测试类
 */
public class AlgorythmTest {
    /**
     *BitMap 位图算法
     */
    @Test
    public void bitmap(){
        System.out.println("问题：假如有一千万条不规则的整数储存在irregular这个数组中，" +
                "并且这些不规则的整数不存在重复的数据，请你写出一个算法来给这些不规则的整数" +
                "进行排序，要求效率越高越好!");
        int[] Irregular = {1,3,4,2,5,10,8,9,6,7};

        int[] rule = new int[Irregular.length];

        for(int i=0;i<Irregular.length;i++)
            rule[Irregular[i]-1] = 1;

        System.out.print("正序排序：");
        for(int i=0;i<rule.length;i++){
            if(rule[i]==1)
                System.out.print("\t"+(i+1));
        }

        System.out.print("\n倒序排序：");
        for(int i=rule.length-1;i>=0;i--){
            if(rule[i]==1)
                System.out.print("\t"+(i+1));
        }
    }

    /**
     * 解析SnowFlake生成的ID的信息
     * @param snowFlakeId SnowFlake算法生成的ID
     * @return Map
     */
    public Map<String, String> SnowFlakeIdAnalysis(String snowFlakeId){
        //创建返回MAP
        Map<String, String> returnMap = new HashMap<String, String>();

        //将字符串类型的SnowFlake转换成Long类型数据
        Long SnowFlakeId2Long = 0L;
        try {
            SnowFlakeId2Long = Long.valueOf(snowFlakeId);
        } catch (Exception e) {
            e.printStackTrace();
        }
        //将10进制的SnowFlake2Long转换成2进制的BIT
        String SnowFlake2Bit = Long.toBinaryString(SnowFlakeId2Long);

        //计算出时间戳所占的位数，所有bit位数减去12位序列号+5位工作号+5位菜单号
        int timestampLen = SnowFlake2Bit.length() - 22;

        //根据SnowFlake算法规定，预留位一个Bit不算，时间戳占据前面0-41位Bit
        Long timestamp = Long.parseLong(SnowFlake2Bit.substring(0,timestampLen), 2) + (timestampLen < 40 ? 1288834974657L : 0L);
        returnMap.put("timestamp", timestamp.toString());

        //根据SnowFlake算法规定，预留位一个Bit不算，菜单ID占据前面42-46位bit
        Long menuId = Long.parseLong(SnowFlake2Bit.substring(timestampLen,timestampLen + 5), 2);
        returnMap.put("menuId", menuId.toString());

        //根据SnowFlake算法规定，预留位一个Bit不算，工作ID占据前面47-51位bit
        Long workerId = Long.parseLong(SnowFlake2Bit.substring(timestampLen + 5,timestampLen + 11), 2);
        returnMap.put("workerId", workerId.toString());

        //根据SnowFlake算法规定，预留位一个Bit不算，工作ID占据最后面12位bit
        Long sequenceNo = Long.parseLong(SnowFlake2Bit.substring(timestampLen + 11), 2);
        returnMap.put("sequenceNo", sequenceNo.toString());

        //返回MAP
        return returnMap;
    }

    /**
     *  解析SnowFlake生成的ID的信息
     * @param snowFlakeId SnowFlake算法生成的ID
     * @param snowFlakeEnum 根据传入的枚举类型来返回对应的值
     * @return
     */
    public String SnowFlakeIdAnalysis(String snowFlakeId,String snowFlakeEnum)  {
        //调用解析方法解析SnowFlakeId
        Map<String, String> returnMap = SnowFlakeIdAnalysis(snowFlakeId);
        String result = null;
        switch (snowFlakeEnum) {
            case "timestamp":
                result = returnMap.get("timestamp");
                break;
            case "menuId":
                result = returnMap.get("menuId");
                break;
            case "workerId":
                result = returnMap.get("workerId");
                break;
            case "sequenceNo":
                result = returnMap.get("sequenceNo");
                break;
            default:
                break;
        }
        return result;
    }

    @Test
    public void weiyi() throws InterruptedException {
        /*for(int i =0;i<30;i++){
            Thread.sleep(1);
            System.out.println(((System.currentTimeMillis() - 1288834974657L) << 22L) | (12 << 17L) | (12 << 12L)| i);
        }*/
        /*Long snowflakeId = ((System.currentTimeMillis() - 1288834974657L) << 22L) | (17 << 17) | (0 << 12)| 1;
        System.out.println(snowflakeId);
        System.out.println(Long.toBinaryString(snowflakeId));
        System.out.println(SnowFlakeIdAnalysis("971661144453414912","timestamp"));
        System.out.println(SnowFlakeIdAnalysis("971661144453414912","menuId"));
        System.out.println(SnowFlakeIdAnalysis("971661144453414912","workerId"));
        System.out.println(SnowFlakeIdAnalysis("971661144453414912","sequenceNo"));*/
    }
}
