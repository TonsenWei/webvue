/*
 * 
 * 　　┏┓　　　┏┓+ +
 * 　┏┛┻━━━┛┻┓ + +
 * 　┃　　　　　　　┃ 　
 * 　┃　　　━　　　┃ ++ + + +
 *  ████━████ ┃+
 * 　┃　　　　　　　┃ +
 * 　┃　　　┻　　　┃
 * 　┃　　　　　　　┃ + +
 * 　┗━┓　　　┏━┛
 * 　　　┃　　　┃　　　　　　　　　　　
 * 　　　┃　　　┃ + + + +
 * 　　　┃　　　┃
 * 　　　┃　　　┃ +  神兽保佑
 * 　　　┃　　　┃    代码无bug　　
 * 　　　┃　　　┃　　+　　　　　　　　　
 * 　　　┃　 　　┗━━━┓ + +
 * 　　　┃ 　　　　　　　┣┓
 * 　　　┃ 　　　　　　　┏┛
 * 　　　┗┓┓┏━┳┓┏┛ + + + +
 * 　　　　┃┫┫　┃┫┫
 * 　　　　┗┻┛　┗┻┛+ + + +
 * 
 * 
 * @Author: Wei.Dongcheng
 * @Date: 2020-11-21 14:32:29
 * @LastEditors: Wei.Dongcheng
 * @LastEditTime: 2020-11-21 20:20:58
 * @FilePath: \src\main\java\com\wdc\demo\service\BookService.java
 * @Description: file content
 */
package com.wdc.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

import com.wdc.demo.pojo.Book;
import com.wdc.demo.pojo.Category;
import com.wdc.demo.dao.BookDAO;

@Service
public class BookService {
    @Autowired
    BookDAO bookDAO;
    @Autowired
    CategoryService categoryService;

    /**
     * @description: 列出所有书
     * @param {void}
     * @return {List<Book>}
     */    
    public List<Book> list() {
        Sort sort = Sort.by(Sort.Direction.DESC, "id");
        // Sort sort = new Sort(Sort.Direction.DESC, "id");  //已过时
        return bookDAO.findAll(sort);
    }

    /**
     * @description: 增加或更新图书
     * @param {Book} book
     * @return {*}
     */    
    public void addOrUpdate(Book book) {
        /**
         * 注意一下 save() 方法的作用是，当主键存在时更新数据，当主键不存在时插入数据。
        */
        bookDAO.save(book);
    }

    /**
     * @description: 通过ID删除图书
     * @param {int} id
     * @return {*}
     */    
    public void deleteById(int id) {
        bookDAO.deleteById(id);
    }

    /**
     * @description: 通过分类查询图书
     * @param {int} cid
     * @return {*}
     */    
    public List<Book> listByCategory(int cid) {
        Category category = categoryService.get(cid);
        return bookDAO.findAllByCategory(category);
    }

    public List<Book> search(String keywords) {
        return bookDAO.findAllByTitleLikeOrAuthorLike('%' + keywords + '%', '%' + keywords + '%');
    }
}

