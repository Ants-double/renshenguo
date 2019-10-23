package tk.mybatis.mapper;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

/**
 * * 自己的 Mapper
 * * 特别注意，该接口不能被扫描到，否则会出错
 * @author lyy
 * @date 2019/7/9
 * @param
 */

public interface MyMapper<T> extends Mapper<T>, MySqlMapper<T> {

}