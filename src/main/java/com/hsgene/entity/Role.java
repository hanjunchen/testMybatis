package com.hsgene.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * Created by hjc on 2016/8/26.
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Role {

    private Integer id;
    private String roleCode;
    private String roleName;
    private List<User> list;

}
