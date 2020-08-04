package com.ynz.front.demothymeleaf.mapper;


public interface Mapper<S extends Domain, T extends Dto> {
    T map(S s);
}
