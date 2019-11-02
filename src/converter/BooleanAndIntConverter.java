package converter;

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BooleanAndIntConverter extends BaseTypeHandler<Boolean> {
    /**
     * set: java(boolean) --> DB(int)
     * @param preparedStatement PreparedStatement对象
     * @param i PreparedStatement对象操作参数的下标
     * @param aBoolean java值
     * @param jdbcType JDBC操作的数据库类型
     * @throws SQLException
     */
    @Override
    public void setNonNullParameter(PreparedStatement preparedStatement, int i, Boolean aBoolean, JdbcType jdbcType) throws SQLException {
        if (aBoolean)
            preparedStatement.setInt(i,1);
        else
            preparedStatement.setInt(i,0);
    }

    //get: DB(int) --> java(boolean)
    @Override
    public Boolean getNullableResult(ResultSet resultSet, String s) throws SQLException {
        int sexNum = resultSet.getInt(s);
        return sexNum == 1;
    }

    //get: DB(int) --> java(boolean)
    @Override
    public Boolean getNullableResult(ResultSet resultSet, int i) throws SQLException {
        int sexNum = resultSet.getInt(i);
        return sexNum == 1;
    }

    //get: DB(int) --> java(boolean)
    @Override
    public Boolean getNullableResult(CallableStatement callableStatement, int i) throws SQLException {
        int sexNum = callableStatement.getInt(i);
        return sexNum == 1;
    }
}
