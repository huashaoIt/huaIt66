package cn.dyh.springboot9cache.dao;

import cn.dyh.springboot9cache.entity.DescName;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

//@Mapper  可以使用注解版和mapper.xml文件，两者都可使用
public interface DescNameMapper {

    //查询
    @Select("select * from descname")
    List<DescName> getList();

    //添加
    @Options(useGeneratedKeys = true,keyProperty = "id")    //插入完成之后会把主键封装到对象中，可以在业务层调用
    @Insert("insert into descname(name) values(#{name})")
     int insertDescName(DescName descName);

    //根据id查询一条数据
    @Select("select * from descname where id = #{id}")
    DescName getListById(Integer id);

    @Update("UPDATE `descname` SET `name` = #{name} WHERE `id` = #{id}")
    int updateDescName(DescName descName);
}
