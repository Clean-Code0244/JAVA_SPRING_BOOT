package com.omertursun.jwt.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DtoDepartment {


 private Long id;
 private String location;
 private String departmentName;
 private DtoDepartment dtoDepartment;

}
