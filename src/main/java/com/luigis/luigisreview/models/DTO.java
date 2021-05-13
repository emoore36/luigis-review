package com.luigis.luigisreview.models;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public abstract class DTO<T> {

    private List<T> data;
    private String responseCode;
    private String message;

}
