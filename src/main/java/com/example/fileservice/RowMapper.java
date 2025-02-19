package com.example.fileservice;

import lombok.AllArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
public class RowMapper {

    private final List<String> types;

    public List<Object> mapRow(String[] arr) {
        List<Object> list = new ArrayList<>();
        for(int i=0; i < types.size(); i++) {
            if("INT".equals(types.get(i))) {
                list.add(Integer.parseInt(arr[i]));
            } else if("DECIMAL".equals(types.get(i))) {
                list.add(Float.parseFloat(arr[i]));
            } else {
                list.add(arr[i]);
            }
        }
        return list;
    }
}
