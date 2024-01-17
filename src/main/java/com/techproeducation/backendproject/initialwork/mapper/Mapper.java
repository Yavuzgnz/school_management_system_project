package com.techproeducation.backendproject.initialwork.mapper;

public interface Mapper<A, B>{

    B mapTo(A a);

    A mapFrom(B a);

}
