package com.yudianxx.springBootDemo.transation;

import com.yudianxx.springBootDemo.model.image.Category;

public interface TransactionTestService {
    void testTransactional() ;
    void a(Category category);
    void b(Category category);
    void c(Category category);
    void d(Category category);
    void e(Category category);
}
