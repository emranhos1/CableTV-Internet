package com.eh.dbconnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author Md. Emran Hossain
 */
public class conRs {

    private Connection con;
    private ResultSet rs;
    private PreparedStatement pstm;

    public Connection getCon() {
        return con;
    }

    public void setCon(Connection con) {
        this.con = con;
    }

    public ResultSet getRs() {
        return rs;
    }

    public void setRs(ResultSet rs) {
        this.rs = rs;
    }

    public PreparedStatement getPstm() {
        return pstm;
    }

    public void setPstm(PreparedStatement pstm) {
        this.pstm = pstm;
    }

    public conRs(Connection con, ResultSet rs, PreparedStatement pstm) {
        this.con = con;
        this.rs = rs;
        this.pstm = pstm;
    }
    
}
