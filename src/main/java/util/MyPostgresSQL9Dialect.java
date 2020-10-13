/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import org.hibernate.dialect.PostgreSQL94Dialect;
import org.hibernate.dialect.function.StandardSQLFunction;

/**
 *
 * @author JGSS
 */
public class MyPostgresSQL9Dialect extends PostgreSQL94Dialect {
    
    public MyPostgresSQL9Dialect(){
        super();
        registerFunction("auditoria", new StandardSQLFunction("auditoria"));
    }
    
}
