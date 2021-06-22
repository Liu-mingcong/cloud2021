package com.atguigu.entities;

import java.util.List;

/**
 * 2 * @Author: Liu Mingcong
 * 3 * @Date: 2021/6/22 17:08
 * 4
 */
public class LiuMingcong {
    private static final String name = "刘銘聪";
    private static final String sex = "男";
    private List<String> girlFriends;

    public List<String> getGirlFriends() {
        for (String entry : girlFriends) {
            synchronized (this) {

                return girlFriends;
            }
        }
        return null;
    }
}
