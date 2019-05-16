package com.cl.fastjson.databind.inner;

import java.util.ArrayList;
import java.util.List;

import com.alibaba.fastjson.JSON;
import com.cl.fastjson.databind.inner.DebtTransferFundRouteResult.DebtTransferFundInfo;

public class DebtTransferFundRouteResultTest {

	public static void main(String[] args) {
		DebtTransferFundRouteResult result = new DebtTransferFundRouteResult();
		result.setIndex(1);
		DebtTransferFundInfo debtTransferFundInfo = new DebtTransferFundRouteResult.DebtTransferFundInfo();
		debtTransferFundInfo.setFinancingNo("11");
		debtTransferFundInfo.setFundParty("22");
		List<DebtTransferFundRouteResult.DebtTransferFundInfo> list = new ArrayList<>();
		list.add(debtTransferFundInfo);
		result.setOrderedBackSecondCapitalSource(list);
		
		String jsonString = JSON.toJSONString(result);

		System.out.println(jsonString);
		result = JSON.parseObject(jsonString, DebtTransferFundRouteResult.class);
		System.out.println(JSON.toJSONString(result));
	}
}
