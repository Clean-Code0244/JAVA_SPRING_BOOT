package com.omertursun.jwt.dto;

import com.omertursun.jwt.model.Department;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.nio.file.LinkOption;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DtoEmployee {

    private Long id;
    private String firstName;
    private String lastName;
    private DtoDepartment dtoDepartment;
}
