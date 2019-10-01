package com.hotel.admin.query;

import lombok.Data;

@Data
public class PageQuery {
    Integer page;
    Integer limit;
    String keyword;
}
