/*
 *                        _oo0oo_
 *                       o8888888o
 *                       88" . "88
 *                       (| -_- |)
 *                       0\  =  /0
 *                     ___/`---'\___
 *                   .' \\|     |// '.
 *                  / \\|||  :  |||// \
 *                 / _||||| -:- |||||- \
 *                |   | \\\  - /// |   |
 *                | \_|  ''\---/''  |_/ |
 *                \  .-\__  '-'  ___/-. /
 *              ___'. .'  /--.--\  `. .'___
 *           ."" '<  `.___\_<|>_/___.' >' "".
 *          | | :  `- \`.;`\ _ /`;.`/ - ` : | |
 *          \  \ `_.   \_ __\ /__ _/   .-` /  /
 *      =====`-.____`.___ \_____/___.-`___.-'=====
 *                        `=---='
 * 
 * 
 *      ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * 
 *            佛祖保佑       永不宕机     永无BUG
 * 
 *        佛曰:  
 *                写字楼里写字间，写字间里程序员；  
 *                程序人员写程序，又拿程序换酒钱。  
 *                酒醒只在网上坐，酒醉还来网下眠；  
 *                酒醉酒醒日复日，网上网下年复年。  
 *                但愿老死电脑间，不愿鞠躬老板前；  
 *                奔驰宝马贵者趣，公交自行程序员。  
 *                别人笑我忒疯癫，我笑自己命太贱；  
 *                不见满街漂亮妹，哪个归得程序员？
 * 
 * @Author: Wei.Dongcheng
 * @Date: 2020-11-21 11:28:01
 * @LastEditors: Wei.Dongcheng
 * @LastEditTime: 2020-11-21 15:38:00
 * @FilePath: \src\main\java\com\wdc\demo\dao\BookDAO.java
 * @Description: file content
 */

package com.wdc.demo.dao;

import java.util.List;

import com.wdc.demo.pojo.Book;
import com.wdc.demo.pojo.Category;

import org.springframework.data.jpa.repository.JpaRepository;


/**
 * 这里关键的地方在于方法的名字。
 * 由于使用了 JPA，无需手动构建 SQL 语句，
 * 而只需要按照规范提供方法的名字即可实现对数据库的增删改查。
*/
public interface BookDAO extends JpaRepository<Book, Integer> {
    // 查找分类为category的所有书
    // 这个能够实现，是Book类中使用了注解 @ManyToOne和@JoinColumn
    List<Book> findAllByCategory(Category category);
    
    // 根据标题或作者进行模糊查询
    List<Book> findAllByTitleLikeOrAuthorLike(String keyword1, String keyword2);
}