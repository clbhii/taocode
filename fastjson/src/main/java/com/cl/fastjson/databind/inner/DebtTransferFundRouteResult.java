package com.cl.fastjson.databind.inner;

import java.io.Serializable;
import java.util.List;

import lombok.Data;

/**
 *  fastjson 序列化时 会把所有get方法，当做获取属性处理
 *  反序列时 会把所有set方法 当前set属性处理
 *  所以 如果不是属性就不要用get或set方法
 * @authorcl
 *
 */
@Data
public class DebtTransferFundRouteResult implements Serializable{
    /**
     * 当前选择的债转资方序号
     */
    private Integer index;
    /**
     * 有序的可支持的债转资方
     */
    private List<DebtTransferFundInfo> orderedBackSecondCapitalSource;

    @Data
    public static class DebtTransferFundInfo{
        /**
         * 资金方
         */
        private String fundParty;
        /**
         * 产品融资编号
         */
        private String financingNo;
    }
    
    public DebtTransferFundInfo getTransferFundInfo(){
        return orderedBackSecondCapitalSource.get(index);
    }


}
