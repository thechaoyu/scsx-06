package com.gsm.entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SysUser {
    private Integer id;
    private String name;
    private String sex;
    private Integer age;
}
