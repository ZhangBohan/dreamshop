package me.nengzhe.utils;

import org.apache.commons.lang.ArrayUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * User: Bohan
 * Date: 13-11-13
 * Time: 下午9:26
 */
public class SqlBuilder {
    public static final String AND = "AND";
    public static final String SPACE = " ";
    public static final String WHERE = "WHERE";

    private StringBuilder stringBuilder;
    private List<Object> params;

    private boolean firstWhere = true;

    public SqlBuilder() {
        stringBuilder = new StringBuilder();
        params = new ArrayList<Object>();
    }

    public String getSql() {
        return stringBuilder.toString().trim();
    }

    public Object[] getParams() {
        return params.toArray();
    }

    public SqlBuilder append(CharSequence charSequence) {
        stringBuilder.append(SPACE).append(charSequence);
        return this;
    }

    public SqlBuilder append(CharSequence charSequence, Object... param) {
        this.append(charSequence);
        for(Object obj : param) {
            params.add(obj);
        }
        return this;
    }

    public SqlBuilder append(SqlBuilder sqlBuilder) {
        stringBuilder.append(" (").append(sqlBuilder.getSql()).append(")");
        for(Object param : sqlBuilder.getParams()) {
            this.params.add(param);
        }
        return this;
    }

    public SqlBuilder appendAnd(CharSequence charSequence, Object... param) {
        return this.append(AND).append(charSequence, param);
    }

    public SqlBuilder appendAndIfNotFirst(CharSequence charSequence, Object... param) {
        if(this.firstWhere) {
            this.append(WHERE).append(charSequence,param);
            this.firstWhere = false;
        } else {
            this.appendAnd(charSequence, param);
        }
        return this;
    }

    public static void main(String[] args) {
        SqlBuilder sqlBuilder = new SqlBuilder();
        sqlBuilder.append("SELECT * FROM table_name");
        sqlBuilder.appendAndIfNotFirst("a = ?", "a");
        sqlBuilder.appendAndIfNotFirst("b = ?", "b");
        sqlBuilder.appendAndIfNotFirst("c IN");

        SqlBuilder sqlBuilder2 = new SqlBuilder();
        sqlBuilder2.append("SELECT * FROM table_name2");
        sqlBuilder2.appendAndIfNotFirst("a2 = ?", "a2");
        sqlBuilder2.appendAndIfNotFirst("b2 = ?", "b2");
        sqlBuilder.append(sqlBuilder2);
        System.out.println(sqlBuilder.getSql());
        System.out.println(ArrayUtils.toString(sqlBuilder.getParams()));
    }
    /*
     * SELECT * FROM table_name WHERE a = ? AND b = ? AND c IN (SELECT * FROM table_name2 WHERE a2 = ? AND b2 = ?)
     * {a,b,a2,b2}
     */
}
