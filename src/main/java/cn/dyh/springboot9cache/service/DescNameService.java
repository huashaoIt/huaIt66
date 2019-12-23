package cn.dyh.springboot9cache.service;

import cn.dyh.springboot9cache.dao.DescNameMapper;
import cn.dyh.springboot9cache.entity.DescName;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class DescNameService {

    @Resource
    private DescNameMapper descNameMapper;



    /**
     * @Cacheable 将方法的运行结果进行缓存，以后再需要相同的数据直接上缓存中取，不用再调方法
     * cacheNames/value:指定缓存组件的名字
     * 方法运行前先按照key来检查缓存
     * key:缓存使用key,可以用它来指定。默认使用的是方法参数的值作为key，值就是方法的返回值
     *      还可以使用spel表达式：
     *      key="#{id}"
     *      #root.methodName/#root.method.name:拿方法名
     *      #root.caches[0].name:指定缓存名数组列表位置
     *      #root.target:当前被调用的目标对象
     *      #root.targetClass:当前被调用的目标对象类
     *      #root.args[0]: 当前方法参数列表位置
     *      #result:取出方法结果的值
     * #id:也可写成这样：#a0  #p0  #root.args[0]
     * condition:指定符合条件的情况下才缓存
     * unless:否定缓存，如果添加成立不缓存，可以取到结果值进行判断
     *
     * keyGenerator:可以自己定义缓存组件：见config包下
     */
    @Cacheable(cacheNames = {"emp"}/*,keyGenerator = "keyGener",condition = "#id>0",unless = "#result == null"*/)
    public DescName getDescName(Integer id){
        System.out.println("查询"+id+"号员工！");
        DescName byId = descNameMapper.getListById(id);
        return byId;
    }

    /**
     * @CachePut:即调用方法又更新缓存数据
     * 修改了数据库某个数据，同时更新缓存(方法运行完之后再按照key来检查缓存)
     * 运行时机：
     *      1.先调用目标方法
     *      2.将目标方法的结果缓存起来
     *类似于更新缓存的方法：
     *      1.查询一个id为1的数据
     *      2.该修改id为1的数据,再查询id为1的可能还是以前的数据
     *      3.这时需要在调用修改方法时把缓存给更新了(缓存的key的名称一定要相同)
     */
    @CachePut(cacheNames = "emp",key = "#result.id")    //key拿返回值对象中的id
    public DescName update(DescName descName){
       descNameMapper.updateDescName(descName);
        return descName;
    }
}
