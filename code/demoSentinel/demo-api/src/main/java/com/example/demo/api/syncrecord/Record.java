package com.example.demo.api.syncrecord;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @Author mubi
 * @Date 2019/7/10 3:18 PM
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Record implements Serializable {
    long queryTime;
    long queryCostTime;

    @Override
    public String toString() {
        return "Record{" +
                "queryTime=" + queryTime +
                ", queryCostTime=" + queryCostTime +
                '}';
    }
}
