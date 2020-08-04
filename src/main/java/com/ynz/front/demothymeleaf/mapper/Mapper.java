package com.ynz.front.demothymeleaf.mapper;


public interface Mapper<S extends Persistable, T extends Presentable> {
    T map(S s);
    S invert(T t);
}
