package com.chanhhoo.findprice.service;

import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.io.IOException;
import java.util.Map.Entry;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ChartDataManufacture {
    List<String> xDomain = new ArrayList<String>();
    List<Integer> chartData = new ArrayList<Integer>() {
        {
            add(0);
            add(0);
            add(0);
            add(0);
        }
    };
    public void getDomainData(List<Integer> articlePrices, int axisVal, int articleCount){
        for(int i = 1; i < 5 ; i++){
            xDomain.add(Integer.toString(axisVal * (i-1)) + " ~ " + Integer.toString(axisVal*i));
        }
        for (int i = 0; i < articleCount;i++){
            if(articlePrices.get(i) < axisVal){
                chartData.set(0, chartData.get(0) + 1);
            }
            else if(articlePrices.get(i) < axisVal*2){
                chartData.set(1, chartData.get(1) + 1);
            }
            else if(articlePrices.get(i) < axisVal*3){
                chartData.set(2, chartData.get(2) + 1);
            }
            else{
                chartData.set(3, chartData.get(3) + 1);
            }
        }

        for (int i = 0; i < 4; i++){
            System.out.println(xDomain.get(i) +" "+ chartData.get(i));
        }
    }
}