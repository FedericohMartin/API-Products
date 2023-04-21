package com.paygoal.productsapp.mapper;

public interface IMapper <I, O> {
    public O map(I in);
}
