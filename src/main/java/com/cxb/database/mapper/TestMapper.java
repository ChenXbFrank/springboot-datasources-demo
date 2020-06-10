package com.cxb.database.mapper;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;

public interface TestMapper {

	Integer queryCount();
	
	@Update("update book set stock = stock - 1 where name = #{name} and stock != 0")
	Integer updateBookByName(@Param("name") String name);

}
